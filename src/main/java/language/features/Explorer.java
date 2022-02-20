package language.features;

import static java.util.Arrays.asList;

import java.math.BigInteger;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** This covers features from Java 8 through 17. Focuses on high level ideas and snippets. */
public class Explorer {

  private static final Logger LOGGER = Logger.getLogger(Explorer.class.getName());

  public static void main(String[] args) throws Exception {

    java8();
    java9();
    java10();
    java11();
    java12();
    java13();
    java14();
    java15();
    java16();
    java17();

    System.exit(0);
  }

  /**
   * Features added in Java 8:
   *
   * <ul>
   *   <li>Streams
   *   <li>Lambdas, Changes to Interfaces & Method References
   *   <li>New Date & Time APIs
   * </ul>
   */
  private static void java8() throws Exception {
    // Features added in Java 8

    java8_streams();
    java8_lambdas();
    java8_date_time();

    // System.exit(0);
  }

  /**
   * Features added in Java 9:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java9() {
    // Features added in Java 9

    // System.exit(0);
  }

  /**
   * Features added in Java 10:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java10() {
    // Features added in Java 10

    // System.exit(0);
  }

  /**
   * Features added in Java 11:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java11() {
    // Features added in Java 11

    // System.exit(0);
  }

  /**
   * Features added in Java 12:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java12() {
    // Features added in Java 12

    // System.exit(0);
  }

  /**
   * Features added in Java 13:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java13() {
    // Features added in Java 13

    // System.exit(0);
  }

  /**
   * Features added in Java 14:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java14() {
    // Features added in Java 14

    // System.exit(0);
  }

  /**
   * Features added in Java 15:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java15() {
    // Features added in Java 15

    // System.exit(0);
  }

  /**
   * Features added in Java 16:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java16() {
    // Features added in Java 16

    // System.exit(0);
  }

  /**
   * Features added in Java 17:
   *
   * <ul>
   *   <li>
   *   <li>
   *   <li>
   * </ul>
   */
  private static void java17() {
    // Features added in Java 17

    // System.exit(0);
  }

  // =========== Java 8 ============================================================================
  private static void java8_streams() throws Exception {
    LOGGER.info(
        "Streams are abstract constructs used for processing sequence of elements. It allows you to "
            + "perform aggregate operations, use intermediary pipelines, introduce parallelism, etc. "
            + "You can connect streams to each other following principles of the Decorator Pattern");
    delayBuffer();

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

      delayBuffer();
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

      delayBuffer();
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

      delayBuffer();
    }

    LOGGER.info("Collectors");
    {
      SimpleClass a = new SimpleClass(1, "One");
      SimpleClass b = new SimpleClass(2, "Two");

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

      delayBuffer();
    }
  }

  private static void java8_lambdas() throws Exception {
    LOGGER.info(
        "Java 8 is the addition of functional programming constructs to its object-oriented root. "
            + "A “lambda expression” is a block of code that you can pass around so it can be executed "
            + "later, once or multiple times. You can supply a lambda expression whenever an object of an "
            + "interface with a single abstract method is expected (functional interface)");
    delayBuffer();

    LOGGER.info("Syntax");
    {
      // The arrow operator '->' followed by an 'expression'
      Comparator<Integer> comparator =
          (i1, i2) -> {
            if (i1 > i2) {
              return 1;
            } else if (i2 > i1) {
              return -1;
            }
            return 0;
          };
      System.out.println("Integer Comparison :: " + comparator.compare(1, 2));

      // creating a thread using lambda expression
      final Thread A = new Thread(() -> System.out.println("I was printed in SimpleThread::run()"));
      A.start();
      A.join();

      delayBuffer();
    }

    LOGGER.info("Functional Interfaces");
    {
      // A Functional Interface is an interface with a single abstract method
      String[] words = new String[] {"commerce", "chain", "shame", "clerk", "horse"};
      Arrays.sort(
          words,
          new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              return Integer.compare(o1.length(), o2.length());
            }
          });

      // can be replaced by
      Arrays.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

    LOGGER.info("Changes to Interfaces");
    {
      // Interfaces can now have concrete implementations called 'default methods'
      // This was done to safely and passively add new functionality to existing interfaces

      interface SimpleInterface {
        String getMessage();

        default int getAnswerToLife() {
          return 42;
        }
      }

      class Impl implements SimpleInterface {
        @Override
        public String getMessage() {
          return "Did not need to implement default getAnswerToLife";
        }
      }

      Impl impl = new Impl();
      System.out.println("impl = " + impl.getAnswerToLife());

      class ImplOverrider implements SimpleInterface {
        @Override
        public String getMessage() {
          return "I can override default methods";
        }

        @Override
        public int getAnswerToLife() {
          return 183;
        }
      }

      ImplOverrider overrider = new ImplOverrider();
      System.out.println("overrider = " + overrider.getAnswerToLife());

      // Interfaces can now have static methods too
      // Overall, Interfaces can now have default & static methods

      delayBuffer();
    }

    LOGGER.info("Method References");
    {
      // Lambda Expressions can sometimes be swapped with method references
      String[] words = new String[] {"commerce", "chain", "shame", "clerk", "horse"};
      System.out.println("words = " + Arrays.toString(words));

      Arrays.sort(words, (o1, o2) -> o1.compareToIgnoreCase(o2));
      // can be swapped with
      // we are essentially passing the compareToIgnoreCase method to the sort method
      Arrays.sort(words, String::compareToIgnoreCase);

      System.out.println("words = " + Arrays.toString(words));
      // A Lambda expression 'x -> System.out.println(x)' can be simplified as:
      // 'System.out::println'

      // At the end of the day the reason you'd use Lambdas is to 'defer execution'
      delayBuffer();
    }
  }

  private static void java8_date_time() throws Exception {
    LOGGER.info(
        "All java.time objects are immutable. "
            + "An Instant is a point on the time line. "
            + "A Duration is the difference between two instants. "
            + "LocalDateTime has no time zone information. "
            + "ZonedDateTime is a point in time in a given time zone. "
            + "Other important classes are Temporal Adjuster, Period & DateTimeFormatter. "
            + "All of these have methods around plus, minus and other common helpers");
    delayBuffer();

    LOGGER.info("Instant & Duration");
    {
      Instant start = Instant.now();
      Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
      Instant end = Instant.now();

      Duration timeElapsed = Duration.between(start, end);
      System.out.println("Elapsed ms :: " + timeElapsed.toMillis());

      Duration shouldBeLessThanOne = timeElapsed.minusSeconds(5);

      System.out.println("shouldBeLessThanOne = " + shouldBeLessThanOne);
      delayBuffer();
    }

    LOGGER.info("Local APIs");
    {
      LocalDate today = LocalDate.now();
      System.out.println("today = " + today);

      LocalDate myBirthday = LocalDate.of(1993, 11, 15);
      System.out.println("myBirthday = " + myBirthday);

      LocalDate myBirthdayUsingMonthEnum = LocalDate.of(1993, Month.NOVEMBER, 15);
      System.out.println("myBirthdayUsingMonthEnum = " + myBirthdayUsingMonthEnum);

      long age = myBirthday.until(today, ChronoUnit.YEARS);
      System.out.println("age = " + age);

      LocalTime rightNow = LocalTime.now();
      System.out.println("rightNow = " + rightNow);

      LocalTime secretTime = LocalTime.of(23, 39);
      System.out.println("secretTime = " + secretTime);

      LocalTime tenHoursAfterSecret = secretTime.plus(10, ChronoUnit.HOURS);
      System.out.println("tenHoursAfterSecret = " + tenHoursAfterSecret);

      // compute specific dates, in this example lets see next workday from now
      TemporalAdjuster NEXT_WORKDAY =
          w -> {
            LocalDate result = (LocalDate) w;
            do {
              result = result.plusDays(1);
            } while (result.getDayOfWeek().getValue() >= DayOfWeek.SATURDAY.getValue());
            return result;
          };
      LocalDate backToWork = today.with(NEXT_WORKDAY);
      System.out.println("backToWork = " + backToWork);

      // finding first Sunday after India won the 1983 World Cup
      LocalDate firstSundayAfter83Win =
          LocalDate.of(1983, Month.JUNE, 25).with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
      System.out.println("firstSundayAfter83Win = " + firstSundayAfter83Win);

      delayBuffer();
    }

    LOGGER.info("Zoned APIs");
    {
      ZonedDateTime indiaWins2011WorldCup =
          ZonedDateTime.of(2011, 4, 2, 23, 31, 0, 0, ZoneId.of("Asia/Kolkata"));
      System.out.println("indiaWins2011WorldCup = " + indiaWins2011WorldCup);

      // Use Period when adjusting across time boundaries (takes into account the DST)
      // Duration won't work with Daylight Savings
      ZonedDateTime oneWeekLater = indiaWins2011WorldCup.plus(Period.ofDays(7));
      System.out.println("oneWeekLater = " + oneWeekLater);

      delayBuffer();
    }

    LOGGER.info("Formatting");
    {
      ZonedDateTime indiaWins2011WorldCup =
          ZonedDateTime.of(2011, 4, 2, 23, 31, 0, 0, ZoneId.of("Asia/Kolkata"));

      String formatted = DateTimeFormatter.ISO_DATE_TIME.format(indiaWins2011WorldCup);
      System.out.println("formatted using ISO = " + formatted);

      DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
      formatted = formatter.format(indiaWins2011WorldCup);
      System.out.println("formatted using Long Localized Style = " + formatted);

      formatted = formatter.withLocale(Locale.UK).format(indiaWins2011WorldCup);
      System.out.println("formatter with Locale UK = " + formatted);
      delayBuffer();
    }
  }

  // =========== Java 9 ============================================================================

  // =========== Java 10 ===========================================================================

  // =========== Java 11 ===========================================================================

  // =========== Java 12 ===========================================================================

  // =========== Java 13 ===========================================================================

  // =========== Java 14 ===========================================================================

  // =========== Java 15 ===========================================================================

  // =========== Java 16 ===========================================================================

  // =========== Java 17 ===========================================================================

  // =========== Utility ===========================================================================

  private static void delayBuffer() throws InterruptedException {
    System.out.println();
    System.out.println();
    Thread.sleep(TimeUnit.SECONDS.toMillis(2L));
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  static class SimpleClass {
    int a;
    String b;
  }
}