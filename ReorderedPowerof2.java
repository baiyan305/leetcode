// 869. Reordered Power of 2

public class ReorderedPowerof2 {

    public void run() {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));
    }

    public boolean reorderedPowerOf2(int N) {
        int digits = (int)(Math.log10(N));
        double floor = Math.pow(10, digits), ceiling = Math.pow(10, digits+1);

        int[] countN = count(N);
        for(int i=0, num=1; i<32; i++, num <<= 1) {
            if(num < floor) continue;
            else if(num >= ceiling) break;

            if(match(count(num), countN)) return true;
        }

        return false;
    }

    private int[] count(long num) {
        int[] count = new int[10];
        for(; num > 0; num /= 10) count[(int)(num % 10)]++;
        return count;
    }

    private boolean match(int[] base, int[] candidate) {
        for(int i=0; i<10; i++) if(base[i] != candidate[i]) return false;
        return true;
    }

}