public class PracticeProblem {

	public static void main(String args[]) {
		System.out.println(searchMazeMoves(new String[][]{{"", "", "F"}, {"", "", ""}, {"S", "", ""}}));
	}

	// public static int searchMazeMoves(String[][] maze) {
	// 	int row = maze.length - 1;

	// 	return mazeHelper(maze, row, 0) - 1;
	// }

	// public static int mazeHelper(String[][] maze, int row, int moves) {
	// 	if (row < 0) {
	// 		return -1;
	// 	}

	// 	for (int i = 0; i < maze[0].length; i++) {
	// 		if (maze[row][i] == "F") {
	// 			return ((maze.length - 1) - row) + i + 1;
	// 		}
	// 	}

	// 	return mazeHelper(maze, row - 1, moves);
	// }

	public static int searchMazeMoves (String[][] maze) {
	    int moves = 0;
	    int row = maze.length - 1;
	    int col = 0;
	    
	    return dfsHelper (maze, row, col, moves);
	}
	
	public static int dfsHelper (String[][] maze, int row, int col, int moves) {
	    if (row < 0 || col >= maze[0].length) {
	        return -1;
	    }
	    
	    if (maze[row][col] == "F") {
	        return moves;
	    }

		if (maze[row][col] != "" && maze[row][col] != "S") {
			return Integer.parseInt(maze[row][col]);
		}
	    
	    moves++;
	    int movesRight = dfsHelper(maze, row, col + 1, moves);
	    int movesUp = dfsHelper(maze, row - 1, col, moves);
	    
	    if (movesRight == -1) {
			if (maze[row][col] != "S") {
				maze[row][col] = Integer.toString(movesUp);
			}
	        return movesUp;
	    } else if (movesUp == -1) {
			if (maze[row][col] != "S") {
				maze[row][col] = Integer.toString(movesRight);
			}
			return movesRight;
	    } else {
			if (maze[row][col] != "S") {
				maze[row][col] = Integer.toString(Math.min(movesUp, movesRight));
			}
	        return Math.min(movesUp, movesRight);
	    }
	}

	public static int noOfPaths(String[][] maze) {
		int dx = 0;
		int dy = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == "F") {
					dx = j;
					dy = i;
				}
			}
		}
		int paths[] = new int[]{0};

		pathsHelper(maze, maze.length - 1, 0, searchMazeMoves(maze), dx, dy, paths);

		return paths[0];
	}

	public static void pathsHelper(String[][] maze, int row, int column, int depth, int dx, int dy, int[] paths) {		
		if (maze[dy][dx] == maze[row][column]) {
			paths[0]++;
		}

		if (depth <= 0) {
			return;
		}

		// if (row + 1 < maze.length) {
		// 	if (pathsHelper(maze, row + 1, column, depth - 1, dx, dy, paths)) { return true; }
		// }
		if (row - 1 >= 0) {
			pathsHelper(maze, row - 1, column, depth - 1, dx, dy, paths);
		}
		if (column + 1 < maze[0].length) {
			pathsHelper(maze, row, column + 1, depth - 1, dx, dy, paths);
		}
		// if (column - 1 >= 0) {
		// 	if (pathsHelper(maze, row, column - 1, depth - 1, dx, dy, paths)) { return true; }
		// }
	}


}
