import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;

public class DemoStable {
  public static void main(String[] args) {
    Friend[] friends = {
      new Friend("Ann", 8),
      new Friend("Don", 6),
      new Friend("Ben", 7),
      new Friend("Dee", 8),
      new Friend("Abe", 9),
      new Friend("Ron", 6),
      new Friend("Dan", 8),
      new Friend("Bob", 6),
      new Friend("Tim", 7),
      new Friend("Rob", 6),
      new Friend("Rob", 6),
      new Friend("Joe", 7),
      new Friend("Jim", 9)
    };

    System.out.println("original friends: " + Arrays.toString(friends));
    System.out.println();

    System.out.println("= = = demo stable sorting = = =");
    Insertion.sort(friends);
    System.out.println("friends by name : " + Arrays.toString(friends));
    Insertion.sort(friends, Friend.BY_AGE);
    System.out.println("friends by age  : " + Arrays.toString(friends));
    System.out.println();

    System.out.println("= = = demo non-stable sorting = = =");
    Selection.sort(friends);
    System.out.println("friends by name : " + Arrays.toString(friends));
    Selection.sort(friends, Friend.BY_AGE);
    System.out.println("friends by age  : " + Arrays.toString(friends));
    System.out.println();
  }
}
