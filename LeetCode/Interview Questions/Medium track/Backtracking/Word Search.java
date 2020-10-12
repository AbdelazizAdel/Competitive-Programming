class Solution {
    boolean flag, visited[][];
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    dfs(i, j, 1, board, word);
                    visited[i][j] = false;
                }
                    
                if(flag)
                    return true;
            }
        return false;
    }
    
    public void dfs(int i, int j, int idx, char[][] board, String word) {
        if(idx == word.length()) {
            flag = true;
            return;
        }
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            if(flag)
                return;
            int x = i + dx[k], y = j + dy[k];
            if(isValid(x, y, board) && !visited[x][y] && board[x][y] == word.charAt(idx)) {
                dfs(x, y, idx + 1, board, word);
                visited[x][y] = false;
            }
        }
    }
    
    public boolean isValid(int x, int y, char[][] board) {
        int n = board.length, m = board[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}