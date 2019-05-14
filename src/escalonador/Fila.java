package escalonador;

public class Fila {
	private No inicio, fim;
	
	public Fila() {
		inicio = fim = null;
	}
	
	public boolean isEmpty() {
		return (inicio == null);
	}
	
	public void enqueue( int dd ){
		No newNo = new No( dd );
		
		if(inicio == null){
			inicio = fim = newNo;
		}
		else {
			fim.setNextNo(newNo);
			fim = newNo;
		}
	}
	
	public int dequeue( ){
		if ( isEmpty( ) ){
			return -1;
		}

		No temp = inicio;
		inicio.setNextNo(inicio.getNextNo());
		
		if(inicio == null){
			fim = null;
		}
		
		return temp.getDado();
	}

}
