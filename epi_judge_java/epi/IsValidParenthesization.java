package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsValidParenthesization {
  @EpiTest(testDataFile = "is_valid_parenthesization.tsv")

  public static boolean isWellFormed(String s) {
    // TODO - you fill in here.

    Map<Character, Character> dic = Map.of(
            '(',')','{','}', '[',']'
    );
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
//      if (!stack.isEmpty() && dic.containsKey(stack.peek()) &&
//              dic.get(stack.peek()) == s.charAt(i)) {
//        stack.removeFirst();
//      }
//      else {
//        stack.addFirst(s.charAt(i));
//      }
//

      if (dic.get(s.charAt(i))!= null) {  // this is a left part
        stack.addFirst(s.charAt(i));
      } else if (stack.isEmpty()  || dic.get(stack.removeFirst()) != s.charAt(i)) {
        return false;  // the last char's value in stack is not matching
      }
    }



    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidParenthesization.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
