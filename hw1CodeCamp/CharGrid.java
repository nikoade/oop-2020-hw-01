// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	public int charArea(char ch) {
		int result = 0;

		int top = firstOccurence(ch, 0, 0, grid.length, grid[0].length,
				1, 1, true);

		if(top == -1 ) return 0;

		int left = firstOccurence(ch, 0, 0, grid[0].length, grid.length,
									1, 1, false);

		int right = firstOccurence(ch, grid[0].length - 1, 0, 0, grid.length,
									-1, 1, false);

		int bot = firstOccurence(ch, grid.length - 1, 0, 0, grid[0].length,
									-1, 1, true);


		result = (right - left + 1) * (bot - top + 1);
		return result;
	}

	public int countPlus() {
		int result = 0;
		for(int i = 0; i < grid.length; i ++){
			for(int j = 0; j < grid[0].length; j ++){
				char c = grid[i][j];
				int left = armLength(c, i, j - 1, 0, -1);
				int top = armLength(c,  i - 1, j, -1, 0);
				int right = armLength(c , i, j + 1, 0, 1);
				int bot = armLength(c, i + 1, j, 1, 0);

				if(left == top && top == right
					&& right == bot && bot >= 2) result ++;
			}
		}
		return result;
	}

	/** --------------------private methods for decomposition--------------------------- **/
	private int firstOccurence(char c, int startI, int startJ,
							   int endI, int endJ, int difI, int difJ,
							   boolean needRow){

		int edge = Math.max(grid.length, grid[0].length);
		if(endI == 0) endI = edge;
		int result = -1;
		for(int i = startI; i < endI; i += difI){
			for(int j = startJ; j < endJ; j += difJ){
				if(needRow && grid[i][j] == c) return i;
				else if (!needRow && grid[j][i] == c) return i;
			}
		}
		return result;
	}

	private int armLength(char c, int i, int j, int difI, int difJ){
		int result = 1;
		if(!inBounds(i,j)) return 1;
		while(c == grid[i][j]){
			result ++;
			i += difI;
			j += difJ;
			if(!inBounds(i,j)) break;
		}
		return result;
	}

	private boolean inBounds(int i, int j){
		if(i < 0 || i >= grid.length) return false;
		if(j < 0 || j >= grid[0].length) return false;
		return true;
	}

}
