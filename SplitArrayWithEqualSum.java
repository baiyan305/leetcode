// 548. Split Array with Equal Sum

import java.util.HashSet;
import java.util.Set;

public class SplitArrayWithEqualSum {

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,1};
        System.out.println(splitArray(nums));
    }

    public static boolean splitArray(int[] nums) {
        if(nums == null || nums.length < 7) return false;

        int len = nums.length;
        int[] sums = new int[len];
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            temp += nums[i];
            sums[i] = temp;
        }

        // 先固定j的位置
        for(int j=3; j<len-3; j++) {
            Set<Integer> validSum = new HashSet<>();
            //因为j的位置是固定的，所以i能移动的区间也定了，比较i分割的左右两部分的和。
            //如果一样，加入到HashSet中。
            for(int i=1; i<j-1; i++) {
                int left = sums[i-1], right = sums[j-1] - sums[i];
                if(left == right && !validSum.contains(left)) validSum.add(left);
            }
            //因为j的位置是固定的，所以i能移动的区间也定了，比较k分割的左右两部分的和。
            //如果两边和相等，并且HashSet中存在这个和，那么就表示4个区间分割值相等。返回true。
            for(int k=j+2; k<len-1; k++){
                int left = sums[k-1]-sums[j], right = sums[len-1] - sums[k];
                if(left == right && validSum.contains(left)) return true;
            }
        }

        return false;
    }

}
