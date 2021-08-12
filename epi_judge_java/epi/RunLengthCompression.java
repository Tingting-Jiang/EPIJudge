package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class RunLengthCompression {

  public static String decoding(String s) {
    // TODO - you fill in here.
    int count = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        count = count * 10 + c - '0';
      } else {
        while (count > 0) {
          builder.append(c);
          count--;
        }

      }
    }
    return builder.toString();

  }

  public static String encoding(String s) {
    // TODO - you fill in here.
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      int count = 1;
      while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
        count ++;
        i++;
      }
      builder.append(count).append(s.charAt(i));

    }
    return builder.toString();


  }
  @EpiTest(testDataFile = "run_length_compression.tsv")
  public static void rleTester(String encoded, String decoded)
      throws TestFailure {
    if (!decoding(encoded).equals(decoded)) {
      throw new TestFailure("Decoding failed");
    }
    if (!encoding(decoded).equals(encoded)) {
      throw new TestFailure("Encoding failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RunLengthCompression.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
