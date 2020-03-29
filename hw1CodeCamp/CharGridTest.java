
// Test cases for CharGrid -- a few basic tests are provided.
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CharGridTest {

	/** charArea tests **/
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][]{
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
		};


		CharGrid cg = new CharGrid(grid);

		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}

	@Test
	public void testCharArea2() {
		char[][] grid = new char[][]{
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}

	@Test
	public void testCharArea3() {
		char[][] grid = new char[][]{
				{'c', 'a', ' '},
				{'b', 'p', 'b'},
				{'d', 'd', 'a'},
				{'k', 'd', 'k'},
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('p'));
		assertEquals(3, cg.charArea('k'));
		assertEquals(4, cg.charArea('d'));

	}

	@Test
	public void testCharArea4() {
		char[][] grid = new char[][]{
				{'c', 'a', ' '},
				{'q', 'j', 'b'},
				{'x', 'y', 'z'},
				{'k', 'n', 'm'},
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.charArea('a'));
		assertEquals(1, cg.charArea('k'));
		assertEquals(1, cg.charArea('m'));
		assertEquals(1, cg.charArea('n'));
	}

	@Test
	public void testCharArea5() {
		char[][] grid = new char[][]{
				{'c', 'a', ' ', 'a', 'k'},
				{'q', 'j', 'b', 'a', 'a'},
				{'x', 'y', 'z', 'a', 'a'},
				{'k', 'n', 'm', 'a', 'c'},
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('.'));
		assertEquals(16, cg.charArea('a'));
		assertEquals(20, cg.charArea('c'));
		assertEquals(20, cg.charArea('k'));
	}


	/** countPlus tests **/
	@Test
	public void testPluses1(){
		char[][] grid = new char[][]{
				{'c', 'a', ' '},
				{'a', 'a', 'a'},
				{'x', 'a', 'z'},
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1, cg.countPlus());
	}

	@Test
	public void testPluses2(){
		char[][] grid1 = new char[][]{
				{'c', 'a', ' '},
				{'a', 'a', 'a'},
				{'x', 'a', 'z'},
				{'c', 'a', 'z'},
		};

		CharGrid cg = new CharGrid(grid1);
		assertEquals(0, cg.countPlus());
	}

	@Test
	public void testPluses3() {
		char[][] grid = new char[][]{
				{'x','c', 'x', ' ', 'x'},
				{'x','a', 'x', 'a', 'x'},
				{'x','x', 'x', 'x', 'x'},
				{'x','c', 'x', 'z', 'x'},
				{'x','x', 'x', 'x', 'x'}
		};

		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	@Test
	public void testPluses4() {
		char[][] grid = new char[][]{
				{'+', '+', '-', '-'},
				{'+', '+', '+', '-'},
				{'x', '+', '+', '+'},
				{'c', 'a', '+', '+'},
				{'c', 'a', 'z', '+'},
				{'c', 'z', 'z', 'z'},
				{'c', 'a', 'z', '+'},
				{'c', 'a', 'd', '+'},
		};

		CharGrid cg = new CharGrid(grid);
		assertEquals(3, cg.countPlus());
	}

	@Test
	public void testPluses5() {
		char[][] grid = new char[][]{
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '},
		};

		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());
	}
}