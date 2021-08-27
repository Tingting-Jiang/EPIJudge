package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDecompositionsIntoDictionaryWords {
  @EpiTest(testDataFile = "string_decompositions_into_dictionary_words.tsv")

  public static List<Integer> findAllSubstrings(String s, List<String> words) {
    // TODO - you fill in here.
    Map<String, Long> dic = words.stream().collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting())
    );

    int unitSize = words.get(0).length();
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i + unitSize * words.size() <= s.length()  ; i++) {
      if (matchAllWords (s, dic, i, words.size(), unitSize)) {

        ans.add(i);
      }
    }
    return ans;

  }

  private static boolean matchAllWords(String s, Map<String, Long> dic, int start, int numWords, int unitSize) {
    Map<String, Integer> dicNew = new HashMap<>();
    for (int i = 0; i < numWords; i++) {
      String currWord = s.substring(start + i* unitSize, start+ (i+1) * unitSize);
      Long freq = dic.get(currWord);
      if (freq == null) return false;
      dicNew.put(currWord, dicNew.getOrDefault(currWord, 0)+1);
      if (dicNew.get(currWord) > freq) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.exit(GenericTest
                    .runFromAnnotations(
                        args, "StringDecompositionsIntoDictionaryWords.java",
                        new Object() {}.getClass().getEnclosingClass())
                    .ordinal());
  }
}
