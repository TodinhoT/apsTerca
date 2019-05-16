package escalonador;

public class Processo {
	private String pid;
	private int duracao;
	private int chegada;
	private Fila operacaoIO;
		
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
	
	public int getChegada() {
		return chegada;
	}
	
	public Fila getOperacaoIO() {
		return operacaoIO;
	}
	
	
}
