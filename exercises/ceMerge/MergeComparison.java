

import java.util.Random;
import java.util.Arrays;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;

public class MergeComparison {
  private static int N = 10000;
  private final static int BILLION = 1000000000;
  public static void main(String[] args) {
    System.out.println("Merge Sort:\n----------");
    for (int i = 0; i < 10; i++) {
      Integer[] array = getIntegerArray(N, 7);
      long start = System.nanoTime();
      Merge.sort(array);
      double elapsedTime = System.nanoTime() - start;
      StdOut.printf("time to sort " + N + " elements: %.10f s %n", elapsedTime / BILLION);
      N *= 2;
    }

    N = 10000;
    System.out.println("\nMergeSlow Sort:\n--------------");
    for (int i = 0; i < 10; i++) {
      Integer[] array = getIntegerArray(N, 7);
      long start = System.nanoTime();
      MergeSlow.sort(array);
      double elapsedTime = System.nanoTime() - start;
      StdOut.printf("time to sort " + N + " elements: %.10f s %n", elapsedTime / BILLION);
      N *= 2;
    }
  }
  
  /**
   * Creates an Integer array of the specified size filled with random n-digit numbers, the number of digits specified by the user.
   * 
   * @param size size number of elements in the array
   * @return array of random 7-digit numbers
   */
  private static Integer[] getIntegerArray(int size, int digitCount) {
    Integer[] array = new Integer[size];
    Random ran = new Random();
    int upperBound = (int) Math.pow(10, digitCount);
    int lowerBound = (int) Math.pow(10, digitCount - 1);
    
    for (int i = 0; i < array.length; i++) {
      array[i] = ran.nextInt(lowerBound, upperBound);
    }

    return array;
  }
}
