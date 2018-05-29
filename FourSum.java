// 18. 4Sum

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length < 3) return lists;

        kSum(lists, new ArrayList<>(), nums, 0, 4, target);

        return lists;
    }

    private void kSum(List<List<Integer>> lists, List<Integer> list, int[] nums, int start, int k, int target) {
        if(k == 2) {
            twoSum(lists, list, nums, start, target);
            return;
        }

        while(start < nums.length-k+1) {
            list.add(nums[start]);
            kSum(lists, list, nums, start+1, k-1, target-nums[start]);
            list.remove(list.size()-1);

            while(start < nums.length-k+1 && nums[start] == nums[start+1]) start++;
            start++;
        }
    }

    private void twoSum(List<List<Integer>> lists, List<Integer> list, int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        while(left<right) {
            if(nums[left]+nums[right] == target) {
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                list.remove(list.size()-1);
                while(left<right && nums[left] == nums[left+1]) left++;
                while(left<right && nums[right] == nums[left-1]) right--;
                left++;
                right--;
            } else if(nums[left]+nums[right] < target) {
                while(left<right && nums[left] == nums[left+1]) left++;
                left++;
            } else {
                while(left<right && nums[right] == nums[left-1]) right--;
                right--;
            }
        }
    }
	
}