// 256. Paint House

public class PaintHouse {

    public static void main(String[] args) {

    }

    public static int minCost(int[][] costs) {
        int minRed = 0, minBlue = 0, minGreen = 0;

        for(int[] cost : costs) {
            int minRedTemp = minRed, minBlueTemp = minBlue;
            minRed = cost[0] + Math.min(minBlue, minGreen);
            minBlue = cost[1] + Math.min(minRedTemp, minGreen);
            minGreen = cost[2] + Math.min(minRedTemp, minBlueTemp);
        }

        return Math.min(minRed, Math.min(minBlue, minGreen));
    }

}