package de.rpr.junit.jupiter.params.provider;

import com.google.gson.Gson;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ObjectArrayArguments;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Stream;

public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

  private String[] value;
  private Type type;

  @Override
  public void accept(final JsonSource annotation) {
    value = annotation.value();
    type = annotation.type();
  }

  @Override
  public Stream<? extends Arguments> arguments(final ContainerExtensionContext context) throws Exception {
    return Arrays.stream(value)
        .map(this::map)
        .map(ObjectArrayArguments::create);
  }

  private <R> R map(final String value) {
    return new Gson().fromJson(value, type);
  }
}
