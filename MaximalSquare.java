// 221. Maximal Square

public class MaximalSquare {
	
	public static void main(String[] args) {
		char[][] matrix = {
			{'1','0','1','0','0'},
				{'1','0','1','1','1'},
					{'1','1','1','1','1'},
						{'1','0','0','1','0'}
		};
		
		System.out.println(maximalSquare(matrix));
	}
	
	public static int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		
        int[] dp = new int[matrix[0].length] ;
        int height = matrix.length, width = matrix[0].length, leftTop = matrix[0][0] == '0' ? 0 : 1, max = 0;;

        for(int i=0; i<width; i++) {
            dp[i] = matrix[0][i] == '0' ? 0 : 1;
            if(matrix[0][i] == '1') max = 1;
        }

        for(int row = 1; row<height; row++) {
            for(int col = 0; col<width; col++) {
                if(col == 0) dp[col] = matrix[row][col] == '0' ? 0 : 1;
                else if(matrix[row][col] == '1'){
                    int tmp = dp[col];
                    dp[col] = Math.min(Math.min(dp[col], dp[col-1]), leftTop) + 1;
                    leftTop = tmp;
                } else {
                    dp[col] = 0;
                }

                max = Math.max(max, dp[col]);
            }
        }

        return max * max;
    }
	
}