// 54. Spiral Matrix

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(spiralOrder(matrix1));

        int[][] matrix2 = {
                {1}
        };
        System.out.println(spiralOrder(matrix2));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int height = matrix.length, width = matrix[0].length;
        int min = Math.min(height, width);
        for(int layer=0; layer<min/2; layer++) {
            int X = 0 + layer, Y = 0 + layer, lenX = width - 2 * layer - 1, lenY = height - 2 * layer - 1;
            for(int i=0; i<lenX; i++) list.add(matrix[Y][X++]);
            for(int i=0; i<lenY; i++) list.add(matrix[Y++][X]);
            for(int i=0; i<lenX; i++) list.add(matrix[Y][X--]);
            for(int i=0; i<lenY; i++) list.add(matrix[Y--][X]);
        }
        if(min%2 == 1){
            int X = min/2, Y = min/2, len = Math.max(width, height) - (min/2 *2);
            if(min == height) for(int i=0; i<len; i++) list.add(matrix[Y][X++]);
            else  for(int i=0; i<len; i++) list.add(matrix[Y++][X]);
        }

        return list;
    }

}