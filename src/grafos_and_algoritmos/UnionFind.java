package grafos_and_algoritmos;

public class UnionFind {

	private static int[] tamano;
	private static int [] A;
	
	public static void UF(int N) {
		tamano = new int [N];
		A = new int [N];
		
		for(int i  = 0; i < N; i++) {
			A[i] = i;
			tamano[i] = 1;
		}
	}
	
	
	int root (int i) {
		while(A[i] != i)
			i = A[i];
		
		return i;
	}
	
	boolean find(int i, int j) {
		return root(i) == root(j);
	}
	
	void union(int i, int j) {
		int ri = root(i);
		int rj = root(j);
		A[ri] = rj;
		
	}
	
	int root2(int i) {
		if(A[i] != i) {
			A[i] = root2(A[i]);
		}
		return i;
	}
}
