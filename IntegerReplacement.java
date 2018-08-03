// 397. Integer Replacement

public class IntegerReplacement {
	
	public void run() {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(0));
        System.out.println(integerReplacement(1));
        System.out.println(integerReplacement(65535)); //17
        System.out.println(integerReplacement(2147483647)); //32
    }

    public int integerReplacement(int n) {
        if(n==Integer.MAX_VALUE) return 32;
        if(n==0) return 1;

        int time = 0;
        while(n != 1) {
            if(n % 2 == 0) n /= 2;
            else if(n == 3 || (n&3) == 1) n--;
            else n++;

            time++;
        }

        return time;
    }

    /*
    public int integerReplacement(int n) {
        long num = (long) n;
        if(num == 0) return 1;

        int time = 0;
        while(num != 1) {
            if(num % 2 == 0) num /= 2;
            else if(num == 3 || (num&3) == 1) num--;
            else num++;

            time++;
        }

        return time;
    }
    */
	
}