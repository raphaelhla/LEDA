package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;
	private boolean testarNegativos;;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new ExtendedCountingSort();
		this.testarNegativos = true;
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	
	@Test
	public void testSort06() {
		Integer[] copy1 = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		Integer[] array = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		
		int leftIndex = 2;
		int rightIndex = 6;
		
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);

//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));
		
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort07() {
		Integer[] copy1 = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		Integer[] array = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		
//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));
		
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort08() {
		Integer[] copy1 = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		Integer[] array = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		
		int leftIndex = 3;
		int rightIndex = array.length - 1;
		
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		
//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));
		
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort09() {
		Integer[] copy1 = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		Integer[] array = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		
		int leftIndex = 3;
		int rightIndex = 7;
		
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		
//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));
		
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort10() {
		Integer[] copy1 = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		Integer[] array = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		
		int leftIndex = 3;
		int rightIndex = 3;
		
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		
//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));

		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort11() {
		Integer[] copy1 = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		Integer[] array = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		
		int leftIndex = 7;
		int rightIndex = 3;
		
		implementation.sort(array, leftIndex, rightIndex);
//		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		
//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));
		
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testSort12() {
		Integer[] copy1 = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		Integer[] array = { 29, 17, 20, 33, 8, 99, 5, 16, 55, 1 };
		
		int leftIndex = -5;
		int rightIndex = 3;
		
		implementation.sort(array, leftIndex, rightIndex);
//		Arrays.sort(copy1, leftIndex, rightIndex + 1);
		
//		System.out.println(Arrays.toString(copy1));
//		System.out.println(Arrays.toString(array));
		
		Assert.assertArrayEquals(copy1, array);
	}
	
	@Test
	public void testNegativos() {
		if (testarNegativos) {
			Integer[] copy1 = { -10, -20, -13, 0, 97, 37, -1, 22, 33, 12};
			Integer[] array = { -10, -20, -13, 0, 97, 37, -1, 22, 33, 12};
			
			int leftIndex = 0;
			int rightIndex = array.length-1;
			
			implementation.sort(array, leftIndex, rightIndex);
			Arrays.sort(copy1, leftIndex, rightIndex + 1);
			
//			System.out.println(Arrays.toString(copy1));
//			System.out.println(Arrays.toString(array));
			
			Assert.assertArrayEquals(copy1, array);
		}
	}
	
	@Test
	public void testNegativos2() {
		if (testarNegativos) {
			Integer[] copy1 = { -10, -20, -13, 0, 97, 37, -1, 22, 33, 12};
			Integer[] array = { -10, -20, -13, 0, 97, 37, -1, 22, 33, 12};
			
			int leftIndex = 2;
			int rightIndex = 6;
			
			implementation.sort(array, leftIndex, rightIndex);
			Arrays.sort(copy1, leftIndex, rightIndex + 1);
			
//			System.out.println(Arrays.toString(copy1));
//			System.out.println(Arrays.toString(array));
			
			Assert.assertArrayEquals(copy1, array);
		}
	}
}