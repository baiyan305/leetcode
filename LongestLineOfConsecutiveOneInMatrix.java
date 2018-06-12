// 562. Longest Line of Consecutive One in Matrix

public class LongestLineOfConsecutiveOneInMatrix {

    public static void main(String[] args) {
        int[][] M = {
                {0,1,0,0},
                {0,1,0,0},
                {1,0,0,0}
        };

        System.out.println(longestLine(M));
    }

    public static int longestLine(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;

        int height = M.length, width = M[0].length, max = 0;

        // horizontal
        for(int y=0; y<height; y++) {
            int localMax = 0;
            for(int x=0; x<width; x++) {
                if(M[y][x] == 1) max = Math.max(max, ++localMax);
                else localMax = 0;
            }
        }

        // vertical
        for(int x=0; x<width; x++) {
            int localMax = 0;
            for(int y=0; y<height; y++) {
                if(M[y][x] == 1) max = Math.max(max, ++localMax);
                else localMax = 0;
            }
        }

        // diagonal and anti-diagonal of first row
        for(int i=0; i<width; i++) {
            int leftX = i, leftY = 0, rightX = width-1-i, rightY = 0, maxLeft = 0, maxRight = 0, loop = Math.min(height, width-i);
            for(int j=0; j<loop; j++) {
                if(M[leftY++][leftX++] == 1) max = Math.max(max, ++maxLeft);
                else maxLeft = 0;
                if(M[rightY++][rightX--] == 1) max = Math.max(max, ++maxRight);
                else maxRight = 0;
            }
        }


        // diagonal of left most column and anti-diagonal of right most column
        for(int i=1; i<height; i++) {
            int leftX = 0, leftY = i, rightX = width-1, rightY = i, maxLeft = 0, maxRight = 0, loop = Math.min(height-i, width-1);
            for(int j=0; j<loop; j++) {
                if(M[leftY++][leftX++] == 1) max = Math.max(max, ++maxLeft);
                else maxLeft = 0;
                if(M[rightY++][rightX--] == 1) max = Math.max(max, ++maxRight);
                else maxRight = 0;
            }
        }


        return max;
    }

}
