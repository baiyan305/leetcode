// 334. Increasing Triplet Subsequence

public class IncreasingTripletSubsequence {
	
	public boolean increasingTriplet(int[] nums) {
        // small是较小的数字, large是较大的数字
        // 我们需要维护两个变量，这样新的数字来了后，我们才可以判断，是否构成triplet
        Integer small = null, large = null;
        for(int num : nums) {
            
            //如果新的数字比small小或者small为空
            //则small=num
            //为什么呢？
            //假设small和large都不为空，那么对于判断triplet来说，small已经没有意义了
            //因为我们之后large比small大，只要新来的数字比large大，那么一定是可以构成triplet的
            //
            //如果新来的数字比small小，为什么small=num呢
            //比如 2,5,1,2,3
            //small=2, large=5, 当遇到1时，需要将small=1，因为1的潜力更大
            if(small == null || num <= small) {
                small = num;
                continue;
            }
            
            //当新来的数字比small大，但是比large小时，需要large=num，
            //这样large就更可能比后面新来的数字小，就是组成triplet的可能性更大
            if(large == null || num <= large) {
                large = num;
            } else {
                return true;
            }
        }
        
        return false;
    }
	
}