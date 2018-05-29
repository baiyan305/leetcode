// 45. Jump Game II

public class JumpGameII {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,1}));

    }

    public static int jump(int[] nums) {
        if(nums==null || nums.length<2) return 0;

        int jumps = 0, pos = 0, dest = nums.length-1;
        while(pos < dest) {
            int newPos = pos;
            for(int i=0; i<=nums[pos]; i++) {
                int tmp = pos + i;
                if(tmp >= dest) return jumps+1;
                if(tmp+nums[tmp] > newPos+nums[newPos]) newPos = tmp;
            }
            pos = newPos;
            jumps++;
        }

        return jumps;
    }

}
