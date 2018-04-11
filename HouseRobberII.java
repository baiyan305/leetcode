// 213. House Robber II

public class HouseRobberII {

    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        return Math.max(helper(nums, 0, nums.length-2),helper(nums, 1, nums.length-1));
    }

    private static int helper(int[] nums, int start, int end) {
        int house1 = 0, house2 = nums[0];

        for(int i=start; i<=end; i++) {
            int max = Math.max(nums[i]+house1, house2);
            house1 = house2;
            house2 = max;         
        }

        return house2;
    }

}