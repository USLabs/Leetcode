package Leetcode;

/**
 * Created by uslabs on 12/5/17.
 */
public class TwitterCupcakeFeast {
    public static void solution() {
        String[] trips = {
                "10 2 5",
                "12 4 4",
                "6 2 2"
        };
        maximumCupcakes(trips);
    }

    static void maximumCupcakes(String[] trips) {
        for (String trip : trips) {
            String[] arr = trip.split(" ");
            int n = Integer.valueOf(arr[0]);
            int c = Integer.valueOf(arr[1]);
            int m = Integer.valueOf(arr[2]);
            System.out.println(getCupcakes(n, c, m, 0));
        }
    }

    static int getCupcakes(int n, int c, int m, int w) {
        if (n / c > 0) {
            return n / c + getCupcakes(n % c, c, m, w + n / c);
        } else {
            if (w >= m) {
                return w / m + getCupcakes(n, c, m, w/m + w % m);
            } else
                return 0;
        }
    }
}
