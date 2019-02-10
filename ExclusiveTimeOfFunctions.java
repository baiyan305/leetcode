// 636. Exclusive Time of Functions

public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        // stack里面存的是id
        // 当有start事件时，就把id加入到stack里面
        //
        // event: 0-start        1-start        1-end         2-start        2-end        0-end
        // time:    0    --事件0--   2   --事件1--  4  --事件0--   6   --事件2--  7  --事件0--  10
        //
        // 为什么要存id到stack中呢。比如上面的例子，time-4到time-6之间的时间，在1-end和2-start之间
        // 我们怎么知道这段时间属于哪个任务呢？其实是事件0的时间。那么就需要stack来记录事件了。
        Stack<Integer> stack = new Stack<>();
        int prev_time = 0;
        for(String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);
            String state = strs[1];

            if(state.equals("start")) {
                if(!stack.isEmpty())
                    res[stack.peek()] += time - prev_time;
                stack.push(id);
                prev_time = time;
            } else {
                res[stack.peek()] += time - prev_time + 1;
                stack.pop();
                prev_time = time+1;
            }

        }

        return res;
    }

}
