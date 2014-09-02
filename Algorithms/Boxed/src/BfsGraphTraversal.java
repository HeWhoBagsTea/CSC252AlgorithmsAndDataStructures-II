import java.util.ArrayList;
import java.util.List;

public class BfsGraphTraversal {

	public List<List<Integer>> traverse(Graph g) {
		resetGraph(g);
		int count = 0;
		List<List<Integer>> theList = new ArrayList<List<Integer>>();

		while(count < g.vcount()) {
			List<Integer> list = new ArrayList<Integer>();
			List<Integer> tree = new ArrayList<Integer>();
			int vertex = 0;
			int next = 0;
			while(g.getMark(vertex) != 0) {
				vertex += 1;
			}

			g.setMark(vertex, 1);
			list.add(vertex);
			count += 1;

			while(!list.isEmpty()) {
				vertex = list.get(0);
				tree.add(list.get(0));
				list.remove(0);
				next = g.first(vertex);
				while(next != g.vcount()) {
					if(g.getMark(next) == 0) {
						g.setMark(next, 1);
						list.add(next);
						count += 1;
					}

					next = g.next(vertex, next);
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
