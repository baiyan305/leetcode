// 621. Task Scheduler

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        String str = "AAABBB";
        //String str = "AAAAAABCDEFG";
        //char[] tasks = {'A','C','C','C','E','E','E'};
        System.out.println(leastInterval(str.toCharArray(), 0));
    }

    public static int leastInterval(char[] tasks, int n) {
        int leastInterval = 0;

        int[] count = new int[26];
        for(char task : tasks) count[task - 'A']++;

        PriorityQueue<Integer> queue = new PriorityQueue<>(26, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2-num1;
            }
        });

        for(int num : count) if(num != 0) queue.add(num);

        int capacity = n + 1;
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<capacity; i++) {
                if(!queue.isEmpty()) {
                    list.add(queue.poll());
                    leastInterval++;
                }
            }

            int taskInSloth  = list.size();
            for(int cnt : list) {
                if(cnt-1 > 0) queue.add(cnt-1);
            }

            if(!queue.isEmpty()) leastInterval += capacity - taskInSloth;
        }

        return leastInterval;
    }


}