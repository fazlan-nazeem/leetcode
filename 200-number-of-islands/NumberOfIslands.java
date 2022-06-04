public class NumberOfIslands {

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
                    dfs(i,j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    void dfs(int i, int j) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}

// time-complexity = O(n * m)
// space-complexity = O(n * m)
