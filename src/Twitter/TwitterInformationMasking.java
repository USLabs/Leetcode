package Twitter;

import java.util.Scanner;

/**
 * Created by uslabs on 11/27/17.
 */
public class TwitterInformationMasking {
    public static void solution() {
        String email = "jackAndJill@gmail.com";
        String phone = "+1 (333) 444-5678";
        System.out.println(MaskEmail(email));
        System.out.println(MaskPhone(phone));

        //E: j*****l@twitter.com 
        //P: +*-**-***-5678
    }

    private static String MaskEmail(String email) {
        int index = email.indexOf('@');
        String username = email.substring(0, index);
        username = username.charAt(0) + "*****" + username.charAt(username.length() - 1);
        return username + email.substring(index);
    }

    private static String MaskPhone(String phone) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone.length(); i++) {
            if (i >= phone.length() - 4) {
                sb.append(phone.charAt(i));
                continue;
            }
            if (phone.charAt(i) == '+') {
                sb.append('+');
                continue;
            }
            if (Character.isDigit(phone.charAt(i))) {
                sb.append('*');
            }
        }

        for (int i = sb.length() - 1, k = 1; i >= 0; i--, k++) {
            if (k == 4 || k == 7 || k == 10) {
                if (k == 10) {
                    if (i == 0)
                        continue;
                    else sb.insert(i, '-');
                } else
                    sb.insert(i, '-');
            }
        }
        return sb.toString();
    }
}