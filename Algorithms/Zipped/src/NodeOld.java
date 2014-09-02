
public class NodeOld<T> {
	
	NodeOld<T> left;
	NodeOld<T> right;
	NodeOld<T> next;
	NodeOld<T> parent;
	T value = null;
	int weight = 1;
	String name;
	
	NodeOld(T t) {
		value = t;
		left = null;
		right = null;
		parent = null;
		next = null;
		name = value.toString();
	}
	
	NodeOld(NodeOld n1, NodeOld n2) {
		value = null;
		left = n1;
		right = n2;
		parent = null;
		left.parent = this;
		right.parent = this;
		next = null;
		weight = n1.weight + n2.weight;
		name = left.name + "" + right.name;
	}
}
