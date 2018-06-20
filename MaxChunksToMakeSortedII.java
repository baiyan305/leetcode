// 768. Max Chunks To Make Sorted II

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{0,1,2,3,4,5}));
        System.out.println(maxChunksToSorted(new int[]{5,4,3,2,1,0}));
        System.out.println(maxChunksToSorted(new int[]{0,1,2,3,5,6,7,4}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int[] leftMax = new int[len], rightMin = new int[len];

        leftMax[0] = arr[0];
        for(int i=1; i<len; i++) leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        rightMin[len-1] = arr[len-1];
        for(int i=len-2; i>=0; i--) rightMin[i] = Math.min(rightMin[i+1], arr[i]);

        int chunk = 0;
        for(int i=0; i<len-1; i++) {
            if(leftMax[i] <= rightMin[i+1]) chunk++;
        }

        return chunk+1;
    }

}