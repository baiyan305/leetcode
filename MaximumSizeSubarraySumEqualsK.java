// 325. Maximum Size Subarray Sum Equals k

import java.util.*;

public class MaximumSizeSubarraySumEqualsK {
	public void run() {

        System.out.println(maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
        System.out.println("123");
    }

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, res = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int tmp = sum-k;

            if(map.containsKey(tmp)) res = Math.max(res, i-map.get(tmp));
            if(!map.containsKey(sum)) map.put(sum ,i);
        }

        return res;
    }
}