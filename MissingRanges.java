// 163. Missing Ranges

import java.util.List;
import java.util.ArrayList;

public class MissingRanges {
	
	public static void main(String[] args) {
		int[] nums = {Integer.MIN_VALUE, 1, 3, 50, Integer.MAX_VALUE};
		System.out.println(findMissingRanges(nums, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length==0) {
            if(lower==upper) list.add(String.valueOf(lower));
            else list.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            return list;
        }

        // first element
        if(nums[0] != lower) {
            if(nums[0]-lower == 1) list.add(String.valueOf(lower));
            else list.add(lower+"->"+String.valueOf(nums[0]-1));
        }

        for(int i=1; i<nums.length; i++) {
            long diff = (long)nums[i]-nums[i-1];
            if(diff == 2) {
                list.add(String.valueOf(nums[i]-1));
            } else if(diff > 2) {
                list.add(String.valueOf(nums[i-1]+1)+"->"+String.valueOf(nums[i]-1));
            }
        }

        // last element
        int last = nums[nums.length-1];
        if(last != upper) {
            if(upper-last == 1) list.add(String.valueOf(upper));
            else list.add(String.valueOf(last+1)+"->"+upper);
        }

        return list;
    }
	
}