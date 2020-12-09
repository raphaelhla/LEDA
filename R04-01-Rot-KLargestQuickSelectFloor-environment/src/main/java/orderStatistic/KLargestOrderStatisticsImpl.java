package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		
		if (k < 1 || k > array.length) {
			T[] resp = (T[]) new Comparable[0];
			return resp;
		}
		if (k == array.length) {
			return array;
		}
		
		T[] resp = (T[]) new Comparable[k];
		int indResp = 0;
		T statistic = orderStatistics(array, array.length - k);
		
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(statistic) > 0) {
				resp[indResp] = array[i];
				indResp++;
			}
		}
		return resp;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		if (k < 1 || k > array.length) {
			return null;
		}
		
		T resp = null;
		
		int menor;
		for (int i = 0; i < array.length; i++) {
			menor = i;
			for (int j = i; j < array.length; j++) {
				if (array[menor].compareTo(array[j]) > 0) {
					menor = j;
				}
			}
			Util.swap(array, i, menor);
			
			if (i == k-1) {
				resp = array[i];
				break;
			}
		}
		
		return resp;
	}
}
