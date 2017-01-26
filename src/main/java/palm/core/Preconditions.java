package palm.core;

public class Preconditions {
    public static <T> void checkNotNull(T arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " can not be null");
        }
    }
}
