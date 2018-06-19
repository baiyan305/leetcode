// 723. Candy Crush

import java.util.ArrayList;
import java.util.List;

public class CandyCrush {

    public static void main(String[] args) {
        int[][] board = {
                {1,2,3,4,5},
                {2,3,4,5,6},
                {1,3,5,5,5},
                {1,3,4,5,6}
        };

        candyCrush(board);

        for(int[] row : board) {
            for(int i : row) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    public static void candyCrush(int[][] board) {
        int height = board.length, width = board[0].length;

        while(true) {
            List<int[]> list = new ArrayList<>();
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    if(board[y][x] == 0) continue;
                    int up = y-1, down = y+1, left = x-1, right = x+1;
                    while(up>=0 && up>=y-2 && board[y][x] == board[up][x]) up--;
                    while(down<height && down<=y+2 && board[y][x] == board[down][x]) down++;
                    while(left>=0 && left>=x-2 && board[y][x] == board[y][left]) left--;
                    while(right<width && right<=x+2 && board[y][x] == board[y][right]) right++;
                    if(down-up>3 || right-left>3) list.add(new int[]{y,x});
                }
            }

            if(list.size() == 0) break;
            for(int[] point : list) board[point[0]][point[1]] = 0;

            for(int x=0; x<width; x++) {
                int bottom = height-1;
                for(int y=height-1; y>=0; y--) {
                    if(board[y][x] != 0) {
                        int tmp = board[bottom][x];
                        board[bottom][x] = board[y][x];
                        board[y][x] = tmp;
                        bottom--;
                    }
                }
            }
        }

    }

}