// 204. Count Primes

public class CountPrimes {

    public void run() {
        System.out.println(countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];

        for(int i=2; i<= Math.sqrt(n); i++) {
            if(!prime[i]) {
                for(int j=i; i*j<n; j++) {
                    prime[i*j] = true;
                }
            }
        }

        int count = 0;
        for(int i=2; i<n ;i++) {
            if(!prime[i]) count++;
        }

        return count;
    }

}
