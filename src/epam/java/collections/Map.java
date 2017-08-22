package epam.java.collections;

public interface Map<K,V> {
	
	interface Entry<K, V> {

		void setValue(V value);

		V getValue();

		K getKey();

	} 
	Entry<K,V>getEntry();
	void put(K key, V value);
	K get(K string);
	int size();

}
