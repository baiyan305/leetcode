class FreeTime {
    
    public List<Interval> freetime(List<Interval> list, Interval j) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(list, (a,b)->a.start-b.start);

        Interval prev = null;
        for(Interval i : list) {
            // i不在j的范围内，直接忽略
            if(i.end<=j.start || j.end<=i.start)
                continue;
            // i比j范围大，那么不可能有任何合法的freetime
            if(i.start<=j.start && i.end >= j.end)
                return res;
            // free time找到了
            // start是前一个的end, 如果前一个是空，那么start是j的开头
            // 还有就是start不能等于end, 比如[12,13],[13,14], j是[10,20]
            if(i.start > j.start){
                int start = prev==null? j.start : prev.end;
                int end = i.start;
                if(start != end)
                    res.add(new Interval(start, end));
            }
            // 更新prev, 只有i的结尾比j的结尾小，才是合法的prev
            prev = i.end<j.end? i : null;
        }

        if(res.size()==0 || prev != null)
            res.add(new Interval(prev==null?j.start:prev.end, j.end));

        return res;
    }

}