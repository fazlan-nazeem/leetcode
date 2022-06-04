public class MaxAreaOfLand {

    int[][] grid;
    boolean[][] visited;
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {

        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        int maxArea = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(i,j));
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j) {

        if(i >= rows || i < 0 || j < 0 || j >= cols) {
            return 0;
        }
        if(grid[i][j] == 0) {
            return 0;
        }
        if(visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs( i -1, j) + dfs(i, j + 1) + dfs(i, j-1);
    }
}

// time-complexity = O(n*m)
// space-complexity = O(n*m)