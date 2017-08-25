import extensions.Benchmarked;
import extensions.BenchmarkedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

class BenchmarkExtensionTests {

  @Test
  @Benchmarked
  void benchmarkAndTest() throws Exception {
    Thread.sleep(new Random().nextInt(1000));
  }

  @BenchmarkedTest
  void benchmarkedTest() throws Exception {
    Thread.sleep(new Random().nextInt(1000));
  }
}
