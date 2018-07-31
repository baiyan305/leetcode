// 296. Best Meeting Point

public class BestMeetingPoint {
	
	public void run() {
        int[][] grid = {
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };

        System.out.println(minTotalDistance(grid));
    }

    public int minTotalDistance(int[][] grid) {
        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        for(int row=0; row<grid.length; row++)
            for(int col=0; col<grid[0].length; col++)
                if(grid[row][col] == 1) vertical.add(row);

        for(int col=0; col<grid[0].length; col++)
            for(int row=0; row<grid.length; row++)
                if(grid[row][col] == 1) horizontal.add(col);

        int left = 0, right = horizontal.size()-1, distance = 0;
        while(left < right) {
            distance += vertical.get(right) - vertical.get(left) + horizontal.get(right) - horizontal.get(left);
            left++;
            right--;
        }

        return distance;
    }
	
}