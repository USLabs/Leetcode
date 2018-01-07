package Leetcode;

/**
 * Created by techmint on 10/17/16.
 */
public class PartialWildCardMatching {
    public static boolean isMatch(String s, String p) {
        char lastch = '\0';
        int k = 0, start = 0;
        boolean first = false;
        for (int i = start; i < s.length(); i++) {
            for (int j = k; j < p.length(); j++) {
                if (p.charAt(j) == '?') {
                    if (lastch == '*')
                        continue;
                    k = j + 1;
                    break;
                } else {
                    if (p.charAt(j) == '*') {
                        lastch = '*';
                        k = j + 1;
                        continue;
                    } else {
                        if (lastch == '*') {
                            i = s.substring(start + 1).indexOf(p.charAt(j)) + start + 1;
                            k = j + 1;
                            break;
                        }
                        if (p.charAt(j) == s.charAt(i)) {
                            k = j + 1;
                            if (first = false) {
                                start = j;
                                first = true;
                            }
                            break;
                        } else {
                            if (first) {
                                int st = s.substring(start + 1).indexOf(s.charAt(start));
                                if (st == -1)
                                    return false;
                                start = st + start + 1;
                                k = 1;
                            } else {
                                int st = start = s.substring(start + 1).indexOf(p.charAt(j));
                                if (st == -1)
                                    return false;
                                start = st + start + 1;
                                first = true;
                                k = j + 1;
                            }
                            i = start;
                            break;
                        }
                    }
                }
            }
        }
        return (k == p.length()) ? true : false;
    }
}