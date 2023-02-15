package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueueB<E> implements Iterable<E> {

	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of words in the list
	final private int capacity;

	public CircularQueueB(int capacity) {
		if(capacity < 1)
			throw new IllegalArgumentException("Cannot create a queue with a capacity lower than 1. Capacity higher than 2 is recommended.");

		this.capacity = capacity;
		head = null;
		tail = null;
		n = 0;
	}

  	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private E item;
		private Node next;
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
	 * Determines if the list is full or not
	 * 
	 * @return true if the number of elements equals the capacity.
	 */
	public boolean isFull() {
		return n == capacity;
	}

  /**
   * Adds item into the cicular queue. Inserts into LinkedList for appropriate positioning.
	 * 
   * @param item
   * @throws UnsupportedOperationException
   */
  public void enqueue(E item) throws UnsupportedOperationException {
		if(isFull())
			throw new UnsupportedOperationException("Cannot insert a new Node into a full Linked List.");

		Node newNode = new Node();
		newNode.item = item;
		
		if (n == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		n++;
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

		E item = head.item;
		head = head.next;
		n--;
		return item;
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

		return head.item;
  }

	@Override
	public String toString() {
    if(isEmpty())
      return "";

    StringBuilder sb = new StringBuilder();

		Iterator<E> it = new QueueIterator(head);

		while(it.hasNext()) {
			sb.append(it.next().toString() + " ");
		}

    return sb.toString();
	}

  @Override
	public Iterator<E> iterator() {
		return new QueueIterator(head);
	}

	private class QueueIterator implements Iterator<E> {
		private Node current;

		public QueueIterator(Node current) {
			this.current = current;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new UnsupportedOperationException("There is no more elements.");

			E nextElement = current.item;
			current = current.next;
			return nextElement;
		}

	}

	// # # # # Testing Area # # # # //
	public static void main(String[] args) {
		CircularQueueB<Integer> queue = new CircularQueueB<>(5);
		System.out.println(queue.toString() + "\n");
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(1);
		System.out.println(queue.toString() + "\n");

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		System.out.println("Queue: " + queue.toString() + "\n");

	}

}
