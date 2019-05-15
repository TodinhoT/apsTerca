package escalonador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorDeArquivo {
	
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

	public String readFile() throws IOException {
		FileReader reader = new FileReader("APS.txt");
		BufferedReader bfReader = new BufferedReader(reader);
		String txt = "";
		while (bfReader.ready()) {
			txt += bfReader.readLine();
		}

		bfReader.close();
		
		return txt.toString();
	}
}
