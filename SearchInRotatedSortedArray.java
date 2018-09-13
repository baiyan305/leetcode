// 33. Search in Rotated Sorted Array

public class SearchInRotatedSortedArray {

    public void run() {
        //int[] arr = {4,5,6,7,0,1,2};
        int[] arr = {3,1};
        System.out.println(search(arr, 1));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length-1;

        while(left +1 < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;

            // if left half is sorted
            if(nums[left] < nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) right = mid -1; // discard right half
                else left = mid + 1; // discard left half
            }
            // if right half is sorted
            else {
                if(nums[mid] < target && target <= nums[right]) left = mid+1; // discard left half
                else right = mid-1; //discard right half
            }
        }

        if(nums[left] == target) return left;
        if(nums[right] == target) return right;

        return -1;
    }

}
