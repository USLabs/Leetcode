/**
 * Created by uslabs on 6/8/17.
 */
public class Atoi {
    public static void Solution(String str) {
        int a = 0, signCount = 0;
        double k = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+')
                signCount++;
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '.') {
                a = 0;
                k = 0;
                continue;
            }
            if (str.charAt(i) == '-') {
                a = -1 * a;
                break;
            }
            if (str.charAt(i) == '+') {
                break;
            }
            a = a + (Character.getNumericValue(str.charAt(i)) * (int) Math.round(Math.pow(10.0, k)));
            k++;
        }
        System.out.println(a);
    }
}