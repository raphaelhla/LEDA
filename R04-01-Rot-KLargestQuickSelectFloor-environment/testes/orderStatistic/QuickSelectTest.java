package orderStatistic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuickSelectTest {

	
	QuickSelect<Integer> qs;
	Integer[] array;
	Integer[] array2;
	
	@BeforeEach
	public void criandoCoisas() {
		qs = new QuickSelect<Integer>();
		array = new Integer[]{6, 4, 5, 3, 1, 2};
		array2 = new Integer[]{4,8,6,9,12,1};
	}
	
	@Test
	void test() {
		assertEquals(5, qs.quickSelect(array, 5));
	}
	
	@Test
	void test2() {
		assertEquals(2, qs.quickSelect(array, 2));
	}
	
	@Test
	void test3() {
		assertEquals(3, qs.quickSelect(array, 3));
	}
	
	@Test
	void test4() {
		assertEquals(4, qs.quickSelect(array, 4));
	}
	
	@Test
	void test5() {
		assertEquals(1, qs.quickSelect(array, 1));
	}
	
	@Test
	void test6() {
		assertEquals(6, qs.quickSelect(array, 6));
	}
	
	@Test
	void test7() {
		assertEquals(null, qs.quickSelect(array, 7));
	}
	
	@Test
	void test8() {
		assertEquals(null, qs.quickSelect(array, 0));
	}

}
