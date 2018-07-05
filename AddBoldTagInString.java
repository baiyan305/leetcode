// 616. Add Bold Tag in String

public class AddBoldTagInString {

    public static void main(String[] args) {
        System.out.println(addBoldTag("abcxyz123",new String[]{"abc","123"}));
        System.out.println(addBoldTag("aaabbcc",new String[]{"aaa","aab","bc"}));
    }

    public static String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];

        for(String sub : dict) {
            for(int idxStr=0; idxStr<s.length(); idxStr++) {
                int i = idxStr, j = 0;
                while(i<s.length() && j<sub.length() && s.charAt(i) == sub.charAt(j)){
                    i++;
                    j++;
                }

                if(j == sub.length()) for(int k=sub.length(); k>0; k--) bold[i-k] = true;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<bold.length; i++) {
            if(bold[i] && (i==0 || !bold[i-1])) builder.append("<b>");
            else if(!bold[i] && (i!=0 && bold[i-1])) builder.append("</b>");
            builder.append(s.charAt(i));
            if(bold[i] && i == bold.length-1) builder.append("</b>");
        }

        return builder.toString();
    }

}