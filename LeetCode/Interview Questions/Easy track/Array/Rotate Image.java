import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n - 1 - 2 * i; j++){
                int x = i, y = i + j, val = matrix[x][y];
                for(int k = 0; k < 4; k++){
                    int new_y = n - 1 - x;
                    int temp = matrix[y][new_y];
                    matrix[y][new_y] = val;
                    val = temp;
                    x = y;
                    y = new_y;
                }
            }
        }
    }
}