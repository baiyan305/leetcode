import java.util.ArrayList;
import java.util.List;

// 229. Majority Element II
public class MajorityElementII {

    // 摩尔投票算法变形
    // 答案最多有两个，所以用两个变量记录两个candidates和counts
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, count1 = 0, candidate2 = 0, count2 = 0;

        for(int i=0; i<nums.length; i++) {
            // 和candidate1相同，count1++
            if(nums[i] == candidate1) {
                count1++;
            }
            // 和candidate2相同，count2++
            else if(nums[i] == candidate2) {
                count2++;
            }
            // count1为0，更新candidate1
            else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }
            // count2为0，更新candidate2
            else if(count2 == 0) {
                candidate2 = nums[i];
                count2++;
            }
            // 和1,2都不同, 并且1,2的count大于0, 那么1,2的count都减减
            else {
                count1--;
                count2--;
            }
        }

        //重新计算candidate1,2出现的次数
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }

        // 判断是否是Majority Element
        List<Integer> list = new ArrayList<>();
        if(count1 > nums.length/3) list.add(candidate1);
        if(count2 > nums.length/3) list.add(candidate2);
        return list;
    }

}
