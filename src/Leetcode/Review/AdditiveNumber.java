package Leetcode.Review;

import java.math.BigInteger;

/**
 * Created by uslabs on 10/23/17.
 */
public class AdditiveNumber {
    public static void solution() {
        System.out.println(isAdditiveNumber("112358"));
    }

    public static boolean isAdditiveNumber(String s) {
        return isAdditiveNumberUtil(s, 0, BigInteger.valueOf(-1), BigInteger.valueOf(-1), BigInteger.valueOf(-1));
    }

    public static boolean isAdditiveNumberUtil(String s, int start, BigInteger p, BigInteger p1, BigInteger p2) {
        if (p.equals(BigInteger.valueOf(-1))) {
            for (int i = 1; i < s.length(); i++) {
                for (int j = 1; j < s.length(); j++) {
                    if ((start + i + j) >= s.length())
                        break;
                    BigInteger a = new BigInteger(s.substring(start, start + i));
                    BigInteger b = new BigInteger(s.substring(start + i, start + i + j));
                    if (s.charAt(start) == '0' && !a.equals(BigInteger.ZERO))
                        return false;
                    if (s.charAt(start + i) == '0' && !b.equals(BigInteger.ZERO))
                        break;
                    if (isAdditiveNumberUtil(s, start + i + j, a.add(b), a, b))
                        return true;
                }
            }
        } else {
            if(start>=s.length())
                return true;
            BigInteger t = new BigInteger(p.toString());
            int c = 0;
            while (t.compareTo(BigInteger.ZERO) > 0) {
                t = t.divide(BigInteger.TEN);
                c++;
            }
            if (p.equals(BigInteger.ZERO))
                c = 1;
            if ((start + c) <= s.length()) {
                BigInteger p3 = new BigInteger(s.substring(start, start + c));
                if (p.equals(p3))
                    return isAdditiveNumberUtil(s, start + c, p2.add(p3), p2, p3);
            } else
                return false;
        }
        return false;
    }
}
