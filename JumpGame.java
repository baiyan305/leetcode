// 55. Jump Game

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        int limit = 0, dest = nums.length-1;
        for(int i=0; i<nums.length; i++) {
            if(limit>=dest) return true;
            if(i>limit) return false;
            limit = Math.max(limit, i+nums[i]);
        }

        return true;
    }    

}
