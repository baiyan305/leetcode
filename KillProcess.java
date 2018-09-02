// 582. Kill Process

import java.util.*;

public class KillProcess {
	
	public void run() {
        Integer[] pid = {1, 3, 10, 5};
        Integer[] ppid = {3, 0, 5, 3};

        System.out.println(killProcess(Arrays.asList(pid), Arrays.asList(ppid), 5));
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<ppid.size(); i++){
            int parentId = ppid.get(i);
            if(!map.containsKey(parentId)) map.put(parentId, new ArrayList<>());
            map.get(parentId).add(pid.get(i));
        }

        List<Integer> list = new ArrayList<>();
        recursion(map, kill, list);
        return list;
    }

    private void recursion(HashMap<Integer, List<Integer>> map, int kill, List<Integer> list) {
        list.add(kill);
        if(!map.containsKey(kill)) return;
        for(int child : map.get(kill)) recursion(map, child, list);
    }
	
}