import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner cin = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    // Create Pascal's triangle for choosing coefs:
    long[][] pascal = new long[51][51];
    for (int i = 0; i < pascal.length; i++) {
      pascal[i][0] = 1L;
      pascal[i][i] = 1L;
      for (int j = 1; j < i; j++) {
        pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
      }
    }
    
    int limit = cin.nextInt();
    cin.nextLine();
    for (int test = 0; test < limit; test++) {
      Scanner lin = new Scanner(cin.nextLine()).useDelimiter("([\\+\\(]|(\\)\\^))");

      String var1 = lin.next();
      String var2 = lin.next();
      int pow = lin.nextInt();

      //Now that we have the input, let's print the output!

      bw.write("Case ");
      bw.write(Integer.toString(test+1));
      bw.write(": ");
      if (pow == 1) {
        bw.write(var1);
        bw.write('+');
        bw.write(var2);
      }
      else {
        bw.write(var1);
        bw.write('^');
        bw.write(Integer.toString(pow));
        bw.write('+');
        for (int i = pow-1; i > 0; i--) { 
          bw.write(Long.toString(pascal[pow][i]));
          bw.write('*');
          bw.write(var1);
          if (i != 1){
            bw.write('^');
            bw.write(Integer.toString(i));
          }
          bw.write('*');
          bw.write(var2);
          if (pow-i != 1) {
            bw.write('^');
            bw.write(Integer.toString(pow-i));
          }
          bw.write('+');
        }
        bw.write(var2);
        bw.write('^');
        bw.write(Integer.toString(pow));
      }
      bw.newLine();
    }

    bw.close();
  }
}
