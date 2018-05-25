// 446. Arithmetic Slices II - Subsequence

import java.util.HashMap;

public class ArithmeticSlicesSubsequence {
	
	public static void main(String[] args) {
		int[] nums = {2,4,6,8,10};
		System.out.println(numberOfArithmeticSlices(nums));
	}
	
	public static int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3) return 0;
		
		int total = 0;
		HashMap<Integer, Integer>[] list = new HashMap[A.length];
		for(int i=0; i<A.length; i++) {
			list[i] = new HashMap<>();
			for(int j=0; j<i; j++) {
				long diff = (long)A[i] - A[j];
				if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
				
				int d = (int)diff;
				int prev = list[j].getOrDefault(d, 0);
				total += (prev);
				
				int current = list[i].getOrDefault(d, 0);
				list[i].put(d, current+prev+1);
			}
		}
		
		return total;
    }
	
}