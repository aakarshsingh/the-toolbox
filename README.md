# the-toolbox

A personal, educational Java toolbox and scratchpad for exploring the evolution of Java language and library features, version by version. This project demonstrates, with code and commentary, the most important features added in each Java release from Java 8 through Java 24.

---

## Java Version Feature Highlights

### Java 24 (2025)
- **Stream Gatherers (final):** Custom stream windowing/folding operations, now standard.
- **Scoped Values (Fourth Preview):** Safer, immutable alternative to ThreadLocal (preview).
- **Structured Concurrency (Fourth Preview):** Treat related tasks as a single unit of work (preview).
- **Primitive Types in Patterns, instanceof, and switch (Second Preview):** Pattern matching with primitives in switch/instanceof (preview).
- **Flexible Constructor Bodies (Third Preview):** Statements before super()/this() in constructors (preview).
- **Unnamed Variables & Patterns (final):** Use `_` for unused variables/patterns everywhere.
- **Class-File API:** New standard API for parsing/generating Java class files (advanced, JEP 484).
- **Vector API (Ninth Incubator):** SIMD/vectorized computation for high performance (incubator).
- **Prepare to Restrict the Use of JNI:** Lays groundwork for future JNI restrictions (JEP 472).
- **Warn upon Use of Memory-Access Methods in sun.misc.Unsafe:** Runtime warnings for unsafe memory access (JEP 498).

### Java 23 (2024)
- **Primitive Types in Patterns, instanceof, and switch (Preview):** Pattern matching with primitives in switch and instanceof.
- **Stream Gatherers (Final/Preview):** Powerful new stream operations for windowing, folding, and more.
- **Structured Concurrency (Third Preview):** Simplifies concurrent programming by treating related tasks as a single unit.
- **Scoped Values (Third Preview):** Safer, more flexible alternative to thread-local variables.
- **Flexible Constructor Bodies (Second Preview):** More flexible placement of statements before constructor calls.

### Java 22 (2023)
- **Unnamed Variables & Patterns (Final):** Use '_' for unused variables and patterns in more contexts.
- **Statements Before super(...) (Preview):** Allows statements before constructor delegation.
- **Stream Gatherers (Preview):** Custom intermediate stream operations (windowing, folding, etc.).
- **Structured Concurrency (Second Preview):** Improved concurrent programming model.
- **Scoped Values (Second Preview):** Safer alternative to thread-local variables.
- **String Templates (Second Preview):** More readable string interpolation with template processors.

### Java 21 (2023, LTS)
- **String Templates (Preview):** Readable string interpolation.
- **Sequenced Collections:** New interfaces for collections with encounter order (getFirst, getLast, reversed, etc.).
- **Record Patterns (Standard):** Destructuring records in pattern matching.
- **Pattern Matching for Switch (Standard):** Powerful pattern matching in switch.
- **Virtual Threads (Standard):** Lightweight, scalable threads.
- **Scoped Values (Preview):** Safer alternative to thread-local variables.
- **Unnamed Patterns and Variables (Preview):** Use '_' for unused variables and patterns.

### Java 20 (2023)
- **Record Patterns (Second Preview):** Improved destructuring for records.
- **Pattern Matching for Switch (Fourth Preview):** More powerful switch pattern matching.
- **Scoped Values (Preview):** Safer alternative to thread-local variables.
- **Virtual Threads (Second Preview):** Lightweight, scalable threads.
- **Structured Concurrency (Second Preview):** Improved concurrent programming model.

### Java 19 (2022)
- **Record Patterns (Preview):** Destructuring records in pattern matching.
- **Virtual Threads (Preview):** Lightweight, scalable threads.
- **Structured Concurrency (Preview):** Improved concurrent programming model.
- **Pattern Matching for Switch (Third Preview):** More powerful switch pattern matching.
- **Vector API (Fourth Incubator):** High-performance vector computations for data-parallel operations.

### Java 18 (2022)
- **Simple Web Server:** Minimal HTTP server for static files.
- **Code Snippets in Java API Documentation:** Improved documentation with code examples.
- **UTF-8 by Default:** Consistent default charset across platforms.
- **Pattern Matching for Switch (Second Preview):** More powerful switch pattern matching.
- **Internet-Address Resolution SPI:** Pluggable address resolution.

### Java 17 (2021, LTS)
- **Enhanced Pseudo-Random Number Generators:** New interfaces and implementations for random numbers.
- **Sealed Classes:** Restrict which classes can extend or implement a class/interface.

### Java 16 (2021)
- **Day Period Support:** New time formatting symbols.
- **Stream.toList():** Convenient method to collect streams to lists.
- **Records:** Concise, immutable data carriers.
- **Pattern Matching for instanceof:** Simplifies type checks and casts.

### Java 15 (2020)
- **Text Blocks:** Multi-line string literals.

### Java 14 (2020)
- **Records (Preview):** Concise, immutable data carriers.
- **Helpful NullPointerExceptions:** More informative NPE messages.

### Java 13 (2019)
- **Switch Expressions (Preview):** Switch as an expression with new syntax.

### Java 12 (2019)
- **String Class New Methods:** New string manipulation methods.
- **File.mismatch():** Find the first mismatched byte between files.
- **Teeing Collector:** Combine results of two collectors.
- **Compact Number Formatting:** Locale-aware compact number formatting.

### Java 11 (2018, LTS)
- **HTTP Client:** Modern, async HTTP client API.
- **Local-Variable Syntax for Lambda Parameters:** Use 'var' in lambda parameters.
- **New String Methods:** isBlank, lines, strip, repeat, etc.
- **New File Methods:** Read/write strings to files.
- **Collection to Array:** Convert collections to arrays easily.
- **Not Predicate Method:** Predicate.not for easier negation.

### Java 10 (2018)
- **Local Variable Type Inference:** Use 'var' for local variables.
- **Unmodifiable Collections:** Collectors.toUnmodifiableList/Set/Map.
- **Optional.orElseThrow():** Improved Optional API.

### Java 9 (2017)
- **Collection Factory Methods:** List.of, Set.of, Map.of for immutable collections.
- **Stream API Improvements:** dropWhile, takeWhile, iterate with predicate.
- **Optional Class Enhancements:** or, ifPresentOrElse, stream.
- **Private Interface Methods:** Private methods in interfaces.
- **Language Modifications:** Try-with-resources, diamond operator improvements.

### Java 8 (2014)
- **Streams:** Functional-style operations on collections.
- **Lambdas:** Anonymous functions and closures.
- **Default & Static Methods in Interfaces:** Concrete methods in interfaces.
- **New Date & Time APIs:** Modern, immutable date/time classes.

---

## Feature Evolution Paths

### Streams Evolution (Java 8 → 24)
| Java Version | Streams Feature Added/Changed |
|--------------|------------------------------|
| 8            | Streams API introduced: map, filter, reduce, parallel streams, collectors |
| 9            | `dropWhile`, `takeWhile`, `iterate` with predicate, `Optional.stream()` |
| 10           | `Collectors.toUnmodifiableList/Set/Map` |
| 12           | `Collectors.teeing` |
| 16           | `Stream.toList()` |
| 22 (Preview) | Stream Gatherers (windowing, folding, custom gatherers) |
| 23           | Stream Gatherers finalized (late preview/final) |
| 24           | Stream Gatherers (final, standard) |

### Streams Subway Map
```
Java 8 ──▶ Java 9 ──▶ Java 10 ──▶ Java 12 ──▶ Java 16 ──▶ Java 24 [final]
  │         │           │           │           │           │
  │         │           │           │           │           │
  └─ Streams API   ── dropWhile,   ── toUnmod   ── teeing   ── toList   ── Gatherers (final)
     introduced        takeWhile      Collectors   Collector   method      (windowing, folding)
```

### Pattern Matching & instanceof Evolution
| Java Version | Pattern Matching Feature Added/Changed |
|--------------|---------------------------------------|
| 14           | Pattern matching for `instanceof` (preview) |
| 16           | Pattern matching for `instanceof` (standard) |
| 18–21        | Pattern matching for `switch` (preview/standard) |
| 23–24        | Primitive types in patterns, instanceof, and switch (preview) |

### Pattern Matching Subway Map
```
Java 14 ──▶ Java 16 ──▶ Java 18-21 [grouped] ──▶ Java 23 [preview] ──▶ Java 24 [preview]
  │         │           │                        │                    │
  │         │           │                        │                    │
  └─ instanceof   ── instanceof   ── switch pattern matching   ── Primitive types in patterns
     patterns         with var         (preview→standard)         (preview, then 2nd preview)
```

### Records Evolution
| Java Version | Records Feature Added/Changed |
|--------------|------------------------------|
| 14           | Records introduced (preview) |
| 16           | Records: inner class support, refinements |
| 19–20        | Record patterns (preview) |
| 21           | Record patterns (standard) |

### Records Subway Map
```
Java 14 ──▶ Java 16 ──▶ Java 19-20 [preview] ──▶ Java 21 [standard]
  │         │           │                        │
  │         │           │                        │
  └─ Records   ── Inner records   ── Record patterns (preview)   ── Record patterns (standard)
     (preview)      as class mem      (destructuring, guards)      (fully standard)
```

### Collections Evolution
| Java Version | Collections Feature Added/Changed |
|--------------|----------------------------------|
| 9            | Factory methods for List, Set, Map |
| 10           | Unmodifiable collections via `copyOf` and collectors |
| 11           | `toArray` method improvements |
| 21           | Sequenced collections (new interfaces) |

### Collections Subway Map
```
Java 9 ──▶ Java 10 ──▶ Java 11 ──▶ Java 21
  │         │           │           │
  │         │           │           │
  └─ Factory   ── Unmod   ── toArray   ── Sequenced
     methods      copy        method       Collections
```

### Concurrency Evolution
| Java Version | Concurrency Feature Added/Changed |
|--------------|----------------------------------|
| 19           | Virtual threads (preview), structured concurrency (preview) |
| 20           | Virtual threads (2nd preview), structured concurrency (2nd preview), scoped values (preview) |
| 21           | Virtual threads (standard), structured concurrency (improved), scoped values (preview) |
| 22–24        | Structured concurrency (2nd–4th preview), scoped values (2nd–4th preview) |

### Concurrency Subway Map
```
Java 19 [preview] ──▶ Java 20-21 [preview/standard] ──▶ Java 22-24 [preview/final]
  │                        │                              │
  │                        │                              │
  └─ Structured   ── Virtual threads,   ── Structured concurrency, Scoped Values
     concurrency      Scoped Values         (4th preview), Scoped Values (4th preview)
     (preview)        (preview→standard)   (finalized in Java 24)
```

### String Handling Evolution
| Java Version | String Feature Added/Changed |
|--------------|-----------------------------|
| 11           | New string methods: `isBlank`, `lines`, `strip`, `repeat` |
| 12           | `indent` method |
| 15           | Text blocks (multi-line strings) |
| 18           | UTF-8 by default |
| 21–23        | String templates (preview) |

### String Handling Subway Map
```
Java 11 ──▶ Java 12 ──▶ Java 18 ──▶ Java 21-22 [preview] ──▶ Java 24
  │         │           │           │                        │
  │         │           │           │                        │
  └─ New     ── indent   ── UTF-8    ── String templates      ── Unnamed variables & patterns
     methods      method     default      (preview)                (final)
```

### New Java 24 Features Subway Map
```
Java 24
  │
  ├─ Class-File API: Standard API for parsing/generating class files
  ├─ Vector API: Incubator for vectorized computations
  ├─ Restrict JNI: Prepares to restrict Java Native Interface usage
  └─ Unsafe Warnings: Warns on use of sun.misc.Unsafe memory-access methods
```

---

## Java Feature JEP Reference Table

| Java Version | Feature Name                                              | JEP Link                                              |
|--------------|----------------------------------------------------------|-------------------------------------------------------|
| **24**       | Stream Gatherers (final)                                 | [JEP 485](https://openjdk.org/jeps/485)              |
|              | Scoped Values (4th preview)                              | [JEP 487](https://openjdk.org/jeps/487)              |
|              | Structured Concurrency (4th preview)                     | [JEP 499](https://openjdk.org/jeps/499)              |
|              | Primitive Types in Patterns, instanceof, and switch      | [JEP 488](https://openjdk.org/jeps/488)              |
|              | Flexible Constructor Bodies (3rd preview)                | [JEP 492](https://openjdk.org/jeps/492)              |
|              | Unnamed Variables & Patterns (final)                     | [JEP 494](https://openjdk.org/jeps/494)              |
|              | Class-File API                                           | [JEP 484](https://openjdk.org/jeps/484)              |
|              | Vector API (incubator)                                   | [JEP 489](https://openjdk.org/jeps/489)              |
|              | Prepare to Restrict the Use of JNI                       | [JEP 472](https://openjdk.org/jeps/472)              |
|              | Warn upon Use of Memory-Access Methods in sun.misc.Unsafe| [JEP 498](https://openjdk.org/jeps/498)              |
| **23**       | Primitive Types in Patterns, instanceof, and switch      | [JEP 443](https://openjdk.org/jeps/443)              |
|              | Stream Gatherers (preview/final)                         | [JEP 461](https://openjdk.org/jeps/461)              |
|              | Structured Concurrency (3rd preview)                     | [JEP 453](https://openjdk.org/jeps/453)              |
|              | Scoped Values (3rd preview)                              | [JEP 446](https://openjdk.org/jeps/446)              |
|              | Flexible Constructor Bodies (2nd preview)                | [JEP 447](https://openjdk.org/jeps/447)              |
| **22**       | Unnamed Variables & Patterns (final)                     | [JEP 443](https://openjdk.org/jeps/443)              |
|              | Statements Before super(...) (preview)                   | [JEP 447](https://openjdk.org/jeps/447)              |
|              | Stream Gatherers (preview)                               | [JEP 461](https://openjdk.org/jeps/461)              |
|              | Structured Concurrency (2nd preview)                     | [JEP 453](https://openjdk.org/jeps/453)              |
|              | Scoped Values (2nd preview)                              | [JEP 446](https://openjdk.org/jeps/446)              |
|              | String Templates (2nd preview)                           | [JEP 430](https://openjdk.org/jeps/430)              |
| **21**       | String Templates (preview)                               | [JEP 430](https://openjdk.org/jeps/430)              |
|              | Sequenced Collections                                    | [JEP 431](https://openjdk.org/jeps/431)              |
|              | Record Patterns (standard)                               | [JEP 440](https://openjdk.org/jeps/440)              |
|              | Pattern Matching for Switch (standard)                   | [JEP 441](https://openjdk.org/jeps/441)              |
|              | Virtual Threads (standard)                               | [JEP 444](https://openjdk.org/jeps/444)              |
|              | Scoped Values (preview)                                  | [JEP 446](https://openjdk.org/jeps/446)              |
|              | Unnamed Patterns and Variables (preview)                 | [JEP 443](https://openjdk.org/jeps/443)              |
| **20**       | Record Patterns (2nd preview)                            | [JEP 432](https://openjdk.org/jeps/432)              |
|              | Pattern Matching for Switch (4th preview)                | [JEP 433](https://openjdk.org/jeps/433)              |
|              | Scoped Values (preview)                                  | [JEP 429](https://openjdk.org/jeps/429)              |
|              | Virtual Threads (2nd preview)                            | [JEP 436](https://openjdk.org/jeps/436)              |
|              | Structured Concurrency (2nd preview)                     | [JEP 437](https://openjdk.org/jeps/437)              |
| **19**       | Record Patterns (preview)                                | [JEP 405](https://openjdk.org/jeps/405)              |
|              | Virtual Threads (preview)                                | [JEP 425](https://openjdk.org/jeps/425)              |
|              | Structured Concurrency (preview)                         | [JEP 428](https://openjdk.org/jeps/428)              |
|              | Pattern Matching for Switch (3rd preview)                | [JEP 427](https://openjdk.org/jeps/427)              |
|              | Vector API (4th incubator)                               | [JEP 426](https://openjdk.org/jeps/426)              |
| **18**       | Simple Web Server                                        | [JEP 408](https://openjdk.org/jeps/408)              |
|              | UTF-8 by Default                                         | [JEP 400](https://openjdk.org/jeps/400)              |
|              | Pattern Matching for Switch (2nd preview)                | [JEP 420](https://openjdk.org/jeps/420)              |
| **17**       | Sealed Classes                                           | [JEP 409](https://openjdk.org/jeps/409)              |
|              | Enhanced Pseudo-Random Number Generators                 | [JEP 356](https://openjdk.org/jeps/356)              |
| **16**       | Records (standard)                                       | [JEP 395](https://openjdk.org/jeps/395)              |
|              | Pattern Matching for instanceof                          | [JEP 394](https://openjdk.org/jeps/394)              |
|              | Stream.toList()                                          | [JEP 376](https://openjdk.org/jeps/376)              |
|              | Day Period Support                                       | [JEP 378](https://openjdk.org/jeps/378)              |
| **15**       | Text Blocks                                              | [JEP 378](https://openjdk.org/jeps/378)              |
| **14**       | Records (preview)                                        | [JEP 359](https://openjdk.org/jeps/359)              |
|              | Helpful NullPointerExceptions                            | [JEP 358](https://openjdk.org/jeps/358)              |
| **13**       | Switch Expressions (preview)                             | [JEP 354](https://openjdk.org/jeps/354)              |
| **12**       | Compact Number Formatting                                | [JEP 334](https://openjdk.org/jeps/334)              |
|              | File::mismatch                                           | [JEP 353](https://openjdk.org/jeps/353)              |
|              | Teeing Collector                                         | [JEP 350](https://openjdk.org/jeps/350)              |
| **11**       | HTTP Client                                              | [JEP 321](https://openjdk.org/jeps/321)              |
|              | Local-Variable Syntax for Lambda Parameters              | [JEP 323](https://openjdk.org/jeps/323)              |
|              | String Methods (isBlank, lines, strip, repeat)           | [JEP 181](https://openjdk.org/jeps/181)              |
| **10**       | Local Variable Type Inference                            | [JEP 286](https://openjdk.org/jeps/286)              |
|              | Unmodifiable Collections                                 | [JEP 269](https://openjdk.org/jeps/269)              |
| **9**        | Collection Factory Methods                               | [JEP 269](https://openjdk.org/jeps/269)              |
|              | Stream API Improvements                                  | [JEP 266](https://openjdk.org/jeps/266)              |
|              | Private Interface Methods                                | [JEP 213](https://openjdk.org/jeps/213)              |
|              | Optional Class Enhancements                              | [JEP 286](https://openjdk.org/jeps/286)              |
| **8**        | Streams API                                              | [JEP 107](https://openjdk.org/jeps/107)              |
|              | Lambdas                                                  | [JEP 126](https://openjdk.org/jeps/126)              |
|              | Date & Time API                                          | [JEP 310](https://openjdk.org/jeps/310)              |
|              | Default Methods in Interfaces                            | [JEP 218](https://openjdk.org/jeps/218)              |

---

## How to Use

- **Requirements:** Java 24+ recommended for latest features; some features require preview flags or newer JDKs
- **Run:**
  ```sh
  mvn compile exec:java -Dexec.mainClass=language.features.Explorer
  ```
- **Explore:** See `src/main/java/language/features/Explorer.java` for code and commentary for each version.

---

## Build & Formatting

- Uses Maven for build and dependency management.
- Code formatting: [Spotify fmt-maven-plugin](https://github.com/spotify/fmt-maven-plugin) (Google Java Format)
- POM sorting: [sortpom-maven-plugin](https://github.com/Ekryd/sortpom)

---

## Navigation

- [Explorer.java](src/main/java/language/features/Explorer.java): Main demo file, organized by Java version.
