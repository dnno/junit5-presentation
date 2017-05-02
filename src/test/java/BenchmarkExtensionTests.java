import extensions.Benchmarked;
import org.junit.jupiter.api.Test;

import java.util.Random;

class BenchmarkExtensionTests {

  @Test
  @Benchmarked
  void benchmarkTest() throws Exception {
    Thread.sleep(new Random().nextInt(1000));
  }
}
