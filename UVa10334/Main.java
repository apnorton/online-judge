import java.util.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    BigInteger[] fib = new BigInteger[1001];
    fib[0] = BigInteger.ONE;
    fib[1] = BigInteger.ONE.add(BigInteger.ONE);
    for (int i = 2; i < fib.length; i++) {
      fib[i] = fib[i-1].add(fib[i-2]);
    }

    /*int[][] memo = new int[2][1001];
    memo[0][0] = 1; memo[0][1] = 2;
    memo[1][0] = 1; memo[1][1] = 1;
    for (int i = 2; i < memo[0].length; i++) {
      memo[0][i] = 2*memo[0][i-2] + memo[1][i-2];
      memo[1][i] =   memo[0][i-2] + memo[1][i-2];
    }*/

    Scanner cin = new Scanner(System.in);
    while (cin.hasNextInt()) {
      int n = cin.nextInt();
      System.out.println(fib[n]);//memo[0][n]);
    }
  }
}
