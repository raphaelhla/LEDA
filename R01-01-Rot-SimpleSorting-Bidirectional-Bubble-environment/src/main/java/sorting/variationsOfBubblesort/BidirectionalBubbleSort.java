package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			return;
		}
		
		for (int i = 0; i <= rightIndex - leftIndex; i++) {
			
			for (int j = leftIndex + 1 + i; j <= rightIndex - i; j++) {
				if (array[j - 1].compareTo(array[j]) > 0) {
					Util.swap(array, j - 1, j);
				}
			}
			
			for (int j = rightIndex - i; j > leftIndex + i; j--) {
				if (array[j-1].compareTo(array[j]) > 0) {
					Util.swap(array, j - 1, j);
				}
			}

		}
	}
}
