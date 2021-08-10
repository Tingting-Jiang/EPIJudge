package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class IsValidSudoku {
  @EpiTest(testDataFile = "is_valid_sudoku.tsv")

  // Check if a partially filled matrix has any conflicts.
  public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
    // TODO - you fill in here.

    int size = partialAssignment.size() ;
    // check every row
    for (int i = 0; i < size; i++) {
      if (hasDuplicate(partialAssignment, i,  i+1, 0, size)) {
        return false;
      }
    }

    // check every col
    for (int i = 0; i < size; i++) {
      if (hasDuplicate(partialAssignment, 0,  size, i, i+1)) {
        return false;
      }
    }

    int smallSize = (int) Math.sqrt(size);
    for (int i = 0; i < smallSize; i++) {
      for (int j = 0; j < smallSize; j++) {
        if (hasDuplicate(partialAssignment,
                smallSize* i,  smallSize*(i+1),
                smallSize* j, smallSize*(j+1))) {
          return false;
        }
      }

    }

    return true;


  }


  public static boolean hasDuplicate(List<List<Integer>> partialAssignment,
                                     int fromRow, int toRow, int fromCol, int toCol) {
    List<Boolean> table = new ArrayList<>(Collections.nCopies(
            partialAssignment.size()+1, false));
    for (int i = fromRow; i < toRow ; i++) {
      for (int j = fromCol; j < toCol; j++) {
        if (partialAssignment.get(i).get(j) !=0 &&
                table.get(partialAssignment.get(i).get(j))) {
          return true;
        }
        table.set(partialAssignment.get(i).get(j), true);
      }
    }

    return false;

  }




  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidSudoku.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
