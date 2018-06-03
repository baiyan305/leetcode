// 228. Summary Ranges

public class SummaryRange {
	
	public static void main(String[] args) {
        int[] nums1 = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums1));
        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums2));
        int[] nums3 = {2};
        System.out.println(summaryRanges(nums3));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums==null || nums.length==0) return ranges;

        int startIdx =0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]-nums[i-1] != 1) {
                if (startIdx == i - 1) {
                    ranges.add(String.valueOf(nums[startIdx]));
                } else {
                    ranges.add(String.valueOf(nums[startIdx]+ "->"+nums[i - 1]));
                }
                startIdx = i;
            }
        }

        if(startIdx==nums.length-1) ranges.add(String.valueOf(nums[startIdx]));
        else ranges.add(String.valueOf(nums[startIdx]+"->"+nums[nums.length-1]));

        return ranges;
    }
	
}