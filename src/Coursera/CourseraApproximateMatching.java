package Coursera;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by uslabs on 1/16/18.
 */
public class CourseraApproximateMatching {
    public static void solution() {
        System.out.println(calculateScore("nothing", "bruno", "ingenious"));
    }

    static String calculateScore(String text, String prefix, String suffix) {
        int totalCount = -1;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String str = text.substring(i, j);
                int prefixCount = getPrefixCount(str, prefix);
                int suffixCount = getPrefixCount(suffix, str);
                if (totalCount < prefixCount + suffixCount) {
                    list = new ArrayList<>();
                    list.add(str);
                    totalCount = prefixCount + suffixCount;
                } else if (totalCount == prefixCount + suffixCount)
                    list.add(str);
            }
        }
        Collections.sort(list);
        return list.get(0);
    }

    static int getPrefixCount(String str, String prefix) {
        for (int p = 0; p < prefix.length(); p++) {
            if (prefix.charAt(p) == str.charAt(0)) {
                int i = 0;
                for (; i + p < prefix.length(); i++) {
                    if (i>=str.length() || prefix.charAt(p + i) != str.charAt(i))
                        break;
                }
                if (p + i == prefix.length())
                    return prefix.length() - p;
            }
        }
        return 0;
    }
}
