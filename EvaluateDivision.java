// 399. Evaluate Division

public EvaluateDivision {

    // 先将所有的equation转化成图
    // 比如 a/b = 2
    // 那么就在图中加入2个条目:
    // HashMap<String, HashMap<String, Double>>
    //           a               b       2
    //           b               a       0.5
    //
    // 有了这个图后, 就可以用DFS来找两个点的值
    // 假如A, B
    // 从A开始深度搜索找B, 每走一步, 就需要乘上两个点之间的double值
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        // 构建图
        for(int i=0; i<equations.length; i++) {
        String start = equations[i][0], end = equations[i][1];
        graph.putIfAbsent(start, new HashMap<>());
        graph.putIfAbsent(end, new HashMap<>());

        graph.get(start).put(end, values[i]);
        graph.get(end).put(start, 1/values[i]);
        }

        // 找query对应的值
        double[] res = new double[queries.length];
        for(int i=0; i<res.length; i++) {
        res[i] = dfs(graph, queries[i][0], queries[i][1], new HashSet<>());
        }

        return res;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> graph, String A, String B, HashSet<String> visited) {
        // graph中不包含A, 直接返回-1.0
        if(!graph.containsKey(A)) return -1.0;
        // 找到B了, 返回1.0
        if(A.equals(B)) return 1.0;
        // A访问过了, 并且还没找到B, 说明这条路走不到B, 返回-1.0
        if(visited.contains(A)) return -1.0;

        // 将A加入visited
        visited.add(A);

        // 遍历A能到的点
        for(String key : neighbor.keySet()) {
            if(!visited.contains(key)) {
                double val = neighbor.get(key);
                double ret = dfs(graph, key, B, visited);
                // 能到达B, 返回结果
                if(ret != -1.0)
                    return val * ret;
            }
        }

        // 从A的邻居到不了B, 就返回-1.0
        return -1.0;
    }

}
