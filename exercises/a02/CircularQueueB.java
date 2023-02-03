package a02;

import java.util.Iterator;

public class CircularQueueB<E> implements Iterable<E> {

	private Node head;
	private Node tail;
	private E item;

	public CircularQueueB() {

	}

	private class Node {
		private Node next;
		private Node prev;
		private E item;

		private Node(Node next, Node prev, E item) {
			this.next = next;
			this.prev = prev;
			this.item = item;
		}
	}

	@Override
	public String toString() {
		return null; // TODO: Need to implement.
	}

	@Override
	public Iterator<E> iterator() {
		return null; // TODO Need to implement
	}
}
