package hashmapPractise;

import hashmapPractise.customhashmap.CustomHashMap;

import java.util.HashMap;

public class HashMapPractise {

	public static void main(String[] args) {
		CustomHashMap<Integer, String> map = new CustomHashMap<>();
		map.put(2, "Amit");
		map.put(6, "Kallu");
		map.put(9, "Ghansham");
		map.put(6, "Sayam");
		System.out.println(map.get(6));
		
		
		
		
		for(Integer x: map.keySet()){
			System.out.println(x);
		}
		
//		for(String x: map.values()){
//			System.out.println(x);
//		}
//		
//		map.remove(6);
		System.out.println(map.get(6));
		
//		for(Map.Entry<Integer, String> entry:map.entrySet()){
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
		
		
		
		
		
		
		
		
		System.out.println(map.get(9));
	}
}
