// 238. Product of Array Except Self

public class ProductOfArrayExceptSelf {
	
	public static void main(String[] args) {
		int[] products = productExceptSelf(new int[]{1,2,0,4});
		
		for(int product : products) System.out.println(product);
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
		for(int i=1; i<nums.length; i++) left[i] = left[i-1] * nums[i-1];
		
		int right = 1;
		for(int i=nums.length-1; i>=0; i--) {
			left[i] = left[i] * right;
			right = right * nums[i];
		}
		
		return left;
    }
	
}