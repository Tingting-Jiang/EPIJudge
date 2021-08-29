package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class FindSalaryThreshold {
  @EpiTest(testDataFile = "find_salary_threshold.tsv")

  public static double findSalaryCap(int targetPayroll,
                                     List<Integer> currentSalaries) {
    // TODO - you fill in here.
//    double sum = 0;
//    for (int i = 0; i < currentSalaries.size(); i++) {
//      final int needCap = currentSalaries.size() - i;
//      final double beforeCap = currentSalaries.get(i) * needCap;
//      if (beforeCap + sum >= targetPayroll) {
//        return (double) (targetPayroll - sum) / needCap;
//
//      }
//      sum += currentSalaries.get(i);
//
//    }
//
//
//    return -1.0;

    double unadjustedSalarySum = 0;
    for (int i = 0; i < currentSalaries.size(); ++i) {
      final int adjustedPeople = currentSalaries.size() - i;
      final double adjustedSalarySum = currentSalaries.get(i) * adjustedPeople;
      if (unadjustedSalarySum + adjustedSalarySum >= targetPayroll) {
        return (targetPayroll - unadjustedSalarySum) / adjustedPeople;
      }
      unadjustedSalarySum += currentSalaries.get(i);
    }
    // No solution, since targetPayroll > existing payroll.
    return -1.0;



  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "FindSalaryThreshold.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
