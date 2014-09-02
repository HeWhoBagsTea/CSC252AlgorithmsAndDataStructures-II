
public class PriorityQ {
	NodeOld head;
	NodeOld tail;
	
	public NodeOld poll() {
		NodeOld temp = head;
		head = head.next;
		return temp;
	}
	
	public void offer(NodeOld n) {
		
		if(head == null) {
			head = n;
			tail = head;
		}
		else if(n.weight <= head.weight) {
			NodeOld temp = head;
			head = n;
			head.next = temp;
		}
		else if(n.weight > head.weight){
			if(head.next != null) {
				NodeOld current = head.next;
				NodeOld previous = head;
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
						NodeOld temp = n;
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
