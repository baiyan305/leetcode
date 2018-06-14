// 560. Subarray Sum Equals K

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum-k, 0);
            if(map.containsKey(sum)) map.put(sum, map.get(sum)+1);
            else map.put(sum, 1);
        }

        return count;
    }

}