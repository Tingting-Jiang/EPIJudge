package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class MatrixRotation {

  public static void rotateMatrix(List<List<Integer>> squareMatrix) {
    // TODO - you fill in here.
    // check if matrix is valid
   int size = squareMatrix.size();
    for (int layer = 0; layer < size / 2; layer++) {
      int first = layer;
      int last = squareMatrix.size() - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        int temp = squareMatrix.get(layer).get(i);  // save the top left value
        squareMatrix.get(layer).set(i, squareMatrix.get(last- offset).get(layer));

        squareMatrix.get(last - offset).set(layer, squareMatrix.get(last).get(last - offset));

        squareMatrix.get(last).set(last- offset, squareMatrix.get(i).get(last));

        squareMatrix.get(i).set(last, temp);

      }

    }






    return;
  }
  @EpiTest(testDataFile = "matrix_rotation.tsv")
  public static List<List<Integer>>
  rotateMatrixWrapper(List<List<Integer>> squareMatrix) {
    rotateMatrix(squareMatrix);
    return squareMatrix;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "MatrixRotation.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
