package genericTree;

import java.util.ArrayList;

public class GenericTreeNode<T> {
	T data;

	int level;
	ArrayList<GenericTreeNode<T>> children;

	public GenericTreeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}
}
