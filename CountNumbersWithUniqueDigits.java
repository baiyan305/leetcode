// 357. Count Numbers with Unique Digits

public class CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3)); 
    }

	public static int countNumbersWithUniqueDigits(int n) {
		if(n==0) return 1;
		
		int total = 10;
		int uniqueNumber = 9;
		int availableNumber = 9;
		int i=1;
		
		while( i<n && availableNumber>0 ){
			uniqueNumber = uniqueNumber * availableNumber;
			total = total + uniqueNumber;
			availableNumber--;
			i++;
		}
		
		return total;
    }
	
	/*
    static boolean[] used = new boolean[10];
    static int total = 1;
    public static int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;

        int max = (int)Math.pow(10, n);
        for(int i=1; i<10; i++) {
            used[i] = true;
            backtracking(1, max);
            used[i] = false;
        }
        
        return total;
    }

    private static void backtracking(int num, int max) {
        if(num < max) total += 1;
        else return;

        for(int i=0; i<10; i++) {
            if(!used[i]) {
                used[i] = true;
                backtracking(num*10+i, max);
                used[i] = false;
            }
        }
    }
	*/
}
