import java.util.ArrayList;
import java.util.List;


public class HuffmanTree {

	private byte[] byteArray;
	private List<Node> huffmanNodes = new ArrayList<Node>();
	private List<Node> listOfNodes = new ArrayList<Node>();

	HuffmanTree(byte[] byteArray) {
		this.byteArray = byteArray;

		Node<Byte> nextToBeAdded;
		boolean included = false;
		for(int i = 0; i < byteArray.length; i++) {
			nextToBeAdded = new Node<Byte>(byteArray[i]);
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

		sortNodes();
		buildTree();
	}

	private void sortNodes() {
		List<Node> temp = new ArrayList<Node>();
		temp.addAll(huffmanNodes);
		huffmanNodes.clear();

		int smallest = Integer.MAX_VALUE;
		int index = Integer.MAX_VALUE;
		while(!temp.isEmpty()){
			smallest = Integer.MAX_VALUE;
			index = Integer.MAX_VALUE;
			for(int i = 0; i < temp.size(); i++){
				if(temp.get(i).weight < smallest){
					smallest = temp.get(i).weight;
					index = i;
				}
			}
			huffmanNodes.add(temp.get(index));
			temp.remove(index);
		}
	}

	private void buildTree() {
		Node pull1 = null;
		Node pull2 = null;

		while(huffmanNodes.size() > 1) {
			pull1 = huffmanNodes.get(0);
			huffmanNodes.remove(0);
			pull2 = huffmanNodes.get(0);
			huffmanNodes.remove(0);
			huffmanNodes.add(new Node(pull1, pull2));
			sortNodes();
		}
	}

	public byte toByte(Bits bits) {
		Node currentNode = huffmanNodes.get(0);
		currentNode = toByte(currentNode, bits);
		if(currentNode.value == null) return 0;
		return (byte)currentNode.value;
	}

	private Node toByte(Node n, Bits bits) {
		if(n.left == null || bits.size() == 0) return n;
		if(bits.poll())
			return toByte(n.right, bits);
		else
			return toByte(n.left, bits);
	}

	public void fromByte(byte b, Bits bits) {
		Node temp = new Node(b);
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

	private void fromByte(Node n, Bits bits) {
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

	private void preOrder(Node n)
	{
		if(n.left != null)
			preOrder(n.left);

		if(n.right != null)
			preOrder(n.right);

		System.out.println(n.name + " " + n.weight);
	}

}
