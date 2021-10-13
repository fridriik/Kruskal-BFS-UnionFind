package grafos_and_algoritmos;

import java.util.ArrayList;

public class Kruskal {		

	
	/**
	 * Crea un arbol generador minimo usando el algoritmo de Kruskal con BFS
	 * @param Grafo a probar 
	 * @return
	 */
	public static Grafo kruskalBFS(Grafo g) {
		if(!BFS.esConexo(g)) {
			throw new IllegalArgumentException("El grafo tiene que ser conexo");
		}
		Grafo aux = new Grafo(g.tamanio());
		ArrayList<Arista> listaAuxArista = (ArrayList<Arista>) g.getAristas().clone();
		while (aux.getAristas().size() < g.tamanio() - 1) {
			Arista arista = seleccionarMenorBFS(listaAuxArista, aux);
			if(arista != null) {
				aux.agregarArista(arista.getVertice_S(), arista.getVertice_T(), arista.getPeso());
			}
		}
		return aux;
	}
	
	
	/**
	 * Crea un arbol generador minimo usando el algoritmo de Kruskal con estructura de datos Union-Find
	 * @param Grafo a probar 
	 * @return
	 */
	public static Grafo kruskalUF (Grafo g) {
		UnionFind uf = new UnionFind(g.tamanio());
		Grafo aux = new Grafo(g.tamanio());
		ArrayList<Arista> listaAuxArista = (ArrayList<Arista>) g.getAristas().clone();
		while (aux.getAristas().size() < g.tamanio() - 1) {
			Arista arista = elegirArista(listaAuxArista, uf);
			aux.agregarArista(arista.getVertice_S(), arista.getVertice_T(), arista.getPeso());
			uf.union(arista.getVertice_S(), arista.getVertice_T());
		}
		if(!uf.esConexo()) {
			throw new IllegalArgumentException("El grafo ingresado no es conexo");
		}
		return aux;
	}
		

	//Metodo que utiliza KruskalBFS para seleccionar la arista de menor peso
	private static Arista seleccionarMenorBFS(ArrayList<Arista> aristaList, Grafo g) {
		Arista auxi = aristaList.get(0);
		for (Arista arista : aristaList) {
			if((arista.getPeso() < auxi.getPeso()) && !BFS.circuito(g, arista.getVertice_S(), arista.getVertice_T())){
				auxi = arista;
			}
		}
		aristaList.remove(auxi);
		return auxi;
	}
	
	
	//Metodo que utiliza elegirArista para seleccionar la arista de menor peso
	private static Arista seleccionarMenorUF(ArrayList<Arista> aristaList) {
		Arista auxi = aristaList.get(0);
		for (Arista arista : aristaList) {
			if(arista.getPeso() < auxi.getPeso()){
				auxi = arista;
			}
		}
		return auxi;
	}
	
	
	//Metodo que utiliza KruskalUF para elegir la arista y comenzar con el algoritmo
	private static Arista elegirArista(ArrayList<Arista> aristaList, UnionFind uf) {
		boolean flag = false;
		Arista auxi = aristaList.get(0);
		while (flag == false) {
			auxi = seleccionarMenorUF(aristaList);
			if (uf.find(auxi.getVertice_S(), auxi.getVertice_T())) {
				aristaList.remove(auxi);
			} 
			else {
				flag = true;
				aristaList.remove(auxi);
			}		
		}
		return auxi;
	}
}
