// 283. Move Zeroes

public class MoveZeroes {

    // 题意是将所有的0放到数组末尾。可以转化为将所有非0数组放到数组开头
    // 用一个for循环从头扫到尾，j记录第一个0的位置。
    public void moveZeroes(int[] nums) {
        for(int i=0, j=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                if(i != j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                j++;
            }
        }
    }

}
