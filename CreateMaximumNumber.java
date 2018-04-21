// 321. Create Maximum Number

import java.util.Stack;;

public class CreateMaximumNumber {

    public static void main(String[] args) {
		//int[] nums = new int[]{3,7,9,4,8,1,4,3,6};
		int[] nums1 = new int[]{3, 4, 6, 5};
		int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
		
		int[] max = maxNumber(nums1, nums2, 5);
		
		for(int num : max)
			System.out.print(num + " ");
    }

	
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;    
		int[] max = new int[k];
	
        for(int i=0; i<=len1 && k-i<=len2; i++) {
			int[] maxSubArray1 = getSubArray(nums1, i);
			int[] maxSubArray2 = getSubArray(nums2, k-i);
			int[] maxSubArray = merge(maxSubArray1, maxSubArray2);
			if(compare(max, maxSubArray, 0, 0)) max = maxSubArray;
        }
		
		return max;
    }
	
	private static int[] getSubArray(int[] nums, int k) {
        int[] ret = new int[k];
        int len = nums.length;

        for(int i=0, j=0; i<len; i++) {
            while(j>0 && nums[i]>ret[j-1] && len-i>k-j) j--;
            if(j<k) ret[j++] = nums[i];
        }

        return ret;
    }
	/*
    private static int[] getSubArray(int[] arr, int k) {
		if(k==0) return new int[0];

		int len = arr.length;
		int[] ret = new int[k];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<arr.length; i++) {
			if(stack.size() == 0) {
				stack.push(arr[i]);
				continue;
			}

			if(arr[i] <= stack.peek()) {
				if(stack.size() < k)
					stack.push(arr[i]);
			} else {
				while(stack.size()>0 && arr[i]>stack.peek() && len-i > k-stack.size())
					stack.pop();
				stack.push(arr[i]);
			}
		}

		for(int i=k-1; i>=0; i--)
			ret[i] = stack.pop();
		
		return ret;
    }
	*/
    private static int[] merge(int[] arr1, int[] arr2) {
		int len1 = arr1.length, len2 = arr2.length, idx1 = 0, idx2 = 0, idx3 = 0;
		int[] ret = new int[len1 + len2];
		while(idx1<len1 && idx2<len2) {
			if(arr1[idx1] > arr2[idx2]) ret[idx3++] = arr1[idx1++];
			else if(arr1[idx1] < arr2[idx2]) ret[idx3++] = arr2[idx2++];
			else ret[idx3++] = compare(arr1, arr2, idx1, idx2) ? arr1[idx1++] : arr2[idx2++];
		}
		while(idx1<len1) ret[idx3++] = arr1[idx1++];
		while(idx2<len2) ret[idx3++] = arr2[idx2++];
		
		return ret;
    }
	
	private static boolean compare(int[] arr1, int[] arr2, int idx1, int idx2) {
		for(int i=idx1, j=idx2; i<arr1.length && j<arr2.length;){
			if(arr1[i] > arr2[j]) i++;
			else if(arr1[i] < arr2[j]) j++;
			else {
				i++;
				j++;
			}
		}
		return false;
	}

}