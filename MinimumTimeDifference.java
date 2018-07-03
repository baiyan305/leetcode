// 539. Minimum Time Difference

public class MinimumTimeDifference {

	public static void main(String[] args) {
		List<String> timePoints = Arrays.asList("00:00","23:59");
		System.out.println(findMinDifference(timePoints));
	}
	
	public static int findMinDifference(List<String> timePoints) {
        boolean[] bucket = new boolean[1440];
        int maxTime = Integer.MIN_VALUE, minTime = Integer.MAX_VALUE;
        for(String time : timePoints) {
        	int timeInt = toMinute(time);
        	if(bucket[timeInt]) return 0;
        	bucket[timeInt] = true;
        	
        	maxTime = Math.max(maxTime, timeInt);
        	minTime = Math.min(minTime, timeInt);
        }
        
        int minDiff = Integer.MAX_VALUE, prevTime = minTime;
        for(int i=minTime+1; i<=maxTime; i++) {
        	if(bucket[i]) {
        		int diff = i - prevTime;
        		diff = Math.min(diff, 1440-diff);
        		minDiff = Math.min(minDiff, diff);
        		prevTime = i;
        	}
        }
        
        int tmp = Math.min(maxTime-minTime, 1440-(maxTime-minTime));
        minDiff = Math.min(minDiff, tmp);
        
        return minDiff;
    }
	
	private static int toMinute(String time) {
		int hour = Integer.parseInt(time.substring(0, 2));
		int minute = Integer.parseInt(time.substring(3));
		
		return hour * 60 + minute;
	}
	
}
