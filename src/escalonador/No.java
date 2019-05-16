package escalonador;

public class No {
	private int dado;
	private Processo dd;
	private No nextNo;
	
	public No(int dd) {
		this.dado = dd;
		this.nextNo = null;
	}
	
	public No(Processo dd) {
		this.dd = dd;
		this.nextNo = null;
	}
	
	public Processo getDd() {
		return dd;
	}

	public void setDd(Processo dd) {
		this.dd = dd;
	}

	public void setDado(int dado){
		this.dado = dado;
	}
	
	public int getDado(){
		return this.dado;
	}
	
	public void setNextNo(No nextNo){
		this.nextNo = nextNo;
	}
	
	public No getNextNo(){
		return this.nextNo;
	}

}
