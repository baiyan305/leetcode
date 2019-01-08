// 329. Longest Increasing Path in a Matrix

public class LongestIncreasingPathInMatrix {

    public void run() {
        int[][] matrix = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        int[][] matrix1 = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(longestIncreasingPath(matrix1));
        System.out.println("123");
    }

    // 基本的DFS
    // 但是要用DP记录一下已经遍历过的点的结果
    // memory[y][x]表示，起点是y,x的最长增长路径
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0, height = matrix.length, width = matrix[0].length;
        int[][] memory = new int[height][width];
        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                res = Math.max(res, dfs(matrix, memory, y, x));
            }
        }
        return res;
    }

    private int dfs(int[][]matrix, int[][] memory, int y, int x) {
        if(memory[y][x] != 0) return memory[y][x];

        int max = 1, height = matrix.length, width = matrix[0].length;
        //up, down, left, right
        int[] dirY = {-1, 1, 0, 0};
        int[] dirX = {0, 0, -1, 1};

        for(int i=0; i<4; i++) {
            int Y = y + dirY[i], X = x + dirX[i];
            if(Y<0 || Y>=height || X<0 || X>=width || matrix[Y][X] <= matrix[y][x]) continue;
            max = Math.max(max, 1+dfs(matrix, memory, Y, X));
        }

        memory[y][x] = max;
        return max;
    }

}
