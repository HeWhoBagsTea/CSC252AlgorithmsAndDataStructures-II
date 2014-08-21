
public class TreeTraverse {


	Node root;
	
	TreeTraverse()
	{
	}
	
	public void preOrder(Node n)
	{
		if(n.left != null)
			preOrder(n.left);
		
		if(n.right != null)
			preOrder(n.right);
		
		System.out.print(n.value + " ");
	}
	
	public void inOrder(Node n)
	{
		if(n.left != null)
			inOrder(n.left);
		
		System.out.print(n.value + " ");
		
		if(n.right != null)
			inOrder(n.right);
	}
	
	public void postOrder(Node n)
	{
		if(n.right != null)
			postOrder(n.right);
		
		if(n.left != null)
			postOrder(n.left);
		
		System.out.print(n.value + " ");
	}

}
