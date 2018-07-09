// 555. Split Concatenated Strings

public class SplitConcatenatedStrings{

    public void run() {
        //String[] strs = {"abc", "xyz"};
        //String[] strs = {"lc", "evol", "cdy"};
        String[] strs = {"awef","eawf","zdaeff","awefzewaf","awefzewaf"};
        System.out.println(splitLoopedString(strs));
    }

    public String splitLoopedString(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<strs.length; i++) {
            strs[i] = larger(strs[i]);
            builder.append(strs[i]);
        }

        String mid = builder.toString(), largest = "";
        for(int i=0; i<strs.length; i++) {
            String str = strs[i], reverseStr = new StringBuilder(str).reverse().toString();
            mid = mid.substring(str.length());

            for(int j=0; j<str.length(); j++) {
                String newStr1 = str.substring(j) + mid + str.substring(0, j);
                String newStr2 = reverseStr.substring(j) + mid + reverseStr.substring(0, j);
                String localLargest = newStr1.compareTo(newStr2) > 0 ? newStr1 : newStr2;
                if(localLargest.compareTo(largest) > 0) largest = localLargest;
            }

            mid = mid + str;
        }

        return largest;
    }

    private String larger(String s) {
        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return s.charAt(left) < s.charAt(right) ? new StringBuilder(s).reverse().toString() : s;
            }
        }

        return s;
    }


}
