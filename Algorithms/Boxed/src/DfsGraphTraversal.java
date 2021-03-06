import java.util.ArrayList;
import java.util.List;


public class DfsGraphTraversal {

	public List<List<Integer>> traverse(Graph g) {
		resetGraph(g);
		int count = 0;
		int startingVertex = 0;
		List<List<Integer>> theList = new ArrayList<List<Integer>>();
		
		while(count < g.vcount()) {
			List<Integer> list = new ArrayList<Integer>();
			List<Integer> tree = new ArrayList<Integer>();
			int vertex = startingVertex;
			int next = 0;
			int first = 0;
			while(g.getMark(vertex) != 0) {
				vertex += 1;
			}
			
			startingVertex = vertex;

			g.setMark(vertex, 1);
			list.add(vertex);
			tree.add(vertex);
			//count += 1;
			first = vertex;
			
			while(!list.isEmpty()) {
				vertex = list.get(list.size() - 1);
				if(g.getMark(vertex) == 0) {
					g.setMark(vertex, 1);
					tree.add(vertex);
				}
					
				first = g.first(vertex);
				next = g.next(vertex, first);
				while(next != g.vcount() && g.getMark(next) != 0) {
					next = g.next(vertex, next);
				}
				
				if(first != g.vcount() && g.getMark(first) == 0 ) {
					g.setMark(first, 1);
					tree.add(first);
					list.add(first);
				}
				else if(next != g.vcount() && g.getMark(next) == 0) {
					g.setMark(next, 1);
					tree.add(next);
					list.add(next);
				}
				else if(next == g.vcount()) {
					list.remove(list.indexOf(vertex));
					count++;
				}
			}
			theList.add(tree);
		}
		
		return theList;
	}
	
	private void resetGraph(Graph g) {
		for(int i = 0; i < g.vcount(); i++) {
			g.setMark(i, 0);
		}
	}
}
