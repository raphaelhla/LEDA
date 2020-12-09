package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) 
			throw new StackOverflowException();
		
		if (element != null)
			top.insert(element);

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) 
			throw new StackUnderflowException();
		
		T resp = top();
		this.top.removeLast();
		
		return resp;
	}

	@Override
	public T top() {
		T resp = null;
		
		if (!isEmpty()) 
			resp = ((DoubleLinkedListImpl<T>) top).getLast().getData();
		
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
