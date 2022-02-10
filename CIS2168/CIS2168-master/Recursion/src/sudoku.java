import java.util.Arrays;
//https://stackoverflow.com/questions/1697334/algorithm-for-solving-sudoku
//https://codepumpkin.com/sudoku-solver-using-backtracking/
public class sudoku {
    public static void main(String[] args) {
        int[][] board =
                {{0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}};
        System.out.println("before:\n"+ Arrays.deepToString(board).replace("], ", "]\n"));
        solve(board, 0);
        System.out.println("after:\n"+Arrays.deepToString(board).replace("], ", "]\n"));

    }


    public static boolean solve(int [][]board, int pos) {
        if (pos == 81) {
            return true;
        }
        //pos/9(x) will check all the rows - only whole numbers work
        //pos%9(y) will check all the columns - any number works
        //this if statement it's not solve it will keep solving
        if (board[pos/9][pos%9] != 0){
            return solve(board, pos+1);
        }
        else {
            //this for loop will become the number that will be entered to solve sudoku
            for (int i = 1; i < 10; i++) {
                if(valid(board, i, pos/9, pos%9)) {
                    //place the number into
                    board[pos/9][pos%9] = i;
                    if (solve(board, pos+1)){
                        //return true when there is no more to solve
                        return true;
                    }
                    else{
                        //if it can't be solved make it equal 0
                        board[pos/9][pos%9] = 0;
                    }
                }
            }
        }
        //back tracks
        return false;
        }


    public static boolean valid(int [][] board, int num, int row, int col){
        //this wil check all the horizontal and vertical
        //we are going to assume the size of all sudoku board is 9x9
        //board.length is 9

        //this will check the horizontal and the vertical
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num){
                return false;
            }
            if (board[i][col] == num){
                return false;
            }
        }

        int rowBox = row/3;
        int colBox = col/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //this for loop will check if everything contained in the box 3*3 box
                if (board[i+(3*rowBox)][j+(3*colBox)] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
