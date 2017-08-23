/**
 * Algoritmo de ordenação rápido (QuickSort, na tradução liretal). Extende de AlgoritmoDeOrdenacao, 
 * ou seja, é um algoritmo de ordenação.
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Doutor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 02
 * Comparando algoritmos de ordenação
 */
public class QuickSort
	extends AlgoritmoDeOrdenacao {
	
	/*
	 * --------------------
	 * Construtores
	 * --------------------
	 */

	/**
	 * Construtor com parâmetros
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho a ser ordenado
	 * @param fim
	 * Final do Trecho a ser ordenado
	 */
	public QuickSort(int[] vetor, int inicio, int fim) {
		// Faz a mesma coisa que a classe mãe
		super(vetor, inicio, fim-1);
	}

	/*
	 * --------------------
	 * Métodos
	 * --------------------
	 */
	
	/**
	 * Ordena determinado trecho de um vetor
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho a ser ordenado
	 * @param fim
	 * Final do trecho a ser ordenado
	 */
	private void ordena(int[] vetor, int inicio, int fim) {
		
		int i = inicio;
		int j = fim;
		int pivo = vetor[(i+j)/2];
		
		while(i<j) {
			while(vetor[i]<pivo) i++;
			while(vetor[j]>pivo) j--;
			if(i<=j) {
				troca(vetor, i, j);
				i++;
				j--;
			}
		}
		
		if(j>inicio) ordena(vetor, inicio, j);
		if(i<fim) ordena(vetor, i, fim);
		
	}
	
	/*
	 * --------------------
	 * Métodos sobrescritos
	 * --------------------
	 */
	
	@Override
	protected int[] ordenar(int[] vetor, int inicio, int fim) {
		tempoDeExecucao=System.nanoTime();
		ordena(vetor, inicio, fim);
		tempoDeExecucao=System.nanoTime()-tempoDeExecucao;
		return vetor;
	}
	
	@Override
	public String toString() { return "QuickSort"; }
	
}