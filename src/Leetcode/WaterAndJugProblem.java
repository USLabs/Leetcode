package Leetcode;

/**
 * Created by uslabs on 10/23/17.
 */
public class WaterAndJugProblem {

    public static void solution() {
        System.out.println(canMeasureWater(3, 5, 4));
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (z - x <= y && z % gcd(x, y) == 0);
    }

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void solution2() {
        System.out.println(canMeasureWater2(3, 5, 4));
    }

    public static boolean canMeasureWater2(int x, int y, int z) {
        arr = new int[x + 1][y + 1];
        return canMeasureUtil(x, y, z, 0, 0);
    }

    public static int[][] arr;

    public static boolean canMeasureUtil(int x, int y, int z, int xx, int yy) {
        if (xx > x || xx < 0 || yy > y || yy < 0 || (x + y) < z)
            return false;

        if (xx == z || yy == z || (xx + yy) == z) {
            arr[xx][yy] = 1;
            return true;
        }
        if (arr[xx][yy] == 2)
            return false;

        if (arr[xx][yy] != 0)
            return (arr[xx][yy] == 1) ? true : false;
        arr[xx][yy] = 2;
        arr[xx][yy] = (
                canMeasureUtil(x, y, z, x, yy) ||
                        canMeasureUtil(x, y, z, xx, y) ||
                        canMeasureUtil(x, y, z, 0, yy) ||
                        canMeasureUtil(x, y, z, xx, 0) ||
                        ((yy > (x - xx)) ? canMeasureUtil(x, y, z, x, yy - (x - xx)) : canMeasureUtil(x, y, z, xx + yy, 0)) ||
                        ((xx > (y - yy)) ? canMeasureUtil(x, y, z, xx - (y - yy), y) : canMeasureUtil(x, y, z, 0, xx + yy)) ||
                        canMeasureUtil(x, y, z, xx - (y - yy), y)) ? 1 : -1;

        return (arr[xx][yy] == 1) ? true : false;
    }
}
