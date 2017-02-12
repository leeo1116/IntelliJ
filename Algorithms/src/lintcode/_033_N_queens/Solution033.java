package lintcode._033_N_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Charlie on 2016/11/19. Saturday
 */
public class Solution033 {
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<String> board = new ArrayList<String>();
        // Initialize board with period
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++)
                row += ".";
            board.add(row);
        }
        return solveNQueensHelper(board, 0, n);
    }

    private ArrayList<ArrayList<String>> solveNQueensHelper(ArrayList<String> board, int row, int n) {
        ArrayList<ArrayList<String>> validBoards = new ArrayList<ArrayList<String>>();
        if (row == n) {
            validBoards.add(board);
            return validBoards;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                char[] newRow = board.get(row).toCharArray();
                newRow[col] = 'Q';
                board.set(row, String.valueOf(newRow));
                validBoards.addAll(solveNQueensHelper(new ArrayList<>(board), row+1, n));
                newRow[col] = '.';
                board.set(row, String.valueOf(newRow));
            }
        }
        return validBoards;
    }

    private boolean isValid(ArrayList<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        for (int i = row-1, j = col+1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

}
