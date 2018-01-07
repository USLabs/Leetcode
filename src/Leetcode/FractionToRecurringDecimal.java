package Leetcode;

import java.util.ArrayList;

/**
 * Created by uslabs on 10/14/17.
 */
public class FractionToRecurringDecimal {
    public static void solution() {
        //System.out.println(fractionToDecimal(1, 2));
        //System.out.println(fractionToDecimal(2, 1));
        //System.out.println(fractionToDecimal(2, 3));
        //System.out.println(fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal(-1, -2147483648));
        System.out.println("Expected : ");
        System.out.println("0.0000000004656612873077392578125");
    }

    public static String fractionToDecimal(int num, int den) {
        long numerator = (long) num;
        long denominator = (long) den;
        int sign = ((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0)) ? 1 : -1;
        if (numerator == 0)
            sign = 1;
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long rem = numerator % denominator;
        //sb.append(numerator / denominator + ".");
        while (!list.contains(rem)) {
            list.add(rem);
            rem *= 10;
            list2.add(rem / denominator);
            rem = rem % denominator;
        }

        int i = list.indexOf(rem);
        StringBuilder sb = new StringBuilder();
        sb.append(numerator / denominator);
        boolean flag = false;


        for (int a = 0; a < list2.size(); a++) {
            if (a == 0)
                sb.append(".");
            if (a == i) {
                flag = true;
                sb.append("(");
            }
            sb.append(list2.get(a));
        }

        if (flag) {
            sb.append(")");
        }

        int r = sb.indexOf("(0)");
        if (r != -1)
            sb.delete(r, r + 3);

        if (sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
        if (sign == -1)
            sb.insert(0, "-");
        return sb.toString();
    }
}