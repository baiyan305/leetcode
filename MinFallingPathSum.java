public class MinFallingPathSum {
    public void minFallingPathSum(List<List<Integer>> matrix) {
        List<Path> prev = new ArrayList<>();

        for(int y = matrix.size()-1; y>=0; y--) {
            List<Path> cur = new ArrayList<>();
            for(int x=0; x<matrix.get(y).size(); x++) {
                Path path = new Path(0, new ArrayList<>());
                for(int i=-1; i<2; i++) {
                    if(x+i>=0 && y+1<matrix.size()) {
                        if(path.path.size() == 0 || path.sum > prev.get(x+i).sum) {
                            path.sum = prev.get(x+i).sum;
                            path.path = new ArrayList(prev.get(x+i).path);
                        }
                    }
                }
                path.sum += matrix.get(y).get(x);
                path.path.add(matrix.get(y).get(x));
                cur.add(path);
            }

            prev = cur;
        }

        System.out.println(prev.get(0).sum);
        System.out.println(prev.get(0).path);
    }

    class Path{
        int sum;
        List<Integer> path;

        Path(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }
    }
}