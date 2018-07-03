// 468. Validate IP Address

public class ValidateIPAddress {
	
	public static void main(String[] args) {
		System.out.println(":1:2:3:2:4".split(":").length);
		
		
		System.out.println(validIPAddress("172.16.254.1"));
		System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("256.256.256.256"));
		System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
		System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
		System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
		System.out.println(validIPAddress("1e1.4.5.6"));
	}
	
	public static String validIPAddress(String IP) {
        // match IPv4
		if(IP.length()>=7){
			for(int i=0; i<=3; i++){
				if(IP.charAt(i) == '.') if(ipv4(IP)) return "IPv4";
			}
		} 
		
		// match IPv6
		if(ipv6(IP)) return "IPv6";
		
		return "Neither";
    }
	
	private static boolean ipv4(String IP) {
		String[] subs = IP.split("\\.");
		if(subs.length != 4) return false;
		
		for(String sub : subs) {
			if(sub.length() == 0 || sub.length() > 3) return false;
			if(sub.length()>1 && sub.charAt(0) == '0') return false;
			if(!checkDecimal(sub)) return false;
			
			//check range, must between 0 and 255
			Integer subInt = Integer.parseInt(sub);
			if(subInt <0 || subInt > 255) return false;
		}
		
		return true;
	}
	
	private static boolean ipv6(String IP) {
		if(IP.charAt(IP.length()-1) == ':') return false;
		String[] subs = IP.split(":");
		if(subs.length != 8) return false;
		
		for(String sub : subs) {
			if(sub.length() == 0 || sub.length() > 4) return false;
			if(!checkhexadecimal(sub)) return false;
			
			Integer subInt = Integer.parseInt(sub, 16);
			if(subInt < 0 || subInt > 65535) return false;
		}
		
		return true;
	}
	
	private static boolean checkDecimal(String str){
		for(char ch : str.toCharArray()){
			if(ch < '0' || ch > '9') return false;
		}
		return true;
	}
	
	private static boolean checkhexadecimal(String str){
		for(char ch : str.toCharArray()){
			if(! ( (ch>='0' && ch<='9') || (ch>='a' && ch<='f') || (ch>='A' && ch<='F') )) return false;
		}
		return true;
	}
	
}