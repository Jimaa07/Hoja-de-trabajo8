package hospital;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * i + 2;
    }

    private void percolateUp(int i) {
        while (i > 0) {
            int p = parent(i);
            if (data.get(i).compareTo(data.get(p)) < 0) {
                E temp = data.get(i);
                data.set(i, data.get(p));
                data.set(p, temp);
                i = p;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int i) {
        int size = data.size();
        while (left(i) < size) {
            int smallest = i;
            int l = left(i);
            int r = right(i);

            if (l < size && data.get(l).compareTo(data.get(smallest)) < 0) {
                smallest = l;
            }
            if (r < size && data.get(r).compareTo(data.get(smallest)) < 0) {
                smallest = r;
            }

            if (smallest != i) {
                E temp = data.get(i);
                data.set(i, data.get(smallest));
                data.set(smallest, temp);
                i = smallest;
            } else {
                break;
            }
        }
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data.get(0);
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        E minVal = data.get(0);
        int lastIndex = data.size() - 1;
        data.set(0, data.get(lastIndex));
        data.remove(lastIndex);
        if (!isEmpty()) percolateDown(0);
        return minVal;
    }

    @Override
    public int size() { return data.size(); }

    @Override
    public boolean isEmpty() { return data.isEmpty(); }

    @Override
    public String toString() { return data.toString(); }
}