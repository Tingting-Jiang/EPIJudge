package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.Collections;

public class ReverseWords {

  public static void reverseWords(char[] input) {
    // TODO - you fill in here.

    int left= 0, right = input.length-1;
    reverse(input, left, right);


    int start = 0;
    int k = 0;
    while (start < input.length)  {
      while (start< k || (start< input.length && input[start] == ' ')) {
        start++;
      }
      while (k < start || (k < input.length && input[k] != ' ')) {
        k++;
      }
      reverse(input, start, k-1);

    }

  }

  private static void reverse(char[] input, int start, int finish) {
    while (start < finish) {
      char temp = input[finish];
      input[finish--] = input[start];
      input[start++] = temp;
    }
  }





  @EpiTest(testDataFile = "reverse_words.tsv")
  public static String reverseWordsWrapper(TimedExecutor executor, String s)
      throws Exception {
    char[] sCopy = s.toCharArray();

    executor.run(() -> reverseWords(sCopy));

    return String.valueOf(sCopy);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseWords.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
