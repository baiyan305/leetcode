// 871. Minimum Number of Refueling Stops

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

    public void run() {
        //int[][] stations = {{10,60},{20,30},{30,30},{60,40}};
        //System.out.println(minRefuelStops(100, 10, stations));
        int[][] stations = {{10, 100},{20, 50},{30, 40}};
        System.out.println(minRefuelStops(200, 10, stations));
        //int[][] stations = {{25, 50},{50, 25}};
        //System.out.println(minRefuelStops(100, 50, stations));
    }

    // PriorityQueue - 16ms
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        int stops = 0, prevLocation = 0, fuel = startFuel;
        for(int i =0; i<=stations.length; i++) {
            int[] station = i==stations.length ? new int[]{target, 0} : stations[i];
            fuel -= station[0] - prevLocation;
            while(fuel < 0 && !queue.isEmpty()) {
                fuel += queue.poll();
                stops++;
            }

            if(fuel < 0) return -1;
            queue.offer(station[1]);
            prevLocation = station[0];
        }

        return stops;
    }

    /* DP - 外层循环是station，内层循环是停留次数 - 36ms
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length+1];
        dp[0] = startFuel;

        for(int station = 0; station < stations.length; station++) { // station
            for(int stop = station+1; stop > 0 && dp[stop-1]>= stations[station][0]; stop--) { // number of stop
                dp[stop] = Math.max(dp[stop], dp[stop-1] + stations[station][1]);
                if(dp[stop] >= target) return stop;
            }

        }

        return -1;
    }
    */
    /* DP - 外层是停留次数，内层是station - 11ms
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;

        long[] dp = new long[stations.length+1];
        dp[0] = startFuel;

        boolean[] used = new boolean[stations.length];
        for(int stop = 1; stop<=stations.length; stop++) {
            int stopStation = 0;
            for(int station = 0; station < stations.length && dp[stop-1] >= stations[station][0]; station++) {
                if(!used[station] && dp[stop-1] + stations[station][1] > dp[stop]) {
                    dp[stop] = dp[stop-1] + stations[station][1];
                    if(dp[stop] >= target) return stop;
                    stopStation = station;
                }
            }
            used[stopStation] = true;
        }

        for(int i=0; i<dp.length; i++) if(dp[i] >= target) return i;

        return -1;
    }
    */

}