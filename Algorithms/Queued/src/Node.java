
public class Node<T> {
	Node<T> left;
	Node<T> right;
	Node<T> parent;
	int balanceFactor = 0;
	T value;
	
	Node(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public void printChildren() {
		String leftValue;
		String rightValue;
		
		if(left == null || left.value == null)
			leftValue = "null";
		else
			leftValue = left.value.toString();
		if(right == null || right.value == null)
			rightValue = "null";
		else
			rightValue = right.value.toString();
		
		System.out.println("Parent:" + this.value + " Left Child:" + leftValue + " Right Child:" + rightValue);
	}
}
