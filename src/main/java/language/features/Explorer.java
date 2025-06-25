package language.features;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
// import java.util.concurrent.Future;
// import java.util.concurrent.ScopedValue;
// import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/** This covers features from Java 8 through 17. Focuses on high level ideas and snippets. */
public class Explorer {

  private static final Logger LOGGER = Logger.getLogger(Explorer.class.getName());

  public static void main(String[] args) throws Exception {
    java24();
    java23();
    java22();
    java21();
    java20();
    java19();
    java18();
    java17();
    java16();
    java15();
    java14();
    java13();
    java12();
    java11();
    java10();
    java9();
    java8();
  }

  /**
   * Features added in Java 8:
   *
   * <ul>
   *   <li>Streams
   *   <li>Lambdas
   *   <li>Changes to Interfaces & Method References
   *   <li>New Date & Time APIs
   * </ul>
   */
  private static void java8() throws Exception {
    // Features added in Java 8

    streams(8);
    lambdas(8);
    interfaces(8);
    date_time(8);

    // System.exit(0);
  }

  /**
   * Features added in Java 9:
   *
   * <ul>
   *   <li>Factory Methods for Collections
   *   <li>Stream API improvements
   *   <li>Optional Class Enhancements
   *   <li>Private interface methods
   *   <li>Java 9 - Language Modifications
   * </ul>
   */
  private static void java9() throws Exception {
    // Features added in Java 9

    collections(9);
    streams(9);
    optional(9);
    interfaces(9);
    java9_language_modifications();

    // System.exit(0);
  }

  /**
   * Features added in Java 10:
   *
   * <ul>
   *   <li>Local Variable Type Inference
   *   <li>Unmodifiable Collections
   *   <li>Optional*.orElseThrow()
   * </ul>
   */
  private static void java10() throws Exception {
    // Features added in Java 10

    var(10);
    collections(10);
    optional(10);

    // System.exit(0);
  }

  /**
   * Features added in Java 11:
   *
   * <ul>
   *   <li>HTTP Client
   *   <li>Local-Variable Syntax for Lambda Parameters
   *   <li>New String Methods
   *   <li>New File Methods
   *   <li>Collection to an Array
   *   <li>The Not Predicate Method
   * </ul>
   */
  private static void java11() throws Exception {
    // Features added in Java 11

    http_client(11);
    var(11);
    string(11);
    file(11);
    collections(11);
    not_predicate(11);

    // System.exit(0);
  }

  /**
   * Features added in Java 12:
   *
   * <ul>
   *   <li>String Class New Methods
   *   <li>File::mismatch Method
   *   <li>Teeing Collector
   *   <li>Compact Number Formatting
   * </ul>
   */
  private static void java12() throws Exception {
    // Features added in Java 12

    string(12);
    file(12);
    teeing(12);
    number(12);

    // System.exit(0);
  }

  /**
   * Features added in Java 13:
   *
   * <ul>
   *   <li>Switch Expressions
   * </ul>
   */
  private static void java13() throws Exception {
    // Features added in Java 13

    switch_expression(13);

    // System.exit(0);
  }

  /**
   * Features added in Java 14:
   *
   * <ul>
   *   <li>Records
   *   <li>Helpful NullPointerExceptions
   * </ul>
   */
  private static void java14() throws Exception {
    // Features added in Java 14

    records(14);
    npe(14);

    // System.exit(0);
  }

  /**
   * Features added in Java 15:
   *
   * <ul>
   *   <li>Text Blocks
   * </ul>
   */
  private static void java15() throws Exception {
    // Features added in Java 15

    text_blocks(15);

    // System.exit(0);
  }

  /**
   * Features added in Java 16:
   *
   * <ul>
   *   <li>Day Period Support
   *   <li>Add Stream.toList Method
   *   <li>Records
   *   <li>Pattern Matching for instanceof
   * </ul>
   */
  private static void java16() throws Exception {
    // Features added in Java 16

    date_time(16);
    streams(16);
    records(16);
    instance_of(16);

    // System.exit(0);
  }

  /**
   * Features added in Java 17:
   *
   * <ul>
   *   <li>Enhanced Pseudo-Random Number Generators
   *   <li>Sealed Classes
   * </ul>
   */
  private static void java17() throws Exception {
    // Features added in Java 17

    number(17);
    classes(17);

    // System.exit(0);
  }

  /**
   * Features added in Java 18:
   *
   * <ul>
   *   <li>Simple Web Server
   *   <li>Code Snippets in Java API Documentation
   *   <li>UTF-8 by Default
   *   <li>Pattern Matching for switch (Second Preview)
   *   <li>Internet-Address Resolution SPI
   * </ul>
   */
  private static void java18() throws Exception {
    // Features added in Java 18

    switch_expression(18);
    string(18);
    simple_web_server(18);

    // System.exit(0);
  }

  /**
   * Features added in Java 19:
   *
   * <ul>
   *   <li>Record Patterns (Preview)
   *   <li>Virtual Threads (Preview)
   *   <li>Structured Concurrency (Preview)
   *   <li>Pattern Matching for Switch (Third Preview)
   *   <li>Vector API (Fourth Incubator)
   * </ul>
   */
  private static void java19() throws Exception {
    // Features added in Java 19

    records(19);
    virtual_threads(19);
    structured_concurrency(19);

    // System.exit(0);
  }

  /**
   * Features added in Java 20:
   *
   * <ul>
   *   <li>Record Patterns (Second Preview)
   *   <li>Pattern Matching for Switch (Fourth Preview)
   *   <li>Scoped Values (Preview)
   *   <li>Virtual Threads (Second Preview)
   *   <li>Structured Concurrency (Second Preview)
   * </ul>
   */
  private static void java20() throws Exception {
    // Features added in Java 20

    records(20);
    virtual_threads(20);
    scoped_values(20);
  }

  /**
   * Features added in Java 21 (LTS):
   *
   * <ul>
   *   <li>String Templates (Preview)
   *   <li>Sequenced Collections
   *   <li>Record Patterns (Standard)
   *   <li>Pattern Matching for Switch (Standard)
   *   <li>Virtual Threads (Standard)
   *   <li>Scoped Values (Preview)
   *   <li>Unnamed Patterns and Variables (Preview)
   * </ul>
   */
  private static void java21() throws Exception {
    // Features added in Java 21

    string(21);
    collections(21);
    records(21);
    switch_expression(21);
    virtual_threads(21);
    unnamed_patterns(21);
  }

  /**
   * Features added in Java 22:
   *
   * <ul>
   *   <li>Unnamed Variables & Patterns (final)
   *   <li>Statements Before super(...) (preview)
   *   <li>Stream Gatherers (preview)
   *   <li>Structured Concurrency (second preview)
   *   <li>Scoped Values (second preview)
   *   <li>String Templates (second preview)
   * </ul>
   */
  private static void java22() throws Exception {
    // Features added in Java 22
    unnamed_patterns(22);
    language_modifications(22);
    streams(22);
    structured_concurrency(22);
    scoped_values(22);
    string(22);
  }

  /**
   * Features added in Java 23:
   *
   * <ul>
   *   <li>Primitive Types in Patterns, instanceof, and switch (Preview)
   *   <li>Stream Gatherers (final/preview)
   *   <li>Structured Concurrency (3rd preview)
   *   <li>Scoped Values (3rd preview)
   *   <li>Flexible Constructor Bodies (2nd preview)
   * </ul>
   */
  private static void java23() throws Exception {
    // Features added in Java 23
    primitive_patterns(23);
    streams(23);
    structured_concurrency(23);
    scoped_values(23);
    language_modifications(23);
  }

  /**
   * Features added in Java 24:
   *
   * <ul>
   *   <li>Stream Gatherers (final)
   *   <li>Scoped Values (4th preview)
   *   <li>Structured Concurrency (4th preview)
   *   <li>Primitive Types in Patterns, instanceof, and switch (2nd preview)
   *   <li>Flexible Constructor Bodies (3rd preview)
   *   <li>Unnamed Variables & Patterns (final)
   *   <li>Class-File API
   *   <li>Vector API (incubator)
   *   <li>Prepare to Restrict the Use of JNI
   *   <li>Warn upon Use of Memory-Access Methods in sun.misc.Unsafe
   * </ul>
   */
  private static void java24() throws Exception {
    // Features added in Java 24
    streams(24);
    scoped_values(24);
    structured_concurrency(24);
    primitive_patterns(24);
    language_modifications(24);
    unnamed_patterns(24);
    class_file_api(24);
    vector_api(24);
    restrict_jni(24);
    unsafe_warnings(24);
    // (Other feature demos to be added in subsequent steps)
  }

  // =========== Language Changes=================================================================
  private static void classes(final int java) throws Exception {
    if (java == 17) {
      LOGGER.info(
          """
              Java 17 :: Sealed Classes. Rules:
              - All permitted subclasses must belong to the same module as the sealed class.
              - Every permitted subclass must explicitly extend the sealed class.
              - Every permitted subclass must define a modifier: final, sealed, or non-sealed.""");
      {
        System.out.println("Valid Example :: ");
        System.out.println(
            "To seal an interface, we can apply the sealed modifier to its declaration. "
                + "The permits clause then specifies the classes that are permitted to implement the sealed interface:");
        System.out.println(
            """
                public sealed interface Service permits Car, Truck {

                    int getMaxServiceIntervalInMonths();

                    default int getMaxDistanceBetweenServicesInKilometers() {
                        return 100000;
                    }

                }
                """);
        System.out.println();
        System.out.println(
            "Similar to interfaces, we can seal classes by applying the same sealed modifier. "
                + "The permits clause should be defined after any extends or implements clause");
        System.out.println(
            """
                public abstract sealed class Vehicle permits Car, Truck {

                    protected final String registrationNumber;

                    public Vehicle(String registrationNumber) {
                        this.registrationNumber = registrationNumber;
                    }

                    public String getRegistrationNumber() {
                        return registrationNumber;
                    }

                }
                """);
        System.out.println();
        System.out.println(
            "A permitted subclass must define a modifier. "
                + "It may be declared final to prevent any further extensions:");
        System.out.println(
            """
                public final class Truck extends Vehicle implements Service {

                    private final int loadCapacity;

                    public Truck(int loadCapacity, String registrationNumber) {
                        super(registrationNumber);
                        this.loadCapacity = loadCapacity;
                    }

                    public int getLoadCapacity() {
                        return loadCapacity;
                    }

                    @Override
                    public int getMaxServiceIntervalInMonths() {
                        return 18;
                    }

                }
                """);
        System.out.println();
        System.out.println(
            "Sealed classes work very well with records. Since records are implicitly final, "
                + "the sealed hierarchy is even more concise.");
        System.out.println(
            """
                public record Car(int numberOfSeats, String registrationNumber) implements Vehicle {

                    @Override
                    public String getRegistrationNumber() {
                        return registrationNumber;
                    }

                    public int getNumberOfSeats() {
                        return numberOfSeats;
                    }

                }
                """);

        delayBuffer();
      }
    }
  }

  private static void collections(final int java) throws Exception {
    if (java == 9) {
      LOGGER.info("Java 9 :: Collection Factory Methods");
      {
        Set<Integer> nums = Set.of(1, 2, 3);
        List<String> strings = List.of("one", "two", "three");

        System.out.println("nums = " + nums);
        System.out.println("strings = " + strings);
        delayBuffer();
      }
    } else if (java == 10) {
      LOGGER.info("Java 10 :: Unmodifiable Collections");
      {
        List<Integer> nums = List.of(1, 2, 3);

        // unmodifiable copy of the given Collection
        List<Integer> unmodifiable = List.copyOf(nums);
        try {
          unmodifiable.add(4);
        } catch (final UnsupportedOperationException e) {
          LOGGER.info("Cannot modify an immutable object. It is an UnsupportedOperation");
        }

        // Collect a Stream into unmodifiable List, Map or Set
        List<Integer> evens =
            nums.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableList());

        System.out.println("evenList.size() = " + evens.size());
        delayBuffer();

        try {
          evens.add(4);
        } catch (final UnsupportedOperationException e) {
          LOGGER.info("Cannot modify an immutable object. It is an UnsupportedOperation");
        }

        delayBuffer();
      }
    } else if (java == 11) {
      LOGGER.info("Java 11 :: Collection to an Array");
      {
        List<String> strings = List.of("one", "two");
        String[] listToArray = strings.toArray(String[]::new);
        System.out.println("listToArray.length = " + listToArray.length);

        delayBuffer();
      }
    } else if (java == 21) {
      LOGGER.info("Java 21 :: Sequenced Collections");
      {
        System.out.println(
            """
                Java 21 introduced new interfaces for collections that have a well-defined encounter order:
                - SequencedCollection
                - SequencedSet
                - SequencedMap

                These interfaces add methods like:
                - getFirst()/getLast()
                - addFirst()/addLast()
                - removeFirst()/removeLast()
                - reversed()

                Example:
                List<String> list = new ArrayList<>();
                list.addLast("end");
                list.addFirst("start");

                String first = list.getFirst();  // "start"
                String last = list.getLast();    // "end"

                // Get reversed view
                List<String> reversed = list.reversed();
                """);

        delayBuffer();
      }
    }
  }

  private static void date_time(final int java) throws Exception {
    if (java == 8) {
      LOGGER.info(
          "Java 8 :: All java.time objects are immutable. "
              + "An Instant is a point on the time line. "
              + "A Duration is the difference between two instants. "
              + "LocalDateTime has no time zone information. "
              + "ZonedDateTime is a point in time in a given time zone. "
              + "Other important classes are Temporal Adjuster, Period & DateTimeFormatter. "
              + "All of these have methods around plus, minus and other common helpers");
      delayBuffer();

      LOGGER.info("Java 8 :: Instant & Duration");
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

      LOGGER.info("Java 8 :: Local APIs");
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

      LOGGER.info("Java 8 :: Zoned APIs");
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

      LOGGER.info("Java 8 :: Formatting");
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
    } else if (java == 16) {
      LOGGER.info("Java 16 :: Day Period Support. Addition of new symbol 'B'");
      {
        LocalTime date = LocalTime.parse("10:21:13");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B");
        System.out.println("date.format(formatter) = " + date.format(formatter));

        delayBuffer();
      }
    }
  }

  private static void file(final int java) throws Exception {
    if (java == 11) {
      LOGGER.info("Java 11 :: Reading & Writing of String to Files");
      final Path path =
          Files.writeString(Files.createTempFile("temp", ".txt"), "You are being watched!");
      System.out.println(Files.readString(path));
    } else if (java == 12) {
      LOGGER.info("Java 12 :: File Mismatch - used to find the position of first mismatched byte");

      Path tempF1 = Files.createTempFile("f1", ".txt");
      Path tempF2 = Files.createTempFile("f2", ".txt");

      Files.writeString(tempF1, "Hello World!");
      Files.writeString(tempF2, "Hello General!");

      System.out.println("Files.mismatch = " + Files.mismatch(tempF1, tempF2));

      delayBuffer();
    }
  }

  private static void http_client(final int java) throws Exception {
    if (java == 11) {
      LOGGER.info(
          """
                  Java 11 :: A new HTTP Client that implements HTTP/2 and WebSocketIt is aimed at replacing the
                  legacy HttpURLConnection. The new API is feature rich and is fully asynchronous. It improves
                  performance by using stream multiplexing, header compression, etc. The core classes/interfaces are:
                  - The HttpClient class, java.net.http.HttpClient
                  - The HttpRequest class, java.net.http.HttpRequest
                  - The HttpResponse<T> interface, java.net.http.HttpResponse
                  - The WebSocket interface, java.net.http.WebSocket""");
      {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request =
            HttpRequest.newBuilder(new URI("https://postman-echo.com/get"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        // sync call
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response.body());

        // async call
        CompletableFuture<HttpResponse<String>> future =
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        String result = future.thenApply(HttpResponse::body).get(10, TimeUnit.SECONDS);
        System.out.println("response = " + result);

        delayBuffer();
      }
    }
  }

  private static void instance_of(final int java) throws Exception {
    if (java == 16) {
      LOGGER.info("Java 16 :: Pattern Matching for instanceOf");
      {
        Object javaVersion = "Java 16";

        // before java 14
        if (javaVersion instanceof String) {
          String str = (String) javaVersion;
          str.strip();
        }

        // now
        if (javaVersion instanceof String s) {
          s.strip();
        }

        delayBuffer();
      }
    }
  }

  private static void interfaces(final int java) throws Exception {
    if (java == 8) {
      LOGGER.info("Java 8 :: Functional Interfaces");
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

      LOGGER.info("Java 8 :: Changes to Interfaces");
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
    } else if (java == 9) {

      LOGGER.info("Java 9 :: Private Interface Methods");
      {
        // If there are multiple default methods which need to call similar functionality
        // We can now add private methods with behavior

        interface Java9Private {

          default void default1() {
            start();
          }

          default void default2() {
            start();
          }

          // not part of the public API
          private void start() {
            System.out.println("Starting...");
          }
        }

        class Impl implements Java9Private {}

        Impl impl = new Impl();
        impl.default1();
        impl.default2();

        delayBuffer();
      }
    }
  }

  private static void java9_language_modifications() throws Exception {
    LOGGER.info("These are small language improvements added in Java 9");
    {
      // try-with-resources
      BufferedReader bufferedReader =
          new BufferedReader(new FileReader(File.createTempFile("temp", ".txt")));

      try (bufferedReader) {
        System.out.println("Can Use Final or Effectively Final in Try with Resources");
      } finally {
        System.out.println("In finally block");
      }

      // diamond operator extension
      abstract class DemoClass<T> {
        abstract T add(T x, T y);
      }

      DemoClass<Integer> summer =
          new DemoClass<>() {
            Integer add(Integer x, Integer y) {
              return x + y;
            }
          };
      Integer sum = summer.add(13, 42);
      System.out.println("sum = " + sum);
    }

    delayBuffer();
  }

  private static void lambdas(final int java) throws Exception {
    if (java == 8) {
      LOGGER.info(
          "Java 8 :: The addition of functional programming constructs to its object-oriented root. "
              + "A lambda expression is a block of code that you can pass around so it can be executed "
              + "later, once or multiple times. You can supply a lambda expression whenever an object of an "
              + "interface with a single abstract method is expected (functional interface)");
      delayBuffer();

      LOGGER.info("Java 8 :: Lambda Expression Syntax");
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
        final Thread A =
            new Thread(() -> System.out.println("I was printed in SimpleThread::run()"));
        A.start();
        A.join();

        delayBuffer();
      }

      LOGGER.info("Java 8 :: Method References");
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
  }

  private static void not_predicate(final int java) throws Exception {
    if (java == 11) {
      LOGGER.info("Java 11 :: The Not Predicated");
      {
        List<String> strings = Arrays.asList(" ", "  ", "Hello");
        List<String> withoutEmptyStrings =
            strings.stream().filter(Predicate.not(String::isEmpty)).collect(Collectors.toList());
        System.out.println("withoutEmptyStrings = " + withoutEmptyStrings);
        delayBuffer();
      }
    }
  }

  private static void npe(final int java) throws Exception {
    if (java == 14) {
      LOGGER.info("Java 14 :: Improved NPEs");
      {
        int[] arr = null;
        try {
          arr[0] = 1;
        } catch (final NullPointerException e) {
          LOGGER.info(e.getMessage());
        }
      }
    }
  }

  private static void number(final int java) throws Exception {
    if (java == 12) {
      LOGGER.info("Java 12 :: Compact Number Formatting");
      {
        NumberFormat longFormat =
            NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        longFormat.setMaximumFractionDigits(2);

        System.out.println("shortFormat = " + longFormat.format(1313));

        delayBuffer();
      }
    } else if (java == 17) {
      LOGGER.info("Java 17 :: Pseudo-Random Number Generators");
      {
        System.out.println("All possible Generator IMPLs:");

        RandomGeneratorFactory.all()
            .map(fac -> fac.group() + " : " + fac.name())
            .sorted()
            .forEach(System.out::println);

        System.out.println();

        RandomGeneratorFactory.of("Xoshiro256PlusPlus")
            .create()
            .ints(5, 0, 100)
            .forEach(System.out::println);

        delayBuffer();
      }
    }
  }

  private static void optional(final int java) throws Exception {
    if (java == 9) {
      LOGGER.info("Java 9 :: Improvements");
      {
        Optional<String> value = Optional.empty();

        // or()
        Optional<String> defaultValue = Optional.of("DEFAULT");
        Optional<String> result = value.or(() -> defaultValue);
        System.out.println("result = " + result);

        // ifPresentOrElse()
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

        // when
        value.ifPresentOrElse(
            v -> successCounter.incrementAndGet(), onEmptyOptionalCounter::incrementAndGet);

        System.out.println("successCounter = " + successCounter);
        System.out.println("onEmptyOptionalCounter = " + onEmptyOptionalCounter);

        delayBuffer();
      }
    } else if (java == 10) {
      LOGGER.info("Java 10 :: orElseThrow");
      List<Integer> odds = List.of(1, 3, 5);
      try {
        odds.stream().filter(i -> i % 2 == 0).findFirst().orElseThrow();
      } catch (final NoSuchElementException e) {
        LOGGER.info("Didn't find any value from teh Optional. It is a NoSuchElementException");
      }
    }
  }

  private static void records(final int java) throws Exception {
    if (java == 14) {
      LOGGER.info(
          "Java 14 :: Records were introduced to reduce repetitive boilerplate code in data model POJOs");

      record Java(String version, LocalDate releaseDate) {
        public Java {
          if (releaseDate.isBefore(LocalDate.of(1996, 1, 23))) {
            throw new IllegalArgumentException("Java was first release on 23rd Jan '96");
          }
        }
      }
      ;

      Java java1 = new Java("JDK 1.0 (Oak)", LocalDate.of(1996, 1, 23));

      System.out.println("java1.version = " + java1.version);
      System.out.println("java1.releaseDate = " + java1.releaseDate);

      delayBuffer();
    } else if (java == 16) {
      LOGGER.info("Java 16 :: Incremental Changes to Records");
      {
        record Java(String version, LocalDate releaseDate) {}

        // defining records as class members of inner classes wasn't possible earlier
        class Outer {
          class Inner {
            Java java2 = new Java("J2SE 1.2 (Playground)", LocalDate.of(1998, 12, 13));
          }
        }

        delayBuffer();
      }
    } else if (java == 19) {
      LOGGER.info("Java 19 :: Record Patterns (Preview)");
      {
        System.out.println(
            """
                Record Patterns were introduced as a preview feature in Java 19.
                They allow for destructuring record values in pattern matching contexts.

                To use this feature, you needed to enable preview features:
                javac --enable-preview --source 19 ...
                java --enable-preview ...

                Example (when preview enabled):
                record Point(int x, int y) {}
                record Rectangle(Point upperLeft, Point lowerRight) {}

                // Pattern matching in if statement
                if (obj instanceof Rectangle(Point(int x1, int y1), Point(int x2, int y2))) {
                    int width = x2 - x1;
                    int height = y2 - y1;
                }
                """);

        delayBuffer();
      }
    } else if (java == 20) {
      LOGGER.info("Java 20 :: Record Patterns (Second Preview)");
      {
        System.out.println(
            """
                Record Patterns continued as a preview feature in Java 20 with some refinements.
                The main enhancement was better support for type inference and generic records.

                Example (when preview enabled):
                record Box<T>(T value) {}

                if (obj instanceof Box(String s)) {  // Type inference for generic record pattern
                    System.out.println(s.toLowerCase());
                }
                """);

        delayBuffer();
      }
    } else if (java == 21) {
      LOGGER.info("Java 21 :: Record Patterns (Standard)");
      {
        System.out.println(
            """
                Record Patterns became a standard feature in Java 21 after being previewed in Java 19-20.
                They allow for powerful pattern matching and destructuring of record values.

                Example:
                record Point(int x, int y) {}
                record Rectangle(Point upperLeft, Point lowerRight) {}

                // Pattern matching in if statement
                if (obj instanceof Rectangle(Point(var x1, var y1), Point(var x2, var y2))) {
                    int width = x2 - x1;
                    int height = y2 - y1;
                }

                // Pattern matching in switch
                return switch (obj) {
                    case Rectangle(Point(var x1, var y1), Point(var x2, var y2))
                        when x1 < x2 && y1 < y2 -> "Valid rectangle";
                    case Rectangle r -> "Invalid rectangle: " + r;
                    default -> "Not a rectangle";
                };
                """);

        delayBuffer();
      }
    }
  }

  private static void streams(final int java) throws Exception {
    if (java == 8) {
      LOGGER.info(
          "Java 8 :: Streams are abstract constructs used for processing sequence of elements. It allows you to "
              + "perform aggregate operations, use intermediary pipelines, introduce parallelism, etc. "
              + "You can connect streams to each other following principles of the Decorator Pattern");
      delayBuffer();

      LOGGER.info("Java 8 :: Creation of Streams");
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

      LOGGER.info("Java 8 :: Iteration -> Stream");
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

      LOGGER.info("Java 8 :: Interesting Operations on Streams");
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
            "\n# of distinct numbers :: "
                + Arrays.stream(randomRepeatedNumbers).distinct().count());

        // sort
        System.out.print("Sorted Distinct Values :: ");
        Arrays.stream(randomRepeatedNumbers)
            .sorted()
            .distinct()
            .forEach(value -> System.out.print(value + "\t"));
        // reduction using a starter value and an accumulator function
        Stream<Integer> aStream = Stream.of(1, 2, 3);
        System.out.println(
            "\nReduction of 5 and sum of all in the stream :: "
                + aStream.reduce(5, (a, b) -> a + b));

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

      LOGGER.info("Java 8 :: Collectors");
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
    } else if (java == 9) {
      LOGGER.info("Java 9 :: New Methods");
      {
        // new dropWhile method
        Stream<Integer> stream = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list = stream.dropWhile(n -> (n / 4 == 1)).collect(Collectors.toList());
        System.out.println("list = " + list.size());

        // Predicates in iterate method
        IntStream.iterate(1, i -> i < 5, i -> i + 1).forEach(System.out::print);

        // Optionals can now be created into streams - this means it can be empty
        Stream<Integer> s = Optional.of(1).stream();

        delayBuffer();
      }
    } else if (java == 16) {
      LOGGER.info("Java 16 :: Stream.toList alternate to Collectors");
      {
        List<String> strings = List.of("one", "two", "three");
        List<String> usingToList = strings.stream().map(s -> s.substring(1)).toList();

        System.out.println("usingToList = " + usingToList);

        delayBuffer();
      }
    } else if (java == 22 || java == 23 || java == 24) {
      LOGGER.info("Java 24 :: Stream Gatherers (Final)");
      System.out.println(
          """
              Stream Gatherers are finalized in Java 24!\n" +
              "They allow you to define custom intermediate operations in stream pipelines, such as windowing and folding, using the gather() method and Gatherers utility class.\n" +
              "\n" +
              "Example:\n" +
              "List<String> words = List.of(\"the\", \"be\", \"two\", \"of\", \"and\", \"a\", \"in\", \"that\");\n" +
              "List<List<String>> fixedWindows = words.stream()\n" +
              "    .gather(Gatherers.windowFixed(5))\n" +
              "    .toList();\n" +
              "System.out.println(fixedWindows); // [[the, be, two, of, and], [a, in, that]]\n" +
              "\n" +
              "This feature is now standard and does not require preview flags!\n"
              """);
      List<String> words = List.of("the", "be", "two", "of", "and", "a", "in", "that");
      List<List<String>> fixedWindows = words.stream().gather(Gatherers.windowFixed(5)).toList();
      System.out.println(fixedWindows); // [[the, be, two, of, and], [a, in, that]]
      delayBuffer();
    }
  }

  private static void string(final int java) throws Exception {
    if (java == 11) {
      LOGGER.info(" Java 11 :: New String Methods");
      {
        System.out.println("\" \".isBlank() = " + " ".isBlank());

        System.out.println();
        String multi =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"
                + " Vestibulum a tortor at velit semper dapibus.\n"
                + "Fusce molestie ante diam, non laoreet nisi tempus eu.\n"
                + "Aliquam vel mi in eros bibendum venenatis sed in nisl.\n"
                + "Vestibulum sapien lectus, luctus aliquet tincidunt eget, cursus quis sapien.\n";
        System.out.println(
            "Number of Lines = " + multi.lines().collect(Collectors.toList()).size());

        System.out.println();
        System.out.println("strip() is unicode aware, trim() wasn't");
        String random = "         Random        ";
        System.out.println("random.strip() = " + random.strip());
        System.out.println("random.stripLeading() = " + random.stripLeading());
        System.out.println("random.stripTrailing() = " + random.stripTrailing());

        System.out.println();
        String magic = "magic".repeat(5);
        System.out.println("magic x5 = " + magic);

        delayBuffer();
      }
    } else if (java == 12) {
      LOGGER.info(" Java 11 :: New String Methods");
      {
        String s = "Hello World!\nThis is Java 12.";
        s = s.indent(7);
        System.out.println("with 7 ident = " + s);

        delayBuffer();
      }
    } else if (java == 18) {
      LOGGER.info("Java 18 :: UTF-8 by Default");
      {
        System.out.println(
            """
                Java 18 makes UTF-8 the default charset for APIs that previously used the platform's default charset.
                This means that file.encoding system property now defaults to UTF-8 on all platforms.

                Benefits:
                - Consistent behavior across all platforms
                - Better handling of international text
                - Reduced encoding/decoding issues
                - Improved portability of applications

                Example APIs affected:
                - new String(byte[] bytes)
                - String.getBytes()
                - new FileReader(File file)
                - new FileWriter(File file)
                - new InputStreamReader(InputStream in)
                - new OutputStreamWriter(OutputStream out)
                - Formatter
                - Scanner
                """);

        // Example showing UTF-8 is now default
        String text = "Hello, 世界!"; // Contains both ASCII and Unicode characters
        byte[] bytes = text.getBytes(); // No charset specified, uses UTF-8
        String decoded = new String(bytes); // No charset specified, uses UTF-8
        System.out.println("Original: " + text);
        System.out.println("Decoded: " + decoded);
        System.out.println("Are equal: " + text.equals(decoded));

        delayBuffer();
      }
    } else if (java == 21 || java == 22) {
      LOGGER.info("Java 22 :: String Templates (Second Preview)");
      System.out.println(
          "String Templates enter their second preview in Java 22. They provide a more readable way to embed expressions inside string literals, using template processors like STR.\n"
              + "\n"
              + "Example (requires --enable-preview):\n"
              + "String name = \"world\";\n"
              + "String message = STR.\"Hello {name}!\";\n"
              + "System.out.println(message); // Hello world!\n"
              + "\n"
              + "// Multi-line with expressions\n"
              + "int x = 10, y = 20;\n"
              + "String result = STR.\"\"\"\n"
              + "    The sum of \\{x} and \\{y}\n"
              + "    is \\{x + y}\n"
              + "    \"\"\";\n"
              + "System.out.println(result);\n"
              + "\n"
              + "This feature requires the preview flag to run.\n");
      // Uncomment the following block and run with --enable-preview on JDK 22+ to see String
      // Templates in action:
      /*
      String name = "world";
      String message = STR."Hello {name}!";
      System.out.println(message); // Hello world!

      int x = 10, y = 20;
      String result = STR."""
          The sum of \{x} and \{y}
          is \{x + y}
          """;
      System.out.println(result);
      */
      delayBuffer();
    }
  }

  private static void switch_expression(final int java) throws Exception {
    if (java == 13) {
      LOGGER.info("Java 13 :: Switch Expressions");
      {
        String day = "FRIDAY";

        // Old Style
        boolean isTodayHoliday;
        switch (day) {
          case "MONDAY":
          case "TUESDAY":
          case "WEDNESDAY":
          case "THURSDAY":
          case "FRIDAY":
            isTodayHoliday = false;
            break;
          case "SATURDAY":
          case "SUNDAY":
            isTodayHoliday = true;
            break;
          default:
            System.out.println("I don't know this day=" + day);
        }

        // new style with ->, break goes away, fall-through goes away
        isTodayHoliday =
            switch (day) {
              case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
              case "SATURDAY", "SUNDAY" -> true;
              default -> throw new IllegalArgumentException("I don't know this day=" + day);
            };

        System.out.println("isTodayHoliday = " + isTodayHoliday);

        delayBuffer();
      }
    } else if (java == 18) {
      LOGGER.info("Java 18 :: Pattern Matching for Switch (Second Preview)");
      {
        System.out.println(
            """
                Pattern Matching for switch was available as a preview feature in Java 18.
                To use this feature, you needed to enable preview features:

                javac --enable-preview --source 18 ...
                java --enable-preview ...

                The feature allows you to use patterns in case labels, making switch
                more powerful for object-oriented pattern matching:

                Example (when preview enabled):
                switch (obj) {
                    case String s -> s.toLowerCase();
                    case Integer i -> String.valueOf(i.doubleValue());
                    case null -> "null";
                    default -> obj.toString();
                }

                This feature became standard in Java 21.
                """);

        delayBuffer();
      }
    } else if (java == 21) {
      LOGGER.info("Java 21 :: Pattern Matching for Switch (Standard)");
      {
        System.out.println(
            """
                Pattern Matching for switch became a standard feature in Java 21.
                It allows for powerful pattern matching in switch expressions and statements.

                Example:
                Object obj = // ...
                String formatted = switch (obj) {
                    case String s -> s.toLowerCase();
                    case Integer i -> String.valueOf(i.doubleValue());
                    case Long l -> String.format("Long: %d", l);
                    case null -> "null";
                    default -> obj.toString();
                };

                // With guards
                int result = switch (obj) {
                    case String s when s.length() > 5 -> s.length();
                    case String s -> -1;
                    case Integer i when i > 0 -> i;
                    case Integer i -> -i;
                    default -> 0;
                };
                """);

        delayBuffer();
      }
    }
  }

  private static void teeing(final int java) throws Exception {
    if (java == 12) {
      LOGGER.info(
          "Java 12 :: Teeing Collector - It is a composite of two downstream collectors. "
              + "Every element is processed by both downstream collectors. Then their results are passed to the merge "
              + "function and transformed into the final result.");
      {
        double means =
            Stream.of(1, 2, 3, 5, 7, 11)
                .collect(
                    Collectors.teeing(
                        Collectors.summingDouble(i -> i), // downstream 1
                        Collectors.counting(), // downstream 2
                        (sum, count) -> sum / count)); // merge function

        System.out.println("means = " + means);
        delayBuffer();
      }
    }
  }

  private static void text_blocks(final int java) throws Exception {
    if (java == 15) {
      LOGGER.info("Java 15 :: Text Blocks brings multi-line string support without line breaks");
      {
        String beforeJava15 =
            "<html>\n"
                + "   <body>\n"
                + "      <p>Hello, World</p>\n"
                + "   </body>\n"
                + "</html>\n";

        String java15 =
            """
                  <html>
                      <body>
                          <p>Hello, World</p>
                      </body>
                  </html>
                  """;

        System.out.println("java15 text blocks = " + java15);

        delayBuffer();
      }
    }
  }

  private static void var(final int java) throws Exception {
    if (java == 10) {
      LOGGER.info(
          "Java 10 :: Local Variable Type Interference. Can be used only in the following case:"
              + "1. Local Variable with initializer\n"
              + "2. Indexes of enhanced for loop or indexes\n"
              + "3. Local declared in for loop");
      {
        var message = "Hello there! General Kenobi!";
        System.out.println("message.getClass() = " + message.getClass());

        var didYouKnow = "var is not a keyword for passivity reasons, which means";

        System.out.println(didYouKnow + " var var = \"var\" is valid");
        var var = "var";

        // More valid ways to use var
        List<Integer> numbers = List.of(1, 2, 3);
        for (var number : numbers) {
          System.out.print(number + " ");
        }
        for (var i = 0; i < numbers.size(); i++) {
          System.out.print(numbers.get(i) + " ");
        }
        delayBuffer();
      }
    } else if (java == 11) {
      LOGGER.info(
          "Java 11 :: Local-Variable Syntax for Lambda Params. "
              + "This allows us to use modifiers on local variables. Such as NonNull, etc.");
      {
        List<String> strings = Arrays.asList("one", "two");
        String result =
            strings.stream()
                .map((@NonNull var x) -> x.toLowerCase())
                .collect(Collectors.joining(", "));
        System.out.println("result = " + result);
      }

      delayBuffer();
    }
  }

  private static void simple_web_server(final int java) throws Exception {
    if (java == 18) {
      LOGGER.info(
          "Java 18 :: Simple Web Server - A command-line tool to start a minimal web server that serves static files");
      {
        System.out.println(
            """
                The Simple Web Server can be started using the 'jwebserver' command:
                $ jwebserver
                listening on port 8000

                Some useful flags:
                -p <port>        // Set port number
                -d <directory>   // Set root directory
                -o <output>      // Set output format
                -b <bind>        // Set bind address
                -h, --help       // Show help message

                This feature provides an easy way to serve static files during development
                or for simple file-sharing scenarios.
                """);

        delayBuffer();
      }
    }
  }

  private static void virtual_threads(final int java) throws Exception {
    if (java == 19) {
      LOGGER.info("Java 19 :: Virtual Threads (Preview)");
      {
        System.out.println(
            """
                Virtual Threads were introduced as a preview feature in Java 19.
                They are lightweight threads that dramatically reduce the effort
                of writing, maintaining, and observing high-throughput concurrent applications.

                Example (when preview enabled):
                // Creating a virtual thread
                Thread.startVirtualThread(() -> {
                    System.out.println("Running in virtual thread");
                });

                // Using virtual thread factory
                try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                    IntStream.range(0, 10_000).forEach(i -> {
                        executor.submit(() -> {
                            Thread.sleep(Duration.ofSeconds(1));
                            return i;
                        });
                    });
                }
                """);

        delayBuffer();
      }
    } else if (java == 20) {
      LOGGER.info("Java 20 :: Virtual Threads (Second Preview)");
      {
        System.out.println(
            """
                Virtual Threads continued as a preview feature in Java 20 with refinements.
                The API was stabilized and performance improvements were made.

                Key benefits of virtual threads:
                - Dramatically improve application throughput
                - Simplify concurrent programming
                - Enable writing server applications in a simple thread-per-request style
                - Scale with near-zero overhead

                They are particularly useful for:
                - Server applications
                - Request handling
                - Task coordination
                """);

        delayBuffer();
      }
    } else if (java == 21) {
      LOGGER.info("Java 21 :: Virtual Threads (Standard)");
      {
        System.out.println(
            """
                Virtual Threads became a standard feature in Java 21.
                They are lightweight threads that make it practical to represent
                each task or unit of work with a dedicated thread.

                Example:
                // Creating a virtual thread
                Thread vThread = Thread.ofVirtual().start(() -> {
                    System.out.println("Running in virtual thread");
                });

                // Using virtual thread factory
                try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                    IntStream.range(0, 10_000).forEach(i -> {
                        executor.submit(() -> {
                            // Each task gets its own virtual thread
                            processRequest(i);
                            return i;
                        });
                    });
                }

                Key features now standard:
                - Lightweight thread implementation
                - Automatic thread pool management
                - Improved debugging and profiling
                - Better integration with existing threading APIs
                - Enhanced monitoring capabilities
                """);

        delayBuffer();
      }
    }
  }

  private static void structured_concurrency(final int java) throws Exception {
    if (java == 19) {
      LOGGER.info("Java 19 :: Structured Concurrency (Preview)");
      {
        System.out.println(
            """
                Structured Concurrency was introduced as a preview feature in Java 19.
                It simplifies multithreaded programming by treating multiple tasks
                running in different threads as a single unit of work.

                Example (when preview enabled):
                try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
                    Future<String> user = scope.fork(() -> findUser());
                    Future<Integer> order = scope.fork(() -> fetchOrder());

                    scope.join();           // Wait for both forks
                    scope.throwIfFailed();  // ... and propagate errors

                    // Here, both forks have succeeded
                    processOrder(user.resultNow(), order.resultNow());
                }
                """);

        delayBuffer();
      }
    } else if (java == 22 || java == 23 || java == 24) {
      LOGGER.info("Java 24 :: Structured Concurrency (Fourth Preview)");
      System.out.println(
          """
                Structured Concurrency enters its fourth preview in Java 24. It continues to simplify concurrent programming by treating related tasks as a single unit of work, improving error handling and cancellation.

                Example (requires --enable-preview):
                try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
                    Future<String> user = scope.fork(() -> findUser());
                    Future<Integer> order = scope.fork(() -> fetchOrder());

                    scope.join();           // Wait for both forks
                    scope.throwIfFailed();  // ... and propagate errors

                    // Here, both forks have succeeded
                    processOrder(user.resultNow(), order.resultNow());
                }

                This feature requires the preview flag to run.
                """);
      // Uncomment the following block and run with --enable-preview on JDK 24+ to see Structured
      // Concurrency in action:
      /*
      try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
          Future<String> user = scope.fork(() -> "user-data");
          Future<Integer> order = scope.fork(() -> 42);

          scope.join();
          scope.throwIfFailed();

          System.out.println("User: " + user.resultNow());
          System.out.println("Order: " + order.resultNow());
      }
      */
      delayBuffer();
    }
  }

  private static void scoped_values(final int java) throws Exception {
    if (java == 20) {
      LOGGER.info("Java 20 :: Scoped Values (Preview)");
      {
        System.out.println(
            """
                Scoped Values were introduced as a preview feature in Java 20.
                They provide a way to share immutable data within and across threads,
                offering a safer alternative to ThreadLocal.

                Key benefits:
                - Immutable by design
                - Bound to a specific scope
                - Automatically cleaned up
                - Thread-safe

                Example (when preview enabled):
                final ScopedValue<String> TRANSACTION_ID = ScopedValue.newInstance();

                void processRequest() {
                    ScopedValue.where(TRANSACTION_ID, generateTransactionId())
                        .run(() -> {
                            // Code here can access TRANSACTION_ID
                            String id = TRANSACTION_ID.get();
                            // Value is available even in child threads
                            processSubTask();
                        });
                    // Value is not available here
                }
                """);

        delayBuffer();
      }
    } else if (java == 22 || java == 23 || java == 24) {
      LOGGER.info("Java 24 :: Scoped Values (Fourth Preview)");
      System.out.println(
          """
                Scoped Values enter their fourth preview in Java 24. They provide a safer, immutable alternative to ThreadLocal for sharing data within and across threads.

                Example (requires --enable-preview):
                final ScopedValue<String> SESSION_ID = ScopedValue.newInstance();

                void processRequest(String sessionId) {
                    ScopedValue.where(SESSION_ID, sessionId)
                        .run(() -> {
                            // Code here can access SESSION_ID
                            String id = SESSION_ID.get();
                            // Value is available even in child threads
                            processSubTask();
                        });
                    // Value is not available here
                }

                This feature requires the preview flag to run.
                """);
      // Uncomment the following block and run with --enable-preview on JDK 24+ to see Scoped Values
      // in action:
      /*
      final ScopedValue<String> SESSION_ID = ScopedValue.newInstance();

      void processRequest(String sessionId) {
          ScopedValue.where(SESSION_ID, sessionId)
              .run(() -> {
                  System.out.println("Session in scope: " + SESSION_ID.get());
              });
          // SESSION_ID is not available here
      }
      processRequest("session-42");
      */
      delayBuffer();
    }
  }

  private static void unnamed_patterns(final int java) throws Exception {
    if (java == 21) {
      LOGGER.info("Java 21 :: Unnamed Patterns and Variables (Preview)");
      {
        System.out.println(
            """
                Unnamed Patterns and Variables were introduced as a preview feature in Java 21.
                They allow for the use of unnamed patterns and variables in pattern matching contexts.

                Example (when preview enabled):
                if (obj instanceof String s) {
                    System.out.println(\"It's a string: \" + s);
                }
                """);

        delayBuffer();
      }
    } else if (java == 22) {
      LOGGER.info("Java 22 :: Unnamed Variables & Patterns (Final)");
      {
        System.out.println(
            """
                Unnamed variables and patterns are now a permanent feature in Java 22.
                Use '_' as a variable or pattern name when the value is unused.
                Examples:
                - Catch block: catch (Exception _) { ... }
                - Lambda: map.computeIfAbsent(key, _ -> new ArrayList<>())
                - For-each: for (var _ : list) { ... }
                - Record pattern: if (obj instanceof Point(int x, _)) { ... }
                """);

        // Demo: catch block
        try {
          Integer.parseInt("not_a_number");
        } catch (NumberFormatException _) {
          System.out.println("Caught NumberFormatException with unnamed variable");
        }

        // Demo: lambda parameter
        Map<String, List<String>> map = Map.of();
        // The following is just a syntax example, not executable as map is immutable and empty
        System.out.println(
            "Lambda with unnamed parameter: map.computeIfAbsent(key, _ -> new ArrayList<>())");

        // Demo: for-each loop
        List<String> list = List.of("a", "b", "c");
        int count = 0;
        for (var _ : list) {
          count++;
        }
        System.out.println("Counted elements using unnamed variable in for-each: " + count);

        // Demo: record pattern
        record Point(int x, int y) {}
        Object obj = new Point(42, 99);
        if (obj instanceof Point(int x, _)) {
          System.out.println(
              "Matched Point with x = " + x + ", y is ignored using unnamed pattern");
        }

        delayBuffer();
      }
    } else if (java == 24) {
      LOGGER.info("Java 24 :: Unnamed Variables & Patterns (Final)");
      System.out.println(
          """
                Unnamed variables and patterns are a permanent feature in Java 24.
                Use '_' as a variable or pattern name when the value is unused.
                Examples:
                - Catch block: catch (Exception _) { ... }
                - Lambda: map.computeIfAbsent(key, _ -> new ArrayList<>())
                - For-each: for (var _ : list) { ... }
                - Record pattern: if (obj instanceof Point(int x, _)) { ... }
                """);
      // Demo: catch block
      try {
        Integer.parseInt("not_a_number");
      } catch (NumberFormatException _) {
        System.out.println("Caught NumberFormatException with unnamed variable");
      }
      // Demo: for-each loop
      List<String> list = List.of("a", "b", "c");
      int count = 0;
      for (var _ : list) {
        count++;
      }
      System.out.println("Counted elements using unnamed variable in for-each: " + count);
      // Demo: record pattern
      record Point(int x, int y) {}
      Object obj = new Point(42, 99);
      if (obj instanceof Point(int x, _)) {
        System.out.println("Matched Point with x = " + x + ", y is ignored using unnamed pattern");
      }
      delayBuffer();
    }
  }

  /**
   * Java 22 :: Statements Before super(...) (Preview) Demonstrates the ability to have statements
   * before an explicit constructor invocation.
   */
  private static void language_modifications(final int java) throws Exception {
    if (java == 22) {
      LOGGER.info("Java 22 :: Statements Before super(...) (Preview)");
      System.out.println(
          """
              In Java 22 (preview), you can now write statements before calling super() or this() in a constructor,
              as long as those statements do not reference the instance being created (no 'this' or instance fields).
              This allows for argument validation, preparation, and sharing before delegating to the superclass constructor.

              Example (requires --enable-preview):
              class Rectangle {
                  int width, height;
                  Rectangle(int width, int height) {
                      this.width = width;
                      this.height = height;
                  }
              }
              class Square extends Rectangle {
                  Square(int area) {
                      if (area < 0) throw new IllegalArgumentException();
                      int side = (int)Math.sqrt(area);
                      super(side, side);
                  }
              }
              // new Square(49); // Will print order of execution
              """);
      delayBuffer();
    } else if (java == 23 || java == 24) {
      LOGGER.info("Java 24 :: Flexible Constructor Bodies (Third Preview)");
      System.out.println(
          """
                Flexible Constructor Bodies are in their third preview in Java 24. This feature allows statements that do not reference the instance being created to appear before an explicit constructor invocation (super() or this()).

                Example (requires --enable-preview):
                public class MyClass {
                    private int value;
                    public MyClass(int value) {
                        int preInitialization = value * 3;  // Non-referential statement
                        this.value = preInitialization;      // Initialization
                    }
                }

                This feature requires the preview flag to run.
                """);
      // Uncomment the following block and run with --enable-preview on JDK 24+ to see Flexible
      // Constructor Bodies in action:
      /*
      public class MyClass {
          private int value;
          public MyClass(int value) {
              int preInitialization = value * 3;  // Non-referential statement
              this.value = preInitialization;      // Initialization
          }
      }
      var myClass = new MyClass(42);
      System.out.println(myClass.value);
      */
      delayBuffer();
    }
  }

  /**
   * Java 23 :: Primitive Types in Patterns, instanceof, and switch (Preview) Demonstrates pattern
   * matching with primitive types in switch and instanceof.
   */
  private static void primitive_patterns(final int java) throws Exception {
    if (java == 23 || java == 24) {
      LOGGER.info(
          "Java 24 :: Primitive Types in Patterns, instanceof, and switch (Second Preview)");
      System.out.println(
          """
                Java 24 allows pattern matching with primitive types in switch and instanceof statements (second preview).

                Example (requires --enable-preview):
                Object obj = 42;
                switch (obj) {
                    case Integer i -> System.out.println("Integer: " + i);
                    case Long l    -> System.out.println("Long: " + l);
                    default        -> System.out.println("Other: " + obj);
                }

                This feature requires the preview flag to run.
                """);
      // Uncomment the following block and run with --enable-preview on JDK 24+ to see this in
      // action:
      /*
      Object obj = 42;
      switch (obj) {
          case Integer i -> System.out.println("Integer: " + i);
          case Long l    -> System.out.println("Long: " + l);
          default        -> System.out.println("Other: " + obj);
      }
      */
      delayBuffer();
    }
  }

  private static void class_file_api(final int java) throws Exception {
    if (java == 24) {
      LOGGER.info("Java 24 :: Class-File API");
      System.out.println(
          """
                Java 24 introduces the Class-File API (JEP 484), a new standard API for parsing, generating, and transforming Java class files.
                This is an advanced feature for tools and frameworks that need to work with bytecode directly.

                Example usage (not a real demo):
                // Parse a class file
                ClassFile cf = ClassFile.read(Paths.get("MyClass.class"));
                // Inspect methods, fields, attributes, etc.
                for (MethodInfo m : cf.methods()) {
                    System.out.println(m.name());
                }
                // Modify and write back
                cf.write(Paths.get("MyClassModified.class"));

                See JEP 484 for details. This is a low-level, expert feature.
                """);
      delayBuffer();
    }
  }

  private static void vector_api(final int java) throws Exception {
    if (java == 24) {
      LOGGER.info("Java 24 :: Vector API (Incubator)");
      System.out.println(
          """
                Java 24 includes the Vector API (JEP 489, Ninth Incubator), which enables developers to express vector computations that reliably compile at runtime to optimal vector instructions on supported hardware.
                This is an incubator feature and may require special flags to enable.

                Example usage (not a real demo):
                // Vector computation example
                Vector<Integer> va = IntVector.fromArray(IntVector.SPECIES_256, a, 0);
                Vector<Integer> vb = IntVector.fromArray(IntVector.SPECIES_256, b, 0);
                Vector<Integer> vc = va.add(vb);
                vc.intoArray(c, 0);

                See JEP 489 for details. This is a low-level, performance-oriented feature.
                """);
      delayBuffer();
    }
  }

  private static void restrict_jni(final int java) throws Exception {
    if (java == 24) {
      LOGGER.info("Java 24 :: Prepare to Restrict the Use of JNI (JEP 472)");
      System.out.println(
          """
                Java 24 prepares to restrict the use of the Java Native Interface (JNI) to improve security and maintainability.
                This is mostly relevant for library and JVM developers. Most application code is unaffected.

                Summary:
                - Warns about unsafe or discouraged JNI usage
                - Lays groundwork for future restrictions
                - Encourages migration to safer APIs
                """);
      delayBuffer();
    }
  }

  private static void unsafe_warnings(final int java) throws Exception {
    if (java == 24) {
      LOGGER.info("Java 24 :: Warn upon Use of Memory-Access Methods in sun.misc.Unsafe (JEP 498)");
      System.out.println(
          """
                Java 24 adds warnings when using certain memory-access methods in sun.misc.Unsafe, as part of the ongoing effort to encapsulate and eventually remove unsafe APIs.
                This is mostly relevant for low-level libraries and frameworks.

                Summary:
                - Warns at runtime when using unsafe memory-access methods
                - Encourages migration to supported APIs
                - Part of long-term plan to encapsulate sun.misc.Unsafe
                """);
      delayBuffer();
    }
  }

  // =========== Utility =========================================================================

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
