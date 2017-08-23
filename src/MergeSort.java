/**
 * Algoritmo de ordenação por mistura (MergeSort). Extende de AlgoritmoDeOrdenacao, ou seja, é um algoritmo 
 * de ordenação.
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Doutor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 02
 * Comparando algoritmos de ordenação
 */
public class MergeSort
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
	public MergeSort(int[] vetor, int inicio, int fim) {
		// Faz a mesma coisa que a classe mãe
		super(vetor, inicio, fim);
	}

	/*
	 * --------------------
	 * Métodos
	 * --------------------
	 */
	
	/**
	 * Quebra o vetor em intervalos e os ordena
	 * 
	 * @param vetor
	 * Vetor a ser ordenado
	 * @param inicio
	 * Início do trecho a ser ordenado
	 * @param fim
	 * Final do trecho a ser ordenado
	 */
	private void ordena(int[] vetor, int inicio, int fim) {
		
		// Quantos elementos existem
		int quantidade=fim-inicio;
		// Se for mais que um
		if(quantidade>1) {
			// Quebra no meio
			int meio=(fim+inicio)/2;
			// Ordena o trecho da esquerda
			ordena(vetor, inicio, meio);
			// Ordena o trecho da direita
			ordena(vetor, meio, fim);
			// Mistura
			merge(vetor, inicio, meio, fim);
		}
	}
	
	/**
	 * Mistura o vetor ordenado entre um trecho inicial e um miolo e este miolo e o fim
	 * 
	 * @param vetor
	 * Vetor base
	 * @param inicio
	 * Início do trecho a ser misturado e ordenado
	 * @param miolo
	 * Miolo do trecho a ser misturado e ordenado
	 * @param fim
	 * Final do trecho a ser misturado e ordenado
	 * @return
	 */
	private int[] merge(int[] vetor, int inicio, int miolo, int fim) {
		
		// Vetor resultado é do tamanho necessário
		int[] resultado=new int[fim-inicio];
		
		// Em que posição do vetor resultado estamos
		int atual=0;
		// Em que posição do trecho da esquerda estamos 
		int atual1=inicio;
		// Em que posição do tercho da direita estamos
		int atual2=miolo;
		
		// Enquanto existir elementos na esquerda ou na direita
		while(atual1<miolo && atual2<fim) {
			
			// Lê os elementos nas primeiras posições existentes nos vetores
			int valor1=vetor[atual1];
			int valor2=vetor[atual2];
			
			// Se o da esquerda for menor que o da direita
			if(valor1<valor2) {
				// Ele é enviado para o vetor resultado
				resultado[atual]=valor1;
				atual1++;
			}
			// Senão (direita maior ou igual o da esquerda)
			else {
				// Ele é enviado para o vetor resultado
				resultado[atual]=valor2;
				atual2++;
			}
			// Indiferentemente de qual é maior o atual no vetor resultado deve ser o próximo
			atual++;
		}
		
		/*
		 *  O tratamento abaixo é necessário para o caso em que no final das iterações ainda 
		 *  exista elementos no vetor da esquerda ou no da direita (número de elementos ímpar 
		 *  no trecho a ser ordenado)
		 */
		
		// Se ainda existir no da esquerda pode enviar na ordem natural para o vetor resultado (afinal, o trecho da esquerda já está ordenado)
		if(atual1<miolo) for(;atual1<miolo;) resultado[atual++]=vetor[atual1++];
		// Se ainda existir no da direita pode enviar na ordem natural para o vetor resultado (afinal, o trecho da direita já está ordenado)
		else if(atual2<fim) for(;atual2<fim;) resultado[atual++]=vetor[atual2++];
		
		// Reenvia do vetor resultado para o original
		// Isso afeta no desempenho do algoritmo
		for(int i=0; i<atual; i++) vetor[inicio+i]=resultado[i];
		
		return vetor;
	}
	
	@Override
	public int[] ordenar(int[] vetor, int inicio, int fim) {
		
		// Iniciando a contagem do tempo de execução
		tempoDeExecucao=System.nanoTime();
		
		// Ordena o trecho do vetor
		ordena(vetor, inicio, fim);
		// Mistura do iníco ao meio e do meio ao fim
		vetor = merge(vetor, inicio, ((fim+inicio)/2), fim);
		
		// Terminando a contagem do tempo de execução
		tempoDeExecucao=System.nanoTime()-tempoDeExecucao;
		
		return vetor;
	}
	
	@Override
	public String toString() { return "MergeSort"; }
	
}