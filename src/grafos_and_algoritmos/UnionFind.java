package grafos_and_algoritmos;

public class UnionFind {

	private int [] A;
	
	public UnionFind(int N) {
		A = new int [N];
		for(int i = 0; i < N; i++) {
			A[i] = i;
		}
	}
	
	public int root (int i) {
		while(A[i] != i)
			i = A[i];
		return i;
	}
	
	public boolean find(int i, int j) {
		return root(i) == root(j);
	}
	
	public void union(int i, int j) {
		int ri = root(i);
		int rj = root(j);
		A[ri] = rj;
		
	}
	
	public int root2(int i) {
		if(A[i] != i) {
			A[i] = root2(A[i]);
		}
		return i;
	}
	
	public boolean esConexo() {
		boolean ret=true;
		for(int indice:this.A) {
			ret= ret && this.root(indice)==this.root(A[0]);
		}
		return ret;
	}
}
