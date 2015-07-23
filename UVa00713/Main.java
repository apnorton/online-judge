import java.util.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    int limit = cin.nextInt();
    for (int i = 0; i < limit; i++) {
      String snum1 = (new StringBuilder(cin.next())).reverse().toString();
      String snum2 = (new StringBuilder(cin.next())).reverse().toString();
      BigInteger num1 = new BigInteger(snum1);
      BigInteger num2 = new BigInteger(snum2);

      String ssnum = (new StringBuilder(num1.add(num2).toString())).reverse().toString();

      System.out.println(new BigInteger(ssnum));
    }
  }
}
