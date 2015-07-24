import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (cin.hasNext()) {
      BigInteger num = new BigInteger(cin.next(), cin.nextInt()); // number, radix
      String out = num.toString(cin.nextInt());
      int len = out.length();
      if (len > 7)
        bw.write("  ERROR");
      else {
        for (int i = 7; i > len; i--)
          bw.write(' ');
        for (int i = 0; i < len; i++) 
          bw.write(Character.toUpperCase(out.charAt(i)));
      }

      bw.newLine();
    }

    bw.flush();
  }
}
