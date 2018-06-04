// 31. Next Permutation

public class NextPermutation {
	
	public static void main(String[] args) {
        //int[] nums = {1,5,1};
        //int[] nums = {1,2,3,4,5};
        int[] nums = {5,4,3,2,1};
        nextPermutation(nums);

        for(int num : nums)
            System.out.print(num+", ");
    }

    public static void nextPermutation(int[] nums) {
        int i=nums.length-1;
        while(i>0 && nums[i-1] >= nums[i]) i--;

        if(i==0) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        int endOfLeft = i-1, posToSwap = nums.length-1;
        while(nums[posToSwap] <= nums[endOfLeft]) {
            posToSwap--;
        }

        int tmp = nums[endOfLeft];
        nums[endOfLeft] = nums[posToSwap];
        nums[posToSwap] = tmp;
        reverse(nums, i, nums.length-1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while(left<right) {
            int leftValue = nums[left];
            nums[left++] = nums[right];
            nums[right--] = leftValue;
        }
    }
	
}