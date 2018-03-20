import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class TwoSumUniqueSorted {
    public static void main(String[] args) {
		int[] nums = new int[]{2, 13,7 ,8, 6, 9};
		List<List<Integer>> result = twoSum(nums, 15);

		for(List<Integer> list : result) {
			System.out.println(list);
		}
	}
	
	private static List<List<Integer>> twoSum(int[] nums, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	
		Arrays.sort(nums);
		
		int i = 0, j = nums.length - 1;
		
		while(i<j) {
			if(nums[i] + nums[j] < target) {
				i++;
			} else if (nums[i] + nums[j] > target) {
			    j--;
			} else {
				List subResult = new ArrayList();
				subResult.add(nums[i]);
				subResult.add(nums[j]);
				result.add(subResult);
				
				do {
					i++;
				}while(i<j && nums[i]==nums[i+1]);

				do {
					j--;
				}while(i<j && nums[j]==nums[j-1]);
			}
		}

		return result;
	}
}
