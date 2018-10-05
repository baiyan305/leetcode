// 240. Search a 2D Matrix II

public class Search2DMatrixII {

    public void run() {
        System.out.println("123");
    }

    // 右上方的元素，左边的元素都比它小，下面的元素都比它大，所有将右上方的元素作为mid。
    // while循环的终止条件是mid超出矩阵范围了。
    // 如果 target 比 mid 小，那么 mid 下面的元素都可以淘汰了，midX--
    // 如果 target 比 mid 大，那么 mid 左面的元素都可以淘汰了，midY++
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int height = matrix.length, midY = 0, midX = matrix[0].length-1;
        while(midY < height && midX >= 0) {
            int num = matrix[midY][midX];
            if(target == num) return true;
            else if(target > num) midY++;
            else midX--;
        }

        return false;
    }

}
