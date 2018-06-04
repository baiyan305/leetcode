// 280. Wiggle Sort

public class WiggleSort {
	
	public static void main(String[] args) {
        //int[] nums = {1,5,1};
        //int[] nums = {1,2,3,4,5};
        int[] nums = {1,2,3,4,5,6};
        wiggleSort(nums);

        for(int num : nums)
            System.out.print(num+", ");
    }

    public static void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if(i%2==1 && nums[i-1]>nums[i] || i%2==0 && nums[i-1]<nums[i]) {
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
	
}