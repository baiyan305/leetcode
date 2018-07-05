// 527. Word Abbreviation

import java.util.*;

public class WordAbbreviation {

    public static void main(String[] args) {
        String[] words = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        System.out.println(wordsAbbreviation(Arrays.asList(words)));
    }

    public static List<String> wordsAbbreviation(List<String> dict) {
        String[] ret = new String[dict.size()];

        // key is abbreviation and value is a list contains index of corresponding strings in 'dict'
        HashMap<String, Integer> words = new HashMap<>();
        for(int i=0; i<dict.size(); i++) words.put(dict.get(i), i);

        HashMap<String, List<String>> abbreviations = new HashMap<>();
        int prefix = 0;
        do{
            shortenAllWords(words, abbreviations, prefix);
            Iterator<Map.Entry<String,List<String>>> iter = abbreviations.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry<String,List<String>> entry = iter.next();
                String abbre = entry.getKey();
                List<String> list = entry.getValue();
                if(list.size() == 1){
                    String word = list.get(0);
                    ret[words.get(word)] = abbre;
                    // remove the word from 'words' map
                    words.remove(word);
                }
            }

            prefix++;
        }while(abbreviations.size() > 0);

        // return ret
        return Arrays.asList(ret);
    }

    private static void shortenAllWords(HashMap<String, Integer> words , HashMap<String, List<String>> abbreviations, int prefix) {
        abbreviations.clear();
        for(String word : words.keySet()) {
            String abbre = shortenSingleWord(word, prefix);
            if(!abbreviations.containsKey(abbre)) abbreviations.put(abbre, new ArrayList<>());
            abbreviations.get(abbre).add(word);
        }
    }

    private static String shortenSingleWord(String str, int prefix) {
        if(str.length() < 4 || prefix >= str.length()-3) return str;

        String abbreviation = str.substring(0, prefix+1);
        abbreviation += str.length()-prefix-2;
        abbreviation += str.charAt(str.length()-1);

        return abbreviation;
    }

}