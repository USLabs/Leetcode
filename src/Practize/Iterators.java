package Practize;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by uslabs on 11/11/17.
 */
public class Iterators {
    public static void practice() {
        //practiceEnumerator();
        System.out.println("------------------------");
        //practiceIterator();
        System.out.println("------------------------");
        //practiceListIterator();
        System.out.println("------------------------");
        practiceHashSet();
    }

    private static void practiceEnumerator() {
        Vector v = new Vector();
        for (int i = 0; i < 10; i++)
            v.addElement(i);
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }

    private static void practiceIterator() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            int i = (int) iter.next();
            System.out.println(i);
            if (i % 2 != 0)
                iter.remove();

        }
        System.out.println(list);
    }

    private static void practiceListIterator() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);
        ListIterator lter = list.listIterator();
        while (lter.hasNext()) {
            int i = (Integer) lter.next();
            System.out.println(i);
            if (i % 2 == 0) {
                i++;
                lter.set(i);
                lter.add(i);
            }
        }
    }

    private static void practiceHashSet() {
    }
}