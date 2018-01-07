package Leetcode;

public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        int[][] table = new int[m][n];
        return isInterleaveUtil(s1, s2, s3, table, 0, 0, 0);
    }

    public static boolean isInterleaveUtil(String s1, String s2, String s3, int[][] table, int ii, int jj, int kk) {
        String s11, s22, s33;
        if (ii >= s1.length() && jj >= s2.length() && kk >= s3.length()) {
            return true;
        }

        if (ii >= s1.length()) {
            s11 = "";
            s22 = s2.substring(jj);
        } else {
            if (jj >= s2.length()) {
                s22 = "";
                s11 = s1.substring(ii);
            } else {
                s11 = s1.substring(ii);
                s22 = s2.substring(jj);
            }
        }
        s33 = s3.substring(kk);
        int l1 = s11.length(), l2 = s22.length(), l3 = s33.length();
        if (l3 != (l1 + l2)) {
            return false;
        }
        if (l1 == 0)
            return s22.equals(s33);

        if (l2 == 0)
            return s11.equals(s33);

        if (table[ii][jj] == 1)
            return true;

        if (table[ii][jj] == -1)
            return false;


        if (s1.charAt(ii) == s3.charAt(kk) && isInterleaveUtil(s1, s2, s3, table, ii + 1, jj, kk + 1)) {
            table[ii][jj] = 1;
            return true;
        }

        if (s2.charAt(jj) == s3.charAt(kk) && isInterleaveUtil(s1, s2, s3, table, ii, jj + 1, kk + 1)) {
            table[ii][jj] = 1;
            return true;
        }

        table[ii][jj] = -1;
        return false;
    }
}

class DriverInterleavingString {
    public static void main(String[] args) {
        System.out.println(InterleavingString.isInterleave(
                "aabcc",
                "dbbca",
                "aadbbcbcac"));
        System.out.println(InterleavingString.isInterleave(
                "aabcc",
                "dbbca",
                "aadbbbaccc"));
        System.out.println(InterleavingString.isInterleave(
                "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
        System.out.println(InterleavingString.isInterleave(
                "aa",
                "ab",
                "aaba"));
        System.out.println(InterleavingString.isInterleave(
                "aabcd",
                "aabcdq",
                "aabcdqaabcd"));
        System.out.println(InterleavingString.isInterleave(
                "aaaabc",
                "aabad",
                "aaaaabacbad"));
        System.out.println(InterleavingString.isInterleave(
                "aaaabc",
                "aabad",
                "aaaaabaabcd"));
        System.out.println(InterleavingString.isInterleave(
                "aabc",
                "abad",
                "aabacbad"));
        System.out.println(InterleavingString.isInterleave(
                "aabd",
                "abdc",
                "aabdabcd"));
        System.out.println(InterleavingString.isInterleave(
                "aabc",
                "abad",
                "aabaabdc"));
        System.out.println(InterleavingString.isInterleave(
                "aa",
                "ab",
                "abaa"
        ));

        System.out.println(InterleavingString.isInterleave(
                "",
                "",
                "a"
        ));
    }
}