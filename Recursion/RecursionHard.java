import java.util.*;

public class RecursionHard {
    public static void main(String[] args) {
        int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        int n = 4;
        List<List<String>> ans = nQueensSolver(n);
        for(List<String> list: ans){
            System.out.println(list);
        }
    }
    public static List<List<String>> nQueensSolver(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        nQueensSolver(board, 0, ans);
        return ans;
    }

    public static void nQueensSolver(boolean[][] board, int row, List<List<String>> ans) {
        if(row == board.length){
            addToAnsString(board, ans);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafeQ(board, row, col)){
                board[row][col] = true;
                nQueensSolver(board, row+1, ans);
                board[row][col] = false;
            }
        }
    }

    public static boolean isSafeQ(boolean[][] board, int row, int col){
        for(int i = row-1;i>=0;i--){
            if(board[i][col]){
                return false;
            }
        }
        for(int i=row, j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        for(int i=row, j=col;i>=0&&j<board.length;i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }

    private static void addToAnsString(boolean[][] board, List<List<String>> ans){

        List<String> list = new ArrayList<>();
        for (boolean[] booleans : board) {
            StringBuilder currAns = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (booleans[j]) {
                    currAns.append('Q');
                } else {
                    currAns.append('.');
                }
            }
            list.add(currAns.toString());
        }
        ans.add(list);
    }

}
