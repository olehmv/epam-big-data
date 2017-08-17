package epam.java.generic;

import java.util.Iterator;
import java.util.List;

public class Generic {

	public static void main(String[] args) {

	}

	public static void exchange(List<Object> list) {
		Object element1 = list.get(0);
		Object element2 = list.get(1);
		list.set(0, element2);
		list.set(1, element1);
	}

	public static <A extends Comparable<A>> A max(List<A> list) {
		Iterator<A> itr = list.listIterator();
		A result = itr.next();
		while (itr.hasNext()) {
			A next = itr.next();
			if (result.compareTo(next) < 0)
				result = next;
		}
		return result;
	}

	public static int findMaxElementFromBeginEnd(List<Integer> list, int start, int end) {
		int result = Integer.MIN_VALUE;
		List<Integer> subList = list.subList(start, end);
		for (Integer integer : subList) {
			if (integer > result) {
				result = integer;
			}
		}
		return result;
	}

	public class Library<T extends Media> {
		private List<T> list;

		public Library(List<T> list) {
			this.list = list;
		}

		public T getMedia(T t) {
			T result = null;
			for (T tt : list) {
				if (t.equals(tt)) {
					result = tt;
				}
			}
			return result;
		}
	}

	public class Media {

	}

	public class Book extends Media {

	}

	public class Video extends Media {

	}

	public class NewsPaper extends Media {

	}

}
