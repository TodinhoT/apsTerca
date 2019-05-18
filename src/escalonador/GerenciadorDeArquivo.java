package escalonador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorDeArquivo {
	private int qtdLinhas = 0;
	private Fila linhas;
	
	
	public GerenciadorDeArquivo() {
		this.linhas = new Fila();
	}

	public void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (buffRead.ready()) {
			linha = buffRead.readLine();
			if(linha != null) {
				linhas.enqueueLinha(linha);
			}
			this.qtdLinhas++;
		}
		buffRead.close();
	}
	
	public Fila getLinhas() {
		return linhas;
	}

	public int getQtdLinhas() {
		return qtdLinhas;
	}

}
