import java.util.Arrays;

/**
 * Created by techmint on 11/24/16.
 */
public class goldmann {
    public static int printPairsUsingTwoPointers(int[] a, int k) {
        if (a.length < 2) {
            return 0;
        }
        int[] x = new int[a.length];
        //Arrays.fill();
        int count = 0, l = 0;
        Arrays.sort(a);
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == k) {
                System.out.printf("(%d, %d) %n", a[left], a[right]);
                if (a[left] != a[right]) {
                    x[l] = a[left];
                    l++;
                    x[l] = a[left];
                    l++;
                }
                count++;
                left = left + 1;
                right = right - 1;


            } else if (sum < k) {
                left = left + 1;
            } else if (sum > k) {
                right = right - 1;
            }
        }
        if (a.length % 2 != 0) {
            int q = a[a.length / 2 + 1];
        }
        return count;
    } /* * Utility method to print two elements in an array that sum to k. */

    public static void prettyPrint(int[] random, int k) {
        System.out.println(printPairsUsingTwoPointers(random, k));
    }
}