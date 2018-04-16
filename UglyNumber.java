// 263 Ugly Number

public class UglyNumber {
	
	public static void main(String[] args) {
		System.out.println(isUgly(14));
	}
	
	public static boolean isUgly(int num) {
        if(num <=0) return false;
		
		while(num > 1) {
			if(num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
		}
		
		return true;
    }
	
	
	/*
	public static boolean recursion(int num, int factor) {
		if(num == 1) return true;
		
		if(num % factor != 0)
			return false;
		
		num = num / factor;
		return recursion(num, 2) || recursion(num, 3) || recursion(num, 5);
	}
	*/
}