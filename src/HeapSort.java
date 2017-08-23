/**
 * Algoritmo de ordenação por amontoamento (HeapSort). Extende a classe AlgoritmoDeOrdenacao, 
 * ou seja, é um algoritmo de ordenação
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 1
 * Comparando algoritmos de ordenação
 */
public class HeapSort
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
	 * Início do trecho que se quer ordenar
	 * @param fim
	 * Final do trecho que se quer ordenar
	 */
	public HeapSort(int[] vetor, int inicio, int fim) {
		// Faz a mesma coisa que a classe mãe
		super(vetor, inicio, fim);
	}

	/*
	 * --------------------
	 * Métodos
	 * --------------------
	 */
	
	/**
	 * Constroi um heap máximo em determinado trecho de um vetor
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho onde será construíduo um heap máximo
	 * @param term
	 * Final do trecho onde será construído um heap máximo
	 */
	private void constroiHeapMaximo(int[] vetor, int inicio, int term) {
		// Percorre rearranjando para formar um heap máximo
		for(int i=(term)/2-1; i>=inicio; i--) refazHeapMaximo(vetor, i, term);
	}
	
	/**
	 * Remonta um heap máximo depois que já foi feito um (não necessariamente)
	 * 
	 * @param vetor
	 * Vetor base
	 * @param analisada
	 * Posição que está sendo analisada no momento
	 * @param term
	 * Última posição a ser considerada
	 */
	private void refazHeapMaximo(int vetor[], int analisada, int term) {
		
		// Posição que possui o maior elemento
		int max;
		// Elemento da esquerda
		int esquerda=2*analisada+1;
		// elemento da direita
		int direita=2*analisada+2;
		
		// Se o elemento da esquerda existir e for maior que a analisada, a maior será a da esquerda
		if(esquerda<term && vetor[esquerda]>vetor[analisada]) max=esquerda;
		// Senão a maior será a própria analisada
		else max=analisada;
		
		// Se o elemento da direita existir e for maior que o maior conhecido, a maior será a da direita
		if(direita<term && vetor[direita]>vetor[max]) max=direita;
		
		// Se a maior não for a analisada
		if(max != analisada) {
			// Troca a analisada com a maior
			troca(vetor, analisada, max);
			// Refaz o Heap máximo
			refazHeapMaximo(vetor, max, term);
		}
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
		
		// Inicia a modelagem do heap maximo
		int compHeap=fim;
		// Constrói o heap inicial
		constroiHeapMaximo(vetor, inicio, fim);
		// Percorre o vetor modelando o heap
		for(int i=fim-1; i>inicio; --i) {
			// Rearranja
			troca(vetor, inicio, i);
			compHeap--;
			// Monta o heap
			refazHeapMaximo(vetor, inicio, compHeap);
		}
		
		// Terminando a contagem do tempo de execução
		tempoDeExecucao = System.nanoTime()-tempoDeExecucao;
		
		return vetor;
	}
	
	@Override
	public String toString() { return "HeapSort"; }
	
}