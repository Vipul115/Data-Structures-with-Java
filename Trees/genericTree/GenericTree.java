package generictree;

import java.util.Scanner;

public class GenericTree {
	static Scanner s = new Scanner(System.in);
//5 3 7 0 9 2 2 0 1 0 4 0
	
	
	
	public static  void printTree(GenericTreeNode<Integer> root) {
		String toBePrinted = root.data+": ";
		for (int i = 0; i < root.childrens.size(); i++) {
			toBePrinted = toBePrinted+"," +root.childrens.get(i).data;
		}
		System.out.println(toBePrinted);
		
		for (int i = 0; i < root.childrens.size(); i++) {
			printTree(root.childrens.get(i));
		}

	}

	public static <T>int count(GenericTreeNode<T> root) {
		int max = root.data;
		
		for (int i = 0; i < root.childrens.size(); i++) {
			int temp  = count(root.childrens.get(i));
			if(temp>max){
				max = temp;
			}
		}
		return max;
	}
	
	
	static GenericTreeNode<Integer> prepareTree() {

		
		System.out.println("Enter data");
		int data = s.nextInt();
		GenericTreeNode<Integer> root = new GenericTreeNode<>(data);
		System.out.println("Enter no. of children");
		int noOfChildren = s.nextInt();
		for (int i = 0; i < noOfChildren; i++) {
			root.childrens.add(prepareTree());
		}
		return root;
	}

	public static void main(String[] args) {

		GenericTreeNode<Integer> root = prepareTree();
		printTree(root);
//		GenericTreeNode<Integer> root5 = new GenericTreeNode<>(5);
//		GenericTreeNode<Integer> root7 = new GenericTreeNode<>(7);
//		GenericTreeNode<Integer> root9 = new GenericTreeNode<>(9);
//		GenericTreeNode<Integer> root4 = new GenericTreeNode<>(4);
//		GenericTreeNode<Integer> root2 = new GenericTreeNode<>(2);
//		GenericTreeNode<Integer> root1 = new GenericTreeNode<>(1);
//		root5.childrens.add(root7);
//		root5.childrens.add(root9);
//		root5.childrens.add(root4);
//		root9.childrens.add(root2);
//		root9.childrens.add(root1);

	}
}
