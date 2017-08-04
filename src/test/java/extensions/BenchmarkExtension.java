package extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static java.lang.System.currentTimeMillis;

public class BenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

  // private long start;

  @Override
  public void beforeTestExecution(final ExtensionContext context) {
    // start = currentTimeMillis();
    getStore(context)
        .put(context.getTestMethod().orElseThrow(RuntimeException::new),
            currentTimeMillis());
  }

  @Override
  public void afterTestExecution(final ExtensionContext context) {
    long start = getStore(context)
        .remove(context.getTestMethod().orElseThrow(RuntimeException::new), long.class);

    System.out.println("Test execution took " + (currentTimeMillis() - start) + "ms");
  }

  private ExtensionContext.Store getStore(final ExtensionContext context) {
    return context.getStore(ExtensionContext.Namespace.create(context));
  }
}
