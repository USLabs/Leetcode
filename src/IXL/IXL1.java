package IXL;

import javax.jnlp.IntegrationService;

/**
 * Created by uslabs on 12/13/17.
 */
public class IXL1 {
    public static void solution() {
        System.out.println(countHoles(630));
    }

    private static int countHoles(int num) {
        String s = Integer.toString(num);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case '0': {
                    count += 1;
                    break;
                }
                case '4':
                    count += 1;
                    break;
                case '6':
                    count += 1;
                    break;
                case '9':
                    count += 1;
                    break;
                case '8':
                    count+=2;
                    break;
            }

        }
        return count;
    }
}
