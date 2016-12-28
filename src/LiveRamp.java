public class LiveRamp {
    public static String time(int A, int B, int C, int D) {
        int[] arr = new int[4];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = D;
        String s = Integer.toString(A) + Integer.toString(B) + Integer.toString(C) + Integer.toString(D);
        String s2 = new String(s), result = "";
        for (int i = 2; i >= 0; i--) {
            int first = exists(i, s2);
            if (first != -1) {
                if (i == 2) {

                    //Remove first
                    if (first == 0)
                        s2 = s2.substring(1);
                    else
                        s2 = s2.substring(0, first) + s2.substring(first + 1);

                    for (int j = 3; j >= 0; j--) {
                        int second = exists(j, s2);
                        if (second != -1) {

                            //Remove second
                            if (second == 0)
                                s2 = s2.substring(1);
                            else
                                s2 = s2.substring(0, second) + s2.substring(second + 1);

                            for (int k = 5; k >= 0; k--) {
                                int third = exists(k, s2);
                                if (third != -1) {
                                    if (third == 0) {
                                        result = Integer.toString(i) + Integer.toString(j) + ":" + s2.charAt(0) + s2.charAt(1);
                                        return result;
                                    } else {
                                        result = Integer.toString(i) + Integer.toString(j) + ":" + s2.charAt(1) + s2.charAt(0);
                                        return result;
                                    }
                                }
                            }

                            //Adding second
                            s2 = s2.substring(0, second) + Integer.toString(j) + s2.substring(second);
                        }
                    }

                    //Adding first
                    s2 = s2.substring(0, first) + Integer.toString(i) + s2.substring(first);
                }

                if (i == 1 || i == 0) {

                    //Remove first
                    if (first == 0)
                        s2 = s2.substring(1);
                    else
                        s2 = s2.substring(0, first) + s2.substring(first + 1);

                    for (int j = 9; j >= 0; j--) {
                        int second = exists(j, s2);
                        if (second != -1) {

                            //Remove second
                            if (second == 0)
                                s2 = s2.substring(1);
                            else
                                s2 = s2.substring(0, second) + s2.substring(second + 1);

                            for (int k = 5; k >= 0; k--) {
                                int third = exists(k, s2);
                                if (third != -1) {
                                    if (third == 0) {
                                        result = Integer.toString(i) + Integer.toString(j) + ":" + s2.charAt(0) + s2.charAt(1);
                                        return result;
                                    } else {
                                        result = Integer.toString(i) + Integer.toString(j) + ":" + s2.charAt(1) + s2.charAt(0);
                                        return result;
                                    }
                                }
                            }

                            //Adding second
                            s2 = s2.substring(0, second) + Integer.toString(j) + s2.substring(second);
                        }
                    }

                    //Adding first
                    s2 = s2.substring(0, first) + Integer.toString(i) + s2.substring(first);
                }
            }
        }
        return "NOT POSSIBLE";
    }

    static boolean isExists(int x, int[] arr) {
        return true;
    }

    static int exists(int x, String s) {
        return s.indexOf(Integer.toString(x));
    }
}