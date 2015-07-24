import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception{
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = cin.nextInt();
    int b = cin.nextInt();
    int i = 1;
    while (a != 0 || b != 0) {
      bw.write("Case "); 
      bw.write(Integer.toString(i));
      bw.write(": ");
      int x = (a-1)/b;
      if (x > 26)
        bw.write("impossible");
      else
        bw.write(Integer.toString(x));
      bw.newLine();

      a = cin.nextInt();
      b = cin.nextInt();
      i++;
    }

    bw.close();
  }
}
