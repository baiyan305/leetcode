// 755. Pour Water

public class PourWater {

    public static void main(String[] args) {
        //int[] water = pourWater(new int[]{2,1,1,2,1,2,2}, 4, 3);
        int[] water = pourWater(new int[]{1,2,3,4}, 2, 2);
        for(int i : water) System.out.print(i+", ");
    }

    public static int[] pourWater(int[] heights, int V, int K) {
        for(int i=0; i<V; i++) {
            int leftMin = K;
            while(leftMin-1>=0 && heights[leftMin-1] <= heights[leftMin]) leftMin--;
            while(leftMin<K && heights[leftMin] == heights[leftMin+1]) leftMin++;
            if(leftMin != K) {
                heights[leftMin] += 1;
                continue;
            }

            int rightMin = K;
            while(rightMin+1<heights.length && heights[rightMin] >= heights[rightMin+1]) rightMin++;
            while(rightMin>K && heights[rightMin] == heights[rightMin-1]) rightMin--;
            if(rightMin != K) {
                heights[rightMin] += 1;
                continue;
            }

            heights[K] += 1;
        }

        return heights;
    }


}