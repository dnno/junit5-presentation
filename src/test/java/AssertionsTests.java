import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AssertionsTests {

  @Test
  void multipleAssertions() {
    Person person = new Person();
    assertAll(() -> assertNotNull(person),
        // () -> assertNotNull(null),
        // () -> assertEquals(1,2),
        () -> assertEquals("Jane", person.firstname),
        () -> assertEquals("Doe", person.lastname));
  }

  @Test
  void timeouts() {
    assertTimeout(Duration.ofMillis(10), () -> {
      // Thread.sleep(2000);
    });
  }

  @Test
  void preemptiveTimeout() {
    assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
      // Thread.sleep(2000);
    });
  }

  static class Person {
    String firstname = "Jane";
    String lastname = "Doe";
  }
}
