package epam.java.generic;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import static epam.java.generic.Watercolors.*;

public class Sets {

	public static <T> Set<T> union1(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}

	public static Set union(Set a, Set b) {
		Set result = null;
		if (a instanceof EnumSet)
			result = ((EnumSet) a).clone();
		else
			result = new HashSet<>(a);
		result.addAll(b);

		return result;
	}

	public static <T> Set<T> union(Class<T> a, Class<T> b) {
		Set<T> result = null;
		try {
			result = (Set<T>) a.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}

	// Subtract subset from superset:
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}

	// Reflexive--everything not in the intersection:
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}

	public static void main(String[] args) {
		Set<Watercolors> s = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> s1 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		EnumSet<Watercolors> w = EnumSet.allOf(Watercolors.class);
		EnumSet<Watercolors> w1 = EnumSet.allOf(Watercolors.class);
		System.out.println(union(w, w1));
		System.out.println(union(s, s1));

	}
}
