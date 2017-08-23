import java.util.Random;

/**
 * Gerador de instâncias aleatórias
 * 
 * @author Paulo Henrique Freitas Guimarães - Nº USP: 9390361 - Turma 04
 * @professor Doutor Alexandre da Silva Freire
 * @disciplina Algoritmos e Estruturas de Dados 1
 * 
 * Exercício de Programação 02
 * Comparando algoritmos de ordenação
 */
public class GeradorInstancias {
	
	/*
	 * --------------------
	 * Declaração de variáveis
	 * --------------------
	 */
	
	// Instância da classe Random, nos auxiliará a gerar números aleatórios em todos os tipos de geração, por isso é tido como um atributo de classe
	static Random random = new Random();
	
	/*
	 * --------------------
	 * Funções
	 * --------------------
	 */
	
	/*
	 * !!!!!!!!!!!!!!!!!!!!
	 * Em determinados momentos a divisão [(2^31)-1] pelo tamanho do vetor se faz necessária 
	 * para que não estouremos o tamanho dos inteiros em nenhum momento de nossa execução.
	 *  !!!!!!!!!!!!!!!!!!!!
	 */
	
	/**
	 * Instância Quase Ordenada. Dados parâmetros n e k, o método deve gerar um vetor com n 
	 * inteiros distintos em ordem crescente e depois fazer k trocas aleatórias
	 * 
	 * @param n
	 * Número de inteiros que serão adicionados ao vetor
	 * @param k
	 * Número de trocas que serão realizadas
	 * @return
	 * Vetor gerado
	 */
	public static int[] qo(int n, int k) {
		// Vetor de tamanho n
		int[] vetor=new int[n];
		
		// Criando o primeiro elemento
		vetor[0] = random.nextInt(((int)Math.pow(2, 31)-1)/n);
		
		// Populando o vetor, o fato de sempre somarmos com o elemento anterior faz com que nunca tenhamos dois elementos iguais e com que ele esteja em ordem crescente
		for(int i=1; i<n; i++) vetor[i] = random.nextInt(((int)Math.pow(2, 31)-1)/n) + vetor[i-1];
		
		// Efetuando as trocas
		for(int i=0; i<k; i++) {
			// Sorteia duas posições para serem trocadas
			int posicaoATrocar1 = random.nextInt(n);
			int posicaoATrocar2 = random.nextInt(n);
			// Efetua a troca
			int aux = vetor[posicaoATrocar1];
			vetor[posicaoATrocar1]=vetor[posicaoATrocar2];
			vetor[posicaoATrocar2]=aux;
		}
		return vetor;
	}
	
	/**
	 * Instância Em Ordem Decrescente. Dado um parâmetro n, o método deve gerar um vetor com n 
	 * inteiros distintos em ordem decrescente
	 * 
	 * @param n
	 * Tamanho do vetor a ser gerado
	 * @return
	 * Vetor gerado
	 */
	public static int[] eod(int n) {
		// Cria um vetor de tamanho n
		int[] vetor = new int[n];
		// O último elemento do vetor é criado
		vetor[n-1] = Math.abs(random.nextInt(Integer.MAX_VALUE));
		// Vai populando de forma cresce o vetor do final até o começo, ou seja, um vetor populado em ordem decrescente
		for(int i=n-2; i>=0; i--) vetor[i]=random.nextInt(Math.abs(((int)Math.pow(2, 31)-1)/n)) + vetor[i+1];
		return vetor;
	}
	
	/**
	 * Instância Gerada Aleatoriamente. Gera uma instância de tamanho n com números dispostos aleatoriamente 
	 * 
	 * @param n
	 * Tamanho do vetor gerado
	 * @return
	 * Vetor gerado
	 */
	public static int[] ga(int n) {
		// Cria um vetor de tamanho n
		int[] vetor = new int[n];
		// Popula o vetor
		for(int i=0; i<n; i++) vetor[i]=random.nextInt();
		return vetor;
	}
	
	/**
	 * Instância com Muitos Números Repeditos. Dados parâmetros n e k, o método deve gerar aleatoriamente um 
	 * vetor com n inteiros no intervalo de 1 a k (a ideia é que k seja uma fração de n: metade, um terços, etc...).
	 * 
	 * @param n
	 * Tamanho do vetor gerado
	 * @param k
	 * Intervalo aceitável para gerar números
	 * @return
	 * Vetor gerado
	 */
	public static int[] mnr(int n, int k) {
		// Cria um vetor de tamanho n
		int[] vetor=new int[n];
		// Gera um número de 0 a k-1 e soma 1, garantindo que qualquer número esteja no intervalo 1 ... k
		for(int i=0; i<n; i++) vetor[i]=random.nextInt(k)+1;
		return vetor;
	}
	
}