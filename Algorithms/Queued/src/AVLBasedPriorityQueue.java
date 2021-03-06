
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
					checkAgainst.left.parent = checkAgainst;
					added = true;
				}
				else if (data.compareTo(checkAgainst.value) > 0 && checkAgainst.right == null) {
					checkAgainst.right = offered;
					checkAgainst.right.parent = checkAgainst;
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

		setBalance();
		rebalance();
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
		if(next == root) {
			root = next.left;
		}


		//setBalance();
		//rebalance();
		
		return next.value;
	}

	public void rebalance() {
		rebalance(root);
	}

	private void rebalance(Node<T> n) {
		if(n.right != null)
			rebalance(n.right);

		if(n.left != null)
			rebalance(n.left);
		
		if(n.balanceFactor > 1 || n.balanceFactor < -1) {
			if(height(n.right) > height(n.left)) {
				lRotation(n);
			}
			else {
				rRotation(n);
			}
			//rebalance(root);
		}
	}

	private void rRotation(Node<T> n) {
		Node<T> oldLeftChild = n.left;

		oldLeftChild.parent = n.parent;
		n.parent = oldLeftChild;

		if(oldLeftChild.parent != null) {
			if(oldLeftChild.parent.left == n)
				oldLeftChild.parent.left = oldLeftChild;
			else
				oldLeftChild.parent.right = oldLeftChild;
		}


		if(n == root)
			root = oldLeftChild;

		n.left = oldLeftChild.right;
		oldLeftChild.right = n;

		setBalance();
	}

	private void lRotation(Node<T> n) {
		Node<T> oldRightChild = n.right;

		oldRightChild.parent = n.parent;
		n.parent = oldRightChild;

		if(oldRightChild.parent != null) {
			if(oldRightChild.parent.left == n)
				oldRightChild.parent.left = oldRightChild;
			else
				oldRightChild.parent.right = oldRightChild;
		}
		if(n == root)
			root = oldRightChild;

		n.right = oldRightChild.left;
		oldRightChild.left = n;

		setBalance();
	}

	public int height(Node<T> n) {
		if(n == null) return -1;

		int left = height(n.left);
		int right = height(n.right);

		if(left>right)
			return left + 1;
		else 
			return right +1;
	}

	private void setBalance() {
		setBalance(root);
	}

	private void setBalance(Node<T> n) {
		if(n.left != null)
			setBalance(n.left);

		n.balanceFactor = height(n.right) - height(n.left);

		if(n.right != null)
			setBalance(n.right);
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
		System.out.print(n.value + " ");
		if(n.left != null)
			preOrder(n.left);

		if(n.right != null)
			preOrder(n.right);

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
		if(n.left != null)
			postOrder(n.left);
		
		if(n.right != null)
			postOrder(n.right);

		System.out.print(n.value + " ");
	}

}
