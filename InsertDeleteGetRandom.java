// 380. Insert Delete GetRandom O(1)

// 设计一个数据结构
// insert, remove, getRandom都是O(1)
// 首先insert(val), val存储在ArrayList中，然后用HashMap存储val在ArrayList中的位置，HashMap key是val，value是在ArrayList中的index
// remove(val), 直接从ArrayList中移除，复杂度是O(n)。正确做法是，将需要移除的val与ArrayList中的最后一个元素交换位置，然后删除最有一个
// getRandom, 就直接从ArrayList中随机返回一个

public class InsertDeleteGetRandom{
	
	HashMap<Integer, Integer> map;
    List<Integer> list;
    private Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int idx = map.get(val), lastVal = list.get(list.size()-1);
        list.set(idx, lastVal);
        list.remove(list.size()-1);
        map.put(lastVal, idx);
        map.remove(val);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
	
}