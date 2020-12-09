package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;
	public Stack<Integer> stack4;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(null);
		stack2.push(null);
		stack2.push(2);
		
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<Integer>(3);
		stack2 = new StackDoubleLinkedListImpl<Integer>(2);
		stack3 = new StackDoubleLinkedListImpl<Integer>(0);
		stack4 = new StackDoubleLinkedListImpl<Integer>(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertTrue(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(new Integer(5)); // levanta excecao apenas se o tamanhonao
										// permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		stack1.pop();
		stack1.pop();
		stack1.pop();
		assertEquals(new Integer(3), stack1.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}
	
	// TESTES DA STACK3
	
	@Test(expected = StackOverflowException.class)
	public void testPushStack3() throws StackOverflowException {
		stack3.push(new Integer(3));
	}
	
	@Test(expected = StackUnderflowException.class)
	public void testPopStack3() throws StackUnderflowException {
		stack3.pop();
	}
	
	@Test
	public void testTopStackVazia() {
		assertNull(stack3.top());
	}
	
	@Test
	public void testIsFullStack3() {
		assertTrue(stack3.isFull());
	}
	
	@Test
	public void testIsEmptyStack3() {
		assertTrue(stack3.isEmpty());
	}
	
	//TESTES DA STACK4
	
	@Test
	public void testIsEmptyStack4() throws StackOverflowException {
		stack4.push(new Integer(2));
		assertFalse(stack4.isEmpty());
	}
	@Test
	public void testIsEmpty2Stack4() throws StackOverflowException {
		assertTrue(stack4.isEmpty());
	}
	
	@Test
	public void testIsFullStack4() throws StackOverflowException {
		stack4.push(new Integer(2));
		assertFalse(stack4.isFull());
	}
	
	
	@Test 
	public void testCompleteStack4() throws StackOverflowException, StackUnderflowException {
		stack4.push(new Integer(1));
		assertEquals(new Integer(1), stack4.top());
		stack4.push(new Integer(2));
		assertEquals(new Integer(2), stack4.top());
		stack4.push(new Integer(3));
		assertEquals(new Integer(3), stack4.top());
		stack4.push(new Integer(4));
		assertEquals(new Integer(4), stack4.top());
		stack4.push(null);
		stack4.push(null);
		stack4.push(null);
		stack4.push(new Integer(5));
		
		try {
			stack4.push(null);
			fail("Deveria lancar excecao");
		} catch (StackOverflowException e) {
			assertEquals("Stack is full", e.getMessage());
		}
		
		assertEquals(new Integer(5), stack4.pop());
		assertEquals(new Integer(4), stack4.pop());
		assertEquals(new Integer(3), stack4.pop());
		assertEquals(new Integer(2), stack4.pop());
		assertEquals(new Integer(1), stack4.pop());
		
		try {
			stack4.pop();
			fail("Deveria lancar excecao");
		} catch (StackUnderflowException e) {
			assertEquals("Stack is empty", e.getMessage());
		}
		
		assertNull(stack4.top());
		stack4.push(new Integer(100));
		stack4.push(new Integer(200));
		
		assertEquals(new Integer(200), stack4.top());
		
	}
}