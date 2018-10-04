// 239. Sliding Window Maximum

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public void run() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] windows = maxSlidingWindow(nums, 3);

        System.out.println("123");
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0) return new int[0];

        int len = nums.length, window = len-k+1;
        int[] res = new int[window];
        Deque<Integer> deque = new LinkedList();

        for(int i=0; i<len; i++) {
            if(!deque.isEmpty() && deque.getFirst() < i-k+1) deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) deque.removeLast();
            deque.addLast(i);

            if(i+1>=k) res[i-k+1] = nums[deque.getFirst()];
        }

        return res;
    }

}
