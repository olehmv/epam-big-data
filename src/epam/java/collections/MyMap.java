package epam.java.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V>, Iterable<K> {

	private Entry<K, V> entry;
	private Set<K> keySet;
	private List<V> valueList;

	public MyMap() {
		super();
		keySet = new HashSet<>();
		valueList = new ArrayList<>();
	}

	@Override
	public Iterator<K> iterator() {
		return null;
	}

	@Override
	public Entry getEntry() {
		return entry;
	}

	class MyEntry<K, V> implements Entry<K, V> {
		private K key;
		private V value;

		@Override
		public void setValue(V value) {
			this.value = value;

		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public K getKey() {
			return key;
		}

	}

	@Override
	public void put(Object key, Object value) {
	
	}

	@Override
	public K get(Object key) {
		for (K k : keySet) {
			if (key.equals(k)) {
				return k;
			}

		}
		return null;
	}

	@Override
	public int size() {
		return keySet.size();
	}

}
