import java.util.IntSummaryStatistics;
import java.util.List;

public class Runner {
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