package grafos_and_algoritmos_TESTS;

import static org.junit.Assert.*;
import org.junit.Test;
import grafos_and_algoritmos.Arista;
import grafos_and_algoritmos.Grafo;

public class AristaTest {
	
	@Test
	public void aristaExistenteTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(2, 3, 5);
		assertTrue(grafo.existeArista(2, 3));
	}
	
	@Test
	public void aristaInexistenteTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(2, 3, 0);
		assertFalse(grafo.existeArista(1, 3));
	}
	
	@Test
	public void aristaOpuestaTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(2, 3, 0);
		assertTrue(grafo.existeArista(3, 2));
	}
	
	@Test
	public void eliminarAristaTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(2, 3, 0);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}
	
	@Test
	public void eliminarAristaInexistenteTest() {
		Grafo grafo = new Grafo(4);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}
	
	@Test
	public void verificarTamanioTest() {
		Grafo grafo = new Grafo (4);
		assertEquals(4, grafo.tamanio());
	}
	
	@Test
	public void testEquals() {
		Arista arista21 = new Arista(2, 1, 0);
		Arista arista12 = new Arista(1, 2, 0);
		assertEquals(arista21, arista12);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(-1, 3, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(5, 2, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(3, -1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(2, 4, 6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest() {
		Grafo grafo = new Grafo(3);
		grafo.agregarArista(2, 2, 2);
	}
}
