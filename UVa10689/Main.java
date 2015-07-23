import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    int limit = cin.nextInt();
    for (int i = 0; i < limit; i++) {
      int a = cin.nextInt();
      int b = cin.nextInt();
      int n = cin.nextInt();
      int m = cin.nextInt();
      int modulus = (int)(Math.pow(10, m));
      
      // Get the cycle length for this fib sequence
      int f1 = a % modulus;
      int f2 = b % modulus;
      int cL = getCycleLength(f1, f2, modulus);

      //Calculate the value we seek
      n %= cL;
      if (n == 0)
        System.out.println(f1);
      else if (n == 1)
        System.out.println(f2);
      else {
        int fib1 = f2;
        int fib2 = (f2 + f1) % modulus;
        for (int j = 2; j < n; j++) {
          int tmp = (fib2 + fib1) % modulus;
          fib1 = fib2;
          fib2 = tmp;
        }

        System.out.println(fib2);
      }
    }
  }

  private static int getCycleLength(int f1, int f2, int m) {
    int fib1 = f2;
    int fib2 = (f2 + f1) % m;
    int cycleLength = 1;
    while (fib1 != f1 || fib2 != f2) {
      int tmp = (fib2 + fib1) % m;
      fib1 = fib2;
      fib2 = tmp;
      cycleLength++;
    }

    return cycleLength;
    
  }
}
