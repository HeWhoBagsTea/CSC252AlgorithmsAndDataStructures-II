public class Driver {

	public static void main(String[] args) {		
		AVLBasedPriorityQueue<Integer> avl = new AVLBasedPriorityQueue<Integer>();
		HeapBasedPriorityQueue<Integer> heap = new HeapBasedPriorityQueue<Integer>();
		
		heap.offer(2);
		heap.offer(8);
		heap.offer(6);
		heap.offer(4);
		heap.offer(5);
		heap.offer(1);
		heap.offer(3);
//		System.out.println(heap.listOfNodes.size());
//		for(int i = 1; i < heap.listOfNodes.size(); i ++)
//			System.out.print(heap.listOfNodes.get(i).value + " ");
//		System.out.println();
		heap.poll();
//		
//		System.out.println(heap.listOfNodes.size());
//		for(int i = 1; i < heap.listOfNodes.size(); i ++)
//			System.out.print(heap.listOfNodes.get(i).value + " ");
		
		System.out.println();
		heap.inOrder();
		
//		int test = 1;
//		System.out.println(heap.listOfNodes.get(test).value);
//		heap.listOfNodes.get(test).printChildren();
		
//		for(int i = 1; i < heap.listOfNodes.size(); i++)
//			System.out.print(heap.listOfNodes.get(i).value + " ");
//		
//		System.out.println();
//		heap.listOfNodes.get(1).printChildren();
//		System.out.println(heap.listOfNodes.get(1).value);
	}

}