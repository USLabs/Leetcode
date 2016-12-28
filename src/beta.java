/**
 * Created by techmint on 12/17/16.
 */
public class beta {
    public static int solution(int[] arr) {
        int left = -1, right = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                left = i;
                break;
            }
        }

        if (left == -1)
            return 0;

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                right = i;
                break;
            }
        }

        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < left; i++) {
            if (arr[i] > min) {
                left = i;
                break;
            }
        }


        for (int i = arr.length - 1; i >= right + 1; i--) {
            if (arr[i] < max) {
                right = i;
                break;
            }
        }

        return (right - left + 1);
    }

}
