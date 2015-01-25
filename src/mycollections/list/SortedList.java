package mycollections.list;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;

import mycollections.iterator.SortedListIterator;

public class SortedList<E extends Comparable<E>> implements SortedSet<E> {

	private Node<E> root;

	private int size;

	public SortedList() {

	}

	@Override
	public boolean add(E arg0) {

		if (root == null) {
			root = new Node<>();
			Set<E> set = new LinkedHashSet<>();
			set.add(arg0);
			root.e = set;
			size++;
			return true;
		} else {
			Node<E> node = find(arg0, root);
			if (arg0.compareTo(node.e.iterator().next()) < 0) {
				node.left = new Node<>();
				Set<E> set = new LinkedHashSet<>();
				set.add(arg0);
				node.left.e = set;
			} else if (arg0.compareTo(node.e.iterator().next()) > 0) {
				node.right = new Node<>();
				Set<E> set = new LinkedHashSet<>();
				set.add(arg0);
				node.right.e = set;
			} else {
				if (node.e.contains(arg0)) {
					return false;
				} else {
					node.e.add(arg0);
				}
			}
			size++;
			return true;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {

		boolean result = true;
		for (E e : arg0) {
			result = add(e);
		}
		return result;
	}

	@Override
	public void clear() {

		root = null;
		size = 0;

	}

	@Override
	public boolean contains(Object arg0) {

		if (root == null) {
			return false;
		}
		try {
			@SuppressWarnings("unchecked")
			E e = (E) arg0;
			Node<E> node = find(e, root);
			return node.e.contains(arg0);
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean containsAll(Collection<?> arg0) {

		if (root == null && !arg0.isEmpty()) {
			return false;
		}
		for (Object o : arg0) {
			try {
				@SuppressWarnings("unchecked")
				E e = (E) o;
				Node<E> node = find(e, root);
				if (!node.e.contains(e)) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {

		return root == null;
	}

	@Override
	public Iterator<E> iterator() {

		return new SortedListIterator<E>(root);
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Add support later

		throw new IllegalArgumentException();
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Add support later

		throw new IllegalArgumentException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Add support later

		throw new IllegalArgumentException();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {

		Object[] arr = new Object[size];
		int i = 0;
		for (E e : this) {
			arr[i] = e;
			i++;
		}
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(arg0.getClass(), size);
		int i = 0;
		for (E e : this) {
			arr[i] = (T) e;
			i++;
		}
		return arr;
	}

	@Override
	public Comparator<? super E> comparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E first() {

		if (root == null) {
			return null;
		}
		return this.iterator().next();
	}

	@Override
	public SortedSet<E> headSet(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E last() {

		if (root == null) {
			return null;
		}
		Node<E> n = root;
		while (n.right != null) {
			n = n.right;
		}
		Iterator<E> it = n.e.iterator();
		E last = null;
		while (it.hasNext()) {
			last = it.next();
		}
		return last;
	}

	@Override
	public SortedSet<E> subSet(E arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> tailSet(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private Node<E> find(E e, Node<E> node) {

		if (e.compareTo(node.e.iterator().next()) < 0) {
			if (node.left != null) {
				return find(e, node.left);
			}
		} else {
			if (node.right != null) {
				return find(e, node.right);
			}

		}
		return node;
	}

	/*
	 * private E find(int index, Node<E> node) {
	 * 
	 * Stack<Node<E>> stack = new Stack<>(); Set<Node<E>> visited = new
	 * HashSet<>(); stack.push(node); int c = -1; while (!stack.isEmpty()) {
	 * Node<E> n = stack.peek(); if (visited.contains(n)) { stack.pop(); c++; if
	 * (c == index) { return n.e.get(0); } if (n.right != null) {
	 * stack.push(n.right); } } else { visited.add(n); if (n.left != null) {
	 * stack.push(n.right); } }
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */
}
