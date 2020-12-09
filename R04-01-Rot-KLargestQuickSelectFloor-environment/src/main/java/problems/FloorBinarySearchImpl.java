package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length - 1);
		
		if (array.length == 0) 
			return null;
		
		if (array[0] > x)
			return null;

		if (array[array.length - 1] <= x)
			return array[array.length - 1];

		
		Integer floor = floorBinarySearch(array, 0, array.length - 1, x, -1);

		return array[floor];
	}

	private Integer floorBinarySearch(Integer[] array, int leftIndex, int rightIndex, Integer x, Integer floor) {
		int middle = (leftIndex + rightIndex) / 2;

		if (leftIndex > rightIndex) {
			return floor;
		}

		if (array[middle] == x) {
			return middle;
		} else if (array[middle] > x) {
			return floorBinarySearch(array, leftIndex, middle - 1, x, floor);
		} else {
			return floorBinarySearch(array, middle + 1, rightIndex, x, middle);
		}
	}

	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {

		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length)) {
			return;
		}

		if (leftIndex < rightIndex) {

			medianaPivot(array, leftIndex, rightIndex);
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot - 1);
			quickSort(array, pivot + 1, rightIndex);
		}
	}

	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int pivot = leftIndex;
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(array[pivot]) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, pivot, i);

		return i;
	}

	private void medianaPivot(Integer[] array, int leftIndex, int rightIndex) {
		int middle = (leftIndex + rightIndex) / 2;

		if (array[rightIndex].compareTo(array[leftIndex]) < 0)
			Util.swap(array, rightIndex, leftIndex);
		if (array[middle].compareTo(array[leftIndex]) < 0)
			Util.swap(array, middle, leftIndex);
		if (array[rightIndex].compareTo(array[middle]) < 0)
			Util.swap(array, rightIndex, middle);
		
		Util.swap(array, leftIndex, middle);
	}
}
