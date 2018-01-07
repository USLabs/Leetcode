package Leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by techmint on 10/27/16.
 */

/*
[1,3],[2,6],[8,10],[15,18],
[1,6],[8,10],[15,18].
*/

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int k = 0;
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval e = intervals.get(i);
            if (i == 0) {
                result.add(new Interval(e.start, e.end));
                continue;
            }
            if (e.start <= result.get(k).end) {
                result.get(k).end = Math.max(result.get(k).end, e.end);
            } else {
                result.add(new Interval(e.start, e.end));
                k++;
            }

        }
        return result;
    }

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}