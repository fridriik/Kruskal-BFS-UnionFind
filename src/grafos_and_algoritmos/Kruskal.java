package grafos_and_algoritmos;

public class Kruskal {
	
	public Grafo kruskal(Grafo g) {
		Grafo aux = new Grafo(g.tamanio());
		int i = 0;
		if(BFS.esConexo(aux) == false) {
			return g;
		}
		else {
		while(aux.getAristas().size() <= g.tamanio() - 1) {
		
			
			seleccionarMenor(g);
			if(BFS.esConexo(aux) == false) {
				
			}
			else {
				
			}
			i ++;
		}
		return aux;	
	}
		
	}
	
	private Arista seleccionarMenor(Grafo g, Grafo g1, int i) {
		for() {
			
		}
		g.getAristas().get(i);
		
		return null;
		// TODO Auto-generated method stub
		
	}
	
	private void ordenarGrafo(Grafo g1) {
		
	}
	
}
