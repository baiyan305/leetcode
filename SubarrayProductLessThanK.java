// 713. Subarray Product Less Than K

public class SubarrayProductLessThanK {

    public static void main(String[] args) {


    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int product = 1, count = 0;
        for(int left = 0, right=0; right<nums.length; right++) {
            product *= nums[right];

            if(product < k) continue;
            else {
                while(left<right && product >= k) {
                    product /= left--;

                }
            }
        }
    }

}