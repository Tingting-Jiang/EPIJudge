package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class LookAndSay {
  @EpiTest(testDataFile = "look_and_say.tsv")

  public static String lookAndSay(int n) {
    // TODO - you fill in here.
    String ans = "1";
    for (int i = 1; i < n; i++) {
      ans = getNext(ans);
    }
    return ans;

  }

  private static String getNext(String ans) {
    StringBuilder builder = new StringBuilder();
    for (int j = 0; j < ans.length(); ++j) {
      int count = 1;
      while (j + 1 < ans.length() && ans.charAt(j) == ans.charAt(j+1)) {
        ++count;
        ++j;
      }
      builder.append(count).append(ans.charAt(j));
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
