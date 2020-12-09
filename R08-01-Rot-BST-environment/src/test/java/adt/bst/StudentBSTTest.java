package adt.bst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

public class StudentBSTTest {

	private BSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new BSTImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(500));
		assertEquals(null, tree.sucessor(500));
		
		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
		
		assertNull(tree.sucessor(232));
		assertNull(tree.predecessor(-40));
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));
		
//		BTNode<Integer> a = new BTNode<Integer>(1, new BTNode<Integer>(), null, null);
//		BTNode<Integer> b = new BTNode<Integer>(1, null, null, null);
//		
//		System.out.println(a.equals(b));
//		System.out.println(a == a);

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232
		
		assertEquals(new BSTNode<Integer>(), tree.search(null));
		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}
	
	@Test
	public void testMeu() {
		tree.insert(56);
		tree.insert(7);
		tree.insert(37);
		tree.insert(9);
		tree.insert(68);
		tree.insert(82);
		tree.insert(75);
		tree.insert(83);
		tree.insert(92);
		
		System.out.println(Arrays.toString(tree.preOrder()));
		
		assertArrayEquals(new Integer[] { 56, 7, 37, 9, 68, 82, 75, 83, 92 }, tree.preOrder());
		
		tree.remove(37);
		assertArrayEquals(new Integer[] { 56, 7, 9, 68, 82, 75, 83, 92 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(56,null,null,null), tree.getRoot());
		
		tree.insert(37);
		assertArrayEquals(new Integer[] { 56, 7, 9, 37, 68, 82, 75, 83, 92 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(56,null,null,null), tree.getRoot());
		
		tree.remove(56);
		assertArrayEquals(new Integer[] { 68, 7, 9, 37, 82, 75, 83, 92 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(68,null,null,null), tree.getRoot());
		
		tree.remove(68);
		assertArrayEquals(new Integer[] { 75, 7, 9, 37, 82, 83, 92 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(75,null,null,null), tree.getRoot());
		
		tree.remove(75);
		assertArrayEquals(new Integer[] { 82, 7, 9, 37, 83, 92 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(82,null,null,null), tree.getRoot());
		
		tree.remove(82);
		assertArrayEquals(new Integer[] { 83, 7, 9, 37, 92 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(83,null,null,null), tree.getRoot());
		
		tree.remove(83);
		assertArrayEquals(new Integer[] { 92, 7, 9, 37 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(92,null,null,null), tree.getRoot());

		tree.remove(92);
		assertArrayEquals(new Integer[] { 7, 9, 37 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(7,null,null,null), tree.getRoot());
		
		tree.remove(7);
		assertArrayEquals(new Integer[] { 9, 37 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(9,null,null,null), tree.getRoot());
		
		tree.remove(9);
		assertArrayEquals(new Integer[] { 37 }, tree.preOrder());
		assertEquals(new BTNode<Integer>(37,null,null,null), tree.getRoot());
		
		tree.remove(37);
		assertArrayEquals(new Integer[] { }, tree.preOrder());
		assertEquals(new BTNode<Integer>(null,null,null,null), tree.getRoot());
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		
		
		
		tree.insert(92);
		tree.insert(96);
		tree.insert(13);
		tree.insert(11);
		tree.insert(43);
		tree.insert(10);
		tree.insert(12);
		tree.insert(24);
		tree.insert(69);
		tree.insert(20);
		tree.insert(38);
		tree.insert(49);
		tree.insert(83);
		
		
//		System.out.println(Arrays.toString(tree.preOrder()));
		assertArrayEquals(new Integer[] { 92, 13,11,10,12,43,24,20,38,69,49,83,96 }, tree.preOrder());
		
		tree.remove(13);
		assertArrayEquals(new Integer[] { 92, 20,11,10,12,43,24,38,69,49,83,96 }, tree.preOrder());
		
		tree.insert(21);
		tree.insert(23);
		assertArrayEquals(new Integer[] { 92, 20,11,10,12,43,24,21,23,38,69,49,83,96 }, tree.preOrder());
		
		tree.remove(20);
		assertArrayEquals(new Integer[] { 92, 21,11,10,12,43,24,23,38,69,49,83,96 }, tree.preOrder());
		
		tree.remove(43);
		assertArrayEquals(new Integer[] { 92, 21,11,10,12,49,24,23,38,69,83,96 }, tree.preOrder());
		
		tree.remove(23);
		tree.insert(22);
		tree.insert(25);
		tree.insert(26);
		tree.insert(27);
		tree.insert(29);
		tree.insert(28);
		tree.insert(30);
		
		tree.remove(24);
		assertArrayEquals(new Integer[] { 92, 21,11,10,12,49,25,22,38,26,27,29,28,30,69,83,96 }, tree.preOrder());
		
		
		
	}
}
