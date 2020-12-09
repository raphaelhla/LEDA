package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length))
			return;

		if (leftIndex < rightIndex) {

			int min = getMinAndMax(array, leftIndex, rightIndex)[0];
			int max = getMinAndMax(array, leftIndex, rightIndex)[1];

			int[] contador = new int[max - min + 1];
			Integer[] arrayAux = Arrays.copyOf(array, array.length);

			for (int i = leftIndex; i <= rightIndex; i++) {
				contador[array[i] - min] += 1;
			}

			for (int i = 1; i < contador.length; i++) {
				contador[i] += contador[i - 1];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				array[leftIndex + contador[arrayAux[i] - min] - 1] = arrayAux[i];
				contador[arrayAux[i] - min] -= 1;
			}
		}
	}

	/**
	 * Retorna um array com o menor e o maior valor de um intervalo que vai de
	 * leftIndex ate rightIndex de um array. O menor valor eh armazenado no indice 0
	 * do array, e o elemento de maior valor eh armazenado no indice 1 do array
	 * 
	 * @param array      Array
	 * @param leftIndex  LeftIndex
	 * @param rightIndex RightIndex
	 * 
	 * @return Retorna o elemento de maior valor de um intervalo que vai de
	 *         leftIndex ate rightIndex de um array.
	 */
	private Integer[] getMinAndMax(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		int min = array[leftIndex];

		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > max)
				max = array[i];

			if (array[i] < min)
				min = array[i];
		}

		Integer[] resp = new Integer[] { min, max };
		return resp;
	}
}
