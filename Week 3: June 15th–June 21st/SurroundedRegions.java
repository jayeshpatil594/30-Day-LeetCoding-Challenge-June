class Solution {
    public void solve(char[][] board) {
        //Time: O(rows * cols) Space:O(rows * cols)
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        if (board.length < 2 || board[0].length < 2){
            return;
        }
        int rows = board.length, cols = board[0].length;
        //first and last column
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][cols - 1] == 'O'){
                dfs(board, i, cols - 1);
            }
        }
        //first and last row
         for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j);
            }
            if(board[rows - 1][j] == 'O'){
                dfs(board, rows - 1, j);
            }
        }
        //flip all 'O' to 'X'
        //restore '#' to 'O'
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    //dfs method to check the boundary and boundary surroudings of 'O'
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        if(board[i][j] == 'O'){
            //change 'O' to '#'
            board[i][j] = '#';
        }
        if(i > 1 && board[i - 1][j] == 'O') dfs(board, i - 1, j);
            
        if(i + 1 < board.length - 1 && board[i + 1][j] == 'O') dfs(board, i + 1, j);
            
        if(j > 1 && board[i][j - 1] == 'O') dfs(board, i, j - 1);
            
        if(j + 1 < board[i].length - 1 && board[i][j + 1] == 'O') dfs(board, i, j + 1);   
    }
}

