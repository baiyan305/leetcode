// 713. Subarray Product Less Than K

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int product = 1, count = 0;
        for(int left = 0, right=0; right<nums.length; right++) {
            product *= nums[right];
            while(left<=right && product>=k) product /= nums[left++];
            count = right - left + 1;
        }

        return count;
    }

}