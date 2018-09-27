// 630. Course Schedule III

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public void run() {
        /*
        int[][] arr = {
                {100,200},
                {200,1300},
                {1000,1250},
                {2000,3200}
        };
        */

        int[][] arr = {
                {100,2},
                {32,50}
        };
        System.out.println(scheduleCourse(arr));
    }

    // 贪心算法
    // 首先将课程按照deadline从小到大排序
    // 之后创建一个PriorityQueue来存储上的课
    // 一个time来追踪起始时间。开始是0，之后每take一个课，time会增加
    // 对于每一个课程，有以下几种情况：
    //     1. time + 课程长度  <= deadline, 那么这个课是肯定可以take的。将其加入PriorityQueue
    //     2. time + 课程长度  > deadline, 那么说明这个take这个课超时了。如果还要上这个课的话，就要从已经take的课里面删除一个。那肯定是删除pq里面耗时最长的。
    //        把耗时最长的课程删除掉，加入当前课程。那么修的课程数目没变，但是消耗的时间变少了。
    //        2.1 如果当前课程时间 < pq.peek, 那么删除掉pe.peek
    //        2.2 当前课程时间比 pe.peek大，那么就跳过当前课程。
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b)->a[1]-b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int time = 0;
        for(int[] course : courses) {
            if(time+course[0]<=course[1]) {
                time += course[0];
                pq.add(course[0]);
            } else {
                if(!pq.isEmpty() && course[0] < pq.peek()) {
                    time -= pq.poll();
                    time += course[0];
                    pq.add(course[0]);
                }
            }
        }

        return pq.size();
    }

}