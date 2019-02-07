// 759. Employee Free Time

public class EmployeeFreeTime {

    //题意是给出几个员工的工作安排:
    //
    // 员工1: [3,5], [6,10]
    // 员工2: [1,4], [6,12]
    // 员工3: [2,5], [15,19]
    //
    // 找出所有员工都休息的时间断, 对于上面的例子就是[5,6],[12,15]
    //
    // 最简单的方法是将所有的员工看成一个人, 然后将所有的工作时间按照开始时间排序
    // 然后循环检查每一个interval(i), 并且用一个变量last来记录上一个遍历过的interval(last)
    // 如果i与last有重合, 那么他们之间是没有freetime的, 将i合并到last, 就是更新last.end
    // 如果i与last没有重合, 那么就是他们之间有freetime, 就是last.end到i.start
    //
    // 但是这样有点浪费空间. 其实不需要将所有的都一起排序, 而是维护一个PriorityQueue,
    // 第一次把所有员工的第1个工作时间加入到Queue中,
    // 然后弹出start time最早的, 比如是员工3的第一个工作时间最早
    // 然后把员工3的第2个工作时间加到Queue中
    //
    // 思路和第一种方法一样, 但是节省了空间
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();

        PriorityQueue<IntervalsWithIndex> queue = new PriorityQueue<>(new Comparator<IntervalsWithIndex>(){
            @Override
            public int compare(IntervalsWithIndex list1, IntervalsWithIndex list2) {
                return list1.list.get(list1.index).start - list2.list.get(list2.index).start;
            }
        });

        for(List<Interval> intervals : schedule)
            if(intervals != null && intervals.size() > 0)
                queue.add(new IntervalsWithIndex(intervals));

        Interval last = null;
        while(!queue.isEmpty()) {
            IntervalsWithIndex intervals = queue.poll();
            Interval interval = intervals.list.get(intervals.index);

            if(last == null) {
                last = interval;
            } else if(interval.start <= last.end) {
                last.end = Math.max(last.end, interval.end);
            } else {
                Interval gap = new Interval(last.end, interval.start);
                last = interval;
                res.add(gap);
            }

            intervals.index++;
            if(intervals.index < intervals.list.size()) queue.add(intervals);
        }

        return res;
    }

    class IntervalsWithIndex {
        List<Interval> list;
        int index;

        public IntervalsWithIndex(List<Interval> list){
            this.list = list;
            index = 0;
        }
    }

}
