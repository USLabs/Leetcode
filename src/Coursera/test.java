package Coursera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by uslabs on 1/16/18.
 */
public class test {

    static ArrayList<Integer>findUndominatedPairIndexes(int[][]arrayOfPairs)
    {
        ArrayList<Integer>result=new ArrayList<Integer>();
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;
        int i=arrayOfPairs.length;
        /**
         * get the max value
         */
        for(;--i>=0;)
        {
            int x=arrayOfPairs[i][0];
            int y=arrayOfPairs[i][1];
            if (x>maxX)
            {
                maxX=x;
            }
            if (y>maxY)
            {
                maxY=y;
            }
        }
        for(i=arrayOfPairs.length;--i>=0;)
        {
            int[] pair=arrayOfPairs[i];
            if (pair[0]>=maxX||pair[1]>=maxY)
            {
                result.add(new Integer(i));
            }

        }
        return result;
    }

    public static void solution() {
        //int[][] arr = {{3, 2}, {8,7},{6,9},{3,4},{7,8}};
        //ArrayList<Integer> list = findUndominatedPairIndexes(arr);
        //System.out.println(list);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<alpha> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new alpha(x, y));
        }

        Collections.sort(list, new Comparator<alpha>() {
            @Override
            public int compare(alpha o1, alpha o2) {
                return o1.x-o2.x;
            }
        });

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = 0;
            for (int j = 0; j < list.size(); j++) {
                if (i == j)
                    continue;
                if (list.get(j).y > list.get(i).y && list.get(j).x > list.get(i).x)
                    break;
                else temp++;
            }
            if (temp == list.size() - 1)
                count++;
        }
        System.out.println(count);

    }

    static class alpha {
        public int x;
        public int y;

        alpha(int a, int b) {
            x = a;
            y = b;
        }
    }
}
