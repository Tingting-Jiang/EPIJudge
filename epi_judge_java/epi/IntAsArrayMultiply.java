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
    // if the first number of num1  or num2 <0, then the result will <0
    int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;

    // get the abs value of the first num
    num1.set(0, Math.abs(num1.get(0)));
    num2.set(0, Math.abs(num2.get(0)));

    List<Integer> ans = new ArrayList<>(Collections.nCopies(
            num1.size()+ num2.size(), 0));

    for (int i = num1.size() -1; i >= 0 ; i--) {
      for (int j = num2.size() -1; j >=0 ; j--) {
        ans.set(i+j+1, ans.get(i+j+1)+ num1.get(i) * num2.get(j));
        ans.set(i+j, ans.get(i+j) + ans.get(i+j+1) / 10);
        ans.set(i+j+1, ans.get(i+j+1) % 10);
      }
    }

    int firstNum = 0;
    while (firstNum < ans.size() && ans.get(firstNum) ==0){
      firstNum++;
    }

    ans = ans.subList(firstNum, ans.size());
    if (ans.size() == 0) {
      return Arrays.asList(0);
    }
    ans.set(0, ans.get(0) * sign);
    return ans;

    // Time: mn   Space: m+n

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayMultiply.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
