
public class PriorityQ {
	Node head;
	Node tail;
	
	public Node poll() {
		Node temp = head;
		head = head.next;
		return temp;
	}
	
	public void offer(Node n) {
		
		if(head == null) {
			head = n;
			tail = head;
		}
		else if(n.weight <= head.weight) {
			Node temp = head;
			head = n;
			head.next = temp;
		}
		else if(n.weight > head.weight){
			if(head.next != null) {
				Node current = head.next;
				Node previous = head;
				boolean added = false;
				
				while(!added) {
					if(current == tail && n.weight > current.weight) {
						added = true;
						tail.next = n;
						tail = tail.next;
						tail.next = null;
					}
					else if(n.weight > current.weight) {
						previous = current;
						current = current.next;
					}
					else if(n.weight <= current.weight) {
						added= true;
						Node temp = n;
						temp.next = current;
						previous.next = temp;
					}
				}
			}
			else {
				tail.next = n;
				tail = tail.next;
			}
		}
	}
}