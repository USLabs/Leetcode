package Twitter;

/**
 * Created by uslabs on 11/27/17.
 */
public class TwitterKraken {
    public static void solution(){
        System.out.println(krakenCount(2, 3));
    }
    private static int krakenCount(int m, int n) {
        if (m < 1 || n < 1)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        return krakenCount(m, n - 1) + krakenCount(m - 1, n) + krakenCount(m - 1, n - 1);
    }
}
