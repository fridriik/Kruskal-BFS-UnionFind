package grafos_and_algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grafo {
	
	private ArrayList<Set<Integer>> vecinos;
	private ArrayList<Arista> aristas;
	
	
	/**
	 * Constructor de Grafos
	 * @param cantidad de vertices del grafo a crear
	 */
	public Grafo(int vertices) {
		
		vecinos = new ArrayList<Set<Integer>>(vertices);

		for (int i = 0; i < vertices; i++) {
			vecinos.add(new HashSet<Integer>());
		}
		aristas = new ArrayList<Arista>();
	}
	
	
	//Getters y setters de aristas y vecinos
	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	
	public ArrayList<Set<Integer>> getVecinos() {
		return vecinos;
	}
	
	
	public Set<Integer> vecinos(int s){
		verificarVertice(s, this);
		return vecinos.get(s);
	}


	/**
	 * Agrega la arista al grafo
	 * @param Vertice origen
	 * @param Vertice destino
	 * @param Peso de la arista (Integer)
	 */
	public void agregarArista (int s, int t, int peso) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		verificarDistintos(s, t);
		
		vecinos.get(s).add(t);
		vecinos.get(t).add(s);
		
		aristas.add(new Arista(s, t, peso));
	}
	
	
	/**
	 * Agrega la arista al grafo
	 * @param Vertice origen
	 * @param Vertice destino
	 * @param Peso de la arista (Float)
	 */
	public void agregarArista (int s, int t, float peso) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		verificarDistintos(s, t);
		
		vecinos.get(s).add(t);
		vecinos.get(t).add(s);
		
		Random random = new Random(); 
		peso = random.nextFloat();
		Arista aux = new Arista(s, t, peso);
		
		aristas.add(aux);
	}
	
	
	/**
	 * Elimina la arista del grafo
	 * @param Vertice origen
	 * @param Vertice destino
	 */
	public void eliminarArista(int s, int t) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		verificarDistintos(s, t);
		
		vecinos.get(s).remove(t);
		vecinos.get(t).remove(s);
		
		for (int i = 0; i < aristas.size(); i++) {
			if ((aristas.get(i).getVertice_S() == s || aristas.get(i).getVertice_S() == t) && (aristas.get(i).getVertice_T() == s || aristas.get(i).getVertice_T() == t)) {
				aristas.remove(i);
			}
		}
	}
	
	
	/**
	 * Verifica si existe la arista
	 * @param Vertice origen
	 * @param Vertice destino
	 */
	public boolean existeArista (int s, int t) {
		verificarVertice(s, this);
		verificarVertice(t, this);
		return vecinos.get(s).contains(t);
	}
	
	
	/**
	 * Peso total de las aristas del grafo
	 */
	public int pesoTotal() {
		int cont = 0;
		for (Arista arista : aristas)
			cont += arista.getPeso();
		return cont;
	}

	
	/**
	 * @param Vertice a verificar
	 * @return Grado del vertice
	 */
	public int grado (int s) { 
		return vecinos.get(s).size();
	}
	
	
	/**
	 * @return Tamanio del grafo
	 */
	public int tamanio () {
		return vecinos.size();
	}
	
	
	/**
	 * Verifica si 2 vertices son distintos
	 * @param Vertice origen
	 * @param Vertice destino
	 */
	private void verificarDistintos(int s, int t) {
		if (s == t) {
			throw new IllegalArgumentException("No se permiten loops: (" + s + ", " + t + ")" );
		}
	}
		
	
	/**
	 * Verifica si el vertice es valido
	 * @param Vertice a verifcar
	 * @param Grafo donde se verifica
	 */
	private void verificarVertice(int s, Grafo grafo) {
		if (s < 0) {
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + s);
		}
		if (s >= grafo.tamanio()) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + s);
		}
	}
}
