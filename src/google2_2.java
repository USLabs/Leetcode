/**
 * Created by techmint on 12/5/16.
 */
public class google2_2 {
    public static int myMax = 0;
    public static boolean l = false, r = false, p = false;

    public static int solution(int min, int max, Tree t1) {
        solutionUtil(min, max, t1);
        return myMax;
    }

    public static int solutionUtil(int min, int max, Tree t1) {
        if (t1 == null) {
            p = true;
            return 0;
        }
        if (t1.val >= min && t1.val <= max) {
            if (t1.l == null && t1.r == null) {
                p = true;
                return 1;
            }
            p = false;
            int left = solutionUtil(min, max, t1.l);
            if (p) {
                l = true;
            }
            p = false;
            int right = solutionUtil(min, max, t1.r);
            if (p) {
                r = true;
            }

            if (left < 0) {
                if (right < 0) {
                    return -1;
                } else {
                    myMax = Math.max(myMax, right);
                    return -1;
                }
            } else {
                if (right < 0) {
                    myMax = Math.max(myMax, left);
                    return -1;
                } else {
                    myMax = Math.max(myMax, 1 + left + right);
                    return myMax;
                }
            }
        } else {
            if (t1.val < min) {
                myMax = Math.max(myMax, solutionUtil(min, max, t1.r));
                return -1;

            }
            if (t1.val > max) {
                myMax = Math.max(myMax, solutionUtil(min, max, t1.l));
                return -1;
            }
        }
        return myMax;
    }
}