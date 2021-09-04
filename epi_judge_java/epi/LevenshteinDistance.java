package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;

public class LevenshteinDistance {
  @EpiTest(testDataFile = "levenshtein_distance.tsv")

  public static int levenshteinDistance(String A, String B) {
    // TODO - you fill in here.
    int [][] dic = new int[A.length()][B.length()];
    for(int[] row: dic) {
      Arrays.fill(row, -1);
    }

    return distanceHelper(A, A.length()-1, B, B.length()-1, dic);

  }

  private static int distanceHelper(String A, int aIndx, String B, int bIndx, int[][] dic) {
    if(aIndx < 0) return bIndx+1;

    else if (bIndx<0) return aIndx+1;

    if(dic[aIndx][bIndx] == -1) {
      if(A.charAt(aIndx) == B.charAt(bIndx)) {
        dic[aIndx][bIndx] = distanceHelper(A, aIndx-1, B, bIndx-1, dic);
      } else {
        int substitute = distanceHelper(A, aIndx-1, B, bIndx-1, dic);
        int addLast = distanceHelper(A, aIndx,B, bIndx-1, dic);
        int delete = distanceHelper(A, aIndx-1, B, bIndx, dic);
        dic[aIndx][bIndx] = 1+ Math.min(substitute, Math.min(addLast, delete));
      }
    }
    return dic[aIndx][bIndx];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LevenshteinDistance.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
