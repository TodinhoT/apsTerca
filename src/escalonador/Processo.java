package escalonador;

public class Processo {
	private String pid;
	private int duracao;
	private int chegada;
	private String[] operacaoIO = new String[4];
		
	public Processo(String pid, int duracao, int chegada) {
		this.pid = pid;
		this.duracao = duracao;
		this.chegada = chegada;
	}
	public Processo(String pid, int duracao, int chegada, String[] operacaoIO) {
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
	
	public String[] getOperacaoIO() {
		return operacaoIO;
	}
	
	
}
