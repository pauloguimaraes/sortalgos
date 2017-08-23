/**
 * Algoritmo de ordenação por inserção (InsertionSort). Extende de AlgoritmoDeOrdenacao, ou seja, é um
 * algoritmo de ordenação.
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Doutor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 02
 * Comparando algoritmos de ordenação
 */
public class InsertionSort
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
	 * Vetor a ser ordenado
	 * @param inicio
	 * Início do trecho a ser ordenado
	 * @param fim
	 * Final do trecho a ser ordenado
	 */
	public InsertionSort(int[] vetor, int inicio, int fim) {
		// Faz a mesma coisa que a classe mãe
		super(vetor, inicio, fim);
	}
	
	/*
	 * --------------------
	 * Métodos sobrescritos
	 * --------------------
	 */
	
	@Override
	protected int[] ordenar(int[] vetor, int inicio, int fim) {
		
		// Iniciando a contagem do tempo de execução
		tempoDeExecucao = System.nanoTime();
		
		// Percorre da primeira até a última posição do vetor
		for(int atual=inicio+1; atual<fim; atual++) {
			// O elemento analisado é o atual
			int analisado=atual;
			// Se a posição analisada é maior que a primeira e o elemento analisado é menor que o anterior
			while(analisado>inicio && vetor[analisado]<vetor[analisado-1]) {
				// Troca o elmento e continua analisando sentido início do vetor
				troca(vetor, analisado, analisado-1);
				analisado--;
			}
		}
		
		// Terminando a contagem do tempo de execução
		tempoDeExecucao = System.nanoTime()-tempoDeExecucao;
		return vetor;
	}
	
	@Override
	public String toString() { return "InsertionSort"; }
	
}