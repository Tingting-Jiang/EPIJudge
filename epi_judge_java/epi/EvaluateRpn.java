package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class EvaluateRpn {
  @EpiTest(testDataFile = "evaluate_rpn.tsv")

  public static int eval(String expression) {
    // TODO - you fill in here.

    Deque<Integer> stack = new ArrayDeque<>();
    String DELIMITER = ",";
    Map<String, ToIntBiFunction<Integer, Integer>> dic = Map.of(
            "+",
            (y, x)->(x + y),
            "-",
            (y, x)-> (x -y),
            "*",
            (y, x)->(x*y),
            "/",
            (y,x)->(x/y)
    );

    for (String word : expression.split(DELIMITER)) {
      if (dic.get(word) != null) {
        int val = dic.get(word).applyAsInt(stack.removeFirst(), stack.removeFirst());
        stack.addFirst(val);
      }
      else {
        stack.addFirst(Integer.parseInt(word));
      }

    }
    return stack.removeFirst();


  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvaluateRpn.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
