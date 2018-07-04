// 553. Optimal Division

public class OptimalDivision {

    public static void main(String[] args) {
        System.out.println(optimalDivision(new int[]{1000,100,10,2}));
        System.out.println(optimalDivision(new int[]{2,3,4}));
        System.out.println(optimalDivision(new int[]{2,4}));
        System.out.println(optimalDivision(new int[]{2}));
    }

    // Math solution
    public static String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]).append('/');
        if(nums.length > 2) builder.append('(');
        for(int i=1; i<nums.length; i++) {
            builder.append(nums[i]).append('/');
        }
        builder.deleteCharAt(builder.length()-1);
        if(nums.length > 2) builder.append(')');

        return builder.toString();
    }

    /* Recursion with memorization
    public static String optimalDivision(int[] nums) {
        Node[][] memory = new Node[nums.length][nums.length];
        Node node = recursion(nums, 0, nums.length-1, memory);
        return node.max_str;
    }

    public static Node recursion(int[] nums, int start, int end, Node[][] memory) {
        if(memory[start][end] != null) return memory[start][end];

        Node node = new Node();
        memory[start][end] = node;

        if(start == end) {
            node.max_value = nums[start];
            node.min_value = nums[start];
            node.max_str = nums[start] + "";
            node.min_str = node.max_str;
            return node;
        }

        node.max_value = Integer.MIN_VALUE;
        node.min_value = Integer.MAX_VALUE;
        node.max_str = node.min_str = "";
        for(int i=start; i<end; i++) {
            Node left = recursion(nums, start, i, memory);
            Node right = recursion(nums, i+1, end, memory);

            // min
            if(left.min_value / right.max_value < node.min_value) {
                node.min_value = left.min_value / right.max_value;
                node.min_str = left.min_str + "/" + (i+1 == end ? "":"(") + right.max_str + (i+1 == end ? "":")") ;
            }
            // max
            if(left.max_value / right.min_value > node.max_value) {
                node.max_value = left.max_value / right.min_value;
                node.max_str = left.max_str + "/" + (i+1 == end ? "":"(") + right.min_str + (i+1 == end ? "":")") ;
            }
        }

        return node;
    }

    static class Node {
        public float max_value, min_value;
        public String max_str, min_str;
    }
    */

}