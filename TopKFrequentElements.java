// 347. Top K Frequent Elements

import java.util.*;

public class TopKFrequentElements {

    public void run() {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2 ));
        System.out.println(topKFrequent(new int[]{1}, 1));
    }

    // Use PriorityQueue
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.containsKey(i) ? map.get(i)+1 : 1);

        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), appear = entry.getValue();
            queue.offer(new int[]{num, appear});
            if(queue.size() > k) queue.poll();
        }

        List<Integer> res = new LinkedList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll()[0]);
        }

        return res;
    }

    /* Bucket Sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.containsKey(i) ? map.get(i)+1 : 1);

        List<Integer>[] frequency = new ArrayList[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), appear = entry.getValue();
            if(frequency[appear] == null) frequency[appear] = new ArrayList<>();
            frequency[appear].add(num);
        }

        List<Integer> res = new LinkedList<>();
        for(int i=frequency.length-1; i>=0; i--) {
            List<Integer> list = frequency[i];
            if(list != null) {
                for(int j : list) {
                    res.add(j);
                    if(res.size() == k) return res;
                }
            }
        }

        return res;
    }
    */

}
