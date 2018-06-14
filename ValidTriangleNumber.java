// 611. Valid Triangle Number

import java.util.Arrays;

public class ValidTriangleNumber {

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for(int large = nums.length-1; large >=2; large--) {
            int left = 0, right = large - 1;
            while(left<right) {
                if(nums[left]+nums[right] > nums[large]){
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

}