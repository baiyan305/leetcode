// 244. Shortest Word Distance II

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {

    public void run() {
        WordDistance wd = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(wd.shortest("coding","practice"));
        System.out.println(wd.shortest("makes","coding"));
    }

    class WordDistance {
        HashMap<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for(int i=0; i<words.length; i++) {
                String word = words[i];
                if(!map.containsKey(word)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(word, list);
                } else {
                    map.get(word).add(i);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1), list2 = map.get(word2);
            int i = 0, j = 0, distance = -1;
            while(i<list1.size() && j<list2.size()) {
                int idx1 = list1.get(i), idx2 = list2.get(j);
                if(idx1 < idx2) {
                    distance = distance == -1 ? idx2-idx1:Math.min(distance, idx2-idx1);
                    i++;
                }
                else if(idx1 > idx2){
                    distance = distance == -1 ? idx1-idx2:Math.min(distance, idx1-idx2);
                    j++;
                }
                else {
                    return 0;
                }
            }

            return distance;
        }
    }

}