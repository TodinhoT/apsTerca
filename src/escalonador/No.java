package escalonador;

public class No {
	private int dado;
	private No nextNo;
	
	public No(int dd) {
		this.dado = dd;
		this.nextNo = null;
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
