import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNextInt()) {
      int cigs = cin.nextInt();
      int k = cin.nextInt();
      int total = cigs;
      int butts = 0;

      while (cigs > 0) {
        butts += cigs;
        cigs = butts / k;
        butts %= k;

        total += cigs;
      }

      System.out.println(total);
    }
  }
}
