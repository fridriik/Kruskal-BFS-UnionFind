package grafos_and_algoritmos_TESTS;

import static org.junit.Assert.*;
import org.junit.Test;
import grafos_and_algoritmos.Grafo;
import grafos_and_algoritmos.Kruskal;

public class KruskalUFTest {
	
	// Ejemplo de la transparencia de la materia
	@Test
	public void tamanioAGMTest() {
		Grafo grafo = new Grafo(9);
		grafo.agregarArista(0, 1, 4);
		grafo.agregarArista(1, 2, 8);
		grafo.agregarArista(2, 3, 6);
		grafo.agregarArista(3, 4, 9);
		grafo.agregarArista(4, 5, 10);
		grafo.agregarArista(5, 6, 3);
		grafo.agregarArista(6, 7, 1);
		grafo.agregarArista(7, 8, 6);
		grafo.agregarArista(0, 7, 8);
		grafo.agregarArista(1, 7, 12);
		grafo.agregarArista(2, 5, 4);
		grafo.agregarArista(3, 5, 13);
		grafo.agregarArista(2, 8, 3);
		grafo.agregarArista(6, 8, 5);
		
		Grafo arbol = Kruskal.kruskalUF(grafo);
		assertEquals (arbol.getAristas().size(), grafo.tamanio() - 1);	
	}
	
	
	// Ejemplo de la transparencia de la materia
	@Test
	public void pesoAGMTest() {
		Grafo grafo = new Grafo(9);
		grafo.agregarArista(0, 1, 4);
		grafo.agregarArista(1, 2, 8);
		grafo.agregarArista(2, 3, 6);
		grafo.agregarArista(3, 4, 9);
		grafo.agregarArista(4, 5, 10);
		grafo.agregarArista(5, 6, 3);
		grafo.agregarArista(6, 7, 1);
		grafo.agregarArista(7, 8, 6);
		grafo.agregarArista(0, 7, 8);
		grafo.agregarArista(1, 7, 12);
		grafo.agregarArista(2, 5, 4);
		grafo.agregarArista(3, 5, 13);
		grafo.agregarArista(2, 8, 3);
		grafo.agregarArista(6, 8, 5);
		
		Grafo arbol = Kruskal.kruskalUF(grafo);
		assertEquals (arbol.pesoTotal(), 38);	
	}
			
	
	@Test
	public void grafoCompletoTamanioAGMTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1, 7);
		grafo.agregarArista(0, 2, 8);
		grafo.agregarArista(0, 3, 9); 
		grafo.agregarArista(0, 4, 70);
		grafo.agregarArista(1, 2, 80);
		grafo.agregarArista(1, 3, 90);
		grafo.agregarArista(1, 4, 1);
		grafo.agregarArista(2, 3, 2);
		grafo.agregarArista(2, 4, 3);
		grafo.agregarArista(3, 4, 4);
				
		Grafo arbol = Kruskal.kruskalUF(grafo);
		assertEquals (arbol.getAristas().size(), grafo.tamanio() - 1);
	}
	
	
	@Test
	public void grafoCompletoPesoAGMTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1, 7);
		grafo.agregarArista(0, 2, 8);
		grafo.agregarArista(0, 3, 9); 
		grafo.agregarArista(0, 4, 70);
		grafo.agregarArista(1, 2, 80);
		grafo.agregarArista(1, 3, 90);
		grafo.agregarArista(1, 4, 1);
		grafo.agregarArista(2, 3, 2);
		grafo.agregarArista(2, 4, 3);
		grafo.agregarArista(3, 4, 4);
		
		Grafo arbol = Kruskal.kruskalUF(grafo);
		assertEquals (arbol.pesoTotal(), 13);
	}
			
	
	@Test
	public void grafoVacioAGM() {
		Grafo grafo = new Grafo (0);
		Kruskal.kruskalUF(grafo);
	}
		
	
	@Test 
	public void grafo2VerticesAGM() {
		Grafo grafo = new Grafo (2);
		grafo.agregarArista(0, 1, 2);
				
		Grafo arbol = Kruskal.kruskalUF(grafo);
		assertEquals (arbol.getAristas().size(), grafo.tamanio()-1);
	}
}
