// 6. ZigZag Conversion

public class ZigZagConversion {
	
	public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }

    public static String convert(String s, int numRows) {
        int total = s.length(), sectorLen = numRows * 2 - 2, totalColumn = (total / sectorLen) * 2;
        if(total % sectorLen != 0) totalColumn += total %sectorLen <= numRows ? 1 : 2;

        StringBuilder builder = new StringBuilder(total);
        for(int row = 0; row < numRows; row++) {
            for(int column = 0; column < totalColumn; column++) {
                if( (row == 0 || row == numRows-1) && column % 2 == 1) continue;
                int idx = (column % 2 == 0) ? (column * numRows) - column + row : ((column+1) * numRows)  - column - 2 - row + 1;
                if(idx < total) builder.append(s.charAt(idx));
            }
        }

        return builder.toString();
    }
	
}