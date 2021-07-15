package stack;

import java.util.Objects;

public class Pair<T, T1> {

  T first;
  T1 second;

  public Pair(T first, T1 second) {
    this.first = first;
    this.second = second;
  }

  public T first() {
    return first;
  }

  public T1 second() {
    return second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }
}
