import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class RepeatableTests {

  @RepeatedTest(value = 10, name = "Test #{currentRepetition}")
  @DisplayName("This test will be repeated 10 times")
  void repeatedTest(RepetitionInfo repetitionInfo) {
    System.out.println("Currently running test #" + repetitionInfo.getCurrentRepetition());
  }

  @RepeatedTest(value = 5, name = "Test #{currentRepetition}")
  @DisplayName("This test will be repeated 5 times")
  void repeatedTest2(RepetitionInfo repetitionInfo) {
    System.out.println("Currently running test #" + repetitionInfo.getCurrentRepetition());
  }
}
