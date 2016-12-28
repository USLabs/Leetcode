/**
 * Created by techmint on 11/24/16.
 */
public class google1 {
    public static String first(String s, int k) {
        String result = "";
        s = s.toUpperCase();
        int dashcnt = 0, charcnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-')
                dashcnt++;
        }
        charcnt = s.length() - dashcnt;
        int fcnt = charcnt % k, st = 0;
        boolean fdone = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j < fcnt) {
                if (s.charAt(i) != '-')
                {
                    result += s.charAt(i);
                    j++;
                }
                else {
                    continue;
                }
            } else {
                if (!fdone) {
                    result += "-";
                    st = 0;
                }
                if (s.charAt(i) != '-') {
                    if (st < k) {
                        result += s.charAt(i);
                        st++;
                    } else {
                        fdone = false;
                        i--;
                    }
                }
            }
        }
        if (fcnt == 0)
            result = result.substring(1);
        return result;
    }

    public static void driver(){
        Tree t = new Tree(25);
        t.l = new Tree(19);
        t.l.l = new Tree(12);
        t.l.l.l = new Tree(4);
        t.r = new Tree(37);
        t.r.l = new Tree(29);
        t.r.l.r = new Tree(30);
        t.l.r = new Tree(22);
        t.l.r.r = new Tree(23);

        System.out.println(google2_2.solution(4, 32, t));
    }
}