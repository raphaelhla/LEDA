package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			return;
		}
		
		int aux;
		T key;
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			aux = i - 1;
			key = array[i];
			while (aux >= leftIndex && array[aux].compareTo(key) > 0) {
				array[aux+1] = array[aux];
				aux--;
			}
			array[aux+1] = key;
		}
	}
}
