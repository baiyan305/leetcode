// 253. Meeting Rooms II

public class MeetingRoomsII {
	
	public void run() {
        System.out.println("123");
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    /* PriorityQueue
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int idx_end = 0, rooms = 0;
        for(int idx_start=0; idx_start<starts.length; idx_start++) {
            if(starts[idx_start] < ends[idx_end]) {
                rooms++;
            } else {
                idx_end++;
            }
        }

        return rooms;
    }
    */
	
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        for(Interval interval : intervals) {
            if(!queue.isEmpty() && interval.start >= queue.peek().end) queue.poll();
            queue.add(interval);
        }

        return queue.size();
    }

	
}