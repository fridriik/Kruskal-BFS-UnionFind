package grafos_and_algoritmos_TESTS;

import static org.junit.Assert.*;
import org.junit.Test;
import grafos_and_algoritmos.Arista;
import grafos_and_algoritmos.Grafo;
import grafos_and_algoritmos.Kruskal;

public class KruskalBFSTest {

	// Ejemplo dado en el PDF de Arbol Generador Minimo del moodle
		@Test
		public void arbolGeneradorTamanioTest() 
		{
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
			
			Grafo arbol = Kruskal.kruskalBFS(grafo);
			
			//En un arbol la cantidad de aristas es igual a la cantidad de vertices -1.
			assertEquals (arbol.getAristas().size(), grafo.tamanio() - 1);	
		}
			@Test
		public void arbolGeneradorPesoTest() 
		{
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
			
			Grafo arbol = Kruskal.kruskalBFS(grafo);
			
			for(Arista arista : arbol.getAristas())
				System.out.println(arista);
			
			//En un arbol la cantidad de aristas es igual a la cantidad de vertices -1.
			assertEquals (arbol.pesoTotal(), 38);	
		}
		
		@Test
		public void arbolGeneradorSobreGrafoCompletoTest()
		{
			Grafo grafo = new Grafo(5);
			grafo.agregarArista(0, 1, 13);
			grafo.agregarArista(0, 2, 21);
			grafo.agregarArista(0, 3, 3); 
			grafo.agregarArista(0, 4, 53);
			grafo.agregarArista(1, 2, 6);
			grafo.agregarArista(1, 3, 30);
			grafo.agregarArista(1, 4, 1);
			grafo.agregarArista(2, 3, 50);
			grafo.agregarArista(2, 4, 12);
			grafo.agregarArista(3, 4, 33);
			
			Grafo arbol = Kruskal.kruskalBFS(grafo);
			
//			for(Arista arista : arbol.getAristas())
//				System.out.println(arista);
			
			assertEquals (arbol.getAristas().size(), grafo.tamanio() - 1);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void arbolGeneradorSobreGrafoNoConexo()
		{
			Grafo grafo = new Grafo(5);
			grafo.agregarArista(0, 1, 3);
			grafo.agregarArista(0, 2, 4);
			grafo.agregarArista(1, 2, 22);
			grafo.agregarArista(3, 4, 12);
			
			Kruskal.kruskalBFS(grafo);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void arbolGeneradorSobreGrafoNull()
		{
			Grafo grafo = null;
			Kruskal.kruskalBFS(grafo);
		}
		
		@Test
		public void ArbolGeneradorSobreGrafoVacio()
		{
		Grafo grafo = new Grafo (0);
		Kruskal.kruskalBFS(grafo);
		}
		
		@Test
		public void ArbolGeneradorSobreGrafoTamanio1()
		{
			Grafo grafo = new Grafo (1);
			Kruskal.kruskalBFS(grafo);
		}
		
		@Test 
		public void ArbolGeneradorSobreGrafoTamanio2()
		{
			Grafo grafo = new Grafo (2);
			grafo.agregarArista(0, 1, 1);
			
			Grafo arbol = Kruskal.kruskalBFS(grafo);
			
			assertEquals (arbol.getAristas().size(), grafo.tamanio()-1);
		}

}
