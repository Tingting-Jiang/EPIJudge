package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.Collections;

public class ReverseWords {

  public static void reverseWords(char[] input) {
    // TODO - you fill in here.
    int left = 0, right = input.length;
    reverseSingle(input, 0, right-1);
    int start = 0;
    int end = 0;

    while (start < right ) {
      while (start < end || start < right && input[start] == ' ') {
        start ++; // skip empty space
      }
      while (end < start || end < right && input[end] != ' ') {
        end ++; // skip non-spaces chars
      }
      reverseSingle(input, start, end-1);


    }

  }


  public static  void reverseSingle(char[] word, int left, int right) {

    while (left < right) {
      char temp = word[left];
      word[left++] = word[right];
      word[right--] = temp;
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
