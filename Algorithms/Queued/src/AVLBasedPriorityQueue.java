
public class AVLBasedPriorityQueue<T> {
	private AVLBasedNode<T> root;
	
	// add value into the right place in the AVL tree
	boolean offer(T data){
		boolean added = false;
		AVLBasedNode<T> offered = new AVLBasedNode<T>(data);
		AVLBasedNode<T> checkAgainst = root;
		
		while(!added) {
			if(root == null) {
				root = offered;
				added = true;
			}
			else {
				if(offered.value == checkAgainst.value){
					checkAgainst.weight += 1;
				}
			}
		}
		
		
		return added;
	}

	//see, but do not remove the highest priority value
	boolean peek(){
		AVLBasedNode<T> highest = root;
		
		while(highest.right != null) {
			highest = highest.right;
		}
		
		System.out.println(highest.value);
		return true;
	}
}
