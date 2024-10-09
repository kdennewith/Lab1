	import java.util.ArrayList;

	class Node{
		   int value;
		   Node left, right;
		   
		   public Node(int value){
		      this.value = value;
		      left = null;
		      right = null;
		   }

		}

		class BinarySearchTree{

		   Node root;
		  
		   
		   /*
		   recursive insert method
			
		   */
		   /*
		   inserts a node into the tree
		   */
		   public void insert(int value){
		      //tree is empty
		      if(root == null){
		         root = new Node(value);
		         return;
		      }else{
		         Node current = root;
		         Node parent = null;
		         
		         while(true){
		            parent = current;
		            
		            if(value < current.value){
		               current = current.left;
		               if(current == null){
		                  parent.left = new Node(value);
		                  return;
		               }
		            }else{
		               current = current.right;
		               if(current == null){
		                  parent.right = new Node(value);
		                  return;
		               }
		            }
		           
		         }//closing while
		      
		      }//closing main if-else 
		   }
		   
		   /*
		   pre-order traversal
		   Prints the value of every node preorder
		   */
		   /**
		    * Prints the value of every node in pre-order.
		    * @param root The root node of the input BinarySearchTree Object.
		    */
		   public void preOrderTraversal(Node root){
			
			   if(root == null) {
				   return;
			   }
			   
			   System.out.print(root.value + ", ");
			   preOrderTraversal(root.left);
			   preOrderTraversal(root.right);
		   }

		   
		   
		   /*
		   in-order traversal
		   */
		   /**
		    * Prints the value of every node in-order.
		    * @param root The root node of the input BinarySearchTree Object.
		    */
		   public void inOrderTraversal(Node root){
		      
			   if(root == null) {
				   return;
			   }
			   
			   inOrderTraversal(root.left);
			   System.out.print(root.value + ", ");
			   inOrderTraversal(root.right);
		   }
		   
		   
		   
		   /*
		   post-order traversal
		   */
		   /**
		    * Prints the value of every node in post-order.
		    * @param root The root node of the input BinarySearchTree Object.
		    */
		   public void postOrderTraversal(Node root){
	      
			   if(root == null) {
				   return;
			   }
			   
			   postOrderTraversal(root.left);
			   postOrderTraversal(root.right);
			   System.out.print(root.value + ", ");
		   }
		   
		   
		   
		   /*
		   a method to find the node in the tree
		   with a specific value
		   */
		   /**
		    * A method to find a key integer inside of a BinaryTree.
		    * @param root The root node of a BinaryTree object.
		    * @param key An integer to search for in the BinaryTree object.
		    * @return rightTreeCheck Returns the final result, if not already found by the last Node.
		    */
		   public boolean find(Node root, int key){
			 
			   if(root == null) {
				   return false;
			   }
			   
			   if(root.value == key) {
				   return true;
			   }
			   
			   boolean lSubTreeCheck = find(root.left, key);
			   
			   if(lSubTreeCheck == true) {
				   return true;
			   }
			   
			   boolean rSubTreeCheck = find(root.right, key);
			   
			   if(rSubTreeCheck == true) {
				   return true;
			   }
			   
			  return rSubTreeCheck;
		   }
		   
		   
		   
		   /*
		   a method to find the node in the tree
		   with a smallest key
		   */
		   /**
		    * This method get's the minumum key value in the given Binary Tree.
		    * @param root The root node of a BinaryTree object.
		    * @return The first index of the inOrder arraylist which is the min.
		    */
		   public int getMin(Node root){
	      
			   if(root == null) {
				   return Integer.MIN_VALUE;
			   }
			   
			   ArrayList<Integer> inOrder = new ArrayList<>();
			   
			   inOrderArray(root, inOrder);
			   
			   
			   return inOrder.get(0);
		   }
		  
		  
		  
		   /*
		   a method to find the node in the tree
		   with a largest key
		   */
		   /**
		    * This method get's the maximum key value in the given Binary Tree.
		    * @param root The root node of a BinaryTree object.
		    * @return The last index of the inOrder arraylist which is the max.
		    */
		   public int getMax(Node root){
			   if(root == null) {
				   return Integer.MIN_VALUE;
			   }
			   
			   ArrayList<Integer> inOrder = new ArrayList<>();
			   
			   inOrderArray(root, inOrder);
			   
			   return inOrder.get(inOrder.size() - 1);
		   }
		   
		   
		   
		   /*
		   this method will not compile until getMax
		   is implemented
		   */
		   public Node delete(Node root, int key){
		      
		      if(root == null){
		         return root;
		      }else if(key < root.value){
		         root.left = delete(root.left, key);
		      }else if(key > root.value){
		         root.right = delete(root.right, key);
		      }else{
		         //node has been found
		         if(root.left==null && root.right==null){
		            //case #1: leaf node
		            root = null;
		         }else if(root.right == null){
		            //case #2 : only left child
		            root = root.left;
		         }else if(root.left == null){
		            //case #2 : only right child
		            root = root.right;
		         }else{
		            //case #3 : 2 children
		            root.value = getMax(root.left);
		            root.left = delete(root.left, root.value);
		         }
		      }
		      return root;  
		   }
		   
		   public void inOrderArray(Node root, ArrayList<Integer> inOrder){
			      
			   if(root == null) {
				   return;
			   }
			   
			   inOrderArray(root.left, inOrder);
			   inOrder.add(root.value);
			   inOrderArray(root.right, inOrder);
		   }
		   
		}



		public class TreeDemov1{
		   public static void main(String[] args){
		      BinarySearchTree t1  = new BinarySearchTree();
		      t1.insert( 24);
		      t1.insert(80);
		      t1.insert(18);
		      t1.insert(9);
		      t1.insert(90);
		      t1.insert(22);
		            
		      System.out.print("in-order :   ");
		      t1.inOrderTraversal(t1.root);
		      
		           
		      
		   }  
		}