package epam.java.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Generators {

	public static <T> Collection<T> fill(Collection<T> list, Generator<T> gen, int size) {
		Collection<T> result = New.list();
		for (int i = 0; i < size; i++) {
			result.add(gen.next());
		}
		return result;
	}

	public static <T> List<T> fill(List<T> list, Generator<T> gen, int size) {
		List<T> result = New.list();
		for (int i = 0; i < size; i++) {
			result.add(gen.next());
		}
		return result;
	}

	public static <T> LinkedList<T> fill(LinkedList<T> list, Generator<T> gen, int size) {
		LinkedList<T> result = New.lList();
		for (int i = 0; i < size; i++) {
			result.add(gen.next());
		}
		return result;
	}

	public static <T> Queue<T> fill(Queue<T> list, Generator<T> gen, int size) {
		Queue<T> result = New.queue();
		for (int i = 0; i < size; i++) {
			result.add(gen.next());
		}
		return result;
	}

	public static <T> Set<T> fill(Set<T> list, Generator<T> gen, int size) {
		Set<T> result = New.set();
		for (int i = 0; i < size; i++) {
			result.add(gen.next());
		}
		return result;
	}

	public static void main(String[] args) {
		List<MovieCharacter> list = Generators.fill(new ArrayList<>(), new MovieCharacterGenerator(), 3);
		for (MovieCharacter movieCharacter : list) {
			System.out.println(movieCharacter);
		}
		LinkedList<MovieCharacter> list2 = Generators.fill(new LinkedList<>(), new MovieCharacterGenerator(), 3);
		for (MovieCharacter movieCharacter : list2) {
			System.out.println(movieCharacter);
		}
		Set<MovieCharacter> list3 = Generators.fill(new HashSet<>(), new MovieCharacterGenerator(), 3);
		for (MovieCharacter movieCharacter : list3) {
			System.out.println(movieCharacter);
		}
		Queue<MovieCharacter> list4 = Generators.fill(New.queue(), new MovieCharacterGenerator(), 3);
		for (MovieCharacter movieCharacter : list4) {
			System.out.println(movieCharacter);
		}
		Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
		for (int i : fnumbers)
			System.out.print(i + ", ");
	}

}
