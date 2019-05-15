package escalonador;

import java.io.IOException;

public class Teste {
	public static void main(String[] args) throws IOException{
		Fila fila = new Fila();
		GerenciadorDeArquivo gf = new GerenciadorDeArquivo();
		
		System.out.println(gf.readFile());
		
		fila.enqueue(5);
		fila.enqueue(6);
		fila.enqueue(7);
		
//		for(int j = 0; j < 3; j++) {
//			i = fila.dequeue();
//			System.out.println(i);
//		}
		
		System.out.println(fila.show());
		System.out.println(fila.peek());
		System.out.println(fila.size());
	
	}
}
