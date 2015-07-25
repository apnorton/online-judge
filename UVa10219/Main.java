import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws IOException {  
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (cin.hasNextLong()) {
      long n = cin.nextLong();
      long k = cin.nextLong();

      bw.write(Integer.toString(binom(n, k).toString().length()));
      bw.newLine();
    }

    bw.close();
  }

  public static BigInteger binom(long n, long k) {
    if (k > n/2) return binom(n, n-k);

    BigInteger result = BigInteger.ONE;
    BigInteger N = BigInteger.valueOf(n);
    BigInteger K = BigInteger.valueOf(k);

    for (long i = 0; i < k; i++)
      result = (result.multiply(N.subtract(BigInteger.valueOf((i)))));
    for (long i = 1; i <= k; i++)
      result = (result.divide(BigInteger.valueOf((i))));

    return result;
  }
}
