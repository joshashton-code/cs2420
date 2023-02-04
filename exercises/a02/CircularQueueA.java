package a02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a First In First Out (FIFO) queue.
 * 
 * Circular refers to the reuse of existing element positions which had their value removed from the queue.
 */
public class CircularQueueA<E> implements Iterable<E> {

  private E[] items;
  private int n;
  private int head;
  private int tail;

  public CircularQueueA(int capacity) throws IllegalArgumentException {
    if(capacity < 1)
      throw new IllegalArgumentException("Cannot create a queue with a capacity lower than 1. Capacity higher than 2 is recommended.");
      
    items = (E[])new Object[capacity];
      for (int i = 0; i < items.length; i++) {
        items[i] = null;
      }
    head = 0;
    tail = 0;
    n = 0;
  }

  /**
   * Determines if the cicular queue has a number of elements equals to its capacity.
   * 
   * @return true if there are an equal amount of elements to the capacity.
   */
  public boolean isFull() {
    return size() == items.length;
  }

  /**
   * Determines if the queue has any items in it or not.
   * 
   * @return true if there are no items in the queue, otherwise return false.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Determines the number of items inside of the queue.
   * 
   * @return the number of items.
   */
  public int size() {
    int counter = 0;
    for (int i = 0; i < items.length; i++) {
      if(items[i] != null)
        counter++;
    }

    return counter;
  }

  /**
   * Adds item into the cicular queue. Reuses positions from removed elements.
   * @param item
   * @throws UnsupportedOperationException
   */
  public void enqueue(E item) throws UnsupportedOperationException {
    if(isFull())
      throw new UnsupportedOperationException("Cannot add another element to a full queue.");

    if(tail == items.length && tail != 0)
      tail = 0;

    items[tail++] = item;

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

    if(head == items.length -1 && head != 0)
      head = 0;

    n--;
    E item = items[head];
    items[head++] = null;
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

    return items[head];
  }

  @Override
  public String toString() {
    if(isEmpty())
      return "";

    StringBuilder sb = new StringBuilder();

    int tempHead = head;
    int counter = 0;

    while(counter < n) {
      if(tempHead == items.length)
        tempHead = 0;
      
      sb.append(items[tempHead++] + " ");
      counter++;
    }

    return sb.toString();
  }

  @Override
  public Iterator<E> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<E> {

    private int currentHead;
    private int counter = 0;

    public QueueIterator() {
    }

    public boolean hasNext()  {
      return counter < items.length && items[currentHead] != null;
    }

    public E next() {
        if (!hasNext()) 
          throw new NoSuchElementException();

        E item = items[currentHead];
        if(currentHead == items.length)
          currentHead = 0;
        else
          currentHead++;

        counter++;
        return item;
    }

  }
  
  // # # # # Testing Area # # # # //
  public static void main(String[] args) {
    CircularQueueA<Integer> queue = new CircularQueueA<>(5);
      queue.enqueue(1);
      System.out.println(queue.toString() + "\n");
      queue.enqueue(2);
      System.out.println(queue.toString() + "\n");
      queue.enqueue(3);
      System.out.println(queue.toString() + "\n");
      queue.enqueue(4);
      System.out.println(queue.toString() + "\n");
      queue.dequeue();
      queue.enqueue(5);
      System.out.println(queue.toString() + "\n");
      Iterator<Integer> it = queue.iterator();
      while (it.hasNext()) {
        System.out.print(it.next() + " ");
      }
      // System.out.println(queue.dequeue());
      // System.out.println(queue.toString() + "\n");
      // queue.enqueue(9);
      // System.out.println(queue.toString() + "\n");
      // queue.enqueue(10);
      // System.out.println(queue.toString());
      // System.out.println(queue.dequeue());
      // System.out.println(queue.toString() + "\n");
  }

}
