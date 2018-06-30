// 68. Text Justification

public class TextJustification {
	
	public static void main(String[] args) {
        List<String> strs1 = fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16);
        for(String str : strs1) {
            System.out.println(str);
            System.out.println(str.length());
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        int start = 0, totalLen = 0;
        for(int i=0; i<words.length;) {
            totalLen += words[i].length();
            if(i != start) totalLen += 1;

            if(totalLen > maxWidth) {
                list.add(fillWordsIntoString(words, start, i-1, maxWidth, false));
                start = i;
                totalLen = 0;
            } else if(totalLen <= maxWidth && i == words.length-1) {
                list.add(fillWordsIntoString(words, start, i, maxWidth, true));
                i++;
            } else {
                i++;
            }
        }

        return list;
    }

    private static String fillWordsIntoString(String[] words, int start, int end, int maxWidth, boolean lastLine) {
        StringBuilder builder = new StringBuilder();

        int wordsLen = 0;
        for(int i=start; i<=end; i++) wordsLen += words[i].length();

        int numOfGap = end-start, lenRegularGap = numOfGap == 0 ? 0 : (maxWidth-wordsLen)/numOfGap, numOfAddGap = numOfGap == 0 ? 0 : (maxWidth-wordsLen)%numOfGap;
        for(int i=start; i<=end; i++) {
            builder.append(words[i]);
            if(lastLine && i != end) builder.append(" ");
            else if(i != end){
                for(int j=0; j<lenRegularGap; j++) builder.append(" ");
                if(numOfAddGap-- > 0) builder.append(" ");
            }
        }
        for(int i=builder.length(); i<maxWidth; i++) builder.append(" ");

        return builder.toString();
    }

	
}