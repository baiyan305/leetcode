// 531. Lonely Pixel I

public class LonelyPixell {

    public static void main(String[] args) {
        /*
        char[][] picture = {
                {'W', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'B'}
        };
        */

        char[][] picture = {
                {'W'},
                {'W'},
                {'B'}
        };

        System.out.println(findLonelyPixel(picture));
    }

    public static int findLonelyPixel(char[][] picture) {
        // If there is only one 'B' in first column, it is the index of that 'B'
        // If there is no 'B' or there are more than one 'B', it is -1.
        int numOfBlackInfirstColumn = 0, indexOfBlackInfirstColumn = 0;
        for(int i=0; i<picture.length; i++) {
            if(picture[i][0] == 'B') {
                numOfBlackInfirstColumn++;
                indexOfBlackInfirstColumn = i;
            }
        }

        for(int row = 0; row < picture.length; row++) {
            int count = 0;
            for(int col = 0; col < picture[0].length; col++) if(picture[row][col] == 'B') count++;
            picture[row][0] = count == 1 ? '1' : '0';
        }

        int lonelyPixel = 0;
        for(int col = 1; col < picture[0].length; col++) {
            int countOfBlack = 0, countOfLonelyPixel = 0;
            for(int row = 0; row < picture.length; row++) {
                if(picture[row][col] == 'B') {
                    countOfBlack++;
                    if(picture[row][0] == '1')
                        countOfLonelyPixel++;
                }
            }

            lonelyPixel += countOfBlack == 1 ? countOfLonelyPixel : 0;
        }

        if(numOfBlackInfirstColumn == 1 && picture[indexOfBlackInfirstColumn][0] == '1') lonelyPixel++;

        return lonelyPixel;
    }

}