// 635. Design Log Storage System

import yan.bai.Main;

import java.util.*;

public class DesignLogStorageSystem {

    public static void main(String[] args) {
        Main.LogSystem obj = new Main.LogSystem();
        obj.put(1, "2017:01:01:23:59:59");
        obj.put(2, "2017:01:01:22:59:59");
        obj.put(3, "2016:01:01:00:00:00");
        System.out.println(obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"));
        System.out.println(obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"));
    }

    static class LogSystem {
        String minStamp, maxStamp;
        HashMap<String, Integer> map;
        TreeMap<String, LinkedList<Integer>> logs;

        public LogSystem() {
            minStamp = "2000:01:01:00:00:00";
            maxStamp = "2017:12:31:23:59:59";
            map = new HashMap<>();
            map.put("Year", 4);
            map.put("Month", 7);
            map.put("Day", 10);
            map.put("Hour", 13);
            map.put("Minute", 16);
            map.put("Second", 19);
            logs = new TreeMap<>();
        }

        public void put(int id, String timestamp) {
            if(!logs.containsKey(timestamp)) logs.put(timestamp, new LinkedList<>());
            logs.get(timestamp).add(id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            List<Integer> ret = new LinkedList<>();

            String start = s.substring(0, map.get(gra)) + (gra.equals("Second") ? "" : minStamp.substring(map.get(gra)));
            String end = e.substring(0, map.get(gra)) + (gra.equals("Second") ? "" : maxStamp.substring(map.get(gra)));
            Map<String, LinkedList<Integer>> sorted = logs.subMap(start, true, end, true);
            for(LinkedList<Integer> ids : sorted.values()) {
                ret.addAll(ids);
            }

            return ret;
        }
    }

}
