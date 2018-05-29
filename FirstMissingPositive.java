// 41. First Missing Positive

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums1 = {1,2,0};
        System.out.println(firstMissingPositive(nums1));
        int[] nums2 = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums2));
        int[] nums3 = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums3));
        int[] nums4 = {1};
        System.out.println(firstMissingPositive(nums4));
        int[] nums5 = {1,2};
        System.out.println(firstMissingPositive(nums5));
        int[] nums6 = {2,1};
        System.out.println(firstMissingPositive(nums6));
        int[] nums7 = {1,1};
        System.out.println(firstMissingPositive(nums7));
    }

    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        int len = nums.length;
        for(int i=0; i<nums.length; i++) {
            while(nums[i] <= len && nums[i] > 0 && nums[i]-1 != i && nums[i]-1 != nums[nums[i]-1]-1) {
                int tmp =  nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i]-1 != i) return i+1;
        }

        return len+1;
    }

}
