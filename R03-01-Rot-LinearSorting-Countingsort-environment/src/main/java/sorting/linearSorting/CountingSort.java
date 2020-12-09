package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if ((leftIndex < 0 || leftIndex >= array.length) || (rightIndex < 0 || rightIndex >= array.length))
			return;

		if (leftIndex < rightIndex) {

			int max = getMaxValue(array, leftIndex, rightIndex);
			
			int[] contador = new int[max + 1];
			Integer[] arrayAux = Arrays.copyOf(array, array.length);

			for (int i = leftIndex; i <= rightIndex; i++) {
				contador[array[i]] += 1;
			}

			for (int i = 1; i < contador.length; i++) {
				contador[i] += contador[i - 1];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				array[leftIndex + contador[arrayAux[i]] - 1] = arrayAux[i];
				contador[arrayAux[i]] -= 1;
			}
		}
	}

	/**
	 * Retorna o elemento de maior valor de um intervalo que vai de leftIndex ate
	 * rightIndex de um array.
	 * 
	 * @param array      Array
	 * @param leftIndex  LeftIndex
	 * @param rightIndex RightIndex
	 * 
	 * @return Retorna o elemento de maior valor de um intervalo que vai de
	 *         leftIndex ate rightIndex de um array.
	 */
	private int getMaxValue(Integer[] array, int leftIndex, int rightIndex) {
		int max = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}
}
