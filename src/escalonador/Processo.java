package escalonador;

public class Processo {
	private String pid;
	private int duracao;
	private int chegada;
	private Fila operacaoIO;
	private int tempExecucao = -1;
	private int tempRestante;

	public Processo(String pid, int duracao, int chegada) {
		this.pid = pid;
		this.duracao = duracao;
		this.chegada = chegada;
		this.operacaoIO = new Fila();
		this.tempRestante = duracao;
	}
	public Processo(String pid, int duracao, int chegada, Fila operacaoIO) {
		this.pid = pid;
		this.duracao = duracao;
		this.chegada = chegada;
		this.operacaoIO = operacaoIO;
		this.tempRestante = duracao;
	}
	
	public String getPid() {
		return pid;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getChegada() {
		return chegada;
	}
	
	public Fila getOperacaoIO() {
		return operacaoIO;
	}
	
	public int getTempExecucao() {
		return tempExecucao;
	}
	
	public void setTempExecucao(int tempExecucao) {
		this.tempExecucao = tempExecucao;
	}
			
	public int getTempRestante() {
		return tempRestante;
	}
	public void setTempRestante(int tempRestante) {
		this.tempRestante= tempRestante;
	}
}
