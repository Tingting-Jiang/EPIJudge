package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;
public class ReplaceAndRemove {

  public static int replaceAndRemove(int size, char[] s) {
    // TODO - you fill in here.
    int write = 0;
    int numA = 0;
    for (int i = 0; i < size; i++) {
      if (s[i] != 'b') s[write++] = s[i];
      if(s[i] == 'a') numA++;
    }

    int finalSize = write + numA;
    int k = finalSize-1;
    write = write-1;
    while (write>=0) {
      if (s[write] == 'a') {
        s[k--] = 'd';
        s[k--] = 'd';
      } else {
        s[k--] = s[write];
      }
      write--;


    }

    return finalSize;

  }
  @EpiTest(testDataFile = "replace_and_remove.tsv")
  public static List<String>
  replaceAndRemoveWrapper(TimedExecutor executor, Integer size, List<String> s)
      throws Exception {
    char[] sCopy = new char[s.size()];
    for (int i = 0; i < size; ++i) {
      if (!s.get(i).isEmpty()) {
        sCopy[i] = s.get(i).charAt(0);
      }
    }

    Integer resSize = executor.run(() -> replaceAndRemove(size, sCopy));

    List<String> result = new ArrayList<>();
    for (int i = 0; i < resSize; ++i) {
      result.add(Character.toString(sCopy[i]));
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReplaceAndRemove.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
