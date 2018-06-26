// 336. Palindrome Pairs

public class PalindromePairs {
	
	public static void main(String[] args) {
        String[] words1 = {"bat", "tab", "cat"};
        System.out.println(palindromePairs(words1));

        String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words2));

        String[] words3 = {"abba", ""};
        System.out.println(palindromePairs(words3));

        String[] words4 = {"ab", "ba"};
        System.out.println(palindromePairs(words4));
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) map.put(words[i], i);

        for(int i = 0; i < words.length; i++) {
            String word = words[i];

            for(int right=0; right<=word.length(); right++) {
                String leftStr = word.substring(0, right);
                if(isPalindrome(leftStr)) {
                    String reverseRightStr = reverse(word.substring(right, word.length()));
                    if(map.containsKey(reverseRightStr) && map.get(reverseRightStr) != i) lists.add(Arrays.asList(map.get(reverseRightStr), i));
                }
            }

            for(int left=word.length()-1; left>=0; left--) {
                String rightStr = word.substring(left, word.length());
                if(isPalindrome(rightStr)) {
                    String reverseLeftStr = reverse(word.substring(0, left));
                    if(map.containsKey(reverseLeftStr) && map.get(reverseLeftStr) != i) lists.add(Arrays.asList(i, map.get(reverseLeftStr)));
                }
            }

        }

        return lists;
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length()-1;
        while(left < right) if(str.charAt(left++) != str.charAt(right--)) return false;
        return true;
    }

    private static String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i=str.length()-1; i > -1; i--) builder.append(str.charAt(i));
        return builder.toString();
    }
	
}