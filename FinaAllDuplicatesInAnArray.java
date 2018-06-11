import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] candidates = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(findDuplicates(candidates));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) list.add(Math.abs(nums[i]));
            nums[idx] = 0 - nums[idx];
        }

        return list;
    }

}