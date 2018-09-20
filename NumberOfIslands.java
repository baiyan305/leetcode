// 200. Number of Islands

public class NumberOfIslands {

    public void run() {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','1'},
                {'0','0','0','1','0'}
        };
        System.out.println(numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islands = 0;
        for(int y=0; y<grid.length; y++) {
            for(int x=0; x<grid[0].length; x++) {
                if(grid[y][x] == '1' && !visited[y][x]) {
                    islands++;
                    search(grid, visited, y, x);
                }
            }
        }

        return islands;
    }

    private void search(char[][] grid, boolean[][] visited, int y, int x) {
        if(y<0 || y>=grid.length || x<0 || x>=grid[0].length || visited[y][x] || grid[y][x] == '0') return;

        visited[y][x] = true;
        search(grid, visited, y+1, x);
        search(grid, visited, y-1, x);
        search(grid, visited, y, x+1);
        search(grid, visited, y, x-1);
    }

}
