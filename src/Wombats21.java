import java.util.ArrayList;
import java.util.Stack;

public class Wombats21 {

    public static int levels;

    public static int find(Tetrahedron[][] arr) {
        int res = 0;
        for (int i = 0; i < levels; i++) {
            int[][] newGiven = new int[arr[i * (i + 1) / 2].length][arr[i * (i + 1) / 2].length];
            for (int a = 0; a < newGiven.length; a++) {
                for (int b = 0; b < newGiven[0].length; b++)
                    newGiven[a][b] = Integer.MIN_VALUE;
            }
            int a = pickAtLevels(i, arr, new Stack(), newGiven);
            res += a;
            savedCombs = new ArrayList();
        }
        return res;
    }

    public static int moreCost(int l, Tetrahedron[][] arr, Stack<Tetrahedron> parentsMarked, int[][] given) {
        int res = 0;
        for (int i = 0; i <= l; i++) {
            for (int j = i * (i + 1) / 2; j < (i + 1) * (i + 2) / 2; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    if (!arr[j][k].isVisited && arr[j][k].x > 0) {
                        int a = 0;
                        for (Tetrahedron p : arr[j][k].parents) {
                            if (p == null || p.isVisited == true) {
                                a++;
                                continue;
                            } else break;
                        }
                        if (arr[j][k].parents.length == a) {
                            res += arr[j][k].x;
                            arr[j][k].isVisited = true;
                            parentsMarked.push(arr[j][k]);
                        }
                    }
                }
            }
        }
        return res;
    }

    static ArrayList<int[][]> savedCombs = new ArrayList();

    static void getCopy(int[][] arr, int[][] copy) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
    }

    static int getComb(int[][] given, int x, int y) {

        boolean mismatch = false;
        int res = Integer.MIN_VALUE;
        for (int[][] combs : savedCombs) {
            for (int i = 0; i < combs.length; i++) {
                for (int j = 0; j < combs[0].length; j++) {
                    if (i == x && j == y) {
                        res = combs[i][j];
                    } else {
                        if (given[i][j] != combs[i][j]) {
                            mismatch = true;
                            break;
                        }
                    }
                }
                if (mismatch)
                    break;
            }
            if (mismatch) {
                mismatch = false;
            } else
                return res;
        }
        return res;
    }

    public static int pickAtLevels(int l, Tetrahedron[][] arr, Stack<Tetrahedron> st, int[][] given) {
        int[][] copy = new int[given.length][given[0].length];
        int[][] copy1 = new int[given.length][given[0].length];
        getCopy(given, copy);
        getCopy(given, copy1);
        int res = 0;
        for (int i = l * (l + 1) / 2; i < (l + 1) * (l + 2) / 2; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                if (!arr[i][k].isVisited && arr[i][k].x > 0 && arr[i][k].take != -1) {

                    Stack<Tetrahedron> parentsMarked = new Stack();
                    int combed = getComb(given, i, k), cost;
                    if (combed == Integer.MIN_VALUE)
                        cost = findParent(arr[i][k], parentsMarked);
                    else
                        cost = combed;
                    cost += moreCost(l, arr, parentsMarked, given);
                    given[i - (l * (l + 1) / 2)][k] = cost;
                    savedCombs.add(given);

                    int[][] t1 = new int[given.length][given[0].length];
                    getCopy(copy, t1);
                    given = t1;
                    given[i - (l * (l + 1) / 2)][k] = cost;
                    Stack<Tetrahedron> test = new Stack();

                    int r1 = pickAtLevels(l, arr, test, given);

                    //int r1 = pickAtLevels(l, arr, test, given);
                    if (r1 < 0)
                        r1 = cost;
                    else
                        r1 += cost;

                    int[][] t2 = new int[given.length][given[0].length];
                    getCopy(copy, t2);
                    given = t2;
                    Wombats2.unmarkVisited(parentsMarked);
                    Wombats2.unmarkVisited(test);

                    Stack<Tetrahedron> temp = new Stack();
                    arr[i][k].take = -1;
                    int r2 = pickAtLevels(l, arr, temp, given);

                    //int r2 = pickAtLevels(l, arr, temp, given);

                    arr[i][k].take = 0;
                    Wombats2.unmarkVisited(temp);
                    int[][] t3 = new int[given.length][given[0].length];
                    getCopy(copy, t3);
                    given = t3;

                    if (r1 > 0) {
                        if (r1 > r2) {
                            Wombats2.markVisited(parentsMarked);
                            Wombats2.markVisited(test);
                            stackadd(st, parentsMarked);
                            stackadd(st, test);
                            res += r1;
                        } else {
                            Wombats2.markVisited(temp);
                            stackadd(st, temp);
                            res += r2;
                        }
                    } else {
                        if (r2 > 0) {
                            Wombats2.markVisited(temp);
                            stackadd(st, temp);
                            res += r2;
                        } else {
                            Wombats2.markVisited(parentsMarked);
                            stackadd(st, parentsMarked);
                        }
                    }
                }
            }
        }
        return res;
    }


    public static void stackadd(Stack s1, Stack s2) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public static int findParent(Tetrahedron p, Stack<Tetrahedron> stack) {
        p.isVisited = true;
        stack.push(p);
        int res = p.x;
        for (Tetrahedron a : p.parents) {
            if (a == null)
                continue;
            if (!a.isVisited) {
                res += findParent(a, stack);
            }
        }
        return res;
    }

    static int getSaved(Tetrahedron[][] arr, int l, int state, int ii, int kk) {
        for (int i = l * (l + 1) / 2; i < (l + 1) * (l + 2) / 2; i++) {
            for (int k = 0; k < arr[i].length; k++) {

            }
        }
        return 0;
    }
}

class combnode {
    int x;
    int y;
    int cost;

    combnode(int a, int b, int c) {
        x = a;
        y = b;
        cost = c;
    }
}