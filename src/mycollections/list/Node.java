package mycollections.list;

import java.util.Set;

public class Node<E extends Comparable<E>> {

	public Set<E> e;
	public Node<E> left;
	public Node<E> right;
}