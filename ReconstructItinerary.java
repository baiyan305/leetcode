// 332. Reconstruct Itinerary
public class ReconstructItinerary {

    // 最基本的DFS+Backtracking
    // 注意：每个点的邻居存入List中，之前我尝试用PriorityQueue，memory limit exceed
    //
    // 先建立图
    // 然后从JFK开始DFS，直到找到一个合法的路径，什么路径算合法呢
    // 一共有tickets.length条边，所有一共有tickets.length+1个点
    // 所以如果path.size() == tickets.length+1, 就是合法的路径了，直接返回了就行
    public List<String> findItinerary(String[][] tickets) {
        List<String> route = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<tickets.length; i++) {
            String start = tickets[i][0], end = tickets[i][1];
            if(!map.containsKey(start))
                map.put(start, new ArrayList<>());
            map.get(start).add(end);
        }

        // 将每个点的邻居，从小到大排序
        // 因为这道题需要返回lexical order最小的
        // 所以对于每个点，先走lexical order最小的邻居
        // 如果是正确的路径，就直接返回
        for(String key : map.keySet())
            Collections.sort(map.get(key));

        route.add("JFK");
        dfs(map, route, "JFK", tickets.length+1);

        return route;
    }

    private boolean dfs(HashMap<String, List<String>> map, List<String> path, String start, int len) {
        // 如果当前路径包含了所有的点，就直接返回了
        if(path.size() == len)
            return true;
        // 走到了死路，并且还没有完全走完所有的路径，那么是非法路径
        if(!map.containsKey(start))
            return false;

        // 遍历所有的邻居，尝试所有的路径
        List<String> dests = map.get(start);
        for(int i=0; i<dests.size(); i++) {
            // 拿出一个邻居
            String dest = dests.get(i);
            // 将邻居加到路径中
            path.add(dest);
            // 从图中移除
            dests.remove(i);
            // dfs继续走
            if(dfs(map, path, dest, len))
                return true;
            // 如果路径是非法的，将之前加入的邻居从path中移除掉
            path.remove(path.size()-1);
            // 将邻居加回到图中
            dests.add(i, dest);
        }

        // 从start开始的所有路径都不合法，那么返回false，并返回上一层继续DFS
        return false;
    }

}
    /* 欧拉解法
    如果存在一个合法的路径，那么构建图后，图中只可能有一条死路，其它所有的路径会构成一个环
    如果存在两条或以上的死路，那么是非法的，一次不可能全部走完

    基于以上的假设，我们可以做DFS, 有两种情况:
    1. 先遇到了死路，之后再回到环上，这种情况，就是将遍历的结点，倒序加入结果path中，因为
    合法的走的顺序，是先走完环，再走死路

    2. 先走完环，再走到死路，就是递归一层一层的，最后一层是死路，所以也是倒序加入结果中

    看下面这个例子:
    {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}


          --> KUL

     JFK  --> NRT
          <--

    JFK和NRT形成了环，JFK到KUL是死路，所以实际的走法是先走环，再走KUL这条死路

    但是遍历的时候，可能先遍历到KUL这条死路，再遍历环
        -- 这种情况下，KUL是第一个被加入结果集的
    也可能是先遍历环，再遍历死路
        -- 这种情况下，KUL也是第一个被加入结果集的

    所以我们是倒序加入结果集的

    public List<String> findItinerary(String[][] tickets) {
        List<String> route = new ArrayList<>();

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(int i=0; i<tickets.length; i++) {
            String start = tickets[i][0], end = tickets[i][1];
            if(!map.containsKey(start))
                map.put(start, new PriorityQueue<>());
            map.get(start).add(end);
        }

        dfs(map, route, "JFK");
        return route;
    }

    private void dfs(HashMap<String, PriorityQueue<String>> map, List<String> route, String start) {
        while(map.containsKey(start) && !map.get(start).isEmpty()) {
            String dest = map.get(start).poll();
            dfs(map, route, dest);
        }

        route.add(0, start);
    }
    */
