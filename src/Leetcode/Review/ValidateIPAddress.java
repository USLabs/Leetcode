package Leetcode.Review;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by uslabs on 10/14/17.
 */
public class ValidateIPAddress {
    public static void solution() {
        System.out.println(validateIPAddress2("2001:db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validateIPAddress2("2001:db8:85a3::8A2E:0370:7334"));
    }

    public static String validateIPAddress2(String IP) {
        String pattern1 = "^(0|1\\d?\\d?|2[0-4]\\d|25[0-5])\\.(0|1\\d?\\d?|2[0-4]\\d|25[0-5])\\.(0|1\\d?\\d?|2[0-4]\\d|25[0-5])\\.(0|1\\d?\\d?|2[0-4]\\d|25[0-5])$";
        String pattern2 = "^([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]{1,4})$";
        String pattern3 = "^(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$";

        /*

        (?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)

         */
        Pattern r1 = Pattern.compile(pattern1);
        Pattern r2 = Pattern.compile(pattern2);
        Pattern r3 = Pattern.compile(pattern3);

        Matcher m1 = r1.matcher(IP);
        Matcher m2 = r2.matcher(IP);
        Matcher m3 = r3.matcher(IP);

        if (m1.find())
            return "IPv4";
        if (m2.find())
            return "IPv6";
        if (m3.find())
            return "IPv6 Compressed";
        return "Neither";
    }
}
