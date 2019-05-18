package escalonador;

public class Fila {
	private No inicio, fim;
	
	public Fila() {
		inicio = fim = null;
	}
	
	public boolean isEmpty() {
		if(inicio == null) {
			return true;
		}
		return false;
	}
	
	public void enqueue( int dd ){
		No newNo = new No( dd );
		
		if(inicio == null){
			inicio = fim = newNo;
		}else{
			fim.setNextNo(newNo);
			fim = newNo;
		}
	}
	
	public void enqueueProcesso( Processo dd ){
		No newNo = new No( dd );
		
		if(inicio == null){
			inicio = fim = newNo;
		}else{
			fim.setNextNo(newNo);
			fim = newNo;
		}
	}
	
	public void enqueueLinha( String ddLinha ){
		No newNo = new No( ddLinha );
		
		if(inicio == null){
			inicio = fim = newNo;
		}else{
			fim.setNextNo(newNo);
			fim = newNo;
		}
	}
	
	public int dequeue( ){
		if ( isEmpty( ) ){
			return -1;
		}

		No temp = inicio;
		inicio = inicio.getNextNo();
		
		if(inicio == null){
			fim = null;
		}
		
		return temp.getDado();
	}
	
	public Processo dequeueProcesso( ){
		if ( isEmpty( ) ){
			return null;
		}

		No temp = inicio;
		inicio = inicio.getNextNo();
		
		if(inicio == null){
			fim = null;
		}
		
		return temp.getDd();
	}
	
	public String dequeueLinha( ){
		if ( isEmpty( ) ){
			return null;
		}

		No temp = inicio;
		inicio = inicio.getNextNo();
		
		if(inicio == null){
			fim = null;
		}
		
		return temp.getDdLinha();
	}
	
	public String showProcessos() {
		String saida = "";
		if (isEmpty()) {
			return saida;
		}else{
			No atual = inicio;

			while (atual != null) {
				saida += atual.getDd().getPid() + "(" + atual.getDd().getTempRestante() + ")" + " ";
				atual = atual.getNextNo();
			}
			
			return saida;
		}
	}
	
	public String show() {
		String saida = "";
		if (isEmpty()) {
			return saida;
		}else{
			No atual = inicio;

			while (atual != null) {
				saida += atual.getDado() + " ";
				atual = atual.getNextNo();
			}
			
			return saida;
		}
	}
	
	public int size() {
		int cont = 0;

		No atual = inicio;

		while (atual != null) {
			cont ++;
			atual = atual.getNextNo();
		}
		
		return cont;
	}
	
	public Processo peekProcesso() {
		if(isEmpty()) {
			return null;
		}
		return inicio.getDd();
	}
	
	public int peek() {
		if(isEmpty()) {
			return 0;
		}
		return inicio.getDado();
	}

}
