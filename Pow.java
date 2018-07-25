// 50. Pow(x, n) 

public class Pow {

    public void run() {
        System.out.println(myPow(2, -3)); // 0.125
        System.out.println(myPow(2, -2)); // 0.25
        System.out.println(myPow(1.72777, 7)); // 45.96227345465138
        System.out.println(myPow(2.0000, -2147483648)); // 0.0
    }

    // 递归
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;

        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = N * -1;
        }
        return recursion(x, N);
    }

    public double recursion(double x, long n) {
        if(n == 1) return x;
        return n % 2 == 1 ? x * recursion(x*x, n/2) : recursion(x*x, n/2);
    }

    /* 循环
    public double myPow(double x, int n) {
        // 这个地方，指数需要从int转为long或者double
        // 如果继续使用int，设想一下n是Integer.MIN_VALUE, 后面将n乘以-1是时候，就会越界。
        long N = n;

        if(N ==0 ) return 1;
        if(N < 0) {
            N = N * -1;
            x = 1/x;
        }

        double ans = 1;
        while(N != 1) {
            if(N%2 == 1) {
                ans *= x;
            }

            x = x * x;
            N = N / 2;
        }

        return ans*x;
    }
    */

}
