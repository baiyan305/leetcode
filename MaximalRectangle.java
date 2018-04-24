// 85. Maximal Rectangle

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int width = matrix[0].length, max = 0;
        int[] heights = new int[width];
        for(char[] row : matrix) {
            for(int i=0; i<width; i++) {
                heights[i] = row[i] == '0' ? 0 : heights[i]+1;
            }
            max = Math.max(max, maxRectangleInHistogram(heights));
        }
        
        return max;
    }

    private static int maxRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0; i<=heights.length; i++) {
            int heightOfI = i == heights.length ? 0 : heights[i];
            while(!stack.isEmpty() && heightOfI < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftExeclude = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, height * (i-leftExeclude-1));
            }

            stack.push(i);
        } 
        return max;
    }

}
