// 165. Compare Version Numbers

public class CompareVersionNumbers {
	
	public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
    }

    public static int compareVersion(String version1, String version2) {
        int left1 = 0, right1 = 0, left2 = 0, right2 = 0;

        while(right1 < version1.length() || right2 < version2.length()) {
            int ver1 = 0, ver2 = 0;

            if(right1 < version1.length()) {
                while(right1 < version1.length() && version1.charAt(right1) != '.') right1++;
                ver1 = Integer.parseInt(version1.substring(left1, right1));
                left1 = ++right1;
            }
            if(right2 < version2.length()){
                while(right2 < version2.length() && version2.charAt(right2) != '.') right2++;
                ver2 = Integer.parseInt(version2.substring(left2, right2));
                left2 = ++right2;
            }

            if(ver1 > ver2) return 1;
            else if(ver1 < ver2) return -1;
        }

        return 0;
    }
	
}