package stackandqueues.queueusingArray;

public class QueueUsingArray {
	int[] data_Array;
	int frontEnd ;
	int backEnd;
	int size;
	public QueueUsingArray() {
		data_Array = new int[10];
		frontEnd=-1;
		backEnd=-1;
		size=0;
	}
	
	public void enqueue(int data) throws QueueOverFlowException{
		if(size==data_Array.length){
			throw new QueueOverFlowException();
		}
		if(size==0){
			frontEnd =0;
		}
		size++;
		backEnd = (backEnd+1)%data_Array.length;
		data_Array[backEnd] = data;
	}

	
	public int dequeue() throws QueueEmptyException{
		if(size==0){
			throw new QueueEmptyException();
		}
		int temp = data_Array[frontEnd];
		frontEnd = (frontEnd+1)%data_Array.length;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
