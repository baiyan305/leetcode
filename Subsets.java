// 78. Subsets

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3, 4}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        backtracking(nums, 0, new ArrayList<>(), lists);

        return lists;
    }

    private static void backtracking(int[] nums, int index, List<Integer> list, List<List<Integer>> lists) {
        if(index == nums.length) return;

        for(int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            backtracking(nums, i+1, list, lists);
            list.remove(list.size()-1);
        }
    }

}
