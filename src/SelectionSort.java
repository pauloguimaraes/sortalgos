/**
 * Algoritmo de ordenação por seleção (SelectionSort). Extende de AlgoritmoDeOrdenacao, ou 
 * seja, é um algoritmo de ordenação.
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 02
 * Comparando algoritmos de ordenação
 */
public class SelectionSort
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
	 * Final do trecho a ser ordenado
	 */
	public SelectionSort(int[] vetor, int inicio, int fim) {
		// Faz a mesma coisa que a classe mãe
		super(vetor, inicio, fim);
	}

	@Override
	public int[] ordenar(int[] vetor, int inicio, int fim) {
		
		// Iniciando a contagem do tempo de execução
		tempoDeExecucao = System.nanoTime();
		
		// Vai do início até o final
		for(int atual=inicio; atual<fim-1; atual++) {
			// Busca o menor no intervalo do atual até o fim
			int menor=buscaMenor(vetor, atual, fim);
			// Troca o menor com o atual
			troca(vetor, menor, atual);
		}
		
		// Terminando a contagem do tempo de execução
		tempoDeExecucao = System.nanoTime()-tempoDeExecucao;
		return vetor;
	}
	
	@Override
	public String toString() { return "SelectionSort"; }
	
}