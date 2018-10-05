// 287. Find the Duplicate Number

public class FindTheDuplicateNumber {

    public void run() {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{1,1}));
        System.out.println(findDuplicate(new int[]{1,1,2}));
        System.out.println(findDuplicate(new int[]{1,2,2}));

        System.out.println("123");
    }

    // 链表有环法
    // 比如 {1,2,3,4,5,6,7,5}, 转换成链表的话, 1 -> 2 -> 3 -> 4 -> 5 -> 6 ->7 |
    //                                                           ^          |
    //                                                           | <-   <-  |
    // 这个问题就转化为，有环链表找环的起始点
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do{
            slow = nums[slow];
            fast= nums[nums[fast]];
        } while(slow != fast);

        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast= nums[fast];
        }

        return slow;
    }

    // 二分法
    // 比如对于 {1,3,4,2,5,2}
    // 我们对于 {1,2,3,4,5} 进行二分搜索
    // 首先 mid = 3, 然后扫描 {1,3,4,2,5,2}, 统计有多少个小于等于3的数字。结果是4,那么说明1,2,3中一定有数字是重复的。
    // 因为如果 1,2,3没有重复，那么小于等于3的数字个数，应该是3。
    // 所以答案一定是在 mid(3) 左边，包含mid。
    // 否则答案在 mid 右边，不包含mid。
    /*
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2, count = 0;
            for(int num : nums) if(num <= mid) count++;

            if(count <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    */

}