class TwoSumUniqueSorted {
    public static void main(String[] args) {
	}
	
	private List<List<Integer, Integer>> twoSum(int[] nums, int target){
		List<List<Integer, Integer>> result = new ArrayList<ArrayList<Integer, Integer>>();
	
		Arrays.sort(nums);
		
		int i=0, j=nums.length-1;
		
		while(i<j) {
			if(nums[i] + nums[j] < target) {
				i++;
			} else if (nums[i] + nums[j] > target) {
			    j--;
			} else {
				ArrayList subResult = new ArrayList();
				subResult.add(nums[i]);
				subResult.add(nums[j]);
				result.add(subResult);
				
				while(nums[i]==nums[i+1])
				    i++;
				while(nums[j]==nums[j-1])
				    j--;
			}
		}
	}
}