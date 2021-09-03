package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class NumberOfScoreCombinations {
  @EpiTest(testDataFile = "number_of_score_combinations.tsv")

  public static int
  numCombinationsForFinalScore(int finalScore,
                               List<Integer> individualPlayScores) {
    // TODO - you fill in here.
    int numScores = individualPlayScores.size();
    int [][] dic = new int[numScores][finalScore +1];

    for (int row = 0; row < numScores; row++) {
      dic[row][0] = 1;
      for (int col = 1; col <= finalScore; col++) {

        int withoutThis = row-1>=0? dic[row-1][col]:0;
        int withThis = col - individualPlayScores.get(row) >=0 ? dic[row][col-individualPlayScores.get(row)]: 0;
        dic[row][col] = withoutThis + withThis;


      }

    }

    return dic[numScores-1][finalScore];
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfScoreCombinations.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
