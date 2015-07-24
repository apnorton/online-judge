import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int limit = cin.nextInt();
    for (int i = 0; i < limit; i++) {
      BigDecimal sum = new BigDecimal(0);

      String curr = cin.next();
      while (!curr.equals("0")){
        sum = sum.add(new BigDecimal(curr));
        curr = cin.next();
      }

      if (sum.compareTo(BigDecimal.ZERO) == 0)
        bw.write("0");
      else
        bw.write(sum.stripTrailingZeros().toPlainString());

      bw.newLine();
      bw.flush();
    }

    bw.close();
  }
}
