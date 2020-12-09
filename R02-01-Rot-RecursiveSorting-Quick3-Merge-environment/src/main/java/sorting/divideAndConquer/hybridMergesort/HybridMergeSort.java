package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes: - Ter
 * contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 * que essa informação possa ser capturada pelo teste. - A cada chamado do
 * método de sort(T[] array) esses contadores são resetados. E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados. - O InsertionSort utilizado no
 * algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort algorithm
	 * will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		hybridMergeSort(array, leftIndex, rightIndex);
	}

	private void hybridMergeSort(T[] array, int leftIndex, int rightIndex) {

		if ((leftIndex < 0) || (rightIndex >= array.length)) 
			return;

		if (rightIndex - leftIndex < 0) 
			return;
		
		if ((rightIndex - leftIndex) + 1 > SIZE_LIMIT) {
			int middle = (leftIndex + rightIndex) / 2;

			hybridMergeSort(array, leftIndex, middle);
			hybridMergeSort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		} else {
			insertionSort(array, leftIndex, rightIndex);
		}
	}
	
	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		MERGESORT_APPLICATIONS ++;
		T[] arrayAux = Arrays.copyOf(array, array.length);

		int i = leftIndex;
		int j = middle + 1;
		int indexResult = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (arrayAux[i].compareTo(arrayAux[j]) <= 0) {
				array[indexResult] = arrayAux[i];
				i++;
			} else {
				array[indexResult] = arrayAux[j];
				j++;
			}
			indexResult++;
		}

		while (i <= middle) {
			array[indexResult] = arrayAux[i];
			i++;
			indexResult++;
		}
		while (j <= rightIndex) {
			array[indexResult] = arrayAux[j];
			j++;
			indexResult++;
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS++;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			
			int aux = i - 1;
			T key = array[i];
			
			while (aux >= leftIndex && array[aux].compareTo(key) > 0) {
				array[aux+1] = array[aux];
				aux--;	
			}
			array[aux+1] = key;
		}
	}
}
