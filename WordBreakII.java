public class WordBreakII {
	public void run() {
        //String[] wordDict = {"apple","pen"};
        //System.out.println(wordBreak("applepenapple", Arrays.asList(wordDict)));
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        System.out.println(wordBreak("catsanddog", Arrays.asList(wordDict)));

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        List<String> list = new ArrayList<>();
        recursion(s, 0, set, new Boolean[s.length()], list, new ArrayList<>());
        return list;
    }

    private boolean recursion(String s, int start, Set<String> dict, Boolean[] mem, List<String> lists, List<String> string) {
        if(start >= s.length()) {
            lists.add(listToStr(string));
            return true;
        }
        if(mem[start] != null && mem[start]==false) return false;

        for(int end=start+1; end<=s.length(); end++) {
            String str = s.substring(start, end);
            if( dict.contains(str) ) {
                string.add(str);
                if( recursion(s, end, dict, mem, lists, string) ) mem[start] = true;
                string.remove(string.size()-1);
            }
        }

        if(mem[start] != null) mem[start] = false;

        return false;
    }

    private String listToStr(List<String> string) {
        StringBuilder builder = new StringBuilder();
        for(String str : string) {
            builder.append(str).append(" ");
        }
        if(builder.length() > 0) builder.deleteCharAt(builder.length()-1);

        return builder.toString();
    }
}