package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	/*
	 * Insere todos os elementos de um array na heap.
	 */
	private void insertAuxiliar(Integer[] array) {
		
		this.heap = new Integer[array.length];
		this.index = -1;
				
		for (Integer num : array)
			insert(num);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {

		Integer resp = null;

		if (array.length > 0) {

			insertAuxiliar(array);

			if (comparator.compare(1, 2) > 0)
				resp = floorMinHeap(numero, null);

			else
				resp = floorMaxHeap(numero, null);
		}

		return resp;
	}

	private Integer floorMaxHeap(double numero, Integer floor) {

		Integer resp = floor;

		if (!isEmpty()) {

			if (rootElement() <= numero) {
				resp = rootElement();

			} else {
				extractRootElement();
				resp = floorMaxHeap(numero, floor);
			}
		}

		return resp;
	}

	private Integer floorMinHeap(double numero, Integer floor) {

		Integer resp = floor;

		if (!isEmpty()) {

			if (rootElement() == numero) {
				resp = rootElement();

			} else if (rootElement() < numero) {
				Integer root = extractRootElement();
				resp = floorMinHeap(numero, root);
			}
		}

		return resp;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {

		Integer resp = null;

		if (array.length > 0) {

			insertAuxiliar(array);

			if (comparator.compare(1, 2) > 0)
				resp = ceilMinHeap(numero, null);

			else
				resp = ceilMaxHeap(numero, null);
		}

		return resp;
	}

	private Integer ceilMaxHeap(double numero, Integer ceil) {

		Integer resp = ceil;

		if (!isEmpty()) {

			if (rootElement() == numero) {
				resp = rootElement();

			} else if (rootElement() > numero) {
				Integer root = extractRootElement();
				resp = ceilMaxHeap(numero, root);
			}
		}

		return resp;
	}

	private Integer ceilMinHeap(double numero, Integer ceil) {

		Integer resp = ceil;

		if (!isEmpty()) {

			if (rootElement() >= numero) {
				resp = rootElement();

			} else {
				extractRootElement();
				resp = ceilMinHeap(numero, ceil);
			}
		}

		return resp;
	}

}
