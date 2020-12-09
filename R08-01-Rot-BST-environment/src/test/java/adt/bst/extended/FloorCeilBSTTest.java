package adt.bst.extended;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilBSTTest {

	private FloorCeilBSTImpl fc;
	
	@Before
	public void setUp() {
		fc = new FloorCeilBSTImpl();
	}
	@Test
	public void testFloor() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		
		assertNull(fc.floor(array, -50));
		assertNull(fc.floor(array, -100));
		
		assertEquals(new Integer(-40), fc.floor(array, -40));
		assertEquals(new Integer(-34), fc.floor(array, -34));
		assertEquals(new Integer(5), fc.floor(array, 5));
		assertEquals(new Integer(2), fc.floor(array, 2));
		assertEquals(new Integer(0), fc.floor(array, 0));
		assertEquals(new Integer(6), fc.floor(array, 6));
		assertEquals(new Integer(23), fc.floor(array, 23));
		assertEquals(new Integer(9), fc.floor(array, 9));
		assertEquals(new Integer(12), fc.floor(array, 12));
		assertEquals(new Integer(76), fc.floor(array, 76));
		assertEquals(new Integer(67), fc.floor(array, 67));
		assertEquals(new Integer(232), fc.floor(array, 232));
		
		
		assertEquals(new Integer(6), fc.floor(array, 8));
		assertEquals(new Integer(12), fc.floor(array, 13));
		assertEquals(new Integer(232), fc.floor(array, 500));
		assertEquals(new Integer(9), fc.floor(array, 9.1));
		assertEquals(new Integer(9), fc.floor(array, 9.99999));
		assertEquals(new Integer(9), fc.floor(array, 11.9));
	}
	
	@Test
	public void testFloor2() {
		Integer[] array = { };
		assertNull(fc.floor(array, -50));
		assertNull(fc.floor(array, -1));
		assertNull(fc.floor(array, 0));
		assertNull(fc.floor(array, 50));
		assertNull(fc.floor(array, 1));
		assertNull(fc.floor(array, 2));
		assertNull(fc.floor(array, 10));
		assertNull(fc.floor(array, 37));
		assertNull(fc.floor(array, 44));
		
	}

	@Test
	public void testCeil() {
		
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		
		assertNull(fc.ceil(array, 233));
		assertNull(fc.ceil(array, 234));
		assertNull(fc.ceil(array, 500));
		
		assertEquals(new Integer(-40), fc.ceil(array, -40));
		assertEquals(new Integer(-34), fc.ceil(array, -34));
		assertEquals(new Integer(5), fc.ceil(array, 5));
		assertEquals(new Integer(2), fc.ceil(array, 2));
		assertEquals(new Integer(0), fc.ceil(array, 0));
		assertEquals(new Integer(6), fc.ceil(array, 6));
		assertEquals(new Integer(23), fc.ceil(array, 23));
		assertEquals(new Integer(9), fc.ceil(array, 9));
		assertEquals(new Integer(12), fc.ceil(array, 12));
		assertEquals(new Integer(76), fc.ceil(array, 76));
		assertEquals(new Integer(67), fc.ceil(array, 67));
		assertEquals(new Integer(232), fc.ceil(array, 232));
		
		assertEquals(new Integer(232), fc.ceil(array, 231));
		assertEquals(new Integer(232), fc.ceil(array, 231.9));
		assertEquals(new Integer(232), fc.ceil(array, 100));
		assertEquals(new Integer(-40), fc.ceil(array, -41));
		assertEquals(new Integer(-40), fc.ceil(array, -42));
		assertEquals(new Integer(-40), fc.ceil(array, -43));
		assertEquals(new Integer(-40), fc.ceil(array, -100));
		assertEquals(new Integer(-40), fc.ceil(array, -1000));
		assertEquals(new Integer(5), fc.ceil(array, 4.4));
		assertEquals(new Integer(5), fc.ceil(array, 4.9));
		assertEquals(new Integer(23), fc.ceil(array, 13));
		assertEquals(new Integer(76), fc.ceil(array, 68));
		assertEquals(new Integer(67), fc.ceil(array, 67));
		
	}
	
	@Test
	public void testCeil2() {
		Integer[] array = { };
		assertNull(fc.ceil(array, -50));
		assertNull(fc.ceil(array, -1));
		assertNull(fc.ceil(array, 0));
		assertNull(fc.ceil(array, 50));
		assertNull(fc.ceil(array, 1));
		assertNull(fc.ceil(array, 2));
		assertNull(fc.ceil(array, 10));
		assertNull(fc.ceil(array, 37));
		assertNull(fc.ceil(array, 44));
	}
}
