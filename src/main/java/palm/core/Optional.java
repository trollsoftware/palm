package palm.core;


import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/**
 * An immutable object that may contain a non-null reference to another object. Each
 * instance of this type either contains a non-null reference, or contains nothing (in
 * which case we say that the reference is "absent"); it is never said to "contain {@code
 * null}".
 *
 * <p>A non-null {@code Optional<T>} reference can be used as a replacement for a nullable
 * {@code T} reference. It allows you to represent "a {@code T} that must be present" and
 * a "a {@code T} that might be absent" as two distinct types in your program, which can
 * aid clarity.
 */

public class Optional<T> implements Serializable {
    public interface NonNullAction<T> {
        void action(T object);
    }

    private final T reference;

    Optional(T reference) {
        this.reference = reference;
    }

    /**
     * Returns an {@code Optional} instance containing the given non-null reference.
     *
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> Optional<T> of(T reference) {
        return new Optional<T>(Preconditions.checkNotNull(reference));
    }

    /**
     * TODO
     * @param a
     */
    public void doNonNull(NonNullAction<T> a) {
        Preconditions.checkNotNull(a);

        if (isPresent()) {
            a.action(get());
        }
    }

    /**
     * Returns {@code true} if this holder contains a (non-null) instance.
     */
    public boolean isPresent() {
        return reference != null;
    }

    /**
     * Returns the contained instance, which must be present.
     *
     * @throws IllegalStateException if the instance is absent ({@link #isPresent} returns
     *     {@code false}); depending on this <i>specific</i> exception type (over the more general
     *     {@link RuntimeException}) is discouraged
     */
    public T get() {
        if (!isPresent()) {
            throw new IllegalStateException();
        }
        return reference;
    }

    /**
     * Returns the contained instance if it is present; {@code defaultValue} otherwise. If
     * no default value should be required because the instance is known to be present, use
     * {@link #get()} instead. For a default value of {@code null}, use {@link #orNull}.
     */
    public T orNull() {
        return reference;
    }

    /**
     * Returns an immutable singleton {@link Set} whose only element is the contained instance
     * if it is present; an empty immutable {@link Set} otherwise.
     */
    public Set<T> asSet() {
        return Collections.singleton(reference);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Optional) {
            Optional<?> other = (Optional<?>) object;
            return reference.equals(other.reference);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0x598df91c + reference.hashCode();
    }

    @Override
    public String toString() {
        return "Optional.of(" + reference + ")";
    }
}

