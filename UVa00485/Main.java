import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    BigInteger lim = BigInteger.TEN.pow(60);
    BigInteger[] prevRow = new BigInteger[1];
    BigInteger[] currRow;
    prevRow[0] = BigInteger.ONE;

    bw.write('1');
    bw.newLine();
    int rowLength = 2;
    boolean keepGoing = true;
    while (keepGoing) {
      currRow = new BigInteger[rowLength];
      currRow[0] = BigInteger.ONE;
      currRow[rowLength-1] = BigInteger.ONE;
      bw.write("1 ");
      for (int i = 1; i < rowLength-1; i++) {
        currRow[i] = prevRow[i-1].add(prevRow[i]);
        bw.write(currRow[i].toString());
        bw.write(' ');

        keepGoing &= currRow[i].compareTo(lim) < 0;
      }
      bw.write('1');
      bw.newLine();
      
      prevRow = currRow;
      rowLength++;
    }

    bw.close();
  }
}
