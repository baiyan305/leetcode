// 544. Output Contest Matches

public class OutputContestMatches {
	
	public static void main(String[] args) {
		System.out.println(findContestMatch(8));
	}
	
	public static String findContestMatch(int n) {
        String[] match = new String[n];
        for(int i=0; i<n; i++) match[i] = String.valueOf(i+1);
        
        while(n>1){
        	int left = 0, right = n-1;
        	while(left<right)
        		match[left] = "(" + match[left++] + "," + match[right--] + ")";
        	
        	n /= 2;
        }
        
       
	
}