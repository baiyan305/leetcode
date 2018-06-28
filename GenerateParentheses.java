// 22. Generate Parentheses

public class GenerateParentheses {
	
	public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursion(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    private static void recursion(List<String> list, StringBuilder builder, int left, int right, int n) {
        if(left == n && right == n) {
            list.add(builder.toString());
            return;
        }

        if(left < n && left >= right){
            recursion(list, builder.append('('), left+1, right, n);
            builder.deleteCharAt(builder.length()-1);
        }
        if(right < n && left > right) {
            recursion(list, builder.append(')'), left, right+1, n);
            builder.deleteCharAt(builder.length()-1);
        }
    }
	
}