/**
 * Classe abstrata que representa um modelo padrão que todos os algoritmos de ordenação devem seguir.
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Doutor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 02
 * Comparando algoritmos de ordenação
 */
public abstract class AlgoritmoDeOrdenacao {
	
	/*
	 * --------------------
	 * Declaração de variáveis
	 * --------------------
	 */
	
	// Tempo de execução do programa
	public long tempoDeExecucao;
	// Número de trocas que ele efetua
	public long trocas;
	
	/*
	 * --------------------
	 * Construtores
	 * --------------------
	 */
	
	/**
	 * Construtor padrão
	 */
	protected AlgoritmoDeOrdenacao() {
		// Inicializa o tempo de execução e o número de trocas como 0
		tempoDeExecucao=0;
		trocas=0;
	}
	
	/**
	 * Construtor com parâmetros
	 * 
	 * @param vetor
	 * @param inicio
	 * @param fim
	 */
	public AlgoritmoDeOrdenacao(int[] vetor, int inicio, int fim) {
		// Invoca o construtor padrão
		this();
		// Inicia a ordenação dos elementos passados como parâmetro
		ordenar(vetor,inicio,fim);
	}
	
	/*
	 * --------------------
	 * Métodos
	 * --------------------
	 */
	
	/**
	 * Ordena determinado trecho do vetor
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho a ser ordenado
	 * @param fim
	 * Final do trecho a ser ordenado
	 * @return
	 * O vetor com o trecho selecionado ordenado
	 */
	protected abstract int[] ordenar(int[] vetor, int inicio, int fim);
	
	/**
	 * Busca o menor elemento em determinado trecho de um vetor
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho em que se quer encontrar o menor
	 * @param fim
	 * Final do trecho em que se quer encontrar o menor
	 * @return
	 * A posição em que esse elemento se encontra
	 */
	public int buscaMenor(int[] vetor, int inicio, int fim) {
		// Menor é o início do trecho na primeira iteração
		int menor=inicio;
		// Percorre todo o trecho e compara se existe alguém menor que o menor já conhecido
		for(int atual=inicio; atual<fim; atual++)
			// Se existir esse será o novo menor conhecido
			if(vetor[atual]<vetor[menor]) menor=atual;
		return menor;
	}
	
	/**
	 * Troca dois elementos nos índices passados como parâmetro
	 * 
	 * @param vetor
	 * Vetor base
	 * @param indexUm
	 * Primeiro índice
	 * @param indexDois
	 * Segundo índice
	 */
	public void troca(int[] vetor, int indexUm, int indexDois) {
		// Trocando
		int aux = vetor[indexUm];
		vetor[indexUm] = vetor[indexDois];
		vetor[indexDois] = aux;
		// Incrementando o número de trocas que este algoritmo faz
		trocas++;
	}
	
	/**
	 * Verifica se determinado trecho do vetor está ordenado
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho a ser verificado
	 * @param fim
	 * Final do trecho a ser verificado
	 * @return
	 * true se estiver, false se não
	 */
	public boolean estaOrdenado(int[] vetor, int inicio, int fim) {
		for(int i=inicio+1; i<fim; i++) if(vetor[i]<vetor[i-1])
			return false;
		return true;
	}
	
}