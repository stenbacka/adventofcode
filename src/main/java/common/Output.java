package common;

import java.util.function.Supplier;

public interface Output extends Supplier<String> {
    String get();
}
