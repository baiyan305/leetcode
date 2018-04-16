// 264. Ugly Number II

public class UglyNumberII {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(8));
    }

    public static int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;

        int idx2 = 0, idx3 = 0, idx5 = 0;
        for(int i=1; i<n; i++) {
            int num2 = uglyNums[idx2] * 2;
            int num3 = uglyNums[idx3] * 3;
            int num5 = uglyNums[idx5] * 5;
            int newNum = Math.min(num2, Math.min(num3, num5));

            if(newNum == num2) idx2++;
            if(newNum == num3) idx3++;
            if(newNum == num5) idx5++;

            uglyNums[i] = newNum;
        }

        return uglyNums[n-1];
    }

}