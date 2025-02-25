package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class LookAndSay {
  @EpiTest(testDataFile = "look_and_say.tsv")

  public static String lookAndSay(int n) {
    // TODO - you fill in here.
    String s = "1";
    for (int i = 1; i < n; i++) {
      s = nextNumber(s);

    }

    return s;

  }

  private static String nextNumber(String s) {
    StringBuilder builder = new StringBuilder();
//    int count = 1;
//    for (int i = 1; i < s.length(); i++) {
//      if(s.charAt(i) != s.charAt(i-1)) {
//        builder.append(count);
//        builder.append(s.charAt(i-1));
//        count = 1;
//      }
//      else {
//        count ++;
//      }
//
//    }
//    builder.append(count);
//    builder.append(s.charAt(s.length()-1));
//    return builder.toString();


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


  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
