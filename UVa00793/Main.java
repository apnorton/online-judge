import java.util.*;

public class Main {
  public static void main(String[] args)  {
    Scanner cin = new Scanner(System.in);
    
    int limit = cin.nextInt();
    for (int test = 0; test < limit; test++) {
      int size = cin.nextInt();  // Size of network
      
      cin.nextLine(); //throw away line feed

      UF network = new UF(size+1); // Creates union find network
      int success = 0, fail = 0; // Number of successful/failed queries
      String line; //Input
      while (cin.hasNextLine() && !(line = cin.nextLine()).isEmpty()) { 
        Scanner sin = new Scanner(line);

        // Get the three characters
        char c = sin.next().charAt(0);
        int a = sin.nextInt();
        int b = sin.nextInt();

        // Perform unions or connection checks as appropriate
        if (c == 'c') {
          network.union(a, b);
        }
        else if (c == 'q') {
          if (network.connected(a, b))
            success++;
          else
            fail++;
        }
      }

      // Print output
      System.out.printf("%d,%d\n\n", success, fail);

    }
    
  }

  private static class UF {
    private int[] parent;
    private int[] sz;

    public UF(int numElements) {
      parent = new int[numElements];
      sz = new int[numElements];

      for (int i = 0; i < numElements; i++) {
        parent[i] = i;
        sz[i] = 1; 
      }
    }

    private int getRoot(int n) {
      int currNode = n;
      while (parent[currNode] != currNode) {
        parent[currNode] = parent[parent[parent[currNode]]];
        currNode = parent[currNode];
      }

      parent[n] = currNode;

      return currNode;
    }

    public void union(int a, int b) {
      if (sz[a] > sz[b]) {
        union(b, a); // assert a <= b;
      }
      else {
        int rtA = getRoot(a);
        int rtB = getRoot(b);
        parent[rtA] = parent[rtB];
        sz[rtB] += sz[rtA];
      }
    }

    public boolean connected(int a, int b) {
      return getRoot(a) == getRoot(b);
    }
  }
}
