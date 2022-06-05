import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands3 {
    char[][] grid;
    int rows;
    int cols;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int numOfIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i,j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    // bfs using queue
    void bfs(int i, int j) {

        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> item = new ArrayList<>();
        item.add(i);
        item.add(j);
        queue.offer(item);
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            List<Integer> node = queue.poll();
            int row = node.get(0);
            int col = node.get(1);
            for(int k =0; k < directions.length; k++) {
                int[] nNode = directions[k];
                int newRow = row + nNode[0];
                int newCol = col + nNode[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                    List<Integer> newNode = new ArrayList<>();
                    newNode.add(newRow);
                    newNode.add(newCol);
                    queue.offer(newNode);
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}

// time-complexity = O(n*m)
// space-complexity = O(n*m)