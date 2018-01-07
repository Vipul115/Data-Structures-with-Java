package stackandqueues;

public class StackPractise {

	public static void main(String[] args) {
		StackUsingArray st = new StackUsingArray();
		
			try {
				for(int i=0;i<200;i++){
					st.push(i);
				}
				
				
				
				
				while(!st.isEmpty()){
					System.out.println(st.pop());
				}
					
				
			} catch (MyStackOverFlow e) {
				e.printStackTrace();
			} catch (MyStackUnderFlow e) {
				e.printStackTrace();
			}
		
	}
}
