// 321. Create Maximum Number

import java.util.ArrayList;

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
			
			if(compare(max, maxSubArray)) max = maxSubArray;
        }
		
		return max;
    }
	
    private static int[] getSubArray(int[] arr, int k) {
		if(k == 0) return new int[0];
		
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=arr.length-1; i>=0; i--) {
			if(list.size()<k) {
				list.add(0, arr[i]);
			} else if(arr[i] >= list.get(0)){
				int idxOfMin = -1, min = Integer.MAX_VALUE;
				for(int j=0; j<list.size(); j++) {
				    if(list.get(j) <= min) {
						idxOfMin = j;
						min = list.get(j);
					}	
				}
				list.remove(idxOfMin);
				list.add(0, arr[i]);
			}
        }

		int[] ret = new int[k];
		for(int i=0; i<k; i++) 
			ret[i] = list.get(i);
		
		return ret;
    }

    private static int[] merge(int[] arr1, int[] arr2) {
		int len1 = arr1.length, len2 = arr2.length, idx1 = 0, idx2 = 0, idx3 = 0;
		int[] ret = new int[len1 + len2];
		while(idx1<len1 && idx2<len2) {
			if(arr1[idx1] >= arr2[idx2]) ret[idx3++] = arr1[idx1++];
			else ret[idx3++] = arr2[idx2++];
		}
		while(idx1<len1) ret[idx3++] = arr1[idx1++];
		while(idx2<len2) ret[idx3++] = arr2[idx2++];
		
		return ret;
    }
	
	private static boolean compare(int[] arr1, int[] arr2) {
		for(int i=0; i<arr1.length; i++) {
			if(arr2[i] > arr1[i]) return true;
			else if(arr1[i] > arr2[i]) return false;
		}
		
		return false;
	}

}
