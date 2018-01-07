package stackandqueues;

class MyStackUnderFlow extends Exception {

}

class MyStackOverFlow extends Exception {

}

public class StackUsingArray {
	private int[] data_Array;
	private int top;

	public StackUsingArray() {
		this.data_Array = new int[10];
		top = -1;
	}

	public StackUsingArray(int size) {
		this.data_Array = new int[size];
		top = -1;
	}

	void push(int data) throws MyStackOverFlow {
		if (isFull()) {
			// throw new MyStackOverFlow();
			grow();
		}
		System.out.println("Push");
		data_Array[++top] = data;
	}

	private void grow() {
		int[] temp = data_Array;
		data_Array = new int[temp.length*2];
		for(int i=0;i<temp.length;i++){
			data_Array[i] = temp[i];
		}
		
		
		System.out.println("Grow : " +temp.length +" "+data_Array.length);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	int pop() throws MyStackUnderFlow {
		if (isEmpty()) {
			throw new MyStackUnderFlow();
		}
		int data = data_Array[top];
		top--;
		System.out.println("pop");
		return data;
	}

	int peek() throws MyStackUnderFlow {
		if (top == -1) {
			throw new MyStackUnderFlow();
		}
		return data_Array[top];
	}

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == data_Array.length - 1 ? true : false;

	}

	//
	// print(){
	//
	// }

	// reset(){
	//
	// }

	int size() {
		return top + 1;
	}
}
