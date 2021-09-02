package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  @EpiTest(testDataFile = "fibonacci.tsv")

  public static int fibonacci(int n) {
    // TODO - you fill in here.
    // use hashmap----------------------------------------
//    Map<Integer, Integer> cache = new HashMap<>();
//
//    if (n <=1) {
//      return n;
//    }
//    cache.put(0, 0);
//    cache.put(1,1);
//    for (int i = 2; i <=n ; i++) {
//      cache.putIfAbsent(i, cache.get(i-1)+ cache.get(i-2));
//    }
//    return cache.get(n);

    // use iterative loop----------------------------------------
//    if (n <=1) return n;
//    int prev = 0, cur = 1;
//    for (int i = 2; i <=n ; i++) {
//      int next = prev + cur;
//      prev = cur;
//      cur = next;
//    }
//    return cur;

    // use recursion---------------------------------------- too slow
    if (n <=1) return n;
    return fibonacci(n-1) + fibonacci(n-2);



  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Fibonacci.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
