
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TetrisGridTest{
	
	/** deleting one row **/
	@Test
	public void testClear1() {
		boolean[][] before =
		{
			{true, true, false, },
			{false, true, true, }
		};

		boolean[][] after =
		{
			{true, false, false},
			{false, true, false}
		};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	/** deleting no rows **/
	@Test
	public void testClear2() {
		boolean[][] before =
				{
						{false, false, true},
						{true,  true,  false}
				};

		boolean[][] after =
				{
						{false, false, true},
						{true,  true,  false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	/** deleting two consecutive rows **/
	@Test
	public void testClear3() {
		boolean[][] before =
				{
						{false, true, true, false},
						{true,  true,  true, true}
				};

		boolean[][] after =
				{
						{false, false, false, false},
						{true,  true,  false, false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	/** deleting random row + last row **/
	@Test
	public void testClear4() {
		boolean[][] before =
				{
						{false, true, false, true},
						{true,  true,  true, true}
				};

		boolean[][] after =
				{
						{false, false, false, false},
						{true,  true,  false, false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	/** deleting all rows **/
	@Test
	public void testClear5() {
		boolean[][] before =
				{
						{true, true, true, true},
						{true,  true,  true, true},
						{true,  true,  true, true},
						{true,  true,  true, true},
						{true,  true,  true, true}
				};

		boolean[][] after =
				{
						{false, false, false, false},
						{false, false, false, false},
						{false, false, false, false},
						{false, false, false, false},
						{false, false, false, false}
				};

		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

}
