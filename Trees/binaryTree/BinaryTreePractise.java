package binaryTree;

import java.util.Scanner;

public class BinaryTreePractise {
	static Scanner s = new Scanner(System.in);

	BinaryTreeNode<Integer> prepareTree() {
		System.out.println("Enter data");

		int data = s.nextInt();
		if (data == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
		root.left = prepareTree();
		root.right = prepareTree();
		return root;
	}

	<T> void printTree(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}

		printTree(root.left);
		printTree(root.right);
		System.out.println(root.data);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
		root.left = new BinaryTreeNode<>(20);
		root.right = new BinaryTreeNode<>(30);
		root.left.left = new BinaryTreeNode<>(40);
	}

	<T> int diameter(BinaryTreeNode<T> root) {
		if (root == null) {
			return 0;
		}

		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);
		int x = height(root.left) + height(root.right) + 1;

		return Math.max(Math.max(leftDiameter, rightDiameter), x);

	}

	<T> DiameterReturnType diameterBetter(BinaryTreeNode<T> root) {
		if (root == null) {
			//return 0;
			return new DiameterReturnType(0, 0);
		}

		DiameterReturnType leftDiameter = diameterBetter(root.left);
		DiameterReturnType rightDiameter = diameterBetter(root.right);
		//int x = height(root.left) + height(root.right) + 1;
		int x = leftDiameter.height +rightDiameter.height+1;
		int currentDiameter= Math.max(Math.max(leftDiameter.diameter, rightDiameter.diameter), x);
		int currentHeight = Math.max(leftDiameter.height,rightDiameter.height)+1;
		DiameterReturnType ans = new DiameterReturnType(currentDiameter, currentHeight);
		return ans;
	}

	
	int preIndex =0;
	BinaryTreeNode<Integer> constructTreeUsingIn_pre(int[] in, int[] pre, int startIndex, int endIndex){
		if(startIndex>endIndex){
			return null;
		}
		int data = pre[preIndex++];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		int index = search(in,data);
		root.left= constructTreeUsingIn_pre(in, pre,startIndex,index-1 );
		root.right = constructTreeUsingIn_pre(in, pre,index+1,endIndex);
		return root;
		
	}
	
	
	
	
	
	boolean isBSTTopDown(BinaryTreeNode<Integer> root){
		if(root==null){
			return true;
		}
		
		int max = getMaxinBT(root.left);//binary tree
		int min = getMininBT(root.right);//binary tree
		
		if(max>root.data.intValue() || (min<root.data.intValue())){
			return false;
		}
		
		return isBSTTopDown(root.left) && isBSTTopDown(root.right);
	}
	
	
	boolean isBSTBottomUp(BinaryTreeNode<Integer> root){
		if(root==null){
			return true;
		}
		
		
		
		if( !isBSTBottomUp(root.left) || !isBSTBottomUp(root.right)){
			return false;
		}
		int max = getMaxinBST(root.left);//bst tree
		int min = getMininBST(root.right);//bst tree
		
		if(max>root.data.intValue() || (min<root.data.intValue())){
			return false;
		}
		return true;
	}
	
	IsBSTReturnType isBSTBottomUpBetter(BinaryTreeNode<Integer> root){
		if(root ==null){
			return new IsBSTReturnType();
		}
		if(root.left==null&&root.right==null){
			 IsBSTReturnType ans= new IsBSTReturnType();
			 ans.min = root.data;
			 ans.max = root.data;
			return ans;
		}
		if(root.left==null&&root.right!=null){
			 IsBSTReturnType ans= new IsBSTReturnType();
			 ans.min = root.data;
			 return ans;
		}
		if(root.left!=null&&root.right==null){
			 IsBSTReturnType ans= new IsBSTReturnType();
			 ans.max = root.data;
			 ans.min = 
			return ans;
		}
		
		
		IsBSTReturnType ans = new IsBSTReturnType();
		IsBSTReturnType leftAns = isBSTBottomUpBetter(root.left);
		if(!leftAns.isBST){
			ans.isBST = false;
			return ans;
		}
		IsBSTReturnType rightAns = isBSTBottomUpBetter(root.right);
		if(!rightAns.isBST){
			ans.isBST = false;
			return ans;
		}

		if(leftAns.max>root.data.intValue() || (rightAns.min<root.data.intValue())){
			ans.isBST = false;
			return ans;
		}
		ans.isBST = true;
		ans.min = leftAns.min;
		ans.max = rightAns.max;
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

class IsBSTReturnType{
	boolean isBST;
	int max;
	int min;
	
	public IsBSTReturnType() {
		this.isBST = true;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
}












class DiameterReturnType {
	int diameter;
	int height;

	DiameterReturnType(int diameter, int height) {
		this.diameter = diameter;
		this.height = height;

	}
}
