class Solution {
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int n, m;
        
    public int numIslands(char[][] grid) {
        n = grid.length;
        if(n == 0)
            return 0;
        m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
        return count;
    }
    
    public static void dfs(int i, int j, char[][] grid) {
        visited[i][j] = true;
        for(int idx = 0; idx < 4; idx++) {
            int x = i + dx[idx], y = j + dy[idx];
            if(isValid(x, y, grid) && !visited[x][y])
                dfs(x, y, grid);
        }
    }
    
    public static boolean isValid(int i , int j, char[][] grid) {
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == '1'; 
    }
}