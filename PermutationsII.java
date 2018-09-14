// 47. Permutations II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public void run() {
        int[] nums = {1,1,2,3};
        List<List<Integer>> lists = permute(nums);
        for(List<Integer> list : lists) System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null) return lists;
        Arrays.sort(nums);
        recursion(nums, new boolean[nums.length], lists, new ArrayList<>());

        return lists;
    }

    private void recursion(int[] nums, boolean[] visited, List<List<Integer>> lists, List<Integer> list) {
        if(list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        int idx = 0;
        while(idx<nums.length) {
            if(visited[idx]) {
                idx++;
                continue;
            }

            list.add(nums[idx]);
            visited[idx] = true;
            recursion(nums, visited, lists, list);
            visited[idx] = false;
            list.remove(list.size()-1);
            do{ idx++;} while(idx < nums.length && nums[idx] == nums[idx-1]);
        }
    }

}
