import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JPanel;

public class MazeGridPanel extends JPanel{
	private int rows;
	private int cols;
	private Cell[][] maze;



	// extra credit
	public void genDFSMaze() {
		boolean[][] visited;
		Stack<Cell> stack  = new Stack<Cell>();
		Cell start = maze[0][0];
		stack.push(start);
	}

	//homework
	public void solveMaze() {
		Stack<Cell> stack  = new Stack<Cell>();
		Cell start = maze[0][0];
		start.setBackground(Color.GREEN);
		Cell finish = maze[rows-1][cols-1];
		finish.setBackground(Color.RED);
		stack.push(start);



		/*
		North
		East
		South
		West

		because the maze is ordered this way

		but the program will check
		North South East West
		 */

		boolean exit = false;
		//the while loop will keep going until it finds an exit and the stack is empty
		//meaning there is no more paths
		while(!exit && !stack.isEmpty()){
			//peeking at the current location
			Cell Current = stack.peek();
			//if it approached the exit it will return true
			if (Current == finish){

				break; //stopping the while loop
			} else {
				//this will check the north first and if we have visited north before
				if( !Current.northWall && !this.visited(Current.row-1, Current.col) ) {
					stack.push(maze[Current.row-1][Current.col]);
					maze[Current.row-1][Current.col].setBackground(Color.MAGENTA);
				}

				//this will check the south first and if we have visited south before
				else if( !Current.southWall && !this.visited(Current.row+1, Current.col) ) {
					stack.push(maze[Current.row+1][Current.col]);
					maze[Current.row+1][Current.col].setBackground(Color.MAGENTA);
				}
				//this will check the east first and if we have visited east before
				else if( !Current.eastWall && !this.visited(Current.row, Current.col+1) ) {
					stack.push(maze[Current.row][Current.col+1]);
					maze[Current.row][Current.col+1].setBackground(Color.MAGENTA);
				}
				//this will check the west first and if we have visited west before
				else if( !Current.westWall && !this.visited(Current.row, Current.col-1) ) {
					stack.push(maze[Current.row][Current.col-1]);
					maze[Current.row][Current.col-1].setBackground(Color.MAGENTA);
				}
				// If path is blocked by maze or dead end then it traces the path it can't complete
				else {
					maze[Current.row][Current.col].setBackground(Color.LIGHT_GRAY);
					stack.pop();
				}

//				if (!Current.northWall && !this.visited(Current.row - 1, Current.col)) {
//					stack.push(maze[Current.row - 1][Current.col]);
//					maze[Current.row - 1][Current.col].setBackground(Color.orange);
//				} else if (!Current.westWall && !this.visited(Current.row, Current.col + 1)) {
//					stack.push(maze[Current.row][Current.col + 1]);
//					maze[Current.row][Current.col + 1].setBackground(Color.orange);
//				} else if (!Current.southWall && !this.visited(Current.row + 1, Current.col)) {
//					stack.push(maze[Current.row + 1][Current.col]);
//					maze[Current.row + 1][Current.col].setBackground(Color.orange);
//				} else if (!Current.eastWall && !this.visited(Current.row, Current.col - 1)) {
//					stack.push(maze[Current.row][Current.col - 1]);
//					maze[Current.row][Current.col - 1].setBackground(Color.orange);
//				} else {
//					maze[Current.row][Current.col].setBackground(Color.DARK_GRAY);
//					stack.pop();
//				}
			}
		}
	}


	

	


	public boolean visited(int row, int col) {
		Cell c = maze[row][col];
		Color status = c.getBackground();
		if(status.equals(Color.WHITE)  || status.equals(Color.RED)  ) {
			return false;
		}


		return true;


	}


	public void genNWMaze() {
		
		for(int row = 0; row  < rows; row++) {
			for(int col = 0; col < cols; col++) {

				if(row == 0 && col ==0) {
					continue;
				}

				else if(row ==0) {
					maze[row][col].westWall = false;
					maze[row][col-1].eastWall = false;
				} else if(col == 0) {
					maze[row][col].northWall = false;
					maze[row-1][col].southWall = false;
				}else {
					boolean north = Math.random()  < 0.5;
					if(north ) {
						maze[row][col].northWall = false;
						maze[row-1][col].southWall = false;
					} else {  // remove west
						maze[row][col].westWall = false;
						maze[row][col-1].eastWall = false;
					}
					maze[row][col].repaint();
				}
			}
		}
		this.repaint();
		
	}

	public MazeGridPanel(int rows, int cols) {
		this.setPreferredSize(new Dimension(800,800));
		this.rows = rows;
		this.cols = cols;
		this.setLayout(new GridLayout(rows,cols));
		this.maze =  new Cell[rows][cols];
		for(int row = 0 ; row  < rows ; row++) {
			for(int col = 0; col < cols; col++) {

				maze[row][col] = new Cell(row,col);

				this.add(maze[row][col]);
			}

		}


		this.genNWMaze();
		this.solveMaze();
		
	}




}
