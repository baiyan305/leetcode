// 621. Task Scheduler

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        //String str = "AAABBB";
        String str = "AAAAAABCDEFG";
        //char[] tasks = {'A','C','C','C','E','E','E'};
        System.out.println(leastInterval(str.toCharArray(), 1));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] counting = new int[26];
        for(char task : tasks) counting[task - 'A']++;

        PriorityQueue<Integer> queue = new PriorityQueue<>(26, new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int2 - int1;
            }
        });
        for(int i : counting) if(i != 0) queue.add(i);

        int capacity = n+1, leastInterval = 0;
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<capacity; i++) if(!queue.isEmpty()) list.add(queue.poll());

            int interval = list.size();
            for(int count : list) if(count -1 > 0) queue.add(count-1);

            interval += queue.isEmpty() ? 0 : capacity - interval;

            leastInterval += interval;
        }

        return leastInterval;
    }


}