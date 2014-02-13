package abstractDataTypes;

public class AVLTree<T extends Comparable<? super T>> {

	 private static class AVLNode<T>{

		 
		 AVLNode<T>        left;
		 AVLNode<T>        right;
		 T                 data;
		 int               height;
		 AVLNode(T data){
			 this(data,null,null);
			 
		 }
		 AVLNode(T data,AVLNode<T> left,AVLNode<T> right){
			 this.left   =     left;   // the left child
			 this.right  =     right;  // the right child
			 this.data   =     data;   // the data stored in the node
			 this.height =     0;      // the Height
		 }
	 }

	 
	 private AVLNode<T> root;
	 
	 public void insert(T data) {
		 root = this.insert(root, data);
		  
	 }
	 private AVLNode<T> insert(AVLNode<T> parent,T data){
		 if(parent == null) { return new AVLNode<>(data,null,null); }  // base case 
		 
		 int comparison = data.compareTo(parent.data);
		 
		 if      ( comparison < 0 )  { parent.left   =  insert ( parent.left,  data ); }
		 
		 else if ( comparison > 0 )  { parent.right  =  insert ( parent.right, data ); }
		 
		 else {  }
		 
		 return balanceToTheForce(parent);
	 }
	 private AVLNode<T> balanceToTheForce(AVLNode<T> root) {
		 
		 if(root == null) { return root; }
		 
		/* determine if left is higher than the right */
		 if( getHeight(root.left) - getHeight(root.right) > 1 ) {  
			 
			/* determine which left subtree makes the imbalance  */
			 if(getHeight(root.left.left) >= getHeight(root.left.right)  ) { 
				 
				root = this.singleRotateLeft(root); // LEFT LEFT imbalance
				
			} else {
				
				root = this.doubleRotateLeft(root); // LEFT RIGHT imbalance
			}
			 
			 /* determine if right is higher than the left */
		 } else if(getHeight(root.right) - getHeight(root.left) > 1) {
			 
			 /* determine which right subtree makes the imbalance  */
			 if(getHeight(root.right.right) >= getHeight(root.right.left)) {
				 
				 root = this.singleRotateRight(root);  // RIGHT RIGHT imbalance
			 } else {
				 root = this.doubleRotateRight(root);  // RIGHT LEFT imbalance
			 }
		 }
		 
		 
		 return null;
	 }
	 
	 private AVLNode<T> doubleRotateRight(AVLNode<T> root) {
		 
		return null;
	}
	
	private AVLNode<T> doubleRotateLeft(AVLNode<T> root) {
		 
		return null;
	}
	private int getHeight(AVLNode<T> node) {
		 
		 return node == null ? -1 : node.height ;
	 }
	 private AVLNode<T> singleRotateRight(AVLNode<T> root) {
		AVLNode<T> newRoot  = root.right;
		root.right          = newRoot.left;
		newRoot.left        = root;
		newRoot.height      = Math.max( getHeight(newRoot.right), getHeight(newRoot.left)) + 1 ;
		root.height         = Math.max(getHeight(root.right), newRoot.height)              + 1 ;
		return newRoot;
	}
	 private AVLNode<T> singleRotateLeft (AVLNode<T> root) {
		 AVLNode<T> newRoot = root.left;
		 root.left          = newRoot.right;
		 newRoot.right      = root ;
		 newRoot.height     = Math.max( getHeight(newRoot.left), getHeight(newRoot.right)) + 1 ;
		 root.height        = Math.max( getHeight(root.left)   , newRoot.height)           + 1 ;
		 return newRoot;
	 }
	 
}
		