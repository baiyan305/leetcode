// 218. The Skyline Problem

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {

    public void run() {
        int[][] buildings = {
                {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}
        };

        int[][] buildings1 = {
                {0,2,3}, {2,5,3}
        };

        List<int[]> points = getSkyline(buildings);

        System.out.println("123");
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        List<int[]> res = new ArrayList<>();

        for(int[] building : buildings) {
            points.add(new int[]{building[0], building[2]});
            points.add(new int[]{building[1], -building[2]});
        }

        Collections.sort(points, (a, b)->{
            return a[0] == b[0] ? b[1]-a[1] : a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.add(0);
        for(int[] point : points) {
            if(point[1] > 0) { // a start point
                if(point[1] > pq.peek()) {
                    res.add(point);
                }
                pq.add(point[1]);
            } else { // a end point
                if(-point[1] == pq.peek()) {
                    pq.remove(-point[1]);
                    if(-point[1] != pq.peek())res.add(new int[]{point[0], pq.peek()});
                } else {
                    pq.remove(-point[1]);
                }
            }
        }

        return res;
    }

}