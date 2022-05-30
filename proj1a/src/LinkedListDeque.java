public class LinkedListDeque <T> {
    private Node<T> sentinel;
    private int size;
    public static class Node<Type> {
        public Type item;
        public Node<Type> left;
        public Node<Type> right;
        public Node(Type i, Node<Type> l, Node<Type> r) {
            item = i;
            left = l;
            right = r;
        }
    }
    public LinkedListDeque() {
        /* Circular Sentinel */
        sentinel = new Node<>(null, null, null);
        sentinel.left = sentinel;
        sentinel.right = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        int POINTER = 0;
        int SIZE = other.size();
        while (SIZE > 0) {
            SIZE -= 1;
            addLast((T) get(POINTER));
            POINTER += 1;
        }
//        newLLD.sentinel.left.item = "HHHHH";
    }
    public void addFirst(T item) {
        sentinel.right = new Node<>(item, sentinel, sentinel.right);
        sentinel.right.right.left = sentinel.right;
//        sentinel.left = sentinel.right;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.left = new Node<>(item, sentinel.left, sentinel);
        sentinel.left.left.right = sentinel.left;
        size += 1;
    }

    public boolean isEmpty() {
        return sentinel.left == sentinel && sentinel.right == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> pointer = this.sentinel.right;
        int SIZE = this.size();
        System.out.print("[");
        while (SIZE > 1) {
            SIZE -= 1;
            System.out.print("\""+pointer.item+"\", ");
            pointer = pointer.right;
        }
        System.out.print("\""+pointer.item+"\"]\n");
    }

    public T removeFirst() {
        size -= 1;
        T value = sentinel.right.item;
        sentinel.right = sentinel.right.right;
        sentinel.right.left = sentinel;
        return value;
    }

    public T removeLast() {
        size -= 1;
        T value = sentinel.left.item;
        sentinel.left = sentinel.left.left;
        sentinel.left.right = sentinel;
        return value;
    }

    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        Node<T> pointer = this.sentinel.right;
        while (index > 0) {
            index -= 1;
            pointer = pointer.right;
        }
        return pointer.item;
    }
    public T getRecursive(int index) {
        return getRecursive(index, this.sentinel);
    }

    private T getRecursive(int index, Node<T> LLST) {
        if (index == 0) {
            return LLST.right.item;
        } else if (index > size - 1 || index < 0) {
            return null;
        } else {
            LLST = LLST.right;
            return getRecursive(index-1, LLST);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<String> a = new LinkedListDeque<>();
        a.addFirst("Third");
        a.addFirst("Second");
        a.addFirst("First");
        a.addLast("Fourth");
        System.out.println(a.get(0));
        System.out.println(a.get(4));
        System.out.println(a.getRecursive(0));
        System.out.println(a.getRecursive(3));
        LinkedListDeque<String> b = new LinkedListDeque<>(a);
        a.printDeque();
        b.printDeque();
        System.out.println(a.isEmpty());
    }
}
