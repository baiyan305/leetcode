// 60. Permutation Sequence

public class PermutationSequence {
	
	public static void main(String[] args) {
        System.out.println(getPermutation(3,3)); //213
        System.out.println(getPermutation(4,9)); //2314
        System.out.println(getPermutation(2,2)); //21
        System.out.println(getPermutation(1,1)); //1
        System.out.println(getPermutation(3,2)); //132
        System.out.println(getPermutation(3,5)); //312
        System.out.println(getPermutation(3,4)); //231
    }
	
	public static String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        StringBuilder builder = new StringBuilder();

        int combination = 1;
        for(int i=1; i<=n; i++) combination *= i;

        for(int i=n; i>=1; i--) {
            combination /= i;

            int digit = k / combination - (k >= combination && k % combination == 0 ? 1 : 0);
            for(int j=0; digit >= 0; j++) {
                if(digit == 0 && !used[j]) {
                    builder.append(j+1);
                    used[j] = true;
                    break;
                }
                if(!used[j]) digit--;
            }

            k %= combination;
            if(k==0) k = combination;
        }

        return builder.toString();
    }
	
}