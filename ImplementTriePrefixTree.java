// 208. Implement Trie (Prefix Tree)

public class ImplementTriePrefixTree {
	
	public void run() {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }
    
    class Trie {
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;

            for(int i=0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.leaves[idx] == null) node.leaves[idx] = new TrieNode();
                if(i == word.length()-1) node.leaves[idx].word = true;

                node = node.leaves[idx];
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;

            for(int i=0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';

                if(node.leaves[idx] == null || (i == word.length()-1 && node.leaves[idx].word == false) ) return false;

                node = node.leaves[idx];
            }

            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;

            for(int i=0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';

                if(node.leaves[idx] == null) return false;

                node = node.leaves[idx];
            }

            return true;
        }

        class TrieNode {
            boolean word;
            TrieNode[] leaves;

            TrieNode() {
                this.word = false;
                this.leaves = new TrieNode[26];
            }
        }
    }
	
}