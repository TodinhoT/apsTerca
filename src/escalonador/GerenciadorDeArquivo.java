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

	public void createFile() throws IOException {
		File file = new File("APS.txt");

		if (!file.exists()) {
			file.createNewFile();

			FileWriter writer = new FileWriter(file);
			BufferedWriter bfWriter = new BufferedWriter(writer);

			bfWriter.write("XIMIRA");

			bfWriter.close();
		} else {
			FileWriter writer = new FileWriter(file);
			BufferedWriter bfWriter = new BufferedWriter(writer);

			bfWriter.write("P1 9 10 2,4,6,8\n");
			bfWriter.write("P2 10 4 5\n");
			bfWriter.write("P3 5 0 2\n");
			bfWriter.write("P4 7 1 3,6\n");
			bfWriter.write("P5 2 17");

			bfWriter.close();
		}
	}

	public String leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String txt = "";
		while (buffRead.ready()) {
			txt += buffRead.readLine() + " ";
		}

		buffRead.close();

		return txt;
	}

	public String leitor1(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		String txt = "";

		while (buffRead.ready()) {
			linha = buffRead.readLine();
			addLinha(linha);
			txt += linha + " ";
			
			this.qtdLinhas++;
		}
		buffRead.close();
		return txt;
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
