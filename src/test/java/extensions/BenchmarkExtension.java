package extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExtensionContext;

import static java.lang.System.currentTimeMillis;

public class BenchmarkExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

  // private long start;

  @Override
  public void beforeTestExecution(final TestExtensionContext context) {
    // start = currentTimeMillis();
    getStore(context)
        .put(context.getTestMethod().orElseThrow(RuntimeException::new),
            currentTimeMillis());
  }

  @Override
  public void afterTestExecution(final TestExtensionContext context) {
    long start = getStore(context)
        .remove(context.getTestMethod().orElseThrow(RuntimeException::new), long.class);

    System.out.println("Test execution took " + (currentTimeMillis() - start) + "ms");
  }

  private ExtensionContext.Store getStore(final TestExtensionContext context) {
    return context.getStore(ExtensionContext.Namespace.create(context));
  }
}
