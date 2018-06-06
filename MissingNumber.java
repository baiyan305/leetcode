// 268. Missing Number
// 比如nums是[0,1,3], 缺的是2. 那么先计算[0,1,2,3]的和，之后减去[0,1,3]的和，就是结果。

public class MissingNumber {
	
	public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,2}));
    }

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;

        return (nums.length*(nums.length+1)/2) - sum;
    }
	
}