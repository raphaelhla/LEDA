package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) 
			throw new QueueOverflowException();
		
		if (element != null)
			list.insert(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) 
			throw new QueueUnderflowException();
		
		T resp = head();
		list.removeFirst();

		return resp;
	}

	@Override
	public T head() {
		T resp = null;
		
		if (!isEmpty()) 
			resp = ((DoubleLinkedListImpl<T>) list).getHead().getData();
		
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() == this.size;
	}

}
