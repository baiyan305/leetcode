// 659. Split Array into Consecutive Subsequences

import java.util.HashMap;

public class SplitArrayIntoConsecutiveSubsequences {

    public void run() {
        System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
        System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
        System.out.println(isPossible(new int[]{1,2,3,4,4,5}));
    }

    // 贪心算法
    // 一个数字，只有三种情况
    // 1. 可以加入到之前的序列中, 检查num-1是否存在
    // 2. 不能加入之前的序列中, 但是可以做为一个新的序列的开头, 检查num+1, num+2是否存在
    // 3. 不能加入前面的序列, 也不能作为新的序列开头, 直接返回false
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();

        for(int num : nums)
            count.put(num, count.getOrDefault(num, 0)+1);

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];

            // 检查当前数字是否可用，比如对于 {1,2,3,4,5}
            // 当遍历到1的时候，发现1是一个sequence的开头，将1,2,3, 在count中-1
            // 当遍历到2的时候，先检查count[2]是不是0，如果是0就跳过，不是0再做继续处理
            if(count.getOrDefault(num, 0) == 0) {
                continue;
            }
            // 检查num是否可以被加到之前的sequence
            else if(end.getOrDefault(num-1,0) > 0) {
                end.put(num-1, end.get(num-1)-1);
                end.put(num, end.getOrDefault(num, 0)+1);
            }
            // 检查num是否可以作为一个sequence的起点。其实就是检查num+1, num+2是否还有。
            else if(count.getOrDefault(num+1, 0) > 0 && count.getOrDefault(num+2, 0) > 0) {
                count.put(num+1, count.get(num+1)-1);
                count.put(num+2, count.get(num+2)-1);
                end.put(num+2, end.getOrDefault(num+2, 0)+1);
            }
            // 既不可以加入到之前的sequence中，也不能作为一个新的sequence的开头，那么返回false
            else {
                return false;
            }

            count.put(num, count.get(num)-1);
        }

        return true;
    }

}
