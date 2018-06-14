// 565. Array Nesting

public class Main {

    public static void main(String[] args) {
        //int[] nums = {5,4,0,3,1,6,2};
        int[] nums = {0,2,1};
        System.out.println(arrayNesting(nums));
    }

    // Recursion
    public static int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, dfs(nums, visited, i));
        }

        return max;
    }

    private static int dfs(int[] nums, boolean[] visited, int idx) {
        if(visited[idx]) return 0;

        visited[idx] = true;
        return 1+dfs(nums, visited, nums[idx]);
    }

    /*
    O(n) time, no extra space
    public static int arrayNesting(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == -1) continue;

            int next = i, len = 0;
            while(nums[next] != -1) {
                int tmp = next;
                next = nums[next];
                nums[tmp] = -1;
                len++;
            }

            max = Math.max(max, len);
        }

        return max;
    }

    O(n) time, O(n) space
    public static int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        int max = 0;
        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;

            int idx = i, len = 0;
            while(!visited[idx]) {
                visited[idx] = true;
                idx = nums[idx];
                len++;
            }

            max = Math.max(max, len);
        }

        return max;
    }
    */
}