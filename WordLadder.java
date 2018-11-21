// 127. Word Ladder

import java.util.*;

public class WordLadder {

    public void run() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength("hit", "cog", wordList));
        System.out.println("Complete!");
    }

    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return res+1;

                StringBuilder builder = new StringBuilder(word);
                for(int j=0; j<word.length(); j++){
                    char orig = builder.charAt(j);
                    for(char c='a'; c<='z'; c++) {
                        if(c != orig) {
                            builder.setCharAt(j, c);
                            String str = builder.toString();
                            if(set.contains(str)) {
                                queue.add(str);
                                set.remove(str);
                            }
                        }
                    }
                    builder.setCharAt(j, orig);
                }
            }

            res++;
        }

        return 0;
    }

    /* DFS - 超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] res = new int[]{0};
        dfs(beginWord, endWord, new HashSet<>(wordList), new HashSet<>(), 1, res);

        return res[0];
    }

    private void dfs(String beginWord, String endWord, Set<String> wordList, Set<String> visited, int step, int[] res) {
        visited.add(beginWord);
        StringBuilder builder = new StringBuilder(beginWord);
        for(int i=0; i<beginWord.length(); i++) {
            char orig = builder.charAt(i);
            for(char c='a'; c<='z'; c++) {
                builder.setCharAt(i, c);
                String str = builder.toString();
                if(str.equals(endWord) && wordList.contains(str)) res[0] = res[0] == 0 ? step+1 : Math.min(res[0], step+1);

                else if(wordList.contains(str) && !visited.contains(str)) {
                    dfs(str, endWord, wordList, visited, step+1, res);
                }
            }
            builder.setCharAt(i, orig);
        }
        visited.remove(beginWord);
    }
    */

}
