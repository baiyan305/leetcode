// 396. Rotate Function

public class RotateFunction {

    public void run() {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] A) {
        int F = 0, sum = 0, n = A.length;
        for(int i=0; i<n; i++) {
            F += i * A[i];
            sum += A[i];
        }

        int res = F;
        for(int i=1; i<n; i++) {
            F = F + sum - n * A[n-i];
            res = Math.max(res, F);
        }

        return res;
    }

}