// 583. Delete Operation for Two Strings

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        System.out.println(minDistance("sead","eatx"));
    }

    // DP - 不用Longest common subsequence
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0; i<=len1; i++) dp[i][0] = i;
        for(int i=0; i<=len2; i++) dp[0][i] = i;

        for(int idx1=1; idx1<=len1; idx1++) {
            for (int idx2 = 1; idx2 <= len2; idx2++) {
                if(word1.charAt(idx1-1) == word2.charAt(idx2-1)) dp[idx1][idx2] = dp[idx1-1][idx2-1];
                else dp[idx1][idx2] = 1 + Math.min(dp[idx1-1][idx2], dp[idx1][idx2-1]);
            }
        }

        return dp[len1][len2];
    }

    /* DP - Longest common subsequence
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int idx1=1; idx1<=len1; idx1++) {
            for(int idx2=1; idx2<=len2; idx2++) {
                if(word1.charAt(idx1-1) == word2.charAt(idx2-1)) dp[idx1][idx2] = 1+dp[idx1-1][idx2-1];
                else dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
            }
        }

        return len1 + len2 - 2 * dp[len1][len2];
    }
    */

    /* Recursion with memorization
    public static int minDistance(String word1, String word2) {
        int[][] memory = new int[word1.length()][word2.length()];
        for(int y=0; y<word1.length(); y++)
            for(int x=0; x<word2.length(); x++)
                memory[y][x] = -1;

        return word1.length() + word2.length() - 2*recursion(word1, word2, 0, 0, memory);
    }

    private static int recursion(String word1, String word2, int start1, int start2, int[][] memory) {
        if(start1 == word1.length() || start2 == word2.length()) return 0;

        if(memory[start1][start2] != -1) return memory[start1][start2];

        if(word1.charAt(start1) == word2.charAt(start2)) {
            memory[start1][start2] = 1+recursion(word1, word2, start1+1, start2+1, memory);
        } else {
            memory[start1][start2] =  Math.max(recursion(word1, word2, start1+1, start2, memory), recursion(word1, word2, start1, start2+1, memory));
        }

        return memory[start1][start2];
    }
    */

}