// 271. Encode and Decode Strings

public class EncodeAndDecodeStrings {
	
	public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("abc");
        strs.add("1asd");
        strs.add("0*+");
        strs.add("!@#$");
        strs.add("");

        String encoded = Codec.encode(strs);
        System.out.println(Codec.decode(encoded));
    }

    public static class Codec {

        // Encodes a list of strings to a single string.
        public static String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for(String str : strs) {
                builder.append(str.length());
                builder.append('?');
                builder.append(str);
            }

            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public static List<String> decode(String s) {
            List<String> list = new ArrayList<>();

            int left = 0;
            while(left < s.length()) {
                int idx = left;
                while(idx < s.length() && s.charAt(idx) != '?') idx++;
                int len = Integer.parseInt(s.substring(left, idx++));
                String str = s.substring(idx, idx+len);
                list.add(str);

                left = idx + len;
            }

            return list;
        }
        
    }
	
}