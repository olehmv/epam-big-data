package epam.java.collections.map;

import static org.junit.Assert.assertEquals;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MyMapTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testMapMap() {
		Map<String, Integer> map = new MyMap<String, Integer>();
		map.put("Lars", 1);
		map.put("Lars", 2);
		map.put("Lars", 1);
		map.put(null, 1);
		map.put(null, 1);
		map.remove("Lars");
		assertEquals(map.get("Lars"), null);
		map.clear();
		assertEquals(map.size(), 0);
		for (int i = 0; i < 100; i++) {
			map.put(String.valueOf(i), i);
		}
		assertEquals(map.size(), 100);
		assertEquals(map.get("51").intValue(), 51);
		Iterator<String> itr = map.newKeyIterator();
		while (itr.hasNext()) {
			String next = itr.next();
			if (next.equals("5")) {
				map.remove(next);
			}
		}
		
	}
}
