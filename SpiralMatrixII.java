// 59. Spiral Matrix II

public class SpiralMatrixII {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(0);

        for(int[] row : matrix) {
            for(int num : row) {
                System.out.print(num+", ");
            }
            System.out.println("");
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for(int layer=0; layer<n/2; layer++) {
            int X = 0 + layer, Y = 0 + layer, lenX = n - 2 * layer - 1, lenY = n - 2 * layer - 1;
            for(int i=0; i<lenX; i++) matrix[Y][X++] = num++;
            for(int i=0; i<lenY; i++) matrix[Y++][X] = num++;
            for(int i=0; i<lenX; i++) matrix[Y][X--] = num++;
            for(int i=0; i<lenY; i++) matrix[Y--][X] = num++;
        }
        if(n%2 == 1) matrix[n/2][n/2] = num;

        return matrix;
    }

}