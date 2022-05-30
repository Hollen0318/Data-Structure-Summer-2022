public class ArrayDeque <T> {
    private T[] items;
    private int size;
    private int capacity;
    public ArrayDeque() {
        items = (T []) new Object[5];
        size = 0;
        capacity = 5;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T []) new Object[5];
        size = 0;
        capacity = 5;
        int SIZE = other.size;
        int POINTER = 0;
        while (SIZE > 0) {
            SIZE -= 1;
            addLast((T) other.items[POINTER]);
            POINTER += 1;
        }
    }

    private void resize() {
        T[] newAL = (T[]) new Object[capacity*2];
        System.arraycopy(items,0,newAL,0,size);
        this.items = newAL;
        capacity *= 2;
    }

    private boolean ifFull() {
        return size >= capacity;
    }

    public void addFirst(T item) {
        if (ifFull()) {
            resize();
        }
        System.arraycopy(items,0,items,1,size);
        items[0] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (ifFull()) {
            resize();
        }
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
        System.out.print("[\""+items[0]+"\", ");
        for (int i = 1; i < size-1; i += 1) {
            System.out.print("\"" + items[i] + "\", ");
        }
        System.out.print("\"" + items[size-1] + "\"]\n");
    }

    public T removeFirst() {
        T aw = items[0];
        System.arraycopy(items,1,items,0,size);
        items[size-1] = null;
        size -= 1;
        return aw;
    }

    public T removeLast() {
        T aw = items[size-1];
        items[size-1] = null;
        size -= 1;
        return aw;
    }

    public T get(int index) {
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<String> AD = new ArrayDeque<>();
        AD.addFirst("Third");
        AD.addFirst("Second");
        AD.addFirst("First");
        AD.addLast("Fourth");
        AD.addLast("Fifth");
        AD.addLast("Sixth");
        AD.addLast("Seventh");
        System.out.println(AD.removeLast());
        ArrayDeque<String> CS = new ArrayDeque<>(AD);
        CS.printDeque();
        AD.printDeque();
        System.out.println(CS.get(2));
    }
}
