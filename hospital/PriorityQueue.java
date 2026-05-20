package hospital;

public interface PriorityQueue<E extends Comparable<E>> {
    void add(E value);
    E peek();
    E remove();
    int size();
    boolean isEmpty();
}