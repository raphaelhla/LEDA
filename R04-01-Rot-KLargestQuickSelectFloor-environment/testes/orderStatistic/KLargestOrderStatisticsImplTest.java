package orderStatistic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KLargestOrderStatisticsImplTest {

	KLargestOrderStatisticsImpl<Integer> kl;
	Integer[] array;
	Integer[] array2;
	
	@BeforeEach
	public void before() {
		kl = new KLargestOrderStatisticsImpl<Integer>();
		array = new Integer[] {9,8,7,6,5};
		array2 = new Integer[] {};
	}
	
	@Test
	void test() {
		Integer[] saidaEsperada = new Integer[] {};
		Integer[] saidaReal = kl.getKLargest(array2, 1);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}
	
	@Test
	void test2() {
		Integer[] saidaEsperada = new Integer[] {9};
		Comparable[] saidaReal = kl.getKLargest(array, 1);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}
	
	@Test
	void test3() {
		Integer[] saidaEsperada = new Integer[] {9,8};
		Comparable[] saidaReal = kl.getKLargest(array, 2);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}

	@Test
	void test4() {
		Integer[] saidaEsperada = new Integer[] {9,8,7};
		Comparable[] saidaReal = kl.getKLargest(array, 3);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}
	
	@Test
	void test5() {
		Integer[] saidaEsperada = new Integer[] {9,8,7,6};
		Comparable[] saidaReal = kl.getKLargest(array, 4);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}
	
	@Test
	void test7() {
		Integer[] saidaEsperada = new Integer[] {9,8,7,6,5};
		Comparable[] saidaReal = kl.getKLargest(array, 5);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}
	
	@Test
	void test8() {
		Integer[] saidaEsperada = new Integer[] {};
		Comparable[] saidaReal = kl.getKLargest(array, 6);
		Arrays.sort(saidaEsperada);
		Arrays.sort(saidaReal);
		assertArrayEquals(saidaEsperada, saidaReal);
	}
}
