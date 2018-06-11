// 289. Game of Life

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gameOfLife(board);

        for (int Y = 0; Y < board.length; Y++) {
            for (int X = 0; X < board[0].length; X++) {
                System.out.print(board[Y][X] + ", ");
            }
            System.out.println();
        }
    }


    public static void gameOfLife(int[][] board) {
        if(board == null) return;

        int lenY = board.length, lenX = board[0].length;

        for(int Y = 0; Y<lenY; Y++) {
            for(int X = 0; X<lenX; X++) {
                int numOfLiveNeighbor = countLiveNeighbor(board, Y, X);
                if(board[Y][X] == 0 && numOfLiveNeighbor == 3) board[Y][X] = deathToLive;
                else if (board[Y][X] == 1 && numOfLiveNeighbor !=2 && numOfLiveNeighbor !=3) board[Y][X] = liveToDeath;
            }
        }

        for(int Y = 0; Y<lenY; Y++) {
            for(int X = 0; X<lenX; X++) {
                if(board[Y][X] == deathToLive) board[Y][X] = live;
                else if (board[Y][X] == liveToDeath) board[Y][X] = death;
            }
        }

    }

    private static int countLiveNeighbor(int[][] board, int Y, int X) {
        int numOfLive = 0, lenY = board.length, lenX = board[0].length;

        for(int y = Y-1; y <= Y+1; y++) {
            for(int x = X-1; x <= X+1; x++) {
                if(y<0 || y>=lenY || x<0 || x>= lenX || (x == X && y == Y)) continue;
                if((board[y][x] == live || board[y][x] == liveToDeath)) numOfLive++;
            }
        }

        return numOfLive;
    }


}
