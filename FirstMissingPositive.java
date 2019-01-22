// 41. First Missing Positive

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums1 = {1,2,0};
        System.out.println(firstMissingPositive(nums1));
        int[] nums2 = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums2));
        int[] nums3 = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums3));
        int[] nums4 = {1};
        System.out.println(firstMissingPositive(nums4));
        int[] nums5 = {1,2};
        System.out.println(firstMissingPositive(nums5));
        int[] nums6 = {2,1};
        System.out.println(firstMissingPositive(nums6));
        int[] nums7 = {1,1};
        System.out.println(firstMissingPositive(nums7));
    }

	// 将数字移动到对应的位置上
	// 将1挪到坐标0位上
	// 将2挪到坐标1位上
	// 将3挪到坐标2位上
	// ...
	//
	// 有个问题是，不能重复交换，会死循环，比如：
	// [1,2,3,4,2]
	// 到最后的一个2时，不能再放到坐标1上了，会造成死循环
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++) {
            while(1<=nums[i] && nums[i]<=len-1 && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i=0; i<len; i++) {
            if(i+1 != nums[i])
                return i+1;
        }

        return len+1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
