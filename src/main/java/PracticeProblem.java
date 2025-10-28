public class PracticeProblem {

	public static void main(String args[]) {
		System.out.println(noOfPaths(new String[][]{{"7", "8", "F"}, {"4", "5", "6"}, {"S", "2", "3"}}));
	}

	public static int searchMazeMoves(String[][] maze) {
		int row = maze.length - 1;

		return mazeHelper(maze, row, 0) - 1;
	}

	public static int mazeHelper(String[][] maze, int row, int moves) {
		if (row < 0) {
			return -1;
		}

		for (int i = 0; i < maze[0].length; i++) {
			if (maze[row][i] == "F") {
				return ((maze.length - 1) - row) + i + 1;
			}
		}

		return mazeHelper(maze, row - 1, moves);
	}

	public static int noOfPaths(String[][] maze) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
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
		System.out.println(maze[dy][dx] + " - " + maze[row][column]);
		
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
