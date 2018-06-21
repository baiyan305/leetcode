// 792. Number of Matching Subsequences

public class NumberOfMatchingSubsequences {
	
	public static void main(String[] args) {

    }

    public static int numMatchingSubseq(String S, String[] words) {
        List<int[]>[] tracker = new List[32];
        int match = 0;

        for(int i=0; i<32; i++) tracker[i] = new ArrayList<>();
        for(int i=0; i<words.length; i++) tracker[words[i].charAt(0) - 'a'].add(new int[]{i,0});
        for(int i=0; i<S.length(); i++) {
            List<int[]> list = tracker[S.charAt(i)-'a'];

            for(int[] wordInfo : list) {
                String word = words[wordInfo[0]];
                if(wordInfo[1] == word.length()-1) match++;
            }
        }

        return match;
    }
	
}