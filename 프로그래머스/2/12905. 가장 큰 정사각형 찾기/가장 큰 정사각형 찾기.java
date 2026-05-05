class Solution{
    
    static int[][] drc = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int solution(int[][] board){
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length;
        
        if (row < 2 || col < 2) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board[r][c] == 1) return 1;
                }
            }
            
            return 0;
        }
        
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (board[r][c] == 1) {
                    board[r][c] = Math.min(board[r-1][c-1], Math.min(board[r][c-1], board[r-1][c])) + 1;
                    answer = Math.max(board[r][c], answer);
                }
            }
        }
        
        return (int) Math.pow(answer, 2);
    }
    
}