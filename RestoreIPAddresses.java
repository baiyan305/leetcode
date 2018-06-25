// 93. Restore IP Addresses

public class RestoreIPAddresses {
	
	public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
        //System.out.println(restoreIpAddresses(")()())"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s==null || s.length()<4) return  list;

        for(int a=0; a<3; a++)
            for(int b=a+1; b<=a+3; b++)
                for(int c=b+1; c<=b+3; c++)
                    for(int d=c+1; d<=c+3; d++){
                        if(d == s.length()-1) {
                            int ip_a = Integer.parseInt(s.substring(0, a+1));
                            int ip_b = Integer.parseInt(s.substring(a+1, b+1));
                            int ip_c = Integer.parseInt(s.substring(b+1, c+1));
                            int ip_d = Integer.parseInt(s.substring(c+1, d+1));
                            if(ip_a<=255 && ip_b<=255 && ip_c<=255 && ip_d<=255) {
                                String ip = ip_a+"."+ip_b+"."+ip_c+"."+ip_d;
                                if(ip.length() == s.length()+3) list.add(ip);
                            }

                        }
                    }
        return list;
    }
	
}