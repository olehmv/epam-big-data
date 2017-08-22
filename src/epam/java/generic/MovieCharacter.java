package epam.java.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class MovieCharacter {
	private static int count = 0;
	final int id = count++;

	@Override
	public String toString() {
		return "MovieCharacter " + getClass().getSimpleName() + " [id=" + id + "]";
	}

	public static void main(String[] args) {
		MovieCharacterGenerator movie = new MovieCharacterGenerator(4);
		for (MovieCharacter m : movie) {
			System.out.println(m);
		}
	}
}

class Vovk extends MovieCharacter {
}

class Zaetz extends MovieCharacter {
}

class Tom extends MovieCharacter {
}

class Jerry extends MovieCharacter {
}

class MovieCharacterGenerator implements Generator<MovieCharacter>, Iterable<MovieCharacter> {
	Class[] a = { Vovk.class, Zaetz.class, Tom.class, Jerry.class };
	int size;

	public MovieCharacterGenerator() {
	}
	public MovieCharacterGenerator(int size) {
		this.size = size;
	}

	@Override
	public Iterator<MovieCharacter> iterator() {
		return new CharacterIterator();
	}

	@Override
	public MovieCharacter next() {
		Random r = new Random(31);

		try {
			return (MovieCharacter) a[r.nextInt(a.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CharacterIterator implements Iterator<MovieCharacter> {
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public MovieCharacter next() {
			count--;
			return MovieCharacterGenerator.this.next();
		}

	}

}



class GenericMethods {
	public <T, E, Integer> void f(T x, E e, Integer i) {
		System.out.println(x.getClass().getName());
	}

	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('i');
		gm.f(gm);
	}
}
