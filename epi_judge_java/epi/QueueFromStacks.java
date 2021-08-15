package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
public class QueueFromStacks {

  public static class Queue {
    private Deque<Integer> addMore = new ArrayDeque<>();
    private Deque<Integer> withdraw = new ArrayDeque<>();

    public void enqueue(Integer x) {
      // TODO - you fill in here.
      addMore.addFirst(x);
    }

    public Integer dequeue() {
      // TODO - you fill in here.
      if (withdraw.isEmpty()) {
        while (!addMore.isEmpty()) {
          withdraw.addFirst(addMore.removeFirst());
        }
      }
      return withdraw.removeFirst();
      }
    }

    @EpiUserType(ctorParams = {String.class, int.class})
    public static class QueueOp {
      public String op;
      public int arg;

      public QueueOp(String op, int arg) {
        this.op = op;
        this.arg = arg;
      }
    }

    @EpiTest(testDataFile = "queue_from_stacks.tsv")
    public static void queueTester(List<QueueOp> ops) throws TestFailure {
      try {
        Queue q = new Queue();

        for (QueueOp op : ops) {
          switch (op.op) {
            case "QueueWithMax":
              q = new Queue();
              break;
            case "enqueue":
              q.enqueue(op.arg);
              break;
            case "dequeue":
              int result = q.dequeue();
              if (result != op.arg) {
                throw new TestFailure("Dequeue: expected " +
                        String.valueOf(op.arg) + ", got " +
                        String.valueOf(result));
              }
              break;
          }
        }
      } catch (NoSuchElementException e) {
        throw new TestFailure("Unexpected NoSuchElement exception");
      }
    }

    public static void main(String[] args) {
      System.exit(
              GenericTest
                      .runFromAnnotations(args, "QueueFromStacks.java",
                              new Object() {
                              }.getClass().getEnclosingClass())
                      .ordinal());
    }
  }
