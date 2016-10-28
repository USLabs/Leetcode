import java.util.ArrayList;
import java.util.List;

/**
 * Created by techmint on 10/27/16.
 */

/*
[1,3],[2,6],[8,10],[15,18],
[1,6],[8,10],[15,18].
*/

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>();
        return merged;
    }

    public static void printIntervals()
    {

    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
