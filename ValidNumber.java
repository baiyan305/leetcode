// 65. Valid Number

public class ValidNumber {
	
	public boolean isNumber(String s) {
        char[] arr = s.trim().toCharArray();
        boolean numberSeen = false, numberAfterESeen = false, dotSeen = false, eSeen = false;

        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            
			// 数字是可以出现在任何地方的，所以数字不能作为判断s是否是数字的条件
            if(Character.isDigit(c)) {
                if(!eSeen)numberSeen = true;
                else numberAfterESeen = true;
            } 
			// 小数点，如果有，只能出现一次，并且一定在e的前面
			else if(c == '.') {
                if(eSeen || dotSeen) return false;
                dotSeen = true;
            } 
			// e如果出现了，只能出现一次，并且前面一定是有数字的
			else if(c =='e') {
                if(eSeen || !numberSeen) return false;
                eSeen = true;
            } 
			// +-号，一定是第一个字符，因为我们trim过。如果不是第一个，那么一定在紧跟在e后面。
			else if(c == '+' || c == '-') {
                if(i != 0 && arr[i-1] != 'e') return false;
            } 
			// 任何其它字符都是非法的
			else {
                return false;
            }
        }

		// 看s结尾
		// 如果有e出现了，那么e后面必须跟数字，就是numberAfterESeen必须是true
		// 如果e没有出现过，那么数字是必须出现的, 就是numberSeen必须是true
        return eSeen ? numberAfterESeen : numberSeen;
    }
	
}