package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class RunLengthCompression {

  public static String decoding(String s) {
    // TODO - you fill in here.
    StringBuilder builder = new StringBuilder();
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        count = count * 10 + c -'0';
      } else {
        while (count > 0) {
          builder.append(c);
          count --;
        }
      }
    }


    return builder.toString();

  }

  public static String encoding(String s) {
    // TODO - you fill in here.
    StringBuilder builder = new StringBuilder();
    int start = 0;
    while (start < s.length()) {
      int count = 1;
      while (start+1 < s.length() && s.charAt(start) == s.charAt(start+1)) {
        start++;
        count ++;
      }
      builder.append(count).append(s.charAt(start++));

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
