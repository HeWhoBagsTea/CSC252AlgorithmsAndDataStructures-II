
public class Graph {
	private int[][] edges;
	private int[] color;

	// initializes a graph of v vertices with no edges
	Graph(int v){
		edges = new int[v][v];
		color = new int[v];
		
		for(int i = 0; i < edges.length; i++){
			for(int j = 0; j < edges.length; j++)
				edges[j][i] = 0;
		}
		
		for(int i = 0; i < color.length; i++){
			color[i] = 0;
		}
	}
	
	// returns number of vertices (whether connected or not) in the graph
	public int vcount() {
		return color.length;
	} 
	
	// returns the number of edges in the graph
	public int ecount() {
		int numEdges = 0;
		for(int i = 0; i < vcount(); i++) {
			for(int j = 0; j < vcount(); j++) {
				if(edges[i][j] != 0) {
					numEdges++;
				}
			}
		}
		
		return numEdges;
	}
	
	// returns the first vertex (in natural order) connected to vertex v.  If there are none, then vcount() is returned
	public int first(int v) {
		for(int i = 0; i < vcount(); i++) {
			if(edges[v][i] != 0) {
				return i;
			}
		}
		return vcount();
	}
	
	// returns the vertex (in natural order) connected to vertex v after vertex w.  If there are no more edges after w, vcount() is returned
	public int next(int v, int w) {
		for(int i = w + 1; i < vcount(); i++) {
			if(edges[v][i] != 0) {
				return i;
			}
		}
		return vcount();
	}
	
	// adds an edge between vertex v and vertex w.
	public void addEdge(int v, int w, int wt) {
		edges[v][w] = wt;
		edges[w][v] = wt;
	}
	
	// removes edge between vertex v and vertex w.
	public void removeEdge(int v, int w) {
		edges[v][w] = 0;
		edges[w][v] = 0;
	}
	
	// returns whether there is a connection between vertex v and vertex w
	public boolean isEdge(int v, int w) {
		return edges[v][w] != 0;
	}
	
	// returns how many edges depart from vertex v
	public int degree(int v) {
		int numEdges = 0;
		for(int i = 0; i < vcount(); i++){
			if(edges[v][i] != 0) {
				numEdges++;
			}
		}
		
		return numEdges;
	}
	
	// returns any graph coloring for this vertex
	public int getMark(int v) {
		return color[v];
	}
	
	// colors vertex v color m
	public void setMark(int v, int m) {
		color[v] = m;
	}

}
