package grafos_and_algoritmos;

public class Principal {
	
	
	/**
	 * Mide el tiempo que tarda el algoritmo de Kruskal con BFS
	 * @return
	 */
	public static long medicionDeTiempoKruskalBFS() {
		long tiempoInicio, tiempoFin, tiempo;
		tiempoInicio = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(5, 10);
			for (int j = 0; j < 50; j++) {
				Kruskal.kruskalBFS(grafo);
			}
		}
		tiempoFin = System.currentTimeMillis();
		tiempo = tiempoFin - tiempoInicio;
		return tiempo;
	}
	
	
	/**
	 * Mide el tiempo que tarda el algoritmo de Kruskal con estructura de datos Union-Find
	 * @return
	 */
	public static long medicionDeTiempoKruskalUF() {
		long tiempoInicio, tiempoFin, tiempo;
		tiempoInicio = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(5, 10);
			for (int j = 0; j < 50; j++) {
				Kruskal.kruskalUF(grafo);
			}
		}
		tiempoFin = System.currentTimeMillis();
		tiempo = tiempoFin - tiempoInicio;
		return tiempo;
	}
	
	
	public static void main (String[]args) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n                                                                                                    \n");
		sb.append("Tiempo en milisegundos de algoritmo de Kruskal usando BFS y grafo aleatorio: ");
		sb.append(medicionDeTiempoKruskalBFS());
		sb.append("\n----------------------------------------------------------------------------------------------------\n");
		sb.append("Tiempo en milisegundos de algoritmo de Kruskal usando estructura Union-Find y grafo aleatorio: ");
		sb.append(medicionDeTiempoKruskalUF());
		sb.append("\n                                                                                                    \n");
		System.out.println(sb);
	}
	
}
