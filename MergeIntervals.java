//56. Merge Intervals

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
        //int[] nums = {1,5,1};
        //int[] nums = {1,2,3,4,5};

        /*
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        */

        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(2,3);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        List<Interval> lists = merge(intervals);

        System.out.println("123");
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return list;

        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);

        list.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++) {
            Interval last = list.get(list.size()-1);
            Interval current = intervals.get(i);

            if(last.end < current.start) {
                list.add(new Interval(current.start, current.end));
            } else if(current.end > last.end) {
                last.end = current.end;
            }
        }

        return list;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
	
}