// 198. House Robber

class HouseRobber {

    public static void main(String[] args){
        System.out.println(rob(new int[]{1,2,3,4,5,6}));
    }

    public static int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int house1 = 0, house2 = nums[0];

        for(int i=1; i<nums.length; i++) {
            int max = Math.max(nums[i]+house1, house2);
            house1 = house2;
            house2 = max;         
        }

        return house2;
    }
}