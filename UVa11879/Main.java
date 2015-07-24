import java.util.*;
import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new  Scanner(System.in);
    BigInteger seventeen = new BigInteger("17");

    while(true) {
      BigInteger m = new BigInteger(cin.next());
      
      // We're done
      if (m.equals(BigInteger.ZERO)) break;

      if (m.mod(seventeen).equals(BigInteger.ZERO))
        System.out.println(1);
      else
        System.out.println(0);
    }
  }
}
