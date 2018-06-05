// 57. Insert Interval

public class InsertInterval {
	
	public static void main(String[] args) {
        Interval i1 = new Interval(2,3);
        Interval i2 = new Interval(4,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,10);
        Interval i5 = new Interval(12,16);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        List<Interval> lists = insert(intervals, new Interval(8,13));
        /*
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6,9);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        List<Interval> lists = insert(intervals, new Interval(2,5));
        */
        System.out.println("123");
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();

        int i = 0;
        for(; i<intervals.size(); i++) {
            if(newInterval == null) break;

            Interval current =  intervals.get(i);
            if(current.end < newInterval.start) {
                list.add(current);
            } else if(newInterval.end < current.start) {
                list.add(newInterval);
                list.add(current);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
            }
        }

        for(;i<intervals.size(); i++) list.add(intervals.get(i));

        if(newInterval != null) list.add(newInterval);

        return  list;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
	
}