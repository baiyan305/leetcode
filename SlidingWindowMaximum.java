// 239. Sliding Window Maximum

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public void run() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] windows = maxSlidingWindow(nums, 3);

        System.out.println("123");
    }

    // 队列中的元素，是从大到小递减的。单调递减队列。
    // 头部元素就是当前window最大值。
    // 每次循环到一个新的元素时，从后往前，比较队列中的元素和新元素。
    // 如果队列中的元素比新元素小，那么出队。
    // 因为他们对于寻找后面window的最大值，已经没有意义了。
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> queue = new LinkedList<>();

        for(int i=0; i<len; i++) {
            // 如果队列头部元素，比window范围小，那么需要出队
            if(i>=k && queue.getFirst() <= i-k) queue.removeFirst();
            // 从后往前，比较队列中的元素和nums[i], 如果队列中的元素比nums[i]小，那么出队。
            // 因为他们对于得到后面window的maximum已经没有意义了。
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) queue.removeLast();
            // 新元素加入队列
            queue.add(i);
            //更新结果
            if(i>=k-1) res[i-k+1] = nums[queue.getFirst()];
        }

        return res;
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
