import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        boolean [][] board = new boolean[8][8];
        System.out.println("before:\n"+Arrays.deepToString(board).replace("], ", "]\n"));
        solve(board,0);
        System.out.println("after:\n"+Arrays.deepToString(board).replace("], ", "]\n"));

        //System.out.println(Arrays.deepToString(board));
    }

    public static boolean solve(boolean [][] board, int pos){
        //this program will take in the input of the size of the board
        // and the initial position for the queen.

        //base case boolean
        //if the program finishes return true;
        if (pos == board.length){
            return true;
        }
        if (pos > board.length){
            System.out.println("out of bounds");
            return true;
        }

        //this for loop will check
        for (int i = 0; i < board.length; i++) {
            if (valid(board, pos, i)){
                board[pos][i] = true;
                if (solve(board,pos+1)){
                    return true;
                } else{
                    board[pos][i] = false;
                }
            }
        }
        return false;
    }

    public static boolean valid(boolean [][] board, int row, int col){
        //this wil check all the horizontal and vertical
        //we are going to assume the size of all chess board is 8x8
        //board.length is 8

        //this will check the horizontal and the vertical queens
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == true){
                return false;
            }
            if (board[i][col] == true){
                return false;
            }
        }

        //finding the min and max between two numbers
        int lowestValue = Math.min(row, col);
        int maxValue = Math.max(row, col);

        //checking the all diagonals
        for (int i = -lowestValue; i + maxValue < board.length ; i++) {
            if(board[row + i][col + i] == true){
                return false;
            }
        }
        for (int i = 0; (row + i < board.length) && (col - i >= 0); i++) {
            if(board[row + i][col - i] == true){
                return false;
            }
        }
        for (int i = 0; (col + i < board.length) && (row - i >= 0); i++) {
            if(board[row - i][col + i] == true){
                return false;
            }
        }
        return true;
    }




    /*
    boolean solve(board, pos) {
        if (//pos is such that there is nothing left to solve
        ) {
            return true;
        }

        for (:)//each possible choice
        {
            if (valid(choice)) {
                mark board at pos with choice;
                if (solve(board, pos + 1) == true) {
                    return true;
                }
            }
        }
        //clear any choices entered at pos on board;

        return false;//backtrack
    }

     */
}
