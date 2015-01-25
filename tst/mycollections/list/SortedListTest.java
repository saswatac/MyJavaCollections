package mycollections.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import mycollections.list.SortedList;

import org.junit.Test;

public class SortedListTest {

	@Test
	public void testAddOrdering() {
		SortedList<Integer> list = new SortedList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		int[] expected = new int[3];
		expected[0] = 1;
		expected[1] = 2;
		expected[2] = 3;
		int c = 0;
		for (Integer i : list) {
			assertEquals(i.intValue(), expected[c]);
			c++;
		}
	}

	@Test
	public void testSize() {

		SortedList<Integer> list = new SortedList<>();
		list.add(3);
		list.add(1);
		assertTrue(list.size() == 2);
	}

	@Test
	public void testAddOrderingDuplicateRemoved() {
		SortedList<Integer> list = new SortedList<>();
		list.add(3);
		list.add(1);
		list.add(3);
		int[] expected = new int[2];
		expected[0] = 1;
		expected[1] = 3;
		assertTrue(list.size() == 2);
		int c = 0;
		for (Integer i : list) {
			assertEquals(i.intValue(), expected[c]);
			c++;
		}
	}

	@Test
	public void testAddOrderingDuplicatesPresent() {
		SortedList<Pair> list = new SortedList<>();
		Pair p1 = new Pair(1,3);
		Pair p2 = new Pair(2,1);
		Pair p3 = new Pair(3,3);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		Pair[] expected = new Pair[3];
		expected[0] = p2;
		expected[1] = p1;
		expected[2] = p3;
		int c = 0;
		assertTrue(list.size() == 3);
		for (Pair p : list) {
			assertEquals(p, expected[c]);
			c++;
		}
	}
	
	@Test
	public void testContainTrueDuplicatesPresent() {
		SortedList<Pair> list = new SortedList<>();
		Pair p1 = new Pair(1,3);
		Pair p2 = new Pair(2,1);
		Pair p3 = new Pair(3,3);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		assertTrue(list.contains(p1));
	}
	
	@Test
	public void testContainFalseDuplicatesPresent() {
		SortedList<Pair> list = new SortedList<>();
		Pair p1 = new Pair(1,3);
		Pair p2 = new Pair(2,1);
		Pair p3 = new Pair(3,3);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		assertFalse(list.contains(new Pair(4,3)));
	}
	
	@Test
	public void testContainsAllTrueDuplicatesPresent() {
		SortedList<Pair> list = new SortedList<>();
		Pair p1 = new Pair(1,3);
		Pair p2 = new Pair(2,1);
		Pair p3 = new Pair(3,3);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		assertTrue(list.containsAll(list));
	}
	
	@Test
	public void testContainsAllFalseDuplicatesPresent() {
		SortedList<Pair> list = new SortedList<>();
		Pair p1 = new Pair(1,3);
		Pair p2 = new Pair(2,1);
		Pair p3 = new Pair(3,3);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		List<Pair> newList = new ArrayList<>(list);
		newList.add(new Pair(0,0));
		
		assertFalse(list.containsAll(newList));
	}
	
	@Test
	public void testContainsWhenEmpty() {
		SortedList<Integer> list = new SortedList<>();
		assertFalse(list.contains(3));
	}
	
	@Test
	public void testContainsEmptyListWhenEmpty() {
		SortedList<Integer> list = new SortedList<>();
		assertTrue(list.containsAll(new ArrayList<>()));
	}
	
	@Test
	public void testContainsEmptyList() {
		SortedList<Integer> list = new SortedList<>();
		list.add(3);
		assertTrue(list.containsAll(new ArrayList<>()));
	}
	
	@Test
	public void testEmptyTrue() {
		
		SortedList<Pair> list = new SortedList<>();
		assertTrue(list.isEmpty());	
	}
	
	@Test
	public void testEmptyFalse() {
		
		SortedList<Integer> list = new SortedList<>();
		list.add(1);
		assertFalse(list.isEmpty());
		
		
	}
	
	@Test
	public void testFirst() {
		
		SortedList<Integer> list = new SortedList<>();
		list.add(1);
		list.add(5);
		list.add(-1);
		assertEquals(-1, list.first().intValue());
	}
	
	@Test
	public void testFirstWhenEmpty() {
		
		SortedList<Integer> list = new SortedList<>();
		assertEquals(null, list.first());
	}
	
	@Test
	public void testLast() {
		
		SortedList<Integer> list = new SortedList<>();
		list.add(1);
		list.add(5);
		list.add(-1);
		assertEquals(5, list.last().intValue());
	}
	
	@Test
	public void testLastWhenEmpty() {
		
		SortedList<Integer> list = new SortedList<>();
		assertEquals(null, list.last());
	}
	
	private class Pair implements Comparable<Pair> {

		int index;
		int value;
		
		public Pair(int index, int value) {
			this.index = index;
			this.value = value;
		}
		@Override
		public int compareTo(Pair arg0) {
			// TODO Auto-generated method stub
			return this.value - arg0.value;
		}
		
	}

}
