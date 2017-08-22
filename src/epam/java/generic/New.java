package epam.java.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class New {
	public static <K, V>/*<-- declaration*/ Map<K, V> /*<-- return type*/map() {
		return new HashMap<K, V>();
	}
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}

	public static <T> LinkedList<T> lList() {
		return new LinkedList<T>();
	}

	public static <T> Set<T> set() {
		return new HashSet<T>();
	}

	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
		 public static void main(String[] args) {
		 Map<MovieCharacterGenerator, List<? super MovieCharacter>> map = New.map();//type inference
		 MovieCharacterGenerator generator = new MovieCharacterGenerator(2);
		 map.put(generator, new ArrayList<>());
		 List<? super MovieCharacter> list = map.get(generator);
		Iterator<MovieCharacter> iterator = generator.iterator();
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
		List<? super MovieCharacter> list2 = map.get(generator);
		System.out.println(list2.toString());
		 
		 } 

}