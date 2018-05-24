// 413. Arithmetic Slices

public class ArithmeticSlices {

	public static void main(String[] args) {
		int[] nums = {1,2,3,6,7,8};
		System.out.println(numberOfArithmeticSlices(nums));
	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length < 3) return 0;
		
		int diff = A[1] - A[0], count = 2, total = 0;
        for(int i=2; i<A.length; i++) {
			if(A[i]-A[i-1] == diff) {
				count++;
			} else {
				if(count>=3) total += helper(count);
				count=2;
				diff=A[i]-A[i-1];
			}
		}
		
		if(count>=3) total += helper(count+1);
		
		return total;
    }
	
	private static int helper(int num) {
		System.out.println("--"+num);
		if(num%2 == 0) return (num-1) * (num/2-1);
		else return ((num-1) * (num/2)) - (num-1)/2;
	}
	
}