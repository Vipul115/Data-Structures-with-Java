package genericTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import stackandqueues.queueusinglinkedlist.QueueUnderFlowException;

public class GenricTreePractise {
	static Scanner s = new Scanner(System.in);

	// 5 3 4 2 3 0 1 0 7 0 6 0
	public static GenericTreeNode<Integer> prepareTree() {

		System.out.println("Enter data");
		int data = s.nextInt();

		GenericTreeNode<Integer> root = new GenericTreeNode<>(data);
		System.out.println("Enter no. of children");
		int noOfChildren = s.nextInt();
		for (int i = 0; i < noOfChildren; i++) {
			root.children.add(prepareTree());
		}
		return root;
	}

	public static <T> void printTree(GenericTreeNode<T> root) {
		System.out.println(root.data);

		for (GenericTreeNode<T> child : root.children) {
			printTree(child);
		}

		// for(int i=0;i<root.children.size();i++){
		// printTree(root.children.get(i));
		// }
	}

	public static <T> int count(GenericTreeNode<T> root) {
		int count = 1;

		for (int i = 0; i < root.children.size(); i++) {
			count = count + count(root.children.get(i));
		}

		return count;
	}

	public static void main(String[] args) {

		GenericTreeNode<Integer> root = prepareTree();
		printTree(root);

		// GenericTreeNode<Integer> root5 = new GenericTreeNode<Integer>(5);
		// GenericTreeNode<Integer> root4 = new GenericTreeNode<Integer>(4);
		// GenericTreeNode<Integer> root7 = new GenericTreeNode<Integer>(7);
		// GenericTreeNode<Integer> root6 = new GenericTreeNode<Integer>(6);
		// GenericTreeNode<Integer> root3 = new GenericTreeNode<Integer>(3);
		// GenericTreeNode<Integer> root1 = new GenericTreeNode<Integer>(1);
		//
		// root5.children.add(root4);
		// root5.children.add(root7);
		// root5.children.add(root6);
		// root4.children.add(root3);
		// root4.children.add(root1);
	}

	GenericTreeNode<Integer> prepareTreeUsingQueue()
			throws QueueUnderFlowException {
		System.out.println("Enter data");
		int data = s.nextInt();
		GenericTreeNode<Integer> root = new GenericTreeNode<>(data);
		// QueueUsingLinkedList<GenericTreeNode<Integer>> queue = new
		// QueueUsingLinkedList<>();
		Queue<GenericTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			GenericTreeNode<Integer> currentNode = queue.remove();
			System.out.println("No of children: ");
			int noOfChildren = s.nextInt();

			for (int i = 0; i < noOfChildren; i++) {
				System.out.println("Enter " + i + "th child data");
				int childData = s.nextInt();
				GenericTreeNode<Integer> child = new GenericTreeNode<>(
						childData);
				currentNode.children.add(child);
				queue.add(child);
			}
		}

		return root;
	}

	
	

	<T>int height(GenericTreeNode<T> root)
			throws QueueUnderFlowException {

		Queue<GenericTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int count =0;
		while (!queue.isEmpty()) {
			GenericTreeNode<T> currentNode = queue.remove();
			if(currentNode==null&&!queue.isEmpty()){
				count++;
				queue.add(null);
				continue;
			}
			
			for (int i = 0; i < currentNode.children.size(); i++) {				
				queue.add(currentNode.children.get(i));
			}
		}

		return count;
	}
}
