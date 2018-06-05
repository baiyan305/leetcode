// 90. Subsets II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {

    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        if(nums == null || nums.length == 0) return lists;
        Arrays.sort(nums);

        int len = 1;
        for(int i=0; i<nums.length; i++) {
            int right = lists.size()-1;
            if(i!=0 && nums[i] != nums[i-1]) len = lists.size();

            for(int j=right-len+1; j<=right; j++) {
                List<Integer> newList = new ArrayList<>(lists.get(j));
                newList.add(nums[i]);
                lists.add(newList);
            }
        }

        return lists;
    }

}