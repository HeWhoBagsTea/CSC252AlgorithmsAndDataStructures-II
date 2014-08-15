
public class Node<T> {
	
	Node<T> left;
	Node<T> right;
	Node<T> next;
	Node<T> parent;
	T value = null;
	int weight = 1;
	String name;
	
	Node(T t) {
		value = t;
		left = null;
		right = null;
		parent = null;
		next = null;
		name = value.toString();
	}
	
	Node(Node n1, Node n2) {
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
