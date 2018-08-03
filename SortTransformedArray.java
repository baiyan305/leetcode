// 360. Sort Transformed Array

public class SortTransformedArray {
	
		public void run() {
        int[] nums1 = {-4, -2, 2, 4};
        nums1 = sortTransformedArray(nums1, 1, 3, 5);
        for(int i : nums1) System.out.print(i + " ");
        System.out.println();

        int[] nums2 = {-4, -2, 2, 4};
        nums2 = sortTransformedArray(nums2, -1, 3, 5);
        for(int i : nums2) System.out.print(i + " ");
        System.out.println();
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int last = nums.length-1, left=0, right = last, idx = a >=0  ? last : 0;
        int[] arr = new int[last+1];

        while(left <= right) {
            if(a >= 0) {
                arr[idx--] = quadratic(nums[left], a, b, c) >= quadratic(nums[right], a, b, c) ? quadratic(nums[left++], a, b, c) : quadratic(nums[right--], a, b, c);
            } else {
                arr[idx++] = quadratic(nums[left], a, b, c) <= quadratic(nums[right], a, b, c) ? quadratic(nums[left++], a, b, c) : quadratic(nums[right--], a, b, c);
            }
        }

        return arr;
    }

    private int quadratic(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
	
}