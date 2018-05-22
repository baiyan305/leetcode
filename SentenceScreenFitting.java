// 418. Sentence Screen Fitting

public class SentenceScreenFitting {
	
	public static void main(String[] args) {
		
	}
	
	/*
	使用DP解题。基本思路：
	假设sentence数组有3个字符串，["abc","bc","df"]。如果"abc"开头，计算下一行的开头字符串是哪个？同理计算"bc"开头和"df"开头的情况。
	
	*/
	public static int wordsTyping(String[] sentence, int rows, int cols) {
        int[] startWordOfNextLine = new int[sentence.length];
        int[] repeatOfSentence = new int[sentence.length];

        for(int i=0; i<sentence.length; i++) {
            int wordIdx = i, repeat = 0, j = 0;
            while(j+sentence[wordIdx].length()-1<cols) {
                j += sentence[wordIdx].length()+1;
                if(wordIdx == sentence.length-1) {
                    wordIdx = 0;
                    repeat++;
                }else{
                    wordIdx++;
                }
            }
            startWordOfNextLine[i] = wordIdx;
            repeatOfSentence[i] = repeat;
        }

        int startWordIdx = 0, repeats = 0;
        for(int i=0; i<rows; i++) {
            repeats += repeatOfSentence[startWordIdx];
            startWordIdx = startWordOfNextLine[startWordIdx];
        }

        return repeats;
    }
	
}