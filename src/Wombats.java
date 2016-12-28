import java.util.ArrayList;
import java.util.Stack;

public class Wombats {

    public static int levels;

    /*
        public static Tetrahedron createTetrahedron(String[] arg) {
            levels = Integer.parseInt(arg[0]);
            if (levels == 0) {
                return null;
            }
            Tetrahedron[][] arr = new Tetrahedron[arg.length][];
            arr[0] = new Tetrahedron[1];
            arr[0][0] = new Tetrahedron(Integer.parseInt(arg[1]));
            for (int i = 1; i < levels; i++) {
                int y = 0;
                for (int j = (i * (i + 1) / 2) + 1; j < (i * (i + 1) / 2) + 1 + i + 1; j++) {
                    ArrayList<Tetrahedron> levelList = new ArrayList();
                    int x = 0;
                    String[] argArr = arg[j].split(" ");
                    for (String s : argArr) {
                        Tetrahedron a = new Tetrahedron(Integer.parseInt(s));
                        levelList.add(x, a);
                        if (x == 0) {
                            if (y == 0) {
                                arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                a.addParent(arr[(i * (i - 1) / 2) + y][x]);
                            } else {
                                if ((i * (i + 1) / 2) + y + 1 == ((i + 2) * (i + 1) / 2)) {
                                    arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);
                                } else {
                                    arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x]);
                                    arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);
                                }
                            }
                        } else {
                            if (x == argArr.length - 1) {
                                if (y == 0) {
                                    arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);
                                } else {
                                    if ((i * (i + 1) / 2) + y + 1 == ((i + 2) * (i + 1) / 2)) {
                                        arr[(i * (i - 1) / 2) + y - 1][x - 1].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y - 1][x - 1]);
                                    } else {
                                        arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);
                                        arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);
                                    }
                                }
                            } else {
                                if (y == 0) {
                                    arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x]);

                                    arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                    a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);
                                } else {
                                    if ((i * (i + 1) / 2) + y + 1 == ((i + 2) * (i + 1) / 2)) {
                                        arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);

                                        arr[(i * (i - 1) / 2) + y - 1][x - 1].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y - 1][x - 1]);
                                    } else {
                                        arr[(i * (i - 1) / 2) + y][x].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y][x]);

                                        arr[(i * (i - 1) / 2) + y][x - 1].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y][x - 1]);

                                        arr[(i * (i - 1) / 2) + y - 1][x].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y - 1][x]);

                                        arr[(i * (i - 1) / 2) + y - 1][x - 1].addChildren(a);
                                        a.addParent(arr[(i * (i - 1) / 2) + y - 1][x - 1]);
                                    }
                                }
                            }
                        }
                        x++;
                    }
                    arr[j - 1] = new Tetrahedron[levelList.size()];
                    arr[j - 1] = levelList.toArray(arr[j - 1]);
                    y++;
                }
            }
            return arr[0][0];
        }
    */
    public static int find(Tetrahedron[][] arr) {
        int res = 0;
        for (int i = 0; i < levels; i++) {
            int a = pickAtLevels(i, arr, new Stack());
            res += a;
        }
        return res;
    }

    public static int moreCost(int l, Tetrahedron[][] arr, Stack<Tetrahedron> parentsMarked) {
        int moreCost = 0;
        for (int q = 0; q < l; q++) {
            int b = pickAtLevels(q, arr, parentsMarked);
            moreCost += b;
        }
        return moreCost;
    }

    public static int pickAtLevels(int l, Tetrahedron[][] arr, Stack<Tetrahedron> st) {
        int res = 0;
        for (int i = l * (l + 1) / 2; i < (l + 1) * (l + 2) / 2; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                if (!arr[i][k].isVisited && arr[i][k].x > 0 && arr[i][k].take != -1) {
                    Stack<Tetrahedron> parentsMarked = new Stack();
                    int cost = findParent(arr[i][k], parentsMarked);
                    cost += moreCost(l, arr, parentsMarked);
                    if (cost > 0) {
                        res += cost;
                        stackadd(st, parentsMarked);
                    } else {
                        arr[i][k].take = 1;
                        Stack<Tetrahedron> stack = new Stack();
                        int p1 = cost + pickAtLevels(l, arr, stack);
                        Wombats2.unmarkVisited(parentsMarked);
                        Wombats2.unmarkVisited(stack);
                        arr[i][k].take = 0;

                        arr[i][k].take = -1;
                        Stack<Tetrahedron> stack2 = new Stack();
                        int p2 = pickAtLevels(l, arr, stack2);
                        Wombats2.unmarkVisited(stack2);
                        arr[i][k].take = 0;

                        if (p1 > 0 && p2 > 0) {
                            if (p1 > p2) {
                                res += p1;
                                Wombats2.markVisited(parentsMarked);
                                Wombats2.markVisited(stack);
                                stackadd(st, parentsMarked);
                                stackadd(st, stack);
                            } else {
                                res += p2;
                                Wombats2.markVisited(stack2);
                                stackadd(st, stack2);
                            }
                            return res;
                        }
                        if (p1 > 0) {
                            res += p1;
                            Wombats2.markVisited(parentsMarked);
                            Wombats2.markVisited(stack);
                            stackadd(st, parentsMarked);
                            stackadd(st, stack);
                        }
                        if (p2 > 0) {
                            res += p2;
                            Wombats2.markVisited(stack2);
                            stackadd(st, stack2);
                        }
                        return res;
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
}