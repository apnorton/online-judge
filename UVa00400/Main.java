import java.util.*;

public class Main {
  public static void main(String[] args) {
    final int DISPLAY_WIDTH   = 60;
    final int DISPLAY_PADDING =  2;
    Scanner cin = new Scanner(System.in);
    
    while (cin.hasNextLine()) {
      int linesInSet = Integer.parseInt(cin.nextLine());

      // Load the whole list of files.
      int maxNameLength = 0;
      String[] files = new String[linesInSet];
      for (int i = 0; i < files.length; i++) {
        files[i] = cin.nextLine();
        maxNameLength = Math.max(maxNameLength, files[i].length());
      }

      // Now they're sorted.
      Arrays.sort(files);

      //At least we have a divider!
      System.out.println("------------------------------------------------------------");

      // Find out how many columns we need
      int numCols = (DISPLAY_WIDTH + DISPLAY_PADDING) / (maxNameLength + DISPLAY_PADDING);
      int namesPerCol = files.length / numCols + (files.length % numCols > 0 ? 1 : 0);
      
      String[][] toPrint = new String[namesPerCol][numCols];
      int currWord = 0;
      for (int i = 0; i < numCols; i++) {
        for (int j = 0; j < namesPerCol && currWord < files.length; j++) 
          toPrint[j][i] = files[currWord++];
      }

      // Now print out all the words!
      String formatString = "%-" + maxNameLength + "s";
      for (int i = 0; i < toPrint.length; i++) {
        for (int j = 0; j < toPrint[0].length; j++) {
          if (toPrint[i][j] != null) {
            System.out.printf(formatString, toPrint[i][j]);
            if (j != toPrint[0].length-1) System.out.print("  ");
          }
        }

        System.out.println();
      }
    }
  }
}
