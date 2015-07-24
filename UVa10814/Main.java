import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int limit = cin.nextInt();
    for (int i = 0; i < limit; i++) {
      BigInteger numerator = new BigInteger(cin.next());
      cin.next(); // Ignore the /
      BigInteger denominator = new BigInteger(cin.next());
      BigInteger gcd = numerator.gcd(denominator);
      numerator = numerator.divide(gcd);
      denominator = denominator.divide(gcd);

      bw.write(numerator.toString());
      bw.write(" / ");
      bw.write(denominator.toString());
      bw.newLine();
    }

    bw.close();
  }
}
