package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueueB<E> implements Iterable<E> {

	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of words in the list

  	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private E item;
		private Node next;
    private Node prev;

    public Node(E item, Node next, Node prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * 
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

  /**
   * Adds item into the cicular queue. Inserts into LinkedList for appropriate positioning.
	 * 
   * @param item
   * @throws UnsupportedOperationException
   */
  public void enqueue(E item) throws UnsupportedOperationException {
    Node newTail = new Node(item, head, tail);
    tail.next = newTail;
    newTail = tail;
  }

  /**
   * Retrieves and removes the next item from the queue.
   * 
   * @return the removed item.
   * @throws NoSuchElementException
   */
  public E dequeue() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException("No elements exist, cannot dequeue an element that does not exist.");

		return null; // TODO: Need to implement in part 2.
		}

  /**
   * Retrieves the next item from the queue.
   * 
   * @return the next item.
   * @throws NoSuchElementException
   */
  public E peek() throws NoSuchElementException {
    if(isEmpty())
      throw new NoSuchElementException("No elements exist, cannot peek an element that does not exist.");

		return null; // TODO: Need to implement.
  }

	@Override
	public String toString() {
		return null; // TODO: Need to implement in part 2.
	}

  @Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E nextElement = current.item;
			current = current.next;
			return nextElement;
		}

	}
}
