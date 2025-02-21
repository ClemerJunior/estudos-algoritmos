package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SudokuValidator {

    public static void main(String[] args) {
        char[][] validSudokuBoard =  {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] invalidSudokuBoard = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','5','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

//        System.out.println(isValidSudoku(validSudokuBoard));
        System.out.println(isValidSudoku(invalidSudokuBoard));
        System.out.println(isValidSudoku2(validSudokuBoard));
        System.out.println(isValidSudoku2(invalidSudokuBoard));
    }

    public static boolean isValidSudoku2(char[][] board) {
        List<List<Integer>> rows = new ArrayList<>();
        List<List<Integer>> cols = new ArrayList<>();
        List<List<List<Integer>>> boxes = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int current = 0;
                if (board[i][j] != '.') {
                    current = Integer.parseInt(board[i][j] +"");
                }

                if(rows.size() == i) {
                    rows.add(new ArrayList<>());
                }

                if(cols.size() == j) {
                    cols.add(new ArrayList<>());
                }

                if(boxes.size() == i/3) {
                    boxes.add(new ArrayList<>());
                }

                if(boxes.get(i/3).size() == j/3) {
                    boxes.get(i/3).add(new ArrayList<>());
                }

                if(current != 0 && ((rows.get(i).contains(current)) || (cols.get(j).contains(current))
                        || (boxes.get(i/3).get(j/3).contains(current)))) {
                    return false;
                }
                rows.get(i).add(current);
                cols.get(j).add(current);
                boxes.get(i/3).get(j/3).add(current);
            }
        }

        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '0'; // Convert '1'-'9' to 0-8
                int mask = 1 << num;         // Create bitmask for the number
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number is already set in the row, column, or box
                if ((rows[i] & mask) != 0 || (columns[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                    return false;
                }

                // Mark the number in the row, column, and box
                rows[i] |= mask;
                columns[j] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }
}
