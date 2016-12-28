/**
 * Created by techmint on 12/17/16.
 */
public class alpha {

    public static void printUnsorted(int arr[]) {

        int left = 0, right = arr.length - 1, max, min;

        // step 1(a) of above algo
        for (left = 0; left < arr.length - 1; left++) {
            if (arr[left] > arr[left + 1])
                break;
        }
        if (left == arr.length - 1) {
            System.out.println("The complete array is sorted");
            return;
        }

        // step 1(b) of above algo
        for (right = arr.length - 1; right > 0; right--) {
            if (arr[right] < arr[right - 1])
                break;
        }

        // step 2(a) of above algo
        max = arr[left];
        min = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        // step 2(b) of above algo
        for (int i = 0; i < left; i++) {
            if (arr[i] > min) {
                left = i;
                break;
            }
        }

        // step 2(c) of above algo
        for (int i = arr.length - 1; i >= right + 1; i--) {
            if (arr[i] < max) {
                right = i;
                break;
            }
        }

        // step 3 of above algo
        System.out.println("The unsorted subarray which makes the given array sorted lies between the indees " + left + " and " + right);
        return;
    }
}