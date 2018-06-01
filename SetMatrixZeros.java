// 73. Set Matrix Zeroes

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        setZeroes(matrix);
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[0].length; x++){
                System.out.print(matrix[y][x]+",");
            }
            System.out.println();
        }

    }

    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length ==0 ) return;
        boolean firstRow = false, firstColumn = false;

        // iterate first row and first column
        for(int x=0; x<matrix[0].length; x++) if(matrix[0][x] == 0) firstRow = true;
        for(int y=0; y<matrix.length; y++)  if(matrix[y][0] == 0) firstColumn = true;

        for(int y=1; y<matrix.length; y++)
            for(int x=1; x<matrix[0].length; x++)
                if(matrix[y][x] == 0)
                    matrix[0][x] = matrix[y][0] = 0;

        for(int x=1; x<matrix[0].length; x++)
            if(matrix[0][x] == 0)
                for(int y=1; y<matrix.length; y++)
                    matrix[y][x] = 0;
        for(int y=1; y<matrix.length; y++)
            if(matrix[y][0] == 0)
                for(int x=1; x<matrix[0].length; x++)
                    matrix[y][x] = 0;
        if(firstRow)
            for(int x=0; x<matrix[0].length; x++)
                matrix[0][x] = 0;
        if(firstColumn)
            for(int y=0; y<matrix.length; y++)
                matrix[y][0] = 0;
    }

}
