// 34. Find First and Last Position of Element in Sorted Array

public class FindFirstAndLastPositionOfElementInSortedArray {

    public void run() {
        int[] nums = {5,7,7,8,8,10};
        int[] res= searchRange(nums, 8);
        System.out.println(res[0]+":"+res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target)left = mid + 1;
            else right = mid;
        }
        if(nums[left] != target) return res;
        res[0] = left;

        right = nums.length - 1;
        while(left < right) {
            int mid = 1 + left + (right-left)/2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target)left = mid + 1;
            else left = mid;
        }
        res[1] = right;

        return res;
    }

}
