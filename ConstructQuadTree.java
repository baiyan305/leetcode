// 427. Construct Quad Tree

public class ConstructQuadTree {

    // 这道题是将一个二维矩阵转换为QuadTree
    //
    // 每个QuadTree Node包含4个部分，左上，左下，右上，右下
    //
    // 如果初始的矩阵，所有的元素值不同，比如有0，有1，那么就需要将矩阵分割成4个部分
    // 之后对于分割后的4个矩阵继续递归处理，直到有子矩阵的所有元素都相同，就是子结点了
    public Node construct(int[][] grid) {
        return recursion(grid, 0, 0, grid.length);
    }

    // Y, X是左上元素坐标，side是边长
    private Node recursion(int[][] grid, int Y, int X, int side) {
        if(side == 0)
            return null;

        // 将矩阵的每个元素与左上元素左比较，如果有任何一个元素与左上元素不同
        // 那么当前矩阵就不是叶结点，需要分割
        for(int y=Y; y<Y+side; y++) {
            for(int x=X; x<X+side; x++) {
                if(grid[y][x] != grid[Y][X]) {
                    return new Node(false, false,
                            recursion(grid, Y, X, side/2),
                            recursion(grid, Y, X+side/2, side/2),
                            recursion(grid, Y+side/2, X, side/2),
                            recursion(grid, Y+side/2, X+side/2, side/2)
                    );
                }
            }
        }

        return new Node(grid[Y][X]==1, true, null, null, null, null);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
}
