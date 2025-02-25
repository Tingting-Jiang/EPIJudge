package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
public class StringIntegerInterconversion {

  public static String intToString(int x) {
    // TODO - you fill in here.
    boolean isNegative = x < 0 ? true: false;

    StringBuilder builder = new StringBuilder();
    do{
      builder.append((char)('0' + Math.abs(x % 10)));
      x = x/10;

    } while (x != 0);

    return builder.append(isNegative? '-' : "").reverse().toString();


  }
  public static int stringToInt(String s) {
    // TODO - you fill in here.
//    System.out.println("xxxxDSSSS");
//    System.out.println(s);
//    System.out.println("DSSSS");

    // this method cannot pass the last test case
    int i = 0;
    String c = "";
    if (s.charAt(0) =='-' || s.charAt(0) =='+'){
      if (s.charAt(0) =='-') {
        c = "-";
      }
      else {
        c = "+";
      }
      i = 1;
    }
    int ans = 0;
    while (i < s.length()) {
      int val = s.charAt(i) -'0';
      ans = ans* 10 + val;
      i++;
    }
    if (c.equals("-")){
      System.out.println(-ans);
      return -ans;
    } else if (c.equals("+")) {
      return +ans;
    }
    return ans;

//    return (s.charAt(0) == '-' ? -1 : 1) *
//            s.substring((s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0)
//                    .chars()
//                    .reduce(0, (runningSum, c) -> runningSum * 10 + c - '0');


  }
  @EpiTest(testDataFile = "string_integer_interconversion.tsv")
  public static void wrapper(int x, String s) throws TestFailure {
    if (Integer.parseInt(intToString(x)) != x) {
      throw new TestFailure("Int to string conversion failed");
    }
    if (stringToInt(s) != x) {
      throw new TestFailure("String to int conversion failed");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringIntegerInterconversion.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
