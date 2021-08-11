package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ConvertBase {
  @EpiTest(testDataFile = "convert_base.tsv")

  public static String convertBase(String numAsString, int b1, int b2) {
    // TODO - you fill in here.
    // first convert string to decimal
//    boolean isNegative = numAsString.charAt(0) == '-';
    boolean isNegative = numAsString.startsWith("-");  // this line is more clear
    int result = 0;
    int i = isNegative ? 1:0;
    while (i < numAsString.length()){
      char val = numAsString.charAt(i);
      int num = Character.isDigit(val) ? val-'0': val - 'A' + 10;
      result = result * b1 + num;
      i++;
    }


//    // then turn the result to b2
//    StringBuilder builder = new StringBuilder();
//    do {
//      char val = (char)((result % b2) >= 10 ? 'A' +  (result % b2 - 10) : '0' + (result % b2));
//      result /= b2;
//      builder.append( val);
//    }
//    while (result != 0);
//
//    if (isNegative) {
//      builder.append('-');
//    }
//
//    builder.reverse();
//    return builder.toString();


    return (isNegative? "-": "") + (result == 0? "0" :
            ConstructFromBase(result, b2));


  }

  public static String ConstructFromBase(int number, int base) {
    return number == 0? "" :
            ConstructFromBase(number/base, base) +
                    (char) (number%base >=10 ? number%base - 10 + 'A' : number%base + '0');

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ConvertBase.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
