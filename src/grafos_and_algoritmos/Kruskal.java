package grafos_and_algoritmos;

import java.util.ArrayList;
import java.util.Set;

public class Kruskal {		
	
	@SuppressWarnings("unchecked")
	public static Grafo kruskal(Grafo g) {
		ArrayList<Arista> marcados = new ArrayList<Arista>();
		Grafo aux = new Grafo(g.tamanio());
		Arista auxi = new Arista(0, 0, 0);
		System.out.println(aux);
		System.out.println(marcados);
		
		if(BFS.esConexo(g) == false) {
			return g;
		}
		
		else {
			
		marcados = (ArrayList<Arista>) g.getAristas().clone();
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
		while(aux.getAristas().size() <= g.tamanio() - 1) {		
			
			auxi = seleccionarMenor(marcados);	
	
			aux.agregarArista(auxi.getVertice_S(), auxi.getVertice_T(), auxi.getPeso());
			if(BFS.esConexo(aux) == false) {
				
				System.out.println(aux);
//				g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
//				System.out.println(aux);
			}
			else {
				
				aux.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
//				g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
//				System.out.println(aux);
			}
		}
		System.out.println(aux);
		return aux;	
	}
		
	}
	
	public static ArrayList<Integer> getMarcados() {
		return getMarcados();
	}


	private static Arista seleccionarMenor(ArrayList<Arista> g1) {
		Arista auxi = new Arista(0, 0, 0);
		auxi = g1.get(0);
		for (int j = 1; j < g1.size(); j++) {		
			if(g1.get(j).getPeso() < auxi.getPeso() ) {
				auxi = g1.get(j);
				g1.remove(j);
				System.out.println(g1);
				return auxi;
			}
			else {
				auxi = g1.get(0);
				g1.remove(0);
				System.out.println(g1);
				return auxi;
			}
		}
		return auxi;
		
	}
	
	

	
}
