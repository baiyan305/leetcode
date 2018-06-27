// 71. Simplify Path

public class SimplifyPath {
	
	public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("////home////."));
    }

    public static String simplifyPath(String path) {
        String[] strs = path.split("/");

        Stack<String> stack = new Stack<>();
        for(String str : strs) {
            if(str.equals("") || str.equals(".")) continue;

            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!str.equals("..")) stack.push(str);
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) builder.insert(0, stack.pop()).insert(0, "/");

        return builder.length() == 0 ? "/" : builder.toString();
    }
	
}