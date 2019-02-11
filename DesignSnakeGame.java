// 353. Design Snake Game

class SnakeGame {

    int[][] food;
    LinkedList<int[]> queue;
    Set<Integer> set;
    int foodIdx = 0, score = 0, height, width;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;

        // copy food
        this.food = food;

        // add initial position
        queue = new LinkedList<>();
        queue.add(new int[2]);

        set = new HashSet<>();
        set.add(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int y = queue.peek()[0], x = queue.peek()[1];
        if(direction.equals("U")) y--;
        else if(direction.equals("D")) y++;
        else if(direction.equals("L"))x--;
        else if(direction.equals("R")) x++;

        // 检查新的位置是否出界了
        // return -1
        if( y<0 || x<0 || y>=height || x>=width) return -1;

        // 检查新的位置是否是food
        // 更新head, 新位置加入set, tail不用删
        if(foodIdx<food.length && y == food[foodIdx][0] && x == food[foodIdx][1]){
            queue.addFirst(new int[]{y,x});
            set.add(y*width+x);

            score++;
            foodIdx++;

            return score;
        }

        // 新的位置是空白
        // queue和set中删除tail
        int[] tail = queue.removeLast();
        set.remove(tail[0]*width+tail[1]);

        // 查看是否吃了自己
        if(set.contains(y*width+x)) return -1;

        // 新的head加入queue和set中
        queue.addFirst(new int[]{y,x});
        set.add(y*width+x);

        return score;
    }
}