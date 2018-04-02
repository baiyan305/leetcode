// 152. Maximum Product Subarray

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,-2,-2,0,-2}));
        System.out.println(maxProduct(new int[]{3,-1,4}));
    }

    public static int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int result = nums[0], max = nums[0], min = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > 0) {
                max = Math.max(nums[i]*max, nums[i]);
                min = Math.min(nums[i]*min, nums[i]);
            }else{
                int tmp = max;
                max = Math.max(nums[i]*min, nums[i]);
                min = Math.min(nums[i]*tmp, nums[i]);
            }

            result = Math.max(result, max);
        }
        
        return result;   
    }

}
