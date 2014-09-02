import java.util.ArrayList;
import java.util.List;


public class HuffmanTree {

	private byte[] byteArray;
	private List<NodeOld> huffmanNodes = new ArrayList<NodeOld>();
	private List<NodeOld> listOfNodes = new ArrayList<NodeOld>();
	private PriorityQ pq = new PriorityQ();

	HuffmanTree(byte[] byteArray) {
		this.byteArray = byteArray;

		NodeOld<Byte> nextToBeAdded;
		boolean included = false;
		for(int i = 0; i < byteArray.length; i++) {
			nextToBeAdded = new NodeOld<Byte>(byteArray[i]);
			included = false;
			for(int j = 0; j < huffmanNodes.size(); j++) {
				if(huffmanNodes.get(j).value == nextToBeAdded.value) {
					included = true;
					huffmanNodes.get(j).weight += 1;
				}
			}
			if(!included) {
				listOfNodes.add(nextToBeAdded);
				huffmanNodes.add(nextToBeAdded);
			}
		}
		
		for(int i = 0; i < huffmanNodes.size(); i++) {
			pq.offer(huffmanNodes.get(i));
		}

		buildTree();
	}

	private void buildTree() {
		NodeOld pull1 = null;
		NodeOld pull2 = null;
		
		do {
			pull1 = pq.poll();
			pull2 = pq.poll();
			pq.offer(new NodeOld(pull1, pull2));
		} while(pq.head != pq.tail);
		huffmanNodes.clear();
		huffmanNodes.add(pq.poll());
	}

	public byte toByte(Bits bits) {
		NodeOld currentNode = huffmanNodes.get(0);
		currentNode = toByte(currentNode, bits);
		if(currentNode.value == null) return 0;
		return (byte)currentNode.value;
	}

	private NodeOld toByte(NodeOld n, Bits bits) {
		if(n.left == null || bits.size() == 0) return n;
		if(bits.poll())
			return toByte(n.right, bits);
		else
			return toByte(n.left, bits);
	}

	public void fromByte(byte b, Bits bits) {
		NodeOld temp = new NodeOld(b);
		Bits tempBits = new Bits();
		for(int i = 0; i < listOfNodes.size(); i++) {
			if(listOfNodes.get(i).value == temp.value){
				fromByte(listOfNodes.get(i), tempBits);
			}
		}

//		System.out.println(tempBits.size());
		for(int i = tempBits.size() - 1; i >= 0; i--) {
//			System.out.println(tempBits.get(i));
			bits.add(tempBits.get(i));
		}
	}

	private void fromByte(NodeOld n, Bits bits) {
		if(n.parent == null) return;
		if(n.name == n.parent.left.name)
			bits.add(false);
		else
			bits.add(true);
		fromByte(n.parent, bits);
	}


	void printNodes()
	{
		for(int i = 0; i < huffmanNodes.size(); i++){ 
			System.out.println(huffmanNodes.get(i).value + " weight " + huffmanNodes.get(i).weight + " name " + huffmanNodes.get(i).name);
		}		

		preOrder(huffmanNodes.get(0));
		System.out.println();
	}

	private void preOrder(NodeOld n)
	{
		if(n.left != null)
			preOrder(n.left);

		if(n.right != null)
			preOrder(n.right);

		System.out.println(n.name + " " + n.weight);
	}

}
