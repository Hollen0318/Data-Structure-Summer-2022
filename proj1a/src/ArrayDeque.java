public class ArrayDeque <T> {
    private T[] items;
    private int size;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {

    }

    public void addFirst(T item) {
        items[size] = item;
        size += 1;
    }

    public void addLast(T item) {
        items[size] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        System.out.println("Print the deque");
    }

    public T removeFirst() {
        return items[1];
    }

    public T removeLast() {
        return items[1];
    }

    public T get(int index) {
        return items[1];
    }
}
