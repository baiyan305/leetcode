// 4. Median of Two Sorted Arrays

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] x = {1,3};
        int[] y = {2};

        System.out.println(findMedianSortedArrays(x, y));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenX = nums1.length, lenY = nums2.length, lowX = 0, highX = lenX - 1;

        while(1) {
            int midX = (lowX + highX) / 2;
            int midY = (lenX + lenY) / 2 - midX - 1;
    
            System.out.println("midX:"+midX);
            System.out.println("midY:"+midY);

            // Edge case. If midX is 0, then no elements on the left. Set maxLeftX to VALUE_MIN.
            int maxLeftX = midX < 0 ? Integer.MIN_VALUE : nums1[midX];
            System.out.println("maxLeftX:"+maxLeftX);
            // Edge case. If midX is lenX-1, then no lements on the right. Set minRightX to VALUE_MAX.
            int minRightX = midX == lenX - 1 ? Integer.MAX_VALUE : nums1[midX+1];             
            System.out.println("minRightX:"+minRightX);
            // Edge case. If midY is 0, then no elements on the left. Set maxLeftY to VALUE_MIN.
            int maxLeftY = midY == 0 ? Integer.MIN_VALUE : nums2[midY-1];
            System.out.println("maxLeftY:"+maxLeftY);
            // Edge case. If midY is lenY-1, then no elements on the right. Set minRightY to VALUE_MAX
            int minRightY = midY > lenY - 1 ? Integer.MAX_VALUE : nums2[midY]; 
            System.out.println("minRightY:"+minRightY);
          
            System.out.println(); 
            System.out.println(); 
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((lenX + lenY) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY)) / 2.0;
                }
                
                return Math.min(minRightX, minRightY);
            }else if(maxLeftX > minRightY){
                highX = midX - 1;
            }else{
                lowX = midX + 1;
            }
        }

        return -1;     
    }
}
