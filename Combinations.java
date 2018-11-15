// 77. Combinations

public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), n, 1, k);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int n, int start, int k) {
        if(k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; n-i+1>=k; i++) {
            list.add(i);
            backtracking(res, list, n, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
	
}