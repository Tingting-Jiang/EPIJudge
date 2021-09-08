package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
public class StringTransformability {
  public String candidateString;
  public int distance;

  StringTransformability(String candidateString, int distance) {
    this.candidateString = candidateString;
    this.distance = distance;

  }
  @EpiTest(testDataFile = "string_transformability.tsv")
  public static int transformString(Set<String> D, String s, String t) {
    // TODO - you fill in here.
    Set<String> visited = new HashSet<>(D);
    Queue<StringTransformability> q = new ArrayDeque<>();
    visited.remove(s);
    q.add(new StringTransformability(s, 0));
    StringTransformability f;
    while ((f = q.poll()) != null) {
      if (f.candidateString.equals(t)) {
        return f.distance;
      }
      String str = f.candidateString;
      for (int i = 0; i < str.length(); i++) {
        String start = i == 0 ? "" : str.substring(0,i);
        String end = i + 1 <str.length() ? str.substring(i+1): "";
        for (char c = 'a'; c <= 'z'; c++) {
          String newStr = start + c + end;
          if (visited.contains(newStr)) {
            visited.remove(newStr);
            q.add(new StringTransformability(newStr, f.distance+1));
          }
        }

      }

    }




    return -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StringTransformability.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
