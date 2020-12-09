package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		try {
			if (element != null)
				stack1.push(element);
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp = null;

		try {
			
			inverteStack();
			resp = stack2.pop();
			inverteStack();
			
		} catch (StackUnderflowException e) {

			throw new QueueUnderflowException();

		} catch (StackOverflowException e) {

		}

		return resp;
	}

	@Override
	public T head() {
		T resp = null;
		
		try {
			
			inverteStack();
			resp = stack2.top();
			inverteStack();
			
		} catch (StackUnderflowException e) {

		} catch (StackOverflowException e) {

		}

		return resp;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

	private void inverteStack() throws StackOverflowException, StackUnderflowException {
		
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} else {
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		}
	}
}
