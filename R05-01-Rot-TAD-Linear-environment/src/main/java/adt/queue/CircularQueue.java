package adt.queue;

import java.util.Arrays;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		
		if (element != null) {
			if (isEmpty()) 
				head++;
			
			tail = (tail + 1) % array.length;
			array[tail] = element;
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();

		T resp = array[head];
		head = (head + 1) % array.length;
		elements--;
		
		if (isEmpty()) {
			head = -1;
			tail = -1;
		}
		
		return resp;
	}

	@Override
	public T head() {
		T resp = null;

		if (!isEmpty())
			resp = array[head];

		return resp;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}
}
