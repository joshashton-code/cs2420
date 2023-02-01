package ceRecursion;

public class Recursion {
  public static void main(String[] args) {
    System.out.println("Seed: 3");
    hailstone(3);
    System.out.println("\n\nSeed: 16");
    hailstone(16);
    System.out.println("\n\nSeed: 17");
    hailstone(17);
    System.out.println("\n\nSeed: 24");
    hailstone(24);
  }

  /**
   * Prints the hailstorm numbers starting with the seed.
   * 
   * @param seed
   * @throws IllegalArgumentException
   */
  public static void hailstone(int seed) throws IllegalArgumentException {
    if(seed <= 0) {
      throw new IllegalArgumentException("REMINDER: Seed must be positive.");
    }

    System.out.print(seed + " ");

    if(seed != 1) {
      if(seed % 2 == 0) {
        hailstone(seed /= 2);
      } else {
        hailstone((seed * 3) + 1);
      }
    }

  }
}
