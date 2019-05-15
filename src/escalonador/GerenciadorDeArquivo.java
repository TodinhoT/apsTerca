package escalonador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorDeArquivo {
	private int qtdLinhas = 0;
	private String[] linhas = new String[5];

	public void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (buffRead.ready()) {
			linha = buffRead.readLine();
			addLinha(linha);
			
			this.qtdLinhas++;
		}
		buffRead.close();
	}
	
	public void addLinha(String linha) {
		this.linhas[this.qtdLinhas] = linha;
	}
	
	public String[] getLinhas() {
		return linhas;
	}

	public int getQtdLinhas() {
		return qtdLinhas;
	}

}
