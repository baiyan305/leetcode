public class KSortedArraysIterator {
    int[][] arrays;

    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] a, int[] b) {
            return arrays[a[0]][a[1]] - arrays[b[0]][b[1]];
        }
    });

    public KSortedArraysIterator(int[][] arrays) {
        if(arrays == null)
            return;
        this.arrays = arrays;
        for(int i=0; i<arrays.length; i++)
            if(arrays[i] != null && arrays[i].length > 0)
                queue.add(new int[]{i, 0});
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public int next() {
        int[] smallest = queue.poll();
        int y = smallest[0], x = smallest[1], val = arrays[y][x];
        if(x+1 < arrays[y].length)
            queue.add(new int[]{y,x+1});

        return val;
    }
}