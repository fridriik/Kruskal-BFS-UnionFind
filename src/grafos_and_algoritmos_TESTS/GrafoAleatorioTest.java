package grafos_and_algoritmos_TESTS;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import grafos_and_algoritmos.Grafo;
import grafos_and_algoritmos.GrafoAleatorio;

public class GrafoAleatorioTest {
	
	
	@Test
	public void testGrafoAleatorio() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(5, 10);
		assertEquals(grafo.tamanio(), 5);
		assertEquals(grafo.getAristas().size(), 10);		
	}
	
	
	@Test
	public void testGrafpAleatorioCon1Vertice() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(1, 0);
		assertEquals(grafo.tamanio(), 1);
		assertEquals(grafo.getAristas().size(), 0);		
	}
	
	
	@Test
	public void testGrafoAleatorioCon2Vertices() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(2, 1);
		assertEquals(grafo.tamanio(), 2);
		assertEquals(grafo.getAristas().size(), 1);		
	}
	
	
	@Test
	public void testGrafoAleatorioSinVertices() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(0, 0);
		assertEquals(grafo.tamanio(), 0);
		assertEquals(grafo.getAristas().size(), 0);		
	}
	
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalArgumentException.class)
	public void testGrafoAleatorioVerticesNegativos() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(-7, 0);		
	}
	
	
	@SuppressWarnings("unused")
	@Test (expected = IllegalArgumentException.class)
	public void testGrafoAleatorioAristasNegativas() {
		Grafo grafo = GrafoAleatorio.nuevoGrafoAleatorio(7, -3);		
	}
}
