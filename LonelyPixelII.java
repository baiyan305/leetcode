// 533. Lonely Pixel II

import java.util.HashMap;

public class LonelyPixelII {

    public static void main(String[] args) {
        int[][] = {
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,1}
        };

        System.out.println(longestLine(M));
    }

    public static int longestLine(int[][] M) {
        int height = M.length, width = M[0].length, max = 0;

        // horizontal
        for(int y=0; y<height; y++) {
            int localMax = 0;
            for(int x=0; x<width; x++) {
                if(M[y][x] == 1) localMax ++;
                else {
                    max = Math.max(max, localMax);
                    localMax = 0;
                }
            }
            max = Math.max(max, localMax);
        }

        // vertical
        for(int x=0; x<width; x++) {
            int localMax = 0;
            for(int y=0; y<height; y++) {
                if(M[y][x] == 1) localMax ++;
                else {
                    max = Math.max(max, localMax);
                    localMax = 0;
                }
            }
            max = Math.max(max, localMax);
        }

        // diagonal
        for(int x = 0, y = 0; x < width; x++) {
            int localMax = 0, startX = x, startY = y;
            while(startX < width && startY < height) {
                if(M[startY][startX] == 1) localMax++;
                else {
                    max = Math.max(max, localMax);
                    localMax = 0;
                }
                startX++;
                startY++;
            }
            max = Math.max(max, localMax);
        }

        for(int x = 0, y = 0; y < height; y++ ) {
            int localMax = 0, startX = x, startY = y;
            while(startX < width && startY < height) {
                if(M[startY][startX] == 1) localMax++;
                else {
                    max = Math.max(max, localMax);
                    localMax = 0;
                }
                startX++;
                startY++;
            }
            max = Math.max(max, localMax);
        }

        // anti-diagonal
        for(int x = 0, y = 0; x < width; x++) {
            int localMax = 0, startX = x, startY = y;
            while(startX > 0 && startY < height) {
                if(M[startY][startX] == 1) localMax++;
                else {
                    max = Math.max(max, localMax);
                    localMax = 0;
                }
                startX--;
                startY++;
            }
            max = Math.max(max, localMax);
        }

        for(int x = width-1, y = 0; y < height; y++ ) {
            int localMax = 0, startX = x, startY = y;
            while(startX > 0 && startY < height) {
                if(M[startY][startX] == 1) localMax++;
                else {
                    max = Math.max(max, localMax);
                    localMax = 0;
                }
                startX--;
                startY++;
            }
            max = Math.max(max, localMax);
        }


        return max;
    }

}