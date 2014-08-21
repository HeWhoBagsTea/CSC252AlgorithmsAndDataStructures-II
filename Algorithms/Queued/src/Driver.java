public class Driver {

	public static void main(String[] args) {		
		AVLBasedPriorityQueue<Integer> avl = new AVLBasedPriorityQueue<Integer>();
		HeapBasedPriorityQueue<Integer> heap = new HeapBasedPriorityQueue<Integer>();
		
		
	//---------------Heap Test----------------\\
//	System.out.println("-----Heap Tests-----");	
//	heap.offer(13);
//	heap.offer(15);
//	heap.offer(20);
//	heap.offer(5);
//	heap.offer(7);
//	heap.offer(11);
//	heap.offer(23);
//
//	System.out.println("---Initial Heap Array---");
//	heap.printList();
//	System.out.println("\n---Peek test--- \nFirst peek: " + heap.peek() + "\nSecond peek: " + heap.peek());
//	System.out.println("\n---Poll test--- \nFirst poll: " + heap.poll() + " \nNew heap array: ");
//	heap.printList();
//	System.out.println("Second poll: " + heap.poll() + " \nNew heap array: ");
//	heap.printList();
//	System.out.println();
		
	//----------------AVL Test----------------\\
	System.out.println("-----AVL Tests-----");	
	avl.offer(63);
	avl.offer(57);
	avl.offer(84);
	avl.offer(30);
	avl.offer(40);
	avl.offer(23);
	avl.offer(15);
	avl.offer(11);
	
	avl.inOrder();
	avl.poll();
	avl.inOrder();
	
	}

}
