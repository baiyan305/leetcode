// 311. Sparse Matrix Multiplication

public class SparseMatrixMultiplication {

    public void run() {
        int[][] A = {
                {1, 0, 0},
                {-1, 0, 3}
        };

        int[][] B = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        int[][] C = multiply(A, B);
        System.out.println("123");
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int aY = A.length, aX = A[0].length, bX = B[0].length;

        int[][] C = new int[aY][bX];
        for(int y=0; y<aY; y++) {
            for(int k=0; k<aX; k++) {
                if(A[y][k] != 0) {
                    for(int x=0; x<bX; x++) {
                        if(B[k][x] != 0) C[y][x] += A[y][k] * B[k][x];
                    }
                }
            }
        }

        return C;
    }

}