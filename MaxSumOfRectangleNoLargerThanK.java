// 363. Max Sum of Rectangle No Larger Than K

public class MaxSumOfRectangleNoLargerThanK {

    public static void main(String[] args) {

    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {       
        int max = Integer.MIN_VALUE, height = matrix.length, width = matrix[0].length;
        int[][] sums = new int[height][width];
        sums[0][0] = matrix[0][0];

        for(int w=1; w<width; w++) sums[0][w] = matrix[0][w] + sums[0][w-1];
        for(int h=1; h<height; h++) sums[h][0] = matrix[h][0] + sums[h-1][0];
        for(int h=1; h<height; h++)
            for(int w=1; w<width; w++)
                sums[h][w] = sums[h][w-1] + sums[h-1][w] - sums[h-1][w-1];
        
        for(int i=0; i<width; i++)
            for(int j=0; j<height; j++)
                for(int m=0; m<width; m++)
                    for(int n=0; n<height; n++)
                        
    }

    private static int area(int[][] area, int i, int j, int m, int n){
        int leftArea = 0, aboveArea = 0;
        if(j>0) leftArea = area[m][j-1];
        if(i>0) aboveArea = area[i-1][n]-(j>0 ? area[i-1][j-1] : 0);

        return area[m][n] - leftArea - aboveArea; 
    }

}
