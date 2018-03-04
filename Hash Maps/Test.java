package hashmapPractise;

import java.util.ArrayList;

class Student {
	String name;
	int rollNo;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.rollNo == ((Student) obj).rollNo;
	}

	@Override
	public int hashCode() {
		return 7;
	}

}

public class Test {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(40);
		list.add(1, 8);
//		Student s1 = new Student();
//		Student s2 = new Student();
//		if (s1.equals(s2)) {
//			System.out.println("equal");
//		} else {
//			System.out.println("Not equal");
//		}
//
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
	}
}
