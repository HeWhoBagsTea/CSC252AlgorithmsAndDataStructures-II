import java.util.ArrayList;
import java.util.List;


public class HeapBasedPriorityQueue<T extends Comparable> {
	private List<Node<T>> listOfNodes = new ArrayList<Node<T>>();

	public boolean offer(T data) {
		boolean added = false;
		Node<T> offered = new Node<T>(data);

		if(listOfNodes.isEmpty()) {
			listOfNodes.add(offered);
			listOfNodes.add(offered);
			added = true;
		}
		else {
			if(listOfNodes.get((listOfNodes.size())/2).left == null) {
				listOfNodes.get((listOfNodes.size())/2).left = offered;
				listOfNodes.add(offered);
				added = true;
			}
			else if(listOfNodes.get((listOfNodes.size())/2).right == null) {
				listOfNodes.get((listOfNodes.size())/2).right = offered;
				listOfNodes.add(offered);
				added = true;
			}
			setUpChildren();
			siftUp(offered);
		}

		return added;
	}

	private void siftUp(Node<T> n) {
		int indexOf = listOfNodes.indexOf(n);

		if(indexOf > 1) {
			if(n.value.compareTo(listOfNodes.get((indexOf - 1)/2).value) > 0) {
				listOfNodes.set(indexOf, listOfNodes.get((indexOf - 1)/2));
				listOfNodes.set(indexOf/2, n);

				setUpChildren();
				siftUp(n);
			}
		}
	}

	private void siftDown(Node<T> n) {
		int indexOf = listOfNodes.indexOf(n);
		if (indexOf < (listOfNodes.size() - 1)/2) {
			if(n.value.compareTo(listOfNodes.get(indexOf * 2).value) < 0 || n.value.compareTo(listOfNodes.get(indexOf * 2 + 1).value) < 0 ) {
				if(listOfNodes.get(indexOf * 2).value.compareTo(listOfNodes.get(indexOf * 2 + 1).value) > 0) {
					listOfNodes.set(indexOf, listOfNodes.get(indexOf * 2));
					listOfNodes.set(indexOf * 2, n);
				}
				else {
					listOfNodes.set(indexOf, listOfNodes.get(indexOf * 2 + 1));
					listOfNodes.set(indexOf * 2 + 1, n);
				}
			}
			setUpChildren();
			siftDown(n);
		}
	}

	public T peek() {
		return listOfNodes.get(1).value;
	}

	public T poll() {
		T polledNode = listOfNodes.get(1).value;
		listOfNodes.set(1, listOfNodes.get(listOfNodes.size() - 1));
		listOfNodes.remove(listOfNodes.size() - 1);
		setUpChildren();
		siftDown(listOfNodes.get(1));

		return polledNode;

	}
	private void setUpChildren() {
		for(int i = 1; i < listOfNodes.size(); i++) {
			if(i * 2 > listOfNodes.size() - 1){
				listOfNodes.get(i).left = null;
			}else {
				listOfNodes.get(i).left = listOfNodes.get(i * 2);
			}
			if(i * 2 + 1 > listOfNodes.size() - 1){
				listOfNodes.get(i).right = null;
			}else {
				listOfNodes.get(i).right = listOfNodes.get((i * 2) + 1);
			}
		}
	}

	public void preOrder() {
		preOrder(listOfNodes.get(1));
		System.out.println();
	}

	public void postOrder() {
		postOrder(listOfNodes.get(1));
		System.out.println();
	}

	public void printList() {
		for(int i = 1; i < listOfNodes.size(); i++) {
			System.out.print(listOfNodes.get(i).value + " ");
		}
		System.out.println();
	}

	public void inOrder() {
		inOrder(listOfNodes.get(1));
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
