import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Given we want to test list operations")
class NestedTests {

  List<String> list;

  @BeforeEach
  void setup() {
    list = new ArrayList<>();
  }

  @Nested
  @DisplayName("when the list is empty")
  class ListIsEmpty {

    @Test
    @DisplayName("its size should be 0")
    void isEmpty() {
      assertEquals(0, list.size(), "Size should be 0!");
    }

    @Test
    @DisplayName("its size should be 1 if we add an element")
    void isNotEmptyWhenElementIsAdded() {
      list.add("element");
      assertEquals(1, list.size(), "Size should be 1!");
    }
  }

  @Nested
  @DisplayName("when the list contains one element")
  class ListContainsOneElement {

    @BeforeEach
    void setup() {
      list.add("existingElement");
    }

    @Test
    @DisplayName("it should not be empty")
    void isNotEmpty() {
      assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("it should be empty if we remove the same element")
    void removeExistingElement() {
      list.remove("existingElement");
      assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("its size should still be 1 if we remove a non-existing element")
    void removeNonExistingElement() {
      list.remove("nonExistingElement");
      assertEquals(1, list.size(), "List should still contain one element!");
    }

    @Test
    @DisplayName("its size should be 2 if we add another element")
    void addAnotherElement() {
      list.add("one more");
      assertEquals(2, list.size());
    }
  }

}
