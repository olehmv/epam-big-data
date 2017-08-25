package epam.java.collections.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyMap<K, V> implements Map<K, V> {
	/**
	 * The default initial capacity - MUST be a power of two.aka 16
	 */
	static final int DEFAULT_INITIAL_CAPACITY = 4;// 1 << 4;
	/**
	 * The maximum capacity, used if a higher value is implicitly specified by
	 * either of the constructors with arguments. MUST be a power of two <=
	 * 1<<30.
	 */
	static final int MAXIMUM_CAPACITY = 8;// 1 << 30;

	/**
	 * The load factor used when none specified in constructor.
	 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	/**
	 * An empty table instance to share when the table is not inflated.
	 */
	static final Entry<?, ?>[] EMPTY_TABLE = {};
	/**
	 * The table, resized as necessary. Length MUST Always be a power of two.
	 */
	transient Entry<K, V>[] table = (Entry<K, V>[]) EMPTY_TABLE;
	/**
	 * The number of key-value mappings contained in this map.
	 */
	transient int size;

	/**
	 * The next size value at which to resize (capacity * load factor). If table
	 * == EMPTY_TABLE then this is the initial capacity at which the table will
	 * be created when inflated.
	 */
	int threshold;
	/**
	 * The load factor for the hash table.
	 */
	final float loadFactor;

	/**
	 * The number of times this HashMap has been structurally modified
	 * Structural modifications are those that change the number of mappings in
	 * the HashMap or otherwise modify its internal structure (e.g., rehash).
	 * This field is used to make iterators on Collection-views of the HashMap
	 * fail-fast. (See ConcurrentModificationException).
	 */
	transient int modCount;

	/**
	 * Constructs an empty HashMap with the specified initial capacity and load
	 * factor. Parameters: initialCapacity the initial capacity loadFactor the
	 * load factor Throws: java.lang.IllegalArgumentException if the initial
	 * capacity is negative or the load factor is nonpositive
	 */
	public MyMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		if (loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

		this.loadFactor = loadFactor;
		threshold = initialCapacity;
	}

	/**
	 * Constructs an empty HashMap with the specified initial capacity and the
	 * default load factor (0.75). Parameters: initialCapacity the initial
	 * capacity. Throws: java.lang.IllegalArgumentException if the initial
	 * capacity is negative.
	 */
	public MyMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Constructs an empty HashMap with the default initial capacity (16) and
	 * the default load factor (0.75).
	 */
	public MyMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	private static int roundUpToPowerOf2(int number) {
		// assert number >= 0 : "number must be non-negative";
		int rounded = number >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY
				: (rounded = Integer.highestOneBit(number)) != 0
						? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded : 1;

		return rounded;
	}

	/**
	 * Inflates the table.
	 */
	private void inflateTable(int toSize) {
		// Find a power of 2 >= toSize
		int capacity = roundUpToPowerOf2(toSize);

		threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
		table = new Entry[capacity];
	}

	/**
	 * Retrieve object hash code and applies a supplemental hash function to the
	 * result hash, which defends against poor quality hash functions. This is
	 * critical because HashMap uses power-of-two length hash tables, that
	 * otherwise encounter collisions for hashCodes that do not differ in lower
	 * bits. Note: Null keys always map to hash 0, thus index 0.
	 */
	final int hash(Object k) {
		int h = 0;
		h ^= k.hashCode();
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * Returns index for hash code h.
	 */
	static int indexFor(int h, int length) {
		// assert Integer.bitCount(length) == 1 : "length must be a non-zero
		// power of 2";
		return h & (length - 1);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V get(Object key) {
		if (key == null)
			return getForNullKey();
		Entry<K, V> entry = getEntry(key);

		return null == entry ? null : entry.getValue();
	}

	/**
	 * Offloaded version of get() to look up null keys. Null keys map to index
	 * 0. This null case is split out into separate methods for the sake of
	 * performance in the two most commonly used operations (get and put), but
	 * incorporated with conditionals in others.
	 */
	private V getForNullKey() {
		if (size == 0) {
			return null;
		}
		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
			if (e.key == null)
				return e.value;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see epam.java.collections.map.MM#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return getEntry(key) != null;
	}

	/*
	 * Returns the entry associated with the specified key in the HashMap.
	 * Returns null if the HashMap contains no mapping for the key.
	 */
	final Entry<K, V> getEntry(Object key) {
		if (size == 0) {
			return null;
		}

		int hash = (key == null) ? 0 : hash(key);
		for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
				return e;
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (table == EMPTY_TABLE) {
			inflateTable(threshold);
		}
		if (key == null)
			return putForNullKey(value);
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		for (Entry<K, V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		modCount++;
		addEntry(hash, key, value, i);
		return null;
	}

	/**
	 * Offloaded version of put for null keys
	 * 
	 * @param value
	 * @return
	 */
	private V putForNullKey(V value) {
		for (Entry<K, V> e = table[0]; e != null; e = e.next) {
			if (e.key == null) {
				V oldValue = e.value;
				e.value = value;

				return oldValue;
			}
		}
		modCount++;
		addEntry(0, null, value, 0);
		return null;
	}

	/**
	 * Rehashes the contents of this map into a new array with a larger
	 * capacity. This method is called automatically when the number of keys in
	 * this map reaches its threshold. If current capacity is MAXIMUM_CAPACITY,
	 * this method does not resize the map, but sets threshold to
	 * Integer.MAX_VALUE. This has the effect of preventing future calls.
	 * Parameters: newCapacity the new capacity, MUST be a power of two; must be
	 * greater than current capacity unless current capacity is MAXIMUM_CAPACITY
	 * (in which case value is irrelevant).
	 */
	private void resize(int newCapacity) {
		Entry[] oldTable = table;
		int oldCapacity = oldTable.length;
		if (oldCapacity == MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return;
		}

		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable);
		table = newTable;
		threshold = (int) Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
	}

	/**
	 * Transfers all entries from current table to newTable.
	 * 
	 * @param newTable
	 */
	private void transfer(Entry[] newTable) {
		int newCapacity = newTable.length;
		for (Entry<K, V> e : table) {
			while (null != e) {
				Entry<K, V> next = e.next;

				int i = indexFor(e.hash, newCapacity);
				e.next = newTable[i];
				newTable[i] = e;
				e = next;
			}
		}
	}

	
	@Override
	public V remove(Object key) {
		Entry<K, V> e = removeEntryForKey(key);
		return (e == null ? null : e.value);
	}

	/**
	 * Removes and returns the entry associated with the specified key in the
	 * HashMap. Returns null if the HashMap contains no mapping for this key.
	 */
	final Entry<K, V> removeEntryForKey(Object key) {
		if (size == 0) {
			return null;
		}
		int hash = (key == null) ? 0 : hash(key);
		int i = indexFor(hash, table.length);
		Entry<K, V> prev = table[i];
		Entry<K, V> e = prev;

		while (e != null) {
			Entry<K, V> next = e.next;
			Object k;
			if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
				modCount++;
				size--;
				if (prev == e)
					table[i] = next;
				else
					prev.next = next;
				e.recordRemoval(this);
				return e;
			}
			prev = e;
			e = next;
		}

		return e;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see epam.java.collections.map.MM#clear()
	 */
	@Override
	public void clear() {
		modCount++;
		Arrays.fill(table, null);
		size = 0;
	}

	static class Entry<K, V> implements Map.Entry<K, V> {

		final K key;
		V value;
		Entry<K, V> next;
		int hash;

		Entry(int h, K k, V v, Entry<K, V> n) {
			value = v;
			next = n;
			key = k;
			hash = h;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see epam.java.collections.map.I#getKey()
		 */
		@Override
		public final K getKey() {
			return key;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see epam.java.collections.map.I#getValue()
		 */
		@Override
		public final V getValue() {
			return value;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see epam.java.collections.map.I#setValue(V)
		 */
		@Override
		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o) {
			if (!(o instanceof Map.Entry))
				return false;
			Map.Entry e = (Map.Entry) o;
			Object k1 = getKey();
			Object k2 = e.getKey();
			if (k1 == k2 || (k1 != null && k1.equals(k2))) {
				Object v1 = getValue();
				Object v2 = e.getValue();
				if (v1 == v2 || (v1 != null && v1.equals(v2)))
					return true;
			}
			return false;
		}

		public final int hashCode() {
			return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
		}

		public final String toString() {
			return getKey() + "=" + getValue();
		}

		@Override
		public void recordAccess(Map<K, V> m) {
		}

		@Override
		public void recordRemoval(Map<K, V> m) {
		}
	}

	/**
	 * Adds a new entry with the specified key, value and hash code to the
	 * specified bucket. It is the responsibility of this method to resize the
	 * table if appropriate.Subclass overrides this to alter the behavior of put
	 * method
	 */
	private void addEntry(int hash, K key, V value, int bucketIndex) {
		if ((size >= threshold) && (null != table[bucketIndex])) {
			resize(2 * table.length);
			hash = (null != key) ? hash(key) : 0;
			bucketIndex = indexFor(hash, table.length);
		}

		createEntry(hash, key, value, bucketIndex);
	}

	/**
	 * Like addEntry except that this version is used when creating entries as
	 * part of Map construction or "pseudo-construction" (cloning,
	 * deserialization). This version needn't worry about resizing the table.
	 * Subclass overrides this to alter the behavior of HashMap(Map), clone, and
	 * readObject.
	 */
	private void createEntry(int hash, K key, V value, int bucketIndex) {
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<>(hash, key, value, e);
		size++;
	}

	private abstract class HashIterator<E> implements Iterator<E> {

		Entry<K, V> next; // next entry to return

		int expectedModCount; // For fast-fail

		int index; // current slot

		Entry<K, V> current; // current entry

		HashIterator() {
			expectedModCount = modCount;
			if (size > 0) { // advance to first entry
				Entry[] t = table;
				while (index < t.length && (next = t[index++]) == null)
					;
			}
		}

		public final boolean hasNext() {
			return next != null;
		}

		final Entry<K, V> nextEntry() {
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			Entry<K, V> e = next;
			if (e == null)
				throw new NoSuchElementException();

			if ((next = e.next) == null) {
				Entry[] t = table;
				while (index < t.length && (next = t[index++]) == null)
					;
			}
			current = e;
			return e;
		}

		public void remove() {
			if (current == null)
				throw new IllegalStateException();
			if (modCount != expectedModCount)
				throw new ConcurrentModificationException();
			Object k = current.key;
			current = null;
			MyMap.this.removeEntryForKey(k);
			expectedModCount = modCount;
		}
	}

	private final class ValueIterator extends HashIterator<V> {
		public V next() {
			return nextEntry().value;
		}
	}

	private final class KeyIterator extends HashIterator<K> {
		public K next() {
			return nextEntry().getKey();
		}
	}

	private final class EntryIterator extends HashIterator<Map.Entry<K, V>> {
		public Map.Entry<K, V> next() {
			return nextEntry();
		}
	}

	// Subclass overrides these to alter behavior of views' iterator() method
	@Override
	public Iterator<K> newKeyIterator() {
		return new KeyIterator();
	}

	@Override
	public Iterator<V> newValueIterator() {
		return new ValueIterator();
	}

	@Override
	public Iterator<Map.Entry<K, V>> newEntryIterator() {
		return new EntryIterator();
	}

}

// @SuppressWarnings("unchecked")
// public MyMap() {
// super();
// table = new MyEntry[DEFAULT_INITIAL_CAPACITY];
// }
//
// private int hash(Object o) {
// int h = o.hashCode();
// h = h ^ (h >>> 7) ^ (h >>> 4);
// return h;
// }
//
// @Override
// public Iterator<K> iterator() {
// return null;
// }
//
// @Override
// public Entry<K, V> getEntry() {
// return null;
// }
//
// public class MyEntry<Key, Value> implements Entry<Key, Value> {
// private int hash;
// private Key key;
// private Value value;
// private Entry<Key, Value> next;
//
// public MyEntry(Key key, Value value) {
// super();
// this.key = key;
// this.value = value;
// this.hash = hash(key);
// }
//
// @Override
// public Value getValue() {
// return value;
// }
//
// @Override
// public Key getKey() {
// return key;
// }
//
// @Override
// public Entry<Key, Value> getNext() {
// return next;
// }
//
// @Override
// public Entry<Key, Value> setNext(Entry<Key, Value> e) {
// return next = e;
// }
//
// }
//
// private boolean isTableFull() {
// int count = 0;
// for (Entry<K, V> entry : table) {
// if (entry != null)
// count++;
// }
// return count == table.length;
// }
//
// transient Entry<K, V>[] tabl = (Entry<K, V>[]) EMPTY_TABLE;
//
// @Override
// public void put(K key, V value) {
// if (isTableFull()) {
// @SuppressWarnings("unchecked")
// Entry<K, V>[] newTable = new MyEntry[DEFAULT_TABLE_SIZE * 2];
// System.arraycopy(table, 0, newTable, 0, table.length);
// table = newTable;
// }
// int index = hash(key) & (table.length - 1);
// Entry<K, V> e = table[index];
// do {
// if (e == null || e.getKey().equals(key)) {
// table[index] = new MyEntry<K, V>(key, value);
// break;
// }
// if (e.getNext() == null) {
// e.setNext(new MyEntry<K, V>(key, value));
// break;
// }
// e = e.getNext();
//
// } while (e != null);
// }
//
//// private Entry<K, V> createEntry(K key, V value) {
//// return new MyEntry<K, V>(key, value);
//// }
//
// @Override
// public V get(K key) {
// Entry<K, V> e = null;
// V v = null;
// int hash = hash(key);
// for (int i = 0; i < table.length; i++) {
// e = table[i];
// if (e != null && key.equals(e.getKey()) && hash == hash(e.getKey())) {
// v = e.getValue();
// }
// }
//
// return v;
// }
//
// @Override
// public int size() {
// return table.length;
// }
