// 611. Valid Triangle Number

import java.util.Arrays;

public class ValidTriangleNumber {

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }

    // nlogn + N*N
    // Two pointers解法
    // 先将数组排序，然后定义3个下标
    //
    // large指向最后一个元素，然后递减到2
    //
    // left指向0, right指向large-1
    // 目的是找到left到right之间，有多少pair能和large组成三角形三边
    //
    // 如果找到了 nums[left] + nums[right] > nums[large], 那么left,right,large可以组成三角形
    // 为什么呢？
    //
    // 先看任意两边是否相加大于第三边
    // nums[left] + nums[right] > nums[large]
    // 然后因为 nums[left] <= nums[right] <= nums[large]
    // 所以 nums[left] + nums[large] > nums[right]
    // nums[right] + nums[large] > nums[left]
    //
    // 再看任意两边之差是否小于第三遍
    // 因为 nums[left] + nums[right] > nums[large]
    // 所以 nums[left] > nums[large] - nums[right]
    //     nums[right] > nums[large] - nums[left]
    //
    // 满足三角形三边要求
    //
    // 如果left, right和large可以组成三角形三边
    // 那么left, right之间所有的组合都可以和large组成三角形三边
    // 因为可以试试将left右移，left值增大，上面的几个条件还是成立的

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for(int large = nums.length-1; large >=2; large--) {
            int left = 0, right = large - 1;
            while(left<right) {
                if(nums[left]+nums[right] > nums[large]){
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

}