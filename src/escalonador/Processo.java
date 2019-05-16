package escalonador;

public class Processo {
	private String pid;
	private int duracao;
	private int chegada;
	private Fila operacaoIO;
	private int tempExecucao = 0;
		
	public Processo(String pid, int duracao, int chegada) {
		this.pid = pid;
		this.duracao = duracao;
		this.chegada = chegada;
		this.operacaoIO = new Fila();
	}
	public Processo(String pid, int duracao, int chegada, Fila operacaoIO) {
		this.pid = pid;
		this.duracao = duracao;
		this.chegada = chegada;
		this.operacaoIO = operacaoIO;
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
	
	
}
