// 34. Find First and Last Position of Element in Sorted Array

public class FindFirstAndLastPositionOfElementInSortedArray {

    public void run() {
        int[] nums = {5,7,7,8,8,10};
        int[] res= searchRange(nums, 8);
        System.out.println(res[0]+":"+res[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        int low = 0, high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(target > nums[mid]) low = mid+1;
            else if(target == nums[mid]) high = mid;
            else high = mid-1;
        }
        if(nums[low] == target) res[0] = low;
        else return res;

        high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2 + 1;
            if(target > nums[mid]) low = mid+1;
            else if(target == nums[mid]) low = mid;
            else high = mid-1;
        }
        res[1] = high;

        return res;
    }

}
