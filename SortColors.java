// 75. Sort Colors

public class SortColors {

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        while(nums[left] == 0) left++;
        while(nums[right] == 2) right++;
        int idx = left;
        while(idx <= right) {
            if(nums[idx] == 1) {
                idx++;
            } else if(nums[idx] == 0) {
                swap(nums, left, idx);
                idx++;
                left++;
            } else {
                swap(nums, idx, right);
                right--;
            }
        }
    }

    private static void swap(int[] array, int m, int n) {
        int tmp = array[m];
        array[m] = array[n];
        array[n] = tmp;
    }

}