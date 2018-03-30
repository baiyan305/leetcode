// 72. Edit Distance

class EditDistance {

    public static void main(String[] args){
        System.out.println(minDistance("aefasd","abas"));
        System.out.println(minDistance1("aefasd","abas"));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[] dp = new int[len1+1];

        for(int i=0; i<len1+1; i++) {
            dp[i] = i;
        }

        for(int i=1; i<len2+1; i++) {
            int tmp = dp[0];
            dp[0] = i;
            for(int j=1; j<len1+1; j++) {
                // replace operation
                int replaceOperation = word1.charAt(j-1) == word2.charAt(i-1) ? tmp : tmp + 1;
                // remove operation
                int removeOperation = dp[j-1] + 1;
                // insert operation
                int insertOperation = dp[j] + 1;

                tmp = dp[j];
                dp[j] = Math.min(replaceOperation, Math.min(removeOperation, insertOperation));
            }
        }

        return dp[len1];
    }
    
    public static int minDistance1(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<len2+1; i++) {
            dp[0][i] = i;
        }
        for(int i=0; i<len1+1; i++) {
            dp[i][0] = i;
        }

        for(int i=1; i<len1+1; i++) {
            for(int j=1; j<len2+1; j++) {
                // replace operation
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1) ? dp[i-1][j-1] : dp[i-1][j-1]+1;
                // remove operation
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                // insert operation
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
            }
        }

        return dp[len1][len2];
    }
    
}