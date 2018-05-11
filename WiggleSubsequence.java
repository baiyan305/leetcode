// 376. Wiggle Subsequence

public class WiggleSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
        int[] nums1 = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums1));
        int[] nums2 = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(wiggleMaxLength(nums2));
        int[] nums3 = new int[]{1};
        System.out.println(wiggleMaxLength(nums3));
    }

    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length==0) return 0;

        int len = 1, prev = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] - nums[i] == 0) continue;

            if(nums[i-1] - nums[i] > 0) {
                if(prev == 0 || prev == -1) {
                    len += 1;
                    prev = 1;
                }
            } else {
                if(prev == 0 || prev == 1) {
                    len += 1;
                    prev = -1;
                }
            }
        }

        return len;
    }

}
