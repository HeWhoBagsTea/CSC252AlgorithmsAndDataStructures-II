
public class Graph {
	private int[][] edges;
	private int[] color;
	
	Graph(int n) {
		edges = new int[n][n];
		color = new int[n];
	}
	
	public int vcount() {
		return color.length;
	}
	
	public int first(int vertex) {
		for(int i = 0; i < vcount(); i++) {
			if(edges[vertex][i] != 0) {
				return i;
			}
		}
		return vcount();
	}
	
	public int next(int vertex, int lastVisitedNeighbor) {
		for(int i = lastVisitedNeighbor + 1; i < vcount(); i++) {
			if(edges[vertex][i] != 0) {
				return i;
			}
		}
		return vcount();
	}
	
	public void addEdge(int fromVertex, int toVertex, int weight) {
		edges[fromVertex][toVertex] = weight;
	}
	
	public void removeEdge(int fromVertex, int toVertex) {
		edges[fromVertex][toVertex] = 0;
	}

	public boolean isEdge(int fromVertex, int toVertex) {
		return edges[fromVertex][toVertex] != 0;
	}
	
	public int getColor(int vertex) {
		return color[vertex];
	}
	
	public void setColor(int vertex, int color) {
		this.color[vertex] = color;
	}
}
