//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	private boolean[][] grid;


	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	public void clearRows() {
		for(int i = 0; i < grid[0].length; ++i){
			if(isColumnFilled(i)){
				deleteRow(i);
				i--;
			}
		}
	}

	boolean[][] getGrid() {
		return grid;
	}

	/** --------------------private methods for decomposition--------------------------- **/
	private void deleteRow(int n){
		int lastCol = grid[0].length - 1;
		for(int i = n; i < lastCol; ++i) {
			for(int j = 0; j < grid.length; ++j){
				grid[j][i] = grid[j][i + 1];
			}
		}
		for(int i = 0; i < grid.length; ++i){
			grid[i][lastCol] = false;
		}
	}

	private boolean isColumnFilled(int i){
		boolean isFilled = true;
		for(int j = 0; j < grid.length; ++j){
			if(!grid[j][i]){
				isFilled = false;
				break;
			}
		}
		return isFilled;
	}
}
