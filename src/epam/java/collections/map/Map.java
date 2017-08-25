package epam.java.collections.map;

import java.util.Iterator;

public interface Map<K, V> {

	interface Entry<K, V> {
		K getKey();

		V getValue();

		V setValue(V newValue);

		/**
		 * This method is invoked whenever the entry is removed from the table
		 */
		void recordRemoval(Map<K, V> m);

		void recordAccess(Map<K, V> m);
	}

	/**
	 * Returns the number of key-value mappings in this map. Returns: the number
	 * of key-value mappings in this map
	 */
	int size();

	/**
	 * Returns true if this map contains no key-value mappings. Returns: true if
	 * this map contains no key-value mappings
	 */
	boolean isEmpty();

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * map contains no mapping for the key. More formally, if this map contains
	 * a mapping from a key k to a value v such that (key==null ? k==null :
	 * key.equals(k)), then this method returns v; otherwise it returns null.
	 * (There can be at most one such mapping.) A return value of null does not
	 * necessarily indicate that the map contains no mapping for the key; it's
	 * also possible that the map explicitly maps the key to null. The
	 * containsKey operation may be used to distinguish these two cases. See
	 * also: put(java.lang.Object,java.lang.Object)
	 */
	V get(Object key);

	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * Parameters: key The key whose presence in this map is to be tested
	 * Returns: true if this map contains a mapping for the specified key.
	 */
	boolean containsKey(Object key);

	/**
	 * Associates the specified value with the specified key in this map. If the
	 * map previously contained a mapping for the key, the old value is
	 * replaced. Parameters: key key with which the specified value is to be
	 * associated value value to be associated with the specified key Returns:
	 * the previous value associated with key, or null if there was no mapping
	 * for key. (A null return can also indicate that the map previously
	 * associated null with key.)
	 */
	V put(K key, V value);

	/**
	 * Removes the mapping for the specified key from this map if present.
	 * Parameters: key key whose mapping is to be removed from the map Returns:
	 * the previous value associated with key, or null if there was no mapping
	 * for key. (A null return can also indicate that the map previously
	 * associated null with key.)
	 */
	V remove(Object key);

	/**
	 * Removes all of the mappings from this map. The map will be empty after
	 * this call returns.
	 */
	void clear();

	Iterator<Map.Entry<K, V>> newEntryIterator();

	Iterator<V> newValueIterator();

	Iterator<K> newKeyIterator();


}
