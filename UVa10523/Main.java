import java.util.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    while (cin.hasNextInt()) {
      BigInteger n = BigInteger.valueOf(cin.nextInt());
      BigInteger a = BigInteger.valueOf(cin.nextInt());

      BigInteger sum = BigInteger.ZERO;
      for (int i = n.intValue(); i >= 1; i--)
        sum = sum.add(BigInteger.valueOf(i)).multiply(a);
        System.out.println(sum);
    }
  }
}
