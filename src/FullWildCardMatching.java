import java.util.*;

/**
 * Created by techmint on 10/17/16.
 */
public class FullWildCardMatching {
    public static boolean check(int si, int pi, String s, String p, LinkedList<sipi> q, Stack<sipi> backtrack) {
        int si2;
        boolean starred = false;
        if (s.length() == 0) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        for (; pi < p.length(); pi++) {
            if (p.charAt(pi) == '?' || p.charAt(pi) == '*') {
                q.add(new sipi(-1, si, p.charAt(pi)));
            } else {
                while (!q.isEmpty()) {
                    sipi oper = q.poll();
                    if (oper.op == '?')
                        si++;
                    if (oper.op == '*')
                        starred = true;
                }
                if (si >= s.length())
                    return false;
                if (starred == true) {
                    starred = false;
                    int st = s.substring(si).indexOf(p.charAt(pi));
                    if (st == -1) {
                        if (backtrack.isEmpty())
                            return false;
                        else {
                            sipi temp = backtrack.pop();
                            si = temp.si + 1;
                            pi = temp.pi;
                            continue;
                        }
                    } else {
                        si = si + st + 1;
                        st = s.substring(si).indexOf(p.charAt(pi));
                        si2 = si;
                        if (st != -1) {
                            do {
                                si2 = st + si2;
                                backtrack.push(new sipi(si2, pi));
                                st = s.substring(si2 + 1).indexOf(p.charAt(pi)) + 1;
                            }
                            while (st > 0);
                        }
                        continue;
                    }
                } else {
                    if (s.charAt(si) == p.charAt(pi)) {
                        si++;
                        continue;
                    } else {
                        if (backtrack.isEmpty())
                            return false;
                        else {
                            si = backtrack.pop().si + 1;
                            pi--;
                        }
                    }
                }
            }
        }

        starred = false;
        if (!q.isEmpty()) {
            while (!q.isEmpty()) {
                sipi oper = q.poll();
                if (oper.op == '?') {
                    si++;
                }
                if (oper.op == '*') {
                    starred = true;
                    continue;
                }
            }
            if (starred) {
                if (si <= s.length() && pi == p.length())
                    return true;
                else
                    return false;
            }
        }

        if (si == s.length() && pi == p.length()) return true;
        else {
            while (!backtrack.isEmpty()) {
                sipi test = backtrack.pop();
                si = test.si;
                pi = test.pi;
                if (check(si, pi, s, p, q, backtrack))
                    return true;
            }
            return false;
        }
    }

    public static boolean isMatch(String s, String p) {
        int si = 0, pi = 0, si2;
        boolean starred = false;
        LinkedList<sipi> q = new LinkedList<sipi>();
        Stack<sipi> backtrack = new Stack<sipi>();
        return check(si, pi, s, p, q, backtrack);
    }
}

class sipi {
    int si;
    int pi;
    char op;

    sipi(int a, int b) {
        si = a;
        pi = b;
    }

    sipi(int a, int b, char c) {
        si = a;
        pi = b;
        op = c;
    }
}