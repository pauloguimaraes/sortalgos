import java.io.FileNotFoundException;
import java.util.Random;

public class Teste {
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		PrintStream out = new PrintStream(new FileOutputStream("output10.txt"));
//		System.setOut(out);
		
		int count=1;
		
		String parametros = "Foi usado o seguinte parÃ¢metro para definir o tamanho das instÃ¢ncias de teste:\n\n" +
				" - InstÃ¢ncias de tamanho n, tal que n=(97,102,107) sÃ£o pequenas;\n" +
				" - InstÃ¢ncias de tamanho n^2 sÃ£o instÃ¢ncias mÃ©dias;\n" +
				" - InstÃ¢ncias de tamanho (n^2)*(n/2) sÃ£o instÃ¢ncias grandes.\n\n" +
				"Segue abaixo as execuÃ§Ãµes:\n\n\n";
		
		String[] tipos = { "InstÃ¢ncias pequenas", "InstÃ¢ncias mÃ©dias", "InstÃ¢ncias Grandes" };
		
		System.out.print(parametros);
		for(int tiposDeInstancia=0; tiposDeInstancia<tipos.length; tiposDeInstancia++) {
			
			System.out.println("******************************************************");
			System.out.println(tipos[tiposDeInstancia]);
			System.out.println("******************************************************\n\n");
			
			int contador=92;
			
			for(int instancia=0; instancia<4; instancia++) {
				
				contador=92;
				
				for(int casos=0; casos<3; casos++) {
					
					contador+=5;
					
					System.out.println("######################################################");
					System.out.println("INÃ�CIO DO CASO DE TESTE " + count);
					System.out.println("######################################################");
					
					int tamanho=contador;
					if(tiposDeInstancia==1) tamanho=((int)Math.pow(tamanho,2));
					else if(tiposDeInstancia==2) tamanho=((int)Math.pow(tamanho,2))*(tamanho/2);
					int[] original;
					String tipoDeOrdenacao="";
					switch(instancia) {
					
						case 0:
							tipoDeOrdenacao="em ordem decrescente";
							original = GeradorInstancias.eod(tamanho);
							break;
							
						case 1:
							tipoDeOrdenacao="gerado aleatoriamente";
							original = GeradorInstancias.ga(tamanho);
							break;
							
						case 2:
							tipoDeOrdenacao="com muitos nÃºmeros repetidos";
							original = GeradorInstancias.mnr(tamanho, tamanho/3);
							break;
							
						default:
							tipoDeOrdenacao="quase ordenadas";
							original = GeradorInstancias.qo(tamanho, new Random().nextInt(tamanho));
							break;
					
					}
					
					int[] v = new int[original.length];
					for(int i=0; i<v.length; i++) v[i]=original[i];
					
					System.out.println("\n\nVetor original gerado com " +tamanho+ " elementos, usando um algoritmo que gerÃ¡ um vetor " + tipoDeOrdenacao);
					System.out.print("[");
					for(int i=0; i<v.length; i++){
						if((i!=0) && (i%100==0)) System.out.println(original[i]);
						else System.out.print(original[i]);
						if(i<v.length-1) System.out.print(", ");
					}
					System.out.print("]");
					
					System.out.println("\n\n");
					
					for(int algoritmos=0; algoritmos<5; algoritmos++) {
						
						AlgoritmoDeOrdenacao ao;
						
						switch(algoritmos) {
						
							case 0:
								ao = new InsertionSort(v, 0, v.length);
								break;
							case 1:
								ao = new SelectionSort(v, 0, v.length);
								break;
							case 2:
								ao = new MergeSort(v, 0, v.length);
								break;
							case 3:
								ao=new QuickSort(v, 0, v.length);						
								break;
							default:
								ao = new HeapSort(v, 0, v.length);
								break;
								
						}
						
						System.out.println(ao.toString()+": ");
						System.out.print("[");
						for(int i=0; i<v.length; i++){
							if((i!=0) && (i%100==0)) System.out.println(v[i]);
							else System.out.print(v[i]);
							if(i<v.length-1) System.out.print(", ");
						}
						System.out.print("]");
						System.out.println("\n");
						System.out.println("O " + ao.toString() + " ordenou o vetor em " + (ao.tempoDeExecucao/1000000) + "ms, fazendo " + ao.trocas + " trocas.");
						System.out.println("\n");
						
						System.out.println("--------------------------------------------------\n");
						
					}
					
					count++;
					System.out.println("######################################################");
					System.out.println("FIM DO CASO DE TESTE " + (count-1));
					System.out.println("######################################################");
					
				}
				
			}
			
		}
		
	}

}