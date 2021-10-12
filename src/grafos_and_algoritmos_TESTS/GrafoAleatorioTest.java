package grafos_and_algoritmos_TESTS;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import grafos_and_algoritmos.Grafo;
import grafos_and_algoritmos.GrafoAleatorio;

public class GrafoAleatorioTest {
	
	@Test
	public void testAleatorios() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(7, 5);
		assertEquals(grafo.tamanio(), 7);
		assertEquals(grafo.getAristas().size(), 5);		
	}
	
	@Test
	public void testAleatoriosCon1Vertice() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(1, 0);
		assertEquals(grafo.tamanio(), 1);
		assertEquals(grafo.getAristas().size(), 0);		
	}
	
	@Test
	public void testAleatoriosCon2Vertices() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(2, 1);
		assertEquals(grafo.tamanio(), 2);
		assertEquals(grafo.getAristas().size(), 1);		
	}
	
	@Test
	public void testAleatoriosSinVertices() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(0, 0);
		assertEquals(grafo.tamanio(), 0);
		assertEquals(grafo.getAristas().size(), 0);		
	}
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalArgumentException.class)
	public void testAleatoriosVerticesNegativos() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(-7, 0);		
	}
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalArgumentException.class)
	public void testAleatoriosAristasNegativas() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(7, -3);		
	}
}
