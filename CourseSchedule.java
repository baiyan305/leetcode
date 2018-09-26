// 207. Course Schedule

public class CourseSchedule {
	
	public void run() {
        int[][] arr = {
                {1,0}
        };

        System.out.println(canFinish(2, arr));
    }

	//拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre : prerequisites) {
            int course = pre[0], dependency = pre[1];
            inDegree[dependency]++;
            if(!map.containsKey(course)) map.put(course, new ArrayList<>());
            map.get(course).add(dependency);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int visited = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            visited++;
            if(map.containsKey(course)) {
                for(int dep : map.get(course)) {
                    inDegree[dep]--;
                    if(inDegree[dep] == 0) queue.offer(dep);
                }
            }
        }

        return visited == numCourses;
    }
	
	/*DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> dependencies = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            if(!dependencies.containsKey(course)) dependencies.put(course, new ArrayList<>());
            dependencies.get(course).add(prerequisite[1]);
        }

        int[] canFinish = new int[numCourses];
        for(int course : dependencies.keySet()) {
            if(!canFinishDFS(course, dependencies, canFinish)) return false;
        }

        return true;
    }

    private boolean canFinishDFS(int course, HashMap<Integer, List<Integer>> map, int[] canFinish) {
        if(canFinish[course] == -1) return false;
        if(canFinish[course] == 1) return true;

        canFinish[course] = -1;
        if(map.containsKey(course)) {
            List<Integer> deps = map.get(course);
            for(int dep : deps) if(!canFinishDFS(dep, map, canFinish)) return false;
        }
        canFinish[course] = 1;

        return true;
    }
	*/
	
}