package grafos_and_algoritmos;

public class main {

	public static void main(String[] args) {

		Grafo a = new Grafo(4);
		
		a.agregarArista(0, 1, 1);
		a.agregarArista(0, 2, 2);
		a.agregarArista(1, 3, 9);
		a.agregarArista(3, 2, 3);
		
//		System.out.println(a.toString());
//		
		KruskalBFS.kruskal(a);
//		
		System.out.println(a.toString());
	}

}
