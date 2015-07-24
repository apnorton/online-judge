import java.util.*;

public class Main { 
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int limit = cin.nextInt();

    for (int iter = 0; iter < limit; iter++) {
      double d = cin.nextDouble();
      double v = cin.nextDouble();
      double u = cin.nextDouble();

      if (v >= u || v == 0.0 || u == 0.0) {
        System.out.printf("Case %d: can't determine\n", iter+1);
        continue;
      }

      double shortCrossingSpeed = Math.cos(Math.asin(v/u)) * u;
      double shortCrossingTime = d/shortCrossingSpeed;
      double fastCrossingTime = d/u;

      System.out.printf("Case %d: %.3f\n", iter+1, shortCrossingTime - fastCrossingTime);
    }
  }
}
