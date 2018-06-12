// 533. Lonely Pixel II

import java.util.HashMap;

public class LonelyPixelII {

    public static void main(String[] args) {
        char[][] picture = {
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'B', 'W'},
                {'W', 'W', 'B', 'W', 'B', 'W'}
        };

        System.out.println(findBlackPixel(picture, 3));
    }


    public static int findBlackPixel(char[][] picture, int N) {
        if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;

        HashMap<String, Integer> map = new HashMap<>();
        int[] numOfBlackInColumn = new int[picture[0].length];

        for(int y = 0; y < picture.length; y++) {
            int numOfBlack = 0;
            for(int x = 0; x < picture[0].length; x++) {
                if(picture[y][x] == 'B') {
                    numOfBlack++;
                    numOfBlackInColumn[x] += 1;
                }
            }
            if(numOfBlack == N) {
                String cur = new String(picture[y]);
                if(!map.containsKey(cur)) map.put(cur, 0);
                map.put(cur, map.get(cur)+1);
            }
        }

        int totalBlack = 0;
        for(String key : map.keySet()) {
            int numOfRow = map.get(key);
            if(numOfRow == N) {
                for(int i=0; i<key.length(); i++) {
                    if(key.charAt(i) == 'B' && numOfBlackInColumn[i] == N) totalBlack += N;
                }
            }
        }

        return totalBlack;
    }

}