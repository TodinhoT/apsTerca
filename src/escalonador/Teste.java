package escalonador;

import java.io.IOException;
import java.util.Arrays;

public class Teste {
	public static void main(String[] args) throws IOException {
		GerenciadorDeArquivo gf = new GerenciadorDeArquivo();
		String path = "APS.txt";

		String[] global = gf.leitor(path).split("\\s");

		System.out.println(Arrays.toString(global));
		gf.leitor1(path);
		String[] global1 = gf.getLinhas();
		System.out.println(Arrays.toString(global1));
		
//		System.out.println(gf.leitor1(path));
//		System.out.println(gf.getQtdLinhas());
		
		

	}

}
