package adt.bst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationTest {

	private BSTImpl<Integer> tree1;
	private BSTImpl<Integer> tree2;
	private SimpleBSTManipulationImpl<Integer> manipulation;
	
	@Before
	public void setUp() {
		tree1 = new BSTImpl<Integer>();
		tree2 = new BSTImpl<Integer>();
		manipulation = new SimpleBSTManipulationImpl<Integer>();
	}
	
	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree1.insert(i);
			tree2.insert(i);
		}
	}
	@Test
	public void testEquals1() {
		
		fillTree();
		
		assertTrue(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
		
		tree2.insert(100);
		assertFalse(manipulation.equals(tree1, tree2));
		tree1.insert(100);		
		assertTrue(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
		
		tree1.remove(6);
		tree1.remove(-34);
		tree1.remove(232);
		assertFalse(manipulation.equals(tree1, tree2));
		
		
		tree2.remove(6);
		tree2.remove(-34);
		tree2.remove(232);
		assertTrue(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
	}
	
	@Test
	public void testEquals2() {
		assertTrue(tree1.isEmpty());
		assertTrue(tree2.isEmpty());
		assertTrue(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
		
		tree1.insert(2);
		tree1.insert(1);
		tree1.insert(3);
		assertFalse(manipulation.equals(tree1, tree2));
		assertFalse(manipulation.isSimilar(tree1, tree2));
		
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(3);
		assertTrue(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
		
		tree1.insert(5);
		tree2.insert(4);
		assertFalse(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
		
		tree1.remove(2);
		tree1.remove(1);
		tree1.remove(3);
		tree1.remove(5);
		
		tree2.remove(2);
		tree2.remove(1);
		tree2.remove(3);
		tree2.remove(4);
		
		assertTrue(manipulation.equals(tree1, tree2));
		assertTrue(manipulation.isSimilar(tree1, tree2));
	}
	
	@Test
	public void testIsSimilar() {
		tree1.insert(2);
		tree1.insert(1);
		tree1.insert(3);
		tree1.insert(4);
		
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(3);
		tree2.insert(5);
		
		assertTrue(manipulation.isSimilar(tree1, tree2));
		
		tree2.insert(9);
		assertFalse(manipulation.isSimilar(tree1, tree2));
	}
	
	@Test
	public void testOrderStatistic() {
		tree1.insert(5);
		tree1.insert(2);
		tree1.insert(1);
		tree1.insert(3);
		tree1.insert(4);
		assertNull(manipulation.orderStatistic(tree1, 0));
		assertNull(manipulation.orderStatistic(tree1, 6));
		
		for (int i = 1; i <= tree1.size(); i++) {
			assertEquals(new Integer(i), manipulation.orderStatistic(tree1, i));
		}
		
		tree2.insert(1);
		tree2.insert(5);
		tree2.insert(10);
		tree2.insert(25);
		tree2.insert(30);
		tree2.insert(15);
		tree2.insert(35);
		tree2.insert(20);
		tree2.insert(40);
		tree2.insert(99);
		
		
		assertEquals(new Integer(1), manipulation.orderStatistic(tree2, 1));
		assertEquals(new Integer(5), manipulation.orderStatistic(tree2, 2));
		assertEquals(new Integer(10), manipulation.orderStatistic(tree2, 3));
		assertEquals(new Integer(15), manipulation.orderStatistic(tree2, 4));
		assertEquals(new Integer(20), manipulation.orderStatistic(tree2, 5));
		assertEquals(new Integer(25), manipulation.orderStatistic(tree2, 6));
		assertEquals(new Integer(30), manipulation.orderStatistic(tree2, 7));
		assertEquals(new Integer(35), manipulation.orderStatistic(tree2, 8));
		assertEquals(new Integer(40), manipulation.orderStatistic(tree2, 9));
		assertEquals(new Integer(99), manipulation.orderStatistic(tree2, 10));
		assertNull(manipulation.orderStatistic(tree1, 0));
		assertNull(manipulation.orderStatistic(tree1, 11));
		
	}

}
