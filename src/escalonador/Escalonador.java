package escalonador;

import java.io.IOException;

public class Escalonador {
	public static void main(String[] args) throws IOException {
		GerenciadorDeArquivo gf = new GerenciadorDeArquivo();
		String path = "APS.txt";
		String pid = "";
		int duracao = 0, chegada = 0;


		gf.leitor(path);
		
		Processo[] processos = new Processo[gf.getLinhas().size()];
//-------------------- Guardar todos os processos a partir do arquivo -------------------------------------
		for (int i = 0; i < processos.length; i++) {
			String[] temp = gf.getLinhas().dequeueLinha().split("\\s");

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

//------------ escalonador ----------------------------------
		Fila filaProcessos = new Fila();
		Fila CPU = new Fila();
		Processo[] posicao = new Processo[1];
		int global = 0;
		
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
		
		System.out.println("**************************************");
		System.out.println("*******ESCALONADOR ROUND ROBIN********");
		System.out.println("--------------------------------------");
		System.out.println("-------Comecando a simulacao----------");
		System.out.println("--------------------------------------");
		
		posicao[0] = null;
		int doneCounter = 0;
		int IOverif = 0;
		while (true) {
			for (int j = 0; j < 4; j++, global++) {
				IOverif = 0;
				System.out.println("-------TEMPO " + global + "-------");

				if (!filaProcessos.isEmpty()) {
					if (global == filaProcessos.peekProcesso().getChegada()) {
						if (posicao[0] == null) { // Se a CPU estiver vazia
							posicao[0] = filaProcessos.dequeueProcesso(); // O processo n�o precisa ir para a fila da
																			// CPU
							System.out.println("#[evento] PROCESSO " + posicao[0].getPid() + " CHEGOU");
						} else {
							System.out.println("#[evento] PROCESSO " + filaProcessos.peekProcesso().getPid() + " CHEGOU");
							if (posicao[0].getTempExecucao() == posicao[0].getOperacaoIO().peek()
									|| j == 3 && posicao[0].getTempExecucao() < posicao[0].getDuracao()) {
								if (posicao[0].getTempExecucao() == posicao[0].getOperacaoIO().peek()) {
									System.out.println("#[evento] OPERACAO I/O <" + posicao[0].getPid() + ">");
									posicao[0].getOperacaoIO().dequeue();
								}
								if (j == 3 && posicao[0].getTempExecucao() < posicao[0].getDuracao()) {
									System.out.println("#[evento] QUANTUM ATINGIDO " + posicao[0].getPid());
								}
								CPU.enqueueProcesso(posicao[0]);
								posicao[0] = CPU.dequeueProcesso();
								CPU.enqueueProcesso(filaProcessos.dequeueProcesso()); // O processo entra na fila da CPU
								IOverif = 1;
								j = -1;
							} else {
								CPU.enqueueProcesso(filaProcessos.dequeueProcesso());
							}
						}
					}
				}

				if (posicao[0].getTempExecucao() == posicao[0].getOperacaoIO().peek() && IOverif != 1) {
					System.out.println("#[evento] OPERACAO I/O <" + posicao[0].getPid() + ">");
					posicao[0].getOperacaoIO().dequeue();
					CPU.enqueueProcesso(posicao[0]);
					posicao[0] = CPU.dequeueProcesso();
					j = -1;
				}
				if (j == 3 && posicao[0].getTempExecucao() < posicao[0].getDuracao()) {
					System.out.println("#[evento] QUANTUM ATINGIDO " + posicao[0].getPid());
					CPU.enqueueProcesso(posicao[0]);
					posicao[0] = CPU.dequeueProcesso();
				}
				if (posicao[0].getTempExecucao() == posicao[0].getDuracao()) {
					System.out.println("#[evento] ENCERRANDO " + posicao[0].getPid());
					posicao[0] = CPU.dequeueProcesso();
					j = -1;
					doneCounter++;
				}
				if (doneCounter == processos.length) {
					break;
				}
				posicao[0].setTempExecucao(posicao[0].getTempExecucao() + 1);
				posicao[0].setTempRestante(posicao[0].getTempRestante() - 1);
				System.out.println("CPU: " + posicao[0].getPid() + "(" + (posicao[0].getTempRestante() + 1) + ")");
				System.out.println("FILA: " + CPU.showProcessos());
				System.out.println("\n");
			}
			if (doneCounter == processos.length) {
				break;
			}
		}
		System.out.println("FIM DOS PROCESSOS");
		System.out.println("--------------------------------------");
		System.out.println("-------ENCERRANDO SIMULACAO-----------");
		System.out.println("--------------------------------------");
	}
}