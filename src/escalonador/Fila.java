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

}
