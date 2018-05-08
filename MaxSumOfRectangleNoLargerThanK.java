// 363. Max Sum of Rectangle No Larger Than K

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {

    public static void main(String[] args) {
		int[][] matrix = {
			{2,2,-1},
			{0,-2,3}
		};
		
		System.out.println(maxSumSubmatrix(matrix, 4));
    }

	public static int maxSumSubmatrix(int[][] matrix, int k) {
		int height = matrix.length, width = matrix[0].length, max = Integer.MIN_VALUE;
		
		for(int left=0; left<width; left++) {
			int[] sum = new int[height];
			for(int right=left; right<width; right++) {
				for(int h=0; h<height; h++) {
					sum[h] += matrix[h][right];
					//if(sum[i] == k) return k;
				}
				
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				int tmp = 0;
				for(int num : sum) {
					tmp += num;
					//if(tmp == k) return k;
					Integer least = set.ceiling(tmp-k);
					if(least != null) max = Math.max(max, tmp-least);
					set.add(tmp);
				}
			}
		}
		
		return max;
	}
	
	/*
    public static int maxSumSubmatrix(int[][] matrix, int k) {       
        int max = Integer.MIN_VALUE, height = matrix.length, width = matrix[0].length;
        int[][] sums = new int[height][width];
        sums[0][0] = matrix[0][0];

        for(int w=1; w<width; w++) sums[0][w] = matrix[0][w] + sums[0][w-1];
        for(int h=1; h<height; h++) sums[h][0] = matrix[h][0] + sums[h-1][0];
        for(int h=1; h<height; h++)
            for(int w=1; w<width; w++)
                sums[h][w] = matrix[h][w] + sums[h][w-1] + sums[h-1][w] - sums[h-1][w-1];
        
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(sums[i][j]+" ");
			}
			System.out.println();
		}
		
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                for(int m=i; m<height; m++) {
                    for(int n=j; n<width; n++) {
						int area = area(sums, i,j,m,n);
						System.out.println("["+i+","+j+"], ["+m+","+n+"] : "+area);
						if(area<=k) max = Math.max(max, area);
					}
				}
			}
		}
                        
		return max;
    }

    private static int area(int[][] area, int i, int j, int m, int n){
        int leftArea = 0, aboveArea = 0;
        if(j>0) leftArea = area[m][j-1];
        if(i>0) aboveArea = area[i-1][n]-(j>0 ? area[i-1][j-1] : 0);

        return area[m][n] - leftArea - aboveArea; 
    }
	*/
}
