// 313. Super Ugly Number

public class SuperUglyNumber {

    public void run() {
        System.out.println(nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglys = new int[n], idxs = new int[primes.length];
        uglys[0] = 1;

        for(int i=1; i<n; i++) {
            int minUgly = primes[0] * uglys[idxs[0]];
            for(int j=1; j<primes.length; j++) minUgly = Math.min(minUgly,primes[j] * uglys[idxs[j]]);
            for(int j=0; j<primes.length; j++) if(primes[j]* uglys[idxs[j]] == minUgly) idxs[j]++;
            uglys[i] = minUgly;
        }

        return uglys[n-1];
    }

}