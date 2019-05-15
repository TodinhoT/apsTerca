package escalonador;

import java.io.IOException;

public class Teste {
	public static void main(String[] args) throws IOException {
		Fila fila = new Fila();
		GerenciadorDeArquivo gf = new GerenciadorDeArquivo();
		int esp = 0;
		int virg = 0;
		int contP = 0;
		int contD = 0;
		int contC = 0;
		int contIO = 0;
		String[] process = new String[contP];

		System.out.println(gf.readFile());

		for (int i = 0; i < gf.readFile().length(); i++) {
			if (gf.readFile().charAt(i) == ' ') {
				esp++;
				if (gf.readFile().charAt(i) == 'P') {
					do {
						process[contP] += gf.readFile().charAt(i);
					} while (gf.readFile().charAt(i) != ' ');
					esp = 0;
				}
			}
		}

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
