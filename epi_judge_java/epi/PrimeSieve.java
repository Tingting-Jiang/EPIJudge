package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PrimeSieve {
  @EpiTest(testDataFile = "prime_sieve.tsv")
  // Given n, return all primes up to and including n.
  public static List<Integer> generatePrimes(int n) {
    // TODO - you fill in here.
    List<Boolean> table = new ArrayList<>(Collections.nCopies(n+1,true));
    List<Integer> ans = new ArrayList<>();
    table.set(0,false);
    table.set(1, false);
    for (int i = 2; i <= n; i++) {
      if (table.get(i)) {
        ans.add(i);

        // set all this primes multiplies to false
        for (int k = i; k <= n; k += i) {
          table.set(k, false);
        }
      }
    }

    return ans;

    // Time: should be nloglogn    Space: n



  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PrimeSieve.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
