import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    int limit = cin.nextInt();
    for (int i = 0; i < limit; i++) {
      int N = cin.nextInt();
      int[] players = new int[N];
      for (int j = 0; j < N; j++)
        players[j] = cin.nextInt();

      Arrays.sort(players);

      System.out.printf("Case %d: %d\n", i+1, players[N/2]);
    }
  }
}
