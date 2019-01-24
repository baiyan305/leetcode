// 916. Word Subsets

public WordSubsets {
	
	// A = ["amazon","apple","facebook","google","leetcode"], B = ["cec","oc","ceo"]
	//
	// 这个题要求出A中的哪个词是universal，universal的意思是
	// B中的每个词都是subset
	//
	// 这个解法比较朴素的解法是 N 平方
	// 
	// 先拿出amazon, 然后和B中的词相比，看是否是subset
	// 对A中的每个词都重复这个过程，所以是 N 平方
	//
	// 还有一种更优化的解法是, 先处理B中的词
	// 对于B中的每个词, 算出每个字母出现的次数, 然后对每个字母，取出出现次数最高的
	// 比如对于c, 在第一个单词中出现2次, 第二个单词出现1次，第三个单词中出现1次，所以c就是2次
	// 因为是否是universal是需要B中的每个单词都是A[i]的subset, 所以可以将B中的所有单词看成一个集合
	
	public List<String> wordSubsets(String[] A, String[] B) {
        int[] dict = new int[26];
        
        for(String b : B) {
            int[] count = count(b);
            for(int i=0; i<26; i++)
                dict[i] = Math.max(dict[i], count[i]);
        }
        
        List<String> res = new ArrayList<>();
        for(String a : A) {
            int[] count = count(a);
            
            boolean valid = true;
            for(int i=0; i<26; i++) {
                if(count[i] < dict[i]) {
                    valid = false;
                    break;
                }
            }
            
           if(valid) 
               res.add(a);
        }
        
        return res;
    }
    
    private int[] count(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray())
            count[c-'a']++;
        return count;
    }
	
}