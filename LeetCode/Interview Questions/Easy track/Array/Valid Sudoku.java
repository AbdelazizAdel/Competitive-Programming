class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++){
            boolean[] seen = new boolean[10];
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                if(seen[Integer.parseInt(board[i][j] + "")])
                    return false;
                seen[Integer.parseInt(board[i][j] + "")] = true;
            }
        }
        
        for(int i = 0; i < 9; i++){
            boolean[] seen = new boolean[10];
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.')
                    continue;
                if(seen[Integer.parseInt(board[j][i] + "")])
                    return false;
                seen[Integer.parseInt(board[j][i] + "")] = true;
            }
        }
        
        for(int i = 0; i < 9; i+=3)
            for(int j = 0; j < 9; j+=3)
                if(!subMatrix(i, j, board))
                    return false;
        return true;
    }
    
    public static boolean subMatrix(int xs, int ys, char[][] board){
        boolean[] seen = new boolean[10];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                if(board[xs + i][ys + j] == '.')
                    continue;
                if(seen[Integer.parseInt(board[xs + i][ys + j] + "")])
                    return false;
                seen[Integer.parseInt(board[xs + i][ys + j] + "")] = true;
            }
        return true;
    }
    
}