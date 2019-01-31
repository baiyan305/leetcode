// 785. Is Graph Bipartite?

public class IsGraphBipartite {

    // 这道题是遍历整个图结构, 给每个结点上颜色
    // 比如先从0开始, 0给白色, 0的邻居上黑色
    // 如果发现有两个联通的点，比如A B颜色相同，连接A B的边叫C
    // 题目的意思是C的两个点，A和B，在不同的集合中，但是A B颜色相同，就是在一个集合中
    // 那么就违反了题意，返回false
    public boolean isBipartite(int[][] graph) {
        // 0 - 未访问
        // 1 - 白
        // 2 - 黑
        int[] visited = new int[graph.length];

        // 对于每一个结点，做BFS.
        // 注意输入可能是有多个图的情况
        // 比如0, 1, 2, 3,4结点是一个联通图
        // 然后5, 6, 7, 8是一个联通图
        // 我们并不知道应该以哪个结点作为起点，所以就要从每个点都开始走一遍
        for(int i=0; i<visited.length; i++) {
            // i结点没有访问过，并且有邻居
            // 可能有的结点是单独的，没有和任何其它点联通
            if(graph[i].length != 0 && visited[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = 1;

                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int neighbor : graph[node]) {
                        // 邻居结点没有访问过，加到queue中，颜色设置为和node相反的颜色
                        if(visited[neighbor] == 0){
                            queue.add(neighbor);
                            visited[neighbor] = visited[node] == 1 ? 2 : 1;
                        } else {
                            if(visited[neighbor] == visited[node])
                                return false;
                        }
                    }
                }
            }
        }

        return true;
    }

}
