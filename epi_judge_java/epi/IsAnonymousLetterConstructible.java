package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IsAnonymousLetterConstructible {
  @EpiTest(testDataFile = "is_anonymous_letter_constructible.tsv")

  public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                          String magazineText) {
    // TODO - you fill in here.
    Map<Character, Integer> dic = new HashMap<>();
    for (char c: letterText.toCharArray()) {
      if (dic.containsKey(c)) {
      dic.put(c, dic.get(c)+1);
    } else {
      dic.put(c,1);
      }
    }



//    Map<Character, Long> dic = letterText.chars()
//            .mapToObj(c->(char)c)
//            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    for (char c: magazineText.toCharArray()) {
      if (dic.containsKey(c)) {
        dic.put(c, dic.get(c)-1);
        if(dic.get(c) == 0) {
//        if (dic.remove(c, 0L)) {
          dic.remove(c);
        }
        if (dic.isEmpty()) {
          break;
        }
      }
    }


    return dic.isEmpty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsAnonymousLetterConstructible.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
