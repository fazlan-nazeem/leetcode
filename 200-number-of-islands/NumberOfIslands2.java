import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

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
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    // iterative dfs using explicit stack
    void dfs(int i, int j) {

        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        List<Integer> item = new ArrayList<>();
        item.add(i);
        item.add(j);
        stack.push(item);
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!stack.isEmpty()) {
            List<Integer> node = stack.pop();
            int row = node.get(0);
            int col = node.get(1);
            visited[row][col] = true;
            for (int k = 0; k < directions.length; k++) {
                int[] nNode = directions[k];
                int newRow = row + nNode[0];
                int newCol = col + nNode[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] &&
                        grid[newRow][newCol] == '1') {
                    List<Integer> newNode = new ArrayList<>();
                    newNode.add(newRow);
                    newNode.add(newCol);
                    stack.push(newNode);
                }
            }
        }
    }
}

// time-complexity = O(n*m)
// space-complexity = O(n*m)