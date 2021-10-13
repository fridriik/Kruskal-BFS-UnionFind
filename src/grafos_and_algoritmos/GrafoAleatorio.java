package grafos_and_algoritmos;

import java.util.Random;

public class GrafoAleatorio {
	
	
	/**
	 * Crea un grafo aleatorio con vertices y aristas ingresadas como parametros
	 * @param Cantidad de vertices
	 * @param Cantidad de aristas
	 * @return
	 */
	public static Grafo nuevoGrafoAleatorio(int vertices, int aristas) {
		
		if (vertices < 0 || aristas < 0) {
			throw new IllegalArgumentException("Se ingresaron vertices y aristas negativas");
		}
		if(aristas > (vertices*(vertices - 1))/2) {
			throw new IllegalArgumentException("Por teoria de grafos la cantidad maxima de aristas es n(n - 1)/2");
		}
		Grafo aux = new Grafo(vertices);
		Random random = new Random();
		for (int i = 0; i < vertices; i++) {
			for (int j = i + 1; j < vertices; j++) {
				aux.agregarArista(i, j, random.nextFloat());
			}
		}
		return aux;
	}
}

