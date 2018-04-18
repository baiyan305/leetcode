// 304. Range Sum Query 2D - Immutable

public class RangeSumQuery2DImmutable {
	
	public static void main(String[] args) {
		int[][] nums = {
			{3,0,1,4,2},
			{5,6,3,2,1},
			{1,2,0,1,5},
			{4,1,0,1,7},
			{1,0,3,0,5}
		};
		
		NumMatrix obj = new NumMatrix(nums);
		System.out.println(obj.sumRegion(1,2,2,4));
	}
	
	static class NumMatrix {
		
		int[][] sum;
		
		public NumMatrix(int[][] matrix) {
			if(matrix != null && matrix.length != 0) {
				sum = new int[matrix.length][matrix[0].length];
				sum[0][0] = matrix[0][0];
				
				//first row
				for(int i=1; i<matrix[0].length; i++) {
					sum[0][i] = matrix[0][i] + sum[0][i-1];
				}
				//first column
				for(int i=1; i<matrix.length; i++) {
					sum[i][0] = matrix[i][0] + sum[i-1][0];
				}	
				for(int h = 1; h < matrix.length; h++)
					for(int w = 1; w < matrix[0].length; w++)
						sum[h][w] = matrix[h][w] + sum[h-1][w] + sum[h][w-1] - sum[h-1][w-1];
			}
			
			/*	
			for(int[] nums : sum){
				for(int num : nums) {
					System.out.print(num + "   ");
				}
				
				System.out.println();
			}
			*/
		}
		
		public int sumRegion(int row1, int col1, int row2, int col2) {
			int ret = sum[row2][col2];
			
			if(row1 > 0) ret -= sum[row1-1][col2];
			if(col1 > 0) ret -= sum[row2][col1-1];
			if(row1 > 0 && col1 > 0) ret += sum[row1-1][col1-1];
			
			return ret;
		}
	}
	
}