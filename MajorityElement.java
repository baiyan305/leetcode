// 169. Majority Element

public class MajorityElement {

    // 摩尔投票算法(Boyer-Moore Voting Algorithm)
    // 关键是两个变量：candidate是可能的候选值，count是计数
    //
    // 当nums[i] == nums[candidate]时，count++
    // 当nums[i] != nums[candidate]时，count--
    // 当count == 0时，当前的值作为候选
    //
    // 如果有Majority Element, 那么最后的candidate就是
    // 不知道怎么证明正确性，但是好像确实是对的，有点两两抵消的意思
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for(int i=0; i<nums.length; i++) {
            // 当前值和candidate相同，count++
            if(nums[i] == nums[candidate]){
                count++;
            }
            // 否则如果当前值和candidate不同，之后有两种情况
            // 先看如果count是否为0，直接更新candidate
            else if(count == 0) {
                candidate = i;
                count++;
            }
            // 如果count不为，count--
            else {
                count--;
            }
        }

        return nums[candidate];
    }

}
