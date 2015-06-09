import java.util.*;


/**
 *  Block Voting
 *  UVa Online Judge Problem #435
 *  Andrew Norton
 */

public class UVa00435 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    final int CASES = cin.nextInt();
    for (int caseNum = 0; caseNum < CASES; caseNum++) {
      int P = cin.nextInt(); // in range [1..20]

      // Store party sizes
      int totalPeople = 0;
      int[] partySize = new int[P];
      for (int i = 0; i < partySize.length; i++) {
        partySize[i] = cin.nextInt();
        totalPeople += partySize[i];
      }


      // Do a complete search of all coallitions
      // to find power index
      int reqVotes = (totalPeople / 2) + 1;
      int[] powerIndex = new int[P];
      int upperLimit = 1 << P; // is a 1 followed by P zeros

      for (int coal = 0; coal < upperLimit; coal++) {
        // First, compute the votes that this particular coallition has
        int voteCt = getVoteCt(coal, partySize);
        // System.out.printf("Party size: %s\n", Arrays.toString(partySize));
        // System.out.printf("Coallition: %s\n", Integer.toBinaryString(coal));
        // System.out.printf("Vote tally: %d\n", voteCt);

        if (voteCt < reqVotes) { // If this is a losing coallition...
          // Find how many other coallitions could save it
          int neededVotes = reqVotes - voteCt;
          for (int i = 0; i < partySize.length; i++)
            // Is appropriate size and is unused
            if (partySize[i] >= neededVotes && (coal & (1 << i)) == 0) 
              powerIndex[i]++;
        }

      }

      // Now we know the powerIndex of each coallition!
      for (int i = 0; i < powerIndex.length; i++)
        System.out.printf("party %d has power index %d\n", i+1, powerIndex[i]);
      System.out.println();
    }
  }

  private static int getVoteCt(int coal, int[] partySize) {
    int retVal = 0;
    for (int i = 0; i < partySize.length; i++, coal >>= 1) {
      if ((coal & 1) == 1)
        retVal += partySize[i];
    }

    return retVal;
  }
}
