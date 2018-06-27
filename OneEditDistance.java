// 161. One Edit Distance

public class OneEditDistance {
	
	public static void main(String[] args) {
        System.out.println(isOneEditDistance("1012","1112"));
        System.out.println(isOneEditDistance("ab","ba"));
        System.out.println(isOneEditDistance("",""));
    }

    public static boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;

        if(s.length() == t.length()) {
            int count = 0;
            for(int i=0; i<s.length(); i++) if(s.charAt(i) != t.charAt(i)) count++;
            return count == 1;
        } else {
            for(int i=0; i<Math.min(s.length(), t.length()); i++)
                if(s.charAt(i) != t.charAt(i)) {
                    if (s.length() < t.length()) return s.substring(i).equals(t.substring(i + 1));
                    else return s.substring(i + 1).equals(t.substring(i));
                }
        }

        return true;
    }
	
}