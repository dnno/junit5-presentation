import de.rpr.junit.demo.Person;
import de.rpr.junit.jupiter.params.provider.JsonSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class ParameterizedTests {

  @ParameterizedTest
  @ValueSource(strings = { "one", "two", "three" })
  void valueSourceTest(String param) {
    System.out.println(param);
  }

  @ParameterizedTest
  @CsvSource({ "one,two", "three,four" })
  void csvSourceTest(String one, String two) {
    System.out.println(one + ", " + two);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "test.csv")
  void csvFileSourceTest(String one, String two) {
    System.out.println(one + ", " + two);
  }

  @ParameterizedTest
  @EnumSource(MyEnum.class)
  void enumSourceTest(MyEnum param) {
    System.out.println(param);
  }

  @ParameterizedTest
  @MethodSource("parameterMethod")
  void methodSourceTest(String param) {
    System.out.println(param);
  }

  @ParameterizedTest
  @JsonSource(value = "{firstname:'Jane', lastname: 'Doe'}", type = Person.class)
  void jsonSourceTest(Person param) {
    System.out.println(param);
  }

  private static Stream<String> parameterMethod() {
    return Stream.of("one", "two", "three", "four");
  }

  enum MyEnum {
    ONE,
    TWO,
    THREE,
    FOUR
  }

}
