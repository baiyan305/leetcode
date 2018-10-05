// 74. Search a 2D Matrix

public class Search2DMatrix {

    public void run() {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        int[][] matrix1 = {
                {1}
        };
        System.out.println(searchMatrix(matrix, 20));

        System.out.println("123");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int low = 0, high = matrix.length-1;
        while(low < high) {
            int mid = low + (high-low)/2 + 1;
            if(matrix[mid][0] > target) {
                //当前mid比target大，那么target一定不在mid这一行，mid以及右半边可以淘汰
                high = mid -1;
            } else {
                //如果当前mid小于等于target，那么target可能在mid这一行，或者后面的行，mid的左边可以淘汰
                //当只有两个元素的时候，mid是low或者high。为了避免死循环，mid应该指向high。
                //所有 mid = low + (high-low) +1, 就是向右偏。
                low = mid;
            }
        }
        if(matrix[low][0] > target) return false;

        // 从目标行中找到target
        int row = low;
        low = 0;
        high = matrix[0].length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

}
