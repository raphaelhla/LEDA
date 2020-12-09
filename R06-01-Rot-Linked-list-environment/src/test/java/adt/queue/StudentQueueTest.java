package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queue4;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<Integer>(4);
		queue2 = new QueueDoubleLinkedListImpl<Integer>(2);
		queue3 = new QueueDoubleLinkedListImpl<Integer>(0);
		queue4 = new QueueDoubleLinkedListImpl<Integer>(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
		queue1.enqueue(new Integer(9));	// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();
		assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
	
	// TESTES DA QUEUE 3
	
	@Test(expected = QueueOverflowException.class)
	public void testEnqueueQueue3() throws QueueOverflowException {
		queue3.enqueue(new Integer(3));
	}
	
	@Test(expected = QueueUnderflowException.class)
	public void testDequeueQueue3() throws QueueUnderflowException {
		queue3.dequeue();
	}
	
	@Test
	public void testHeadQueue3Vazia() {
		assertNull(queue3.head());
	}
	
	@Test
	public void testIsFullQueue3() {
		assertTrue(queue3.isFull());
	}
	
	@Test
	public void testIsEmptyQueue3() {
		assertTrue(queue3.isEmpty());
	}
	
	// TESTES DA QUEUE 4
	
	@Test
	public void testEnqueueQueue4() throws QueueOverflowException, QueueUnderflowException {
		assertNull(queue4.head());
		
		queue4.enqueue(new Integer(1));
		queue4.enqueue(new Integer(2));
		queue4.enqueue(new Integer(3));
		queue4.enqueue(new Integer(4));
		queue4.enqueue(null);
		queue4.enqueue(null);
		queue4.enqueue(null);
		queue4.enqueue(new Integer(5));
		
		assertEquals(new Integer(1), queue4.head());
		
		Integer x = queue4.dequeue();
		Integer y = queue4.dequeue();
		
		assertEquals(x, new Integer(1));
		assertEquals(y, new Integer(2));
		
		queue4.enqueue(new Integer(6));
		queue4.enqueue(new Integer(7));
		
		assertEquals(new Integer(3), queue4.dequeue());
		assertEquals(new Integer(4), queue4.dequeue());
		assertEquals(new Integer(5), queue4.dequeue());
		assertEquals(new Integer(6), queue4.dequeue());
		assertEquals(new Integer(7), queue4.dequeue());
		
		queue4.enqueue(new Integer(101));
		queue4.enqueue(new Integer(102));
		queue4.enqueue(new Integer(103));
		
		assertEquals(new Integer(101), queue4.dequeue());
		assertEquals(new Integer(102), queue4.dequeue());
		assertEquals(new Integer(103), queue4.head());
		
		queue4.enqueue(new Integer(650));
		queue4.enqueue(new Integer(651));
		queue4.enqueue(new Integer(652));
		queue4.enqueue(new Integer(653));
		
		try {
			queue4.enqueue(new Integer(653));
			fail("Deveria Lançar exceção");
		} catch (QueueOverflowException e) {
			assertEquals("Fila cheia", e.getMessage());
		}
		
		assertEquals(new Integer(103), queue4.dequeue());
		assertEquals(new Integer(650), queue4.head());
		assertEquals(new Integer(650), queue4.dequeue());
		assertEquals(new Integer(651), queue4.head());
		assertEquals(new Integer(651), queue4.dequeue());
		assertEquals(new Integer(652), queue4.head());
		assertEquals(new Integer(652), queue4.dequeue());
		assertEquals(new Integer(653), queue4.head());
		assertEquals(new Integer(653), queue4.dequeue());
		assertNull(queue4.head());
		
		try {
			queue4.dequeue();
			fail("Deveria Lançar exceção");
		} catch (QueueUnderflowException e) {
			assertEquals("Fila vazia", e.getMessage());
		}
		
		assertNull(queue4.head());
	}
}