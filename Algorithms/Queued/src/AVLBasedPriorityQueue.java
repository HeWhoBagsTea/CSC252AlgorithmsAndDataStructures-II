
public class AVLBasedPriorityQueue<T extends Comparable> {
	Node<T> root = null;

	public boolean offer(T data) {
		Node<T> offered = new Node<T>(data);
		Node<T> checkAgainst = root;
		boolean added = false;

		if(root == null) {
			root = offered;
			added = true;
		}
		else {
			while(!added) {
				if(data.compareTo(checkAgainst.value) < 0 && checkAgainst.left == null) {
					checkAgainst.left = offered;
					added = true;
				}
				else if (data.compareTo(checkAgainst.value) > 0 && checkAgainst.right == null) {
					checkAgainst.right = offered;
					added = true;
				}
				else if (data.compareTo(checkAgainst.value) == 0) {
					return false;
				}
				else if(data.compareTo(checkAgainst.value) < 0) {
					checkAgainst = checkAgainst.left;
				}
				else if(data.compareTo(checkAgainst.value) > 0) {
					checkAgainst = checkAgainst.right;
				}
			}
		}

		return added;
	}

	public T peek() {
		Node<T> next = root;
		
		while(next.right != null) {
			next = next.right;
		}
		
		return next.value;
	}

	public T poll() {
		Node<T> next = root;
		Node<T> previous = root;
		
		while(next.right != null) {
			previous = next;
			next = next.right;
		}
		
		previous.right = next.left;
		
		return next.value;
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	
	public void postOrder() {
		postOrder(root);
		System.out.println();
	}
	
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	
	private void preOrder(Node<T> n)
	{
		if(n.left != null)
			preOrder(n.left);
		
		if(n.right != null)
			preOrder(n.right);
		
		System.out.print(n.value + " ");
	}
	
	private void inOrder(Node<T> n)
	{
		if(n.left != null)
			inOrder(n.left);
		
		System.out.print(n.value + " ");
		
		if(n.right != null)
			inOrder(n.right);
	}
	
	private void postOrder(Node<T> n)
	{
		if(n.right != null)
			postOrder(n.right);
		
		if(n.left != null)
			postOrder(n.left);
		
		System.out.print(n.value + " ");
	}
		
}