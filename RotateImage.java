// 48. Rotate Image

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        rotate(matrix);

        for(int[] nums : matrix){
            for(int num : nums) {
                System.out.print(num+"  ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        if(matrix == null) return;

        int layers = matrix.length/2, len = matrix.length-1;
        for(int layer=0; layer<layers; layer++) {
            for(int offset=layer; offset<len-layer; offset++) {
                //backup top
                int bak = matrix[layer][offset];

                //left to top
                matrix[layer][offset] = matrix[len-offset][layer];

                //bottom to left
                matrix[len-offset][layer] = matrix[len-layer][len-offset];

                //right to bottom
                matrix[len-layer][len-offset] = matrix[offset][len-layer];

                //top to right
                matrix[offset][len-layer] = bak;
            }
        }
    }

}