package grafos_and_algoritmos;

import java.util.Random;

public class GrafoAleatorio {
	
	public static Grafo nuevoGrafoAleatorio(int vertices, int aristas) {
		
		if (vertices < 0 || aristas < 0) {
			throw new IllegalArgumentException("Se ingresaron numeros negativos");
		}
		
		Grafo aux = new Grafo(vertices);
		Random random = new Random();
		int i = 0; 
		while (i < aristas) {
			int vertice_S = random.nextInt(vertices);
			int vertice_T = vertice_S;
			while (vertice_T == vertice_S || aux.existeArista(vertice_S, vertice_T)) {
				vertice_T = random.nextInt(vertices);
			}
			aux.agregarArista(vertice_S, vertice_T, random.nextFloat());
			i++;
		}
		return aux;
	}
}

