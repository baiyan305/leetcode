// 679. 24 Game

public class 24Game {

    public void run() {
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(judgePoint24(new int[]{1, 2, 1, 2}));
        System.out.println(judgePoint24(new int[]{1, 3, 4, 6}));
        System.out.println("123");
    }

    // 最基本的DFS, 就是遍历所有情况
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int num : nums)
        list.add((double)num);

        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        // 只剩下一个元素了, 检查这个元素是否满足条件
        // 注意的是, 最后的结果是有误差的
        if(list.size() == 1) {
        return Math.abs(list.get(0) - 24.0) <= 0.001;
        }

        // 从list中选2个数字list[i], list[j]
        for(int i=0; i<list.size(); i++) {
        for(int j=0; j<list.size(); j++) {
        if(i == j) continue;

        List<Double> nums = new ArrayList<>();
        // 将list[i], list[j]之外的数字加入到nums中
        for(int k=0; k<list.size(); k++)
        if(k != i && k != j)
        nums.add(list.get(k));

        // 将list[i], list[j]做加减乘除后加入到nums中
        for(int k=0; k<4; k++) {
        if(k==0) {
        nums.add(list.get(i)+list.get(j));
        } else if(k==1) {
        nums.add(list.get(i)-list.get(j));
        } else if(k==2) {
        nums.add(list.get(i)*list.get(j));
        } else if(k==3){
        if(list.get(j) != 0)
        nums.add(list.get(i)/list.get(j));
        else
        continue;
        }

        // 将新的数字组合继续做DFS
        // 如果有合法的, 就直接返回true
        if(dfs(nums))
        return true;
        // 将前面的加减乘除从nums中移除
        nums.remove(nums.size()-1);
        }
        }
        }

        // 所有的情况都不能到达24, 就返回false
        return false;
    }

}
