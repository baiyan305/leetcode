// 338. Counting Bits

public class CountingBits {
	
	public static void main(String[] args) {
		int[] bits = countBits(5);
		for(int bit : bits) System.out.print(bit + " ");
	}
	
	public static int[] countBits(int num) {
        int[] bits = new int[num+1];
		
		int nextPow2 = 1, dp = 0;
		for(int i=1; i<bits.length; i++) {
			if(i == nextPow2) {
				bits[i] = 1;
				dp = 1;
				nextPow2 = nextPow2 << 1;                                                     
			} else {
				bits[i] = bits[dp++] + 1;
			}
		}
		
		return bits;
    }
	
}

