package escalonador;

import java.io.IOException;
import java.util.Arrays;

public class Teste {
	public static void main(String[] args) throws IOException {
		GerenciadorDeArquivo gf = new GerenciadorDeArquivo();
		String path = "APS.txt";
		String pid = "";
		int duracao = 0, chegada = 0;
		String[] linhas = new String[gf.getQtdLinhas()];

		Processo[] processos = new Processo[5];

		gf.leitor(path);
		linhas = gf.getLinhas().clone();
//-------------------- Guardar todos os processos a partir do arquivo -------------------------------------
		for (int i = 0; i < linhas.length; i++) {
			String[] temp = linhas[i].split("\\s");

			for (int j = 0; j < temp.length + 1; j++) {
				switch (j) {
				case 0:
					pid = temp[0];
					break;
				case 1:
					duracao = Integer.parseInt(temp[1]);
					break;
				case 2:
					chegada = Integer.parseInt(temp[2]);
					break;
				case 3:
					if (temp.length == 4) {
						String tempIos[] = temp[3].split(",");
						Fila filaOperacaoIO = new Fila();
						for (int k = 0; k < tempIos.length; k++) {
							filaOperacaoIO.enqueue(Integer.parseInt(tempIos[k]));
						}
						Processo processo = new Processo(pid, duracao, chegada, filaOperacaoIO);
						processos[i] = processo;
					} else {
						Processo processo = new Processo(pid, duracao, chegada);
						processos[i] = processo;
					}
					break;
				}
			}
		}

		for (int i = 0; i < processos.length; i++) {
			System.out.println(processos[i].getPid());
			System.out.println(processos[i].getDuracao());
			System.out.println(processos[i].getChegada());
			System.out.println(processos[i].getOperacaoIO().show());
			System.out.println("--------------------------------------------------------------------------");
		}
//------------ escalonador ----------------------------------
		Fila filaProcessos = new Fila();
		Fila CPU = new Fila();
		Processo[] posicao = new Processo[1];
		int global = 0;
		String fila = "";

		for (int i = 0; i < processos.length; i++) {
			for (int j = 0; j < processos.length - 1; j++) {
				if (processos[j].getChegada() > processos[j + 1].getChegada()) {
					posicao[0] = processos[j];
					processos[j] = processos[j + 1];
					processos[j + 1] = posicao[0];

				}
			}
		}

		for (int i = 0; i < processos.length; i++) {
			filaProcessos.enqueueProcesso(processos[i]);
		}

		posicao[0] = null;
		while (global < 5) {
			for (int i = 0; i < processos.length; i++) {
				if (global <= processos[processos.length - 1].getChegada()) {
					if(processos[i].getChegada() == global) {
						System.out.println("PROCESSO CHEGOU");
						CPU.enqueueProcesso(processos[i]);
						for(int j = 0; j < 4; j++) {
							if(j == 0) {
								posicao[0] = CPU.dequeueProcesso();
							}
							if(j == 3) {
								System.out.println("QUANTUM ATINGIDO");
								CPU.enqueueProcesso(processos[0]);
							}
							if(posicao[0].getOperacaoIO().peek() == global) {
								CPU.enqueueProcesso(posicao[0]);
								posicao[0] =CPU.dequeueProcesso();
							}
						}
					}
				}else {
					posicao[0] = filaProcessos.dequeueProcesso();
				}
			}
			if (filaProcessos.peekProcesso().getChegada() == global) {
				posicao[0] = filaProcessos.dequeueProcesso();
				for (int j = 0; j < 4; j++) {
					if (posicao[0].getOperacaoIO().peek() == posicao[0].getTempExecucao()) {
						posicao[0].getOperacaoIO().dequeue();
						System.out.println("OPERACAO I/O <" + posicao[0].getPid() + ">");
						break;
					}

					posicao[0].setTempExecucao(posicao[0].getTempExecucao() + 1);
					posicao[0].setDuracao(posicao[0].getDuracao() - 1);
				}
				filaProcessos.enqueueProcesso(posicao[0]);
			} else if (posicao[0] == null) {

			}
			global++;
		}
	}

}
