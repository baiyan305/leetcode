// 56. Merge Intervals

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

    // 创建一个新的List
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if(intervals == null || intervals.size() == 0) return res;

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        res.add(intervals.get(0));
        Interval last = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if(last.end >= cur.start) {
                last.end = Math.max(last.end, cur.end);
            } else {
                res.add(cur);
                last = cur;
            }
        }

        return res;
    }

    /* 不创建新List, 在输入的List中直接merge
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        Interval previous = null;
        Iterator<Interval> iterator = intervals.iterator();
        while(iterator.hasNext()) {
            Interval cur = iterator.next();
            if(previous == null || previous.end < cur.start) {
                previous = cur;
            } else {
                iterator.remove();
                previous.end = cur.end;
            }
        }

        return intervals;
    }
    */
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
	
}