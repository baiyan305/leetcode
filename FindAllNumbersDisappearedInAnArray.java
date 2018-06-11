// 448. Find All Numbers Disappeared in an Array

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) nums[idx] = - nums[idx];
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) list.add(i+1);
        }

        return list;
    }

}