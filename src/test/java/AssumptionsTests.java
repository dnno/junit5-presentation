import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssumptionsTests {

  @Test
  @DisplayName("Test runs if assumption is fulfilled")
  void assumptionIsFulfilled() {
    assumeTrue(true);
  }

  /**
   * Test wird abgebrochen
   */
  @Test
  @DisplayName("Test is aborted if assumption is not fulfilled")
  void assumptionIsNotFulfilled() {
    assumeTrue(false);
  }

  /**
   * Test wird mit message abgebrochen
   */
  @Test
  @DisplayName("A custom message is displayed if assumption isn't fulfilled")
  void assumptionIsNotFulfilledWithMessage() {
    assumeFalse(true, "True != False");
  }

  /**
   * Testcode wird ausgeführt
   */
  @Test
  @DisplayName("assumingThat() runs testcode if assumption is fulfilled")
  void assumingThatRunsTestcodeWhenFulfilled() {
    assumingThat(
        true,
        () -> assertTrue(true));
  }

  /**
   * Testcode wird nicht ausgeführt
   */
  @Test
  @DisplayName("assumingThat() doesn't run testcode if assumption is not fulfilled")
  void assumingThatDoesntRunTestcodeWhenNotFulfilled() {
    assumingThat(
        this::testAssumption,
        () -> assertTrue(false));
  }

  private boolean testAssumption() {
    return true == false;
  }

}
