package language.features;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/** This covers features from Java 8 through 17. Focuses on high level ideas and snippets. */
public class Explorer {

  private static final Logger LOGGER = Logger.getLogger(Explorer.class.getName());

  public static void main(String[] args) throws Exception {

    java8();

    System.exit(0);

    java9();
    java10();
    java11();
    java12();
    java13();
    java14();
    java15();
    java16();
    java17();
  }

  /**
   * Features added in Java 8:
   *
   * <ul>
   *   <li>Streams
   *   <li>Lambdas & Interfaces
   *   <li>New Date & Time APIs
   * </ul>
   */
  private static void java8() throws Exception {
    // =================== Streams ================================================================
    {
      LOGGER.info(
          "Streams are abstract constructs used for processing sequence of elements. It allows you to "
              + "perform aggregate operations, use intermediary pipelines, introduce parallelism, etc. "
              + "You can connect streams to each other following principles of the Decorator Pattern");

      java8_streams();
    }

    // =================== Lambdas ================================================================
    {
      LOGGER.info("");
    }
  }

  private static void java9() {
    // Features added in Java 9
  }

  private static void java10() {
    // Features added in Java 10
  }

  private static void java11() {
    // Features added in Java 11
  }

  private static void java12() {
    // Features added in Java 12
  }

  private static void java13() {
    // Features added in Java 13
  }

  private static void java14() {
    // Features added in Java 14
  }

  private static void java15() {
    // Features added in Java 15
  }

  private static void java16() {
    // Features added in Java 16
  }

  private static void java17() {
    // Features added in Java 17
  }

  private static void java8_streams() throws Exception {
    LOGGER.info("Creation of Streams");
    {

      // Basics
      Stream<String> streamUsingOf = Stream.of("Lorem", "Ipsum");
      System.out.println(streamUsingOf.findFirst());

      Stream<Integer> emptyStream = Stream.empty();
      System.out.println(emptyStream.findFirst());

      // Infinite Streams

      // Infinite Stream of a constant using Stream.generate
      Stream<String> infiniteLorems = Stream.generate(() -> "Lorem");
      System.out.println(infiniteLorems.findAny());

      // infinite random numbers
      Stream<Integer> infiniteRandomNumbers =
          Stream.generate(() -> ThreadLocalRandom.current().nextInt());
      System.out.println(infiniteRandomNumbers.findAny());

      LOGGER.info(
          "Stream operations are not executed on the elements in the order in"
              + "which they are invoked on the streams. Nothing happens until a "
              + "terminal operation is called on the stream. Once that a terminal operation"
              + "asks for something, the stream lazily loads the first element and kicks off everything");

      System.out.println();
      System.out.println();
      Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
    }

    LOGGER.info("Iteration -> Stream");
    {
      final URL resource = Explorer.class.getClassLoader().getResource("lorem_ipsum.txt");
      assert resource != null;
      final String loremIpsum = new String(Files.readAllBytes(Paths.get(resource.toURI())));
      List<String> words = asList(loremIpsum.split("[\\P{L}]+"));

      long count = 0;

      // using arrays
      for (String w : words) {
        if (w.length() > 8) count++;
      }
      System.out.println("count from foreach = " + count);

      // using streams, filter method to do the operation
      count =
          words.stream() // creation of a stream
              .filter(w -> w.length() > 5) // one or more intermediate operations
              .count(); // terminal operation which forces the lazy execution
      System.out.println("count from stream = " + count);

      // using parallel streams
      count = words.parallelStream().filter(w -> w.length() > 3).count();
      System.out.println("count from parallel stream = " + count);

      System.out.println();
      System.out.println();
      Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
    }

    LOGGER.info("Interesting Operations on Streams");
    {
      // distinct, count
      int[] randomRepeatedNumbers = new int[] {873, 348, 210, 873, 348};
      System.out.print("Distinct Values :: ");
      Arrays.stream(randomRepeatedNumbers)
          .distinct()
          .forEach(
              value -> {
                System.out.print(value + "\t");
              });
      System.out.println(
          "\n# of distinct numbers :: " + Arrays.stream(randomRepeatedNumbers).distinct().count());

      // sort
      System.out.print("Sorted Distinct Values :: ");
      Arrays.stream(randomRepeatedNumbers)
          .sorted()
          .distinct()
          .forEach(value -> System.out.print(value + "\t"));
      // reduction using a starter value and an accumulator function
      Stream<Integer> aStream = Stream.of(1, 2, 3);
      System.out.println(
          "\nReduction of 5 and sum of all in the stream :: " + aStream.reduce(5, (a, b) -> a + b));

      // matching using predicates
      List<String> randomStrings =
          asList(
              "3Fm9",
              "2S5",
              "aWC",
              "v5s69qD",
              "jZBXu",
              "MvzDT5r9",
              "ifBoLzc",
              "QOP6",
              "Pl0l76H",
              "r9Yz3q");
      boolean doYouHaveLetter_v = randomStrings.stream().anyMatch(s -> s.contains("v"));
      boolean doNoneOfYouHaveLetter_a = randomStrings.stream().noneMatch(s -> s.contains("a"));

      System.out.println("doYouHaveLetter_v = " + doYouHaveLetter_v);
      System.out.println("doNoneOfYouHaveLetter_a = " + doNoneOfYouHaveLetter_a);

      List<String> randomWords = asList("nurse", "measure", "prevent", "lunch", "degree");

      // use stream.map to transform using a function which applies to each value
      List<String> randomWordsUpperCased =
          randomWords.stream().map(String::toUpperCase).collect(Collectors.toList());
      System.out.println("Get them Upper-cased :: " + randomWordsUpperCased);

      // largest in a dictionary
      Optional<String> largest = randomWords.stream().max(String::compareToIgnoreCase);
      System.out.println("largest = " + largest.get());

      // use stream.flatMap to flatten a stream of streams to a single stream
      List<List<String>> nested =
          asList(
              asList("1::0", "1::1"),
              asList("2::0", "2::1", "2::2"),
              asList("3::0", "3::1", "3::2", "3::3"));
      List<String> flattened =
          nested.stream().flatMap(Collection::stream).collect(Collectors.toList());
      System.out.println("flattened = " + flattened);

      // infinite numbers in order using Stream.iterate
      Stream<BigInteger> infiniteNumbers =
          Stream.iterate(BigInteger.ZERO, i -> i.add(BigInteger.ONE));

      // Getting sub-stream using limit & skip
      infiniteNumbers.skip(5).limit(5).forEach(bigInt -> System.out.print(bigInt + "\t"));

      // Summarizing Stats

      System.out.println();
      System.out.println();
      Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
    }

    LOGGER.info("Collectors");
    {
      SimpleClass a = SimpleClass.builder().a(1).b("One").build();
      SimpleClass b = SimpleClass.builder().a(2).b("Two").build();

      // collecting into specific type of set
      List<Integer> numbers = asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
      TreeSet<Integer> set = numbers.stream().collect(Collectors.toCollection(TreeSet::new));
      System.out.println("set = " + set);

      // collect a stream of string by joining them
      List<String> randomWords = asList("nurse", "measure", "prevent", "lunch", "degree");
      String result = randomWords.stream().collect(Collectors.joining(", "));
      System.out.println("result = " + result);

      // collect a stream of simple classes to a map
      Map<Integer, String> numToWords =
          Stream.of(a, b).collect(Collectors.toMap(SimpleClass::getA, SimpleClass::getB));
      System.out.println("numToWords = " + numToWords);

      IntSummaryStatistics statistics =
          randomWords.stream().collect(Collectors.summarizingInt(String::length));
      System.out.println("statistics = " + statistics);

      System.out.println();
      System.out.println();
      Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
    }
  }

  @Data
  @Builder
  static class SimpleClass {
    int a;
    String b;
  }
}
