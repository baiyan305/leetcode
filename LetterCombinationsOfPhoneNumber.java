// 17. Letter Combinations of a Phone Number

public class LetterCombinationsOfPhoneNumber {
	
	public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> letters = Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        List<String> list = new ArrayList<>();
        backtracking(list, letters, new StringBuilder(), digits, 0);
        return list;
    }

    private static void backtracking(List<String> list, List<String> letters, StringBuilder builder, String digits, int idx) {
        if(idx == digits.length()) {
            if(idx != 0) list.add(builder.toString());
            return;
        }

        String letter = letters.get(digits.charAt(idx)-'0'-2);
        for(int i=0; i<letter.length(); i++) {
            builder.append(letter.charAt(i));
            backtracking(list, letters, builder, digits, idx+1);
            builder.deleteCharAt(builder.length()-1);
        }
    }
	
}