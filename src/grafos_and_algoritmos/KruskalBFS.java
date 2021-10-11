package grafos_and_algoritmos;

import java.util.ArrayList;

public class KruskalBFS {		
	

	public static Grafo kruskal(Grafo g) {
	//	ArrayList<Arista> marcados = new ArrayList<Arista>();
//		Arista auxi = new Arista(0, 0, 0);
//		System.out.println(aux);
//		System.out.println(marcados);
		
		if(!BFS.esConexo(g)) {
			throw new IllegalArgumentException("El grafo tiene que ser conexo");
		}
		
		Grafo aux = new Grafo(g.tamanio());
		ArrayList<Arista> listaAuxArista = (ArrayList<Arista>) g.getAristas().clone();
		int i = 0;
		while (i < g.tamanio() - 1) {
			Arista arista = seleccionarMenor(listaAuxArista, g);
			if(arista != null) {
				aux.agregarArista(arista.getVertice_S(), arista.getVertice_T(), arista.getPeso());
			}
			i++;
		}
		
		System.out.println(aux);
		return aux;
	}
		
//		System.out.println(marcados);
////		auxi = seleccionarMenor(marcados);
//		
//		
//		while(BFS.esConexo(g) == true) {	
//			
//			auxi = seleccionarMayor(marcados);
//			g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
//			
//		}
//		System.out.println(g);
//		return aux;	
//		
//		}
//	}
//		while(aux.getAristas().size() <= g.tamanio() - 1) {		
//			
//			auxi = seleccionarMenor(marcados);	
//			if(BFS.alcanzables(aux, auxi.getVertice_S()).contains(auxi.getVertice_T()) == false)
//				aux.agregarArista(auxi.getVertice_S(), auxi.getVertice_T(), auxi.getPeso());
//			if(BFS.esConexo(aux) == false) {
//				
//				System.out.println(aux);
////				g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
////				System.out.println(aux);
//			}
//			else {
//				
//				aux.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
//				g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
//				System.out.println(aux);
//			}
//		}
//		System.out.println(aux);
//		return aux;	
		
//	
//	public static ArrayList<Integer> getMarcados() {
//		return getMarcados();
//	}


	private static Arista seleccionarMenor(ArrayList<Arista> aristaList, Grafo g) {
		Arista auxi = null;
		for (Arista arista : aristaList) {
			if(auxi == null) {
				auxi = arista;
			}
			else if((arista.getPeso() < auxi.getPeso()) && !BFS.circuito(g, arista.getVertice_S(), arista.getVertice_T())){
				auxi = arista;
			}
		}
		aristaList.remove(auxi);
		return auxi;
	}
	
	
	private static Arista seleccionarMenorUF(ArrayList<Arista> aristaList, Grafo g) {
		Arista auxi = null;
		for (Arista arista : aristaList) {
			if(auxi == null) {
				auxi = arista;
			}
			else if((arista.getPeso() < auxi.getPeso()) && !BFS.circuito(g, arista.getVertice_S(), arista.getVertice_T())){
				auxi = arista;
			}
		}
		aristaList.remove(auxi);
		return auxi;
	}
	
	
	public static Grafo kruskalUF (Grafo g) {
		
		UnionFind.UF(g.tamanio());
		
		if(!BFS.esConexo(g)) {
			throw new IllegalArgumentException("El grafo tiene que ser conexo");
		}
		
		Grafo aux = new Grafo(g.tamanio());
		ArrayList<Arista> listaAuxArista = (ArrayList<Arista>) g.getAristas().clone();
		int i = 0;
		while (i < g.tamanio() - 1) {
			Arista arista = seleccionarMenor(listaAuxArista, g);
			if(arista != null) {
				aux.agregarArista(arista.getVertice_S(), arista.getVertice_T(), arista.getPeso());
			}
			i++;
		}
		
		System.out.println(aux);
		return aux;
	}

		
//		auxi = g1.get(0);
//		for (int j = 1; j < g1.size(); j++) {		
//			if(g1.get(j).getPeso() < auxi.getPeso() ) {
//				auxi = g1.get(j);
//				g1.remove(j);
//				System.out.println(g1);
//				return auxi;
//			}
//			else {
//				auxi = g1.get(0);
//				g1.remove(0);
//				System.out.println(g1);
//				return auxi;
//			}
//		}
//	}
}
