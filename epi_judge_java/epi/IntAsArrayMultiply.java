package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class IntAsArrayMultiply {
  @EpiTest(testDataFile = "int_as_array_multiply.tsv")
  public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
    // TODO - you fill in here.
   final int sign = (num1.get(0) < 0 && num2.get(0) < 0) ||
           (num1.get(0) > 0 && num2.get(0) > 0)  ? 1 : -1;
   num1.set(0, Math.abs(num1.get(0)));
   num2.set(0, Math.abs(num2.get(0)));

   List<Integer> res = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
    for (int i = num1.size() -1; i >=0; i--) {
      for (int j = num2.size() -1; j >=0; j--) {
        res.set(i+j+1, res.get(i+j+1) + num1.get(i) * num2.get(j));
        res.set(i+j, res.get(i+j) + res.get(i+j+1) / 10);
        res.set(i+j+1, res.get(i+j+1) % 10);
      }
    }

    int firstNum = 0;
    while(firstNum < res.size() && res.get(firstNum) == 0) {
      ++firstNum;
    }

    res = res.subList(firstNum, res.size());
    if (res.isEmpty()) return List.of(0);

    res.set(0, res.get(0) * sign);
    return res;



  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
