package Twitter;

/**
 * Created by uslabs on 11/27/17.
 */
public class TwitterHackingTime {
    public static void solution() {
        String a = "Otjfvknou kskgnl, K mbxg";
        System.out.println(decrypt(a));
    }

    private static String encrypt(String str) {
        String key = "8251220";
        int k = 0;
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (Character.isLowerCase(ch)) {
                    int temp = ch - 'a' + 1 + key.charAt(k) - '0';
                    if (temp > 26)
                        temp -= 26;
                    arr[i] = (char) ('a' + temp - 1);
                } else {
                    int temp = ch - 'A' + 1 + key.charAt(k) - '0';
                    if (temp > 26)
                        temp -= 26;
                    arr[i] = (char) ('A' + temp - 1);
                }
                k++;
                if (k == key.length())
                    k = 0;
            } else
                arr[i] = str.charAt(i);
        }
        return String.valueOf(arr);
    }

    private static String decrypt(String str) {
        String key = "8251220";
        int k = 0;
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (Character.isLowerCase(ch)) {
                    int temp = ch - 'a' + 1 - (key.charAt(k) - '0');
                    if (temp < 0)
                        temp += 26;
                    arr[i] = (char) ('a' + temp - 1);
                } else {
                    int temp = ch - 'A' + 1 - (key.charAt(k) - '0');
                    if (temp < 0)
                        temp += 26;
                    arr[i] = (char) ('A' + temp - 1);
                }
                k++;
                if (k == key.length())
                    k = 0;
            } else
                arr[i] = str.charAt(i);
        }
        return String.valueOf(arr);
    }
}