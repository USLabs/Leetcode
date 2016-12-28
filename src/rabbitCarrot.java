/**
 * Created by techmint on 12/21/16.
 */
public class rabbitCarrot {
    public int[][] farm = {
            {5, 7, 8, 6, 3},
            {0, 0, 7, 0, 4},
            {4, 6, 3, 4, 9},
            {3, 1, 0, 5, 8}
    };

    public static int[] getMiddle(int[][] farm) {
        int[] arr = new int[2];
        int m = farm.length;
        int n = farm[0].length;
        int h = -1, v = -1;
        if (m % 2 != 0) {
            h = m / 2;
        }
        if (n % 2 != 0) {
            v = n / 2;
        }
        if (h != -1 && v != -1) {
            arr[0] = h;
            arr[1] = v;
            return arr;
        }

        if (h == -1 && v != -1) {
            if (farm[m / 2 - 1][v] > farm[(m / 2)][v]) {
                arr[0] = m / 2 - 1;
                arr[1] = v;
                return arr;
            } else {
                arr[0] = m / 2;
                arr[1] = v;
                return arr;
            }
        }


        if (v == -1 && h != -1) {
            if (farm[h][n / 2 - 1] > farm[h][n / 2]) {
                arr[0] = h;
                arr[1] = n / 2 - 1;
                return arr;
            } else {
                arr[0] = h;
                arr[1] = n / 2;
                return arr;
            }
        }

        if (farm[m / 2 - 1][n / 2 - 1] > farm[m / 2 - 1][n / 2]) {
            h = m / 2 - 1;
            v = n / 2 - 1;
        } else {
            h = m / 2 - 1;
            v = n / 2;
        }

        if (farm[m / 2][n / 2 - 1] > farm[m / 2][n / 2]) {
            if (farm[m / 2][n / 2 - 1] > farm[h][v]) {
                h = m / 2;
                v = n / 2 - 1;
            }
        } else {
            if (farm[m / 2][n / 2] > farm[h][v]) {
                h = m / 2;
                v = n / 2;
            }
        }

        arr[0] = h;
        arr[1] = v;
        return arr;
    }

    public static int eatCarrot(int[][] farm) {
        if (farm.length == 0) {
            System.out.println("Empty Farm");
            return -1;
        }
        int[] mid = getMiddle(farm);
        int h = mid[0], v = mid[1];
        return eatCarrotUtil(farm, h, v);
    }

    public static int eatCarrotUtil(int[][] farm, int h, int v) {
        int carr = farm[h][v];
        farm[h][v] = -1;

        int[][] arr = {
                {h + 1, v},
                {h - 1, v},
                {h, v + 1},
                {h, v - 1}
        };
        int max = -1;
        for (int[] a : arr) {
            if (a[0] >= 0 && a[0] < farm[0].length && a[1] >= 0 && a[1] < farm[0].length && farm[a[0]][a[1]] != -1) {
                if (farm[a[0]][a[1]] > max) {
                    h = a[0];
                    v = a[1];
                    max = farm[a[0]][a[1]];
                }
            }
        }

        if (max <= 0) {
            //System.out.println("Gonna Sleep");
            return carr;
        } else {
            return carr + eatCarrotUtil(farm, h, v);
        }
    }
}