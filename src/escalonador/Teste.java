package escalonador;

public class Teste {
	public static void main(String[] args) {
		Fila fila = new Fila();
		int i = 0;
		
		fila.enqueue(5);
		fila.enqueue(6);
		fila.enqueue(7);
		
//		for(int j = 0; j < 3; j++) {
//			i = fila.dequeue();
//			System.out.println(i);
//		}
		
		System.out.println(fila.show());
	}
}
