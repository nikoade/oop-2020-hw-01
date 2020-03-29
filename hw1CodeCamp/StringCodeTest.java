// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCodeTest {

	/** blowup tests **/
	@Test
	public void testBlowup1() {
		assertEquals("", StringCode.blowup(""));
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}

	@Test
	public void testBlowup2() {
		assertEquals("axxx", StringCode.blowup("a2x3"));
		assertEquals("a33111", StringCode.blowup("a231"));
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}

	@Test
	public void testBlowup3() {
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
	}

	@Test
	public void testBlowup4(){
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}

	@Test
	public void testBlowup5(){
		assertEquals("2334445555", StringCode.blowup("12345"));
		assertEquals("paulmorphy", StringCode.blowup("paulmorphy9"));
	}

	/** maxRun tests **/
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	@Test
	public void testRun3() {
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	@Test
	public void testRun4(){
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(1, StringCode.maxRun("h"));
	}
	@Test
	public void testRun5(){
		assertEquals(5, StringCode.maxRun("     ook"));
		assertEquals(4, StringCode.maxRun("h    ...."));
	}


	/** stringIntersect tests **/

	@Test
	public void testIntesect1(){
		assertFalse(StringCode.stringIntersect("Carlsen","Magnus", 4));
		assertFalse(StringCode.stringIntersect("Garry", "Kasparov", 3));
	}

	@Test
	public void testIntersect2(){
		assertTrue(StringCode.stringIntersect("Karjakin", "Radjabov", 2));
		assertTrue(StringCode.stringIntersect("karjakin", "Hikaru", 3));
	}

	@Test
	public void testIntersect3(){
		assertTrue(StringCode.stringIntersect("nightblue3", "nightbot", 4));
		assertTrue(StringCode.stringIntersect("nightblue3", "nightbot", 5));
		assertTrue(StringCode.stringIntersect("nightblue3", "nightbot", 6));
	}

	@Test
	public void testIntersect4(){
		assertTrue(StringCode.stringIntersect("Botvinik Mikhail", "Tal Mikhail", 7));
		assertTrue(StringCode.stringIntersect("Botvinik Mikhail", "Tal Mikhail", 8));
		assertFalse(StringCode.stringIntersect("Botvinik Mikhail", "Tal Mikhail", 9));
	}

	@Test
	public void testIntersect5(){
		assertFalse(StringCode.stringIntersect("longerString", "shortstring", 12 ));
		assertFalse(StringCode.stringIntersect("shortstring", "longerString", 12 ));
	}
}
