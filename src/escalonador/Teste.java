package escalonador;

import java.io.IOException;
import java.util.Arrays;

public class Teste {
	public static void main(String[] args) throws IOException {
		GerenciadorDeArquivo gf = new GerenciadorDeArquivo();
		String path = "APS.txt";
		int esp = 0;
		int virg = 0;
		int contP = 0;
		int contD = 0;
		int contC = 0;
		int contIO = 0;
		String[] process = new String[contP];
		String[] global = gf.leitor(path).split("\\s");

//		System.out.println(gf.readFile());
//
//		for (int i = 0; i < gf.readFile().length(); i++) {
//			if (gf.readFile().charAt(i) == ' ') {
//				esp++;
//				if (gf.readFile().charAt(i) == 'P') {
//					do {
//						process[contP] += gf.readFile().charAt(i); //pegar os caracteres
//					} while (gf.readFile().charAt(i) != ' '); //até proximo ESPAÇO
//					esp = 0;
//				}
//			}
//		}
		
		System.out.println(Arrays.toString(global));

	}
}
