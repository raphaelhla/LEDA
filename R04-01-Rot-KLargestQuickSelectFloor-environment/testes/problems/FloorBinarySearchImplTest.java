package problems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FloorBinarySearchImplTest {

	FloorBinarySearchImpl fb;
	Integer[] array;
	Integer[] array2;
	Integer[] array3;
	
	@BeforeEach
	public void before() {
		fb = new FloorBinarySearchImpl();
		array = new Integer[] {10, 8, 6, 4};
		array2 = new Integer[]{8, 12, 1, 19, 10, 2, 10};
		array3 = new Integer[]{5};
	}
	
	@Test
	void test() {
		assertEquals(4, fb.floor(array, 5));
	}
	@Test
	void test2() {
		assertEquals(6, fb.floor(array, 7));
	}
	@Test
	void test3() {
		assertEquals(8, fb.floor(array, 8));
	}
	@Test
	void test4() {
		assertEquals(8, fb.floor(array, 9));
	}
	@Test
	void test5() {
		assertEquals(10, fb.floor(array, 425435348));
	}
	@Test
	void test6() {
		assertEquals(null, fb.floor(array, 2));
	}
	
	@Test
	void testArray2() {
		assertEquals(2, fb.floor(array2, 5));
	}
	@Test
	void test2Array2() {
		assertEquals(19, fb.floor(array2, 20));
	}
	@Test
	void test3Array2() {
		assertEquals(null, fb.floor(array2, 0));
	}
	@Test
	void test4Array2() {
		assertEquals(2, fb.floor(array2, 6));
	}
	@Test
	void test5Array2() {
		assertEquals(2, fb.floor(array2, 7));
	}
	@Test
	void test6Array2() {
		assertEquals(10, fb.floor(array2, 10));
	}@Test
	void test7Array2() {
		assertEquals(1, fb.floor(array2, 1));
	}@Test
	void test8Array2() {
		assertEquals(2, fb.floor(array2, 2));
	}@Test
	void test9Array2() {
		assertEquals(19, fb.floor(array2, 10000));
	}@Test
	void test10Array2() {
		assertEquals(null, fb.floor(array2, -1));
	}
	
	
	@Test
	void testArray3() {
		assertEquals(null, fb.floor(array3, 4));
	}
	
	@Test
	void testArrayVazio() {
		Integer[] array4 = new Integer[] {};
		assertNull(fb.floor(array4, 5));
	}
}
