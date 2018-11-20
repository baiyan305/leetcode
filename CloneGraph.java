// 133. Clone Graph

public class CloneGraph {
	
	    public void run() {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        UndirectedGraphNode cloned = cloneGraph(node0);

        System.out.println("123");
    }

    // DFS - 2 ms
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        return clone(node, new HashMap<>());
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label, cloned);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            if(map.containsKey(neighbor.label)) cloned.neighbors.add(map.get(neighbor.label));
            else cloned.neighbors.add(clone(neighbor, map));
        }

        return cloned;
    }

    /* BFS - 5 ms
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        UndirectedGraphNode res = null;

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            // copy node
            UndirectedGraphNode orig = queue.poll(), copy = null;
            if(map.containsKey(orig.label)) copy = map.get(orig.label);
            else {
                copy = new UndirectedGraphNode(orig.label);
                map.put(orig.label, copy);
            }

            if(res == null) res = copy;

            // handle neighbors
            for(UndirectedGraphNode neighbor : orig.neighbors) {
                if(map.containsKey(neighbor.label)) copy.neighbors.add(map.get(neighbor.label));
                else {
                    UndirectedGraphNode copyNeighbor = new UndirectedGraphNode(neighbor.label);
                    copy.neighbors.add(copyNeighbor);
                    map.put(neighbor.label, copyNeighbor);
                    queue.offer(neighbor);
                }

            }
        }

        return res;
    }
    */

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };
	
}