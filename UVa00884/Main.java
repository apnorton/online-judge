import java.util.*;
import java.io.*;

public class Main {
  private static final int LIMIT = 1000000;

  public static void main(String[] args) throws Exception {
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] factorCt = new int[LIMIT+1];
    for (int i = 2; i < factorCt.length; i++) {
      if (factorCt[i] == 0) { // It's a prime!
        //Iterate over the prime "sieve" multiple times, once for each prime power
        long primePower = i;
        while (primePower < factorCt.length) {
          for (long j = primePower; j < factorCt.length; j += primePower) {
            factorCt[(int)j]++;
          }

          primePower *= i;
        }
      }
    }

    long[] memo = new long[LIMIT+1];
    for (int i = 2; i < memo.length; i++) {
      memo[i] = memo[i-1] + factorCt[i];
    }

    while(cin.hasNextInt()) {
      bw.write(Long.toString(memo[cin.nextInt()]));
      bw.newLine();
    }
    bw.close();


  }
}
