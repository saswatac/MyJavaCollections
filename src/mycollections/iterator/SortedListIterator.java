package mycollections.iterator;

import java.util.Iterator;

import mycollections.list.Node;

public class SortedListIterator<E extends Comparable<E>> implements Iterator<E> {

	private Node<E> root;

	private Node<E> current;

	private Iterator<E> listIter;

	public SortedListIterator(Node<E> root) {

		this.root = root;
		this.current = getMin();
		if (current != null) {
			this.listIter = current.e.iterator();
		} 
	}

	@Override
	public boolean hasNext() {

		if (current == null) {
			return false;
		}
		if (listIter.hasNext()) {
			return listIter.hasNext();
		}
		return getNext() != null;
	}

	@Override
	public E next() {

		if (listIter.hasNext()) {
			return listIter.next();
		}
		Node<E> next = getNext();
		if (next != null) {
			current = next;
			listIter = current.e.iterator();
			return listIter.next();
		}
		return null;

	}

	@Override
	public void remove() {
		// TODO Add support later
		throw new IllegalArgumentException();

	}

	private Node<E> getNext() {

		if (current.right != null) {

			Node<E> n = current.right;
			while (n.left != null) {
				n = n.left;
			}
			return n;
		}

		Node<E> n = root;
		Node<E> successor = null;
		while (n != null) {
			if (current.e.iterator().next().compareTo(n.e.iterator().next()) < 0) {
				successor = n;
				n = n.left;
			} else if (current.e.iterator().next()
					.compareTo(n.e.iterator().next()) > 0) {
				n = n.right;
			} else {
				break;
			}
		}
		return successor;
	}

	private Node<E> getMin() {

		Node<E> n = root;
		if (root == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

}
