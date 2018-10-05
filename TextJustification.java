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
            if(i != start) totalLen += 1; // 每个单词前面的空格, 如果是每一行的开始单词，不需要加空格。

            if(totalLen > maxWidth) { 
                // 遍历过的单词总长度已经超过了允许的最大长度，那么一行就结束了，开始填充。
                // 将start和i-1 之间的单词填充为一行。
                list.add(fillWordsIntoString(words, start, i-1, maxWidth, false));
                start = i;
                totalLen = 0;
            } else if(totalLen <= maxWidth && i == words.length-1) { // 最后一行
                list.add(fillWordsIntoString(words, start, i, maxWidth, true));
                i++;
            } else {
                i++;
            }
        }

        return list;
    }

    // 将start, end 和start end之间的单词，填充一行
    // words - 单词表
    // start - 开始下标
    // end - 结束下标
    // maxWidth - 允许的最大长度
    // lastLine - 是否是最后一行
    private static String fillWordsIntoString(String[] words, int start, int end, int maxWidth, boolean lastLine) {
        StringBuilder builder = new StringBuilder();

        int wordsLen = 0;
        for(int i=start; i<=end; i++) wordsLen += words[i].length();

        int numOfGap = end-start; // 间隔的个数。比如是4个单词，那么就有3个间隔。
        int lenRegularGap = numOfGap == 0 ? 0 : (maxWidth-wordsLen)/numOfGap; // 间隔的长度。允许的最大长度减去单词长度，除以间隔个数，就是每个间隔的长度。
        int numOfAddGap = numOfGap == 0 ? 0 : (maxWidth-wordsLen)%numOfGap; // 额外的间隔长度。比如空格总长度是11，间隔有3个，那么每个间隔长度是3。另外前两个间隔，需要额外加一个空格。 
        for(int i=start; i<=end; i++) {
            builder.append(words[i]);
            if(lastLine && i != end) builder.append(" "); // 最后一行的空格比较特殊。每个单词后面只需要一个空格，最后一个不用加。
            else if(i != end){
                for(int j=0; j<lenRegularGap; j++) builder.append(" "); // 每个单词后面加空格
                if(numOfAddGap-- > 0) builder.append(" "); // 加上额外的空格
            }
        }
        for(int i=builder.length(); i<maxWidth; i++) builder.append(" "); // ？ 最后一行的末尾，填充上空格

        return builder.toString();
    }

	
}
