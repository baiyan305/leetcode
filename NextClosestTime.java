// 681. Next Closest Time

public class NextClosestTIme {

    public static void main(String[] args) {
        System.out.println("===="+nextClosestTime("19:34"));
        System.out.println("===="+nextClosestTime("23:59"));
        System.out.println("===="+nextClosestTime("00:00"));
    }

    public static String nextClosestTime(String time) {
        int[] digits = {Integer.valueOf(time.substring(0, 1)),
                Integer.valueOf(time.substring(1, 2)),
                Integer.valueOf(time.substring(3, 4)),
                Integer.valueOf(time.substring(4, 5))};

        int nowTime = (digits[0] * 10 + digits[1]) * 60 + digits[2]*10 + digits[3], minDiff = Integer.MAX_VALUE;
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<4; i++){
            if(digits[i] > 2) continue;
            for(int j=0; j<4; j++){
                if(digits[i] == 2 && digits[j] > 4) continue;
                for(int k=0; k<4; k++) {
                    if(digits[k] >= 6) continue;
                    for(int l=0; l<4; l++) {
                        int newTime = (digits[i] * 10 + digits[j]) * 60 + digits[k]*10 + digits[l];
                        int diff = newTime - nowTime;
                        if(diff <= 0) diff += 3600;
                        if(diff < minDiff){
                            minDiff = diff;
                            builder.setLength(0);
                            builder.append(digits[i]).append(digits[j]).append(':').append(digits[k]).append(digits[l]);
                        }
                    }
                }
            }
        }

        return builder.toString();
    }

}