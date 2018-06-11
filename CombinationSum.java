// 39. Combination Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        //int[] candidates = new int[]{10,1,2,7,6,1,5};
        //int[] candidates = new int[]{2,5,2,1,2};
        int[] candidates = new int[]{};

        System.out.println(combinationSum(candidates, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return lists;

        Arrays.sort(candidates);
        backtracking(lists, new ArrayList<>(), 0, candidates, 0, target);
        return lists;
    }

    private static void backtracking(List<List<Integer>> lists, List<Integer> list, int sum, int[] candidates, int start, int target) {
        if(sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            if(sum+candidates[i] <= target) {
                list.add(candidates[i]);
                backtracking(lists, list, sum+candidates[i], candidates, i, target);
                list.remove(list.size()-1);
            }
        }
    }

}