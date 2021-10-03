package grafos_and_algoritmos;

public class Kruskal {
	
	public Grafo kruskal(Grafo g) {
		Grafo aux = new Grafo(g.tamanio());
		Arista auxi = new Arista(0, 0, 0);
		int i = 0;
		if(BFS.esConexo(aux) == false) {
			return g;
		}
		else {
		while(aux.getAristas().size() <= g.tamanio() - 1) {
			auxi = g.getAristas().get(0);
			for (int j = 1; j< g.tamanio(); ++j) {
				if(g.getAristas().get(j).getPeso() < auxi.getPeso()) {
					auxi = g.getAristas().get(j);
				}
			}
			
			aux.agregarArista(auxi.getVertice_S(), auxi.getVertice_T(), auxi.getPeso());
			if(BFS.esConexo(aux) == false) {
				g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
			}
			else {
				aux.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
				g.eliminarArista(auxi.getVertice_S(), auxi.getVertice_T());
			}
			i ++;
		}
		return aux;	
	}
		
	}
	
//	private Arista seleccionarMenor(Grafo g, Grafo g1, int i) {
//		for() {
//			
//		}
//		g.getAristas().get(i);
//		
//		return null;
//		// TODO Auto-generated method stub
//		
//	}

	
}
