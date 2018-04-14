// 265. Paint House II

public class PaintHouseII {

    public static void main(String[] args) {
            int[][] costs = new int[][]{{14,18,16},{18,4,9},{2,20,2},{4,19,10},{7,13,4},{11,4,17},{10,11,20},{8,3,16},{4,17,15},{8,7,3},{1,19,4},{12,11,18},{10,5,6},{14,19,19},{5,8,12},{12,16,13},{20,8,16},{17,15,2},{14,2,20},{2,6,14},{3,17,17},{17,8,3},{16,8,4},{7,14,8},{13,3,7},{15,11,14},{19,20,10},{4,2,6}};
            System.out.println(minCostII(costs));
    }
    
    public static int minCostII(int[][] costs) {
        if(costs == null) return 0;

        int minCostSoFar = 0, minCostSoFar2 = 0, lastColor = -1;

        for(int h=0; h<costs.length; h++) {
            int minCostThis = Integer.MAX_VALUE, minCostThis2 = Integer.MAX_VALUE, minColor = -1;
            for(int c=0; c<costs[h].length; c++) {
                int cost = costs[h][c] + (c == lastColor ? minCostSoFar2 : minCostSoFar);
                if(minColor == -1 || cost < minCostThis) { // set minimum value
                    minCostThis2 = minCostThis;
                    minCostThis = cost;
                    minColor = c;
                } else if (cost < minCostThis2){
                    minCostThis2 = cost;
                }
            }

            minCostSoFar = minCostThis;
            minCostSoFar2 = minCostThis2;
            lastColor = minColor;
        }

        return minCostSoFar;
    }
    
}

            