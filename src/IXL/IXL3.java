package IXL;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by uslabs on 12/13/17.
 */
public class IXL3 {
    public static void solution() {

    }

    private static int maximumGroups(int[] arr) {
        int count = 0;

        HashMap<Integer, Integer> mappy = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mappy.putIfAbsent(i, arr[i]);
        }

        boolean flag = true;
        while (mappy.size()>0) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1) {
                    if (flag) {
                        count++;
                    }
                    mappy.remove(new Integer(i));
                    flag = false;
                }
                if(arr[arr[i]]<0){

                }
            }
        }
        return count;
    }
}
