// 792. Number of Matching Subsequences

public class NumberOfMatchingSubsequences {

	public static void main(String[] args) {

    }

    public static int numMatchingSubseq(String S, String[] words) {
        List<int[]>[] tracker = new List[26];
        int match = 0;

        for(int i=0; i<26; i++) tracker[i] = new ArrayList<>();
        for(int i=0; i<words.length; i++) tracker[words[i].charAt(0) - 'a'].add(new int[]{i,0});

        for(int i=0; i<S.length(); i++) {
            List<int[]> list = new ArrayList<>(tracker[S.charAt(i)-'a']);
            tracker[S.charAt(i)-'a'].clear();

            for(int[] wordInfo : list) {
                String word = words[wordInfo[0]];
                if(wordInfo[1] == word.length()-1) match++;
                else tracker[word.charAt(wordInfo[1]+1)-'a'].add(new int[]{wordInfo[0], wordInfo[1]+1});
            }
        }

        return match;
    }
	
}