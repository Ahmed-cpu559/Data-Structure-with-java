import java.util.Objects;

public class CustomArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public CustomArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative.");
        }
        data = new Object[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return (T) data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        shrinkCapacity();
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], element)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private void shrinkCapacity() {
        if (size < data.length / 4 && data.length > DEFAULT_CAPACITY) {
            int newCapacity = data.length / 2;
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i] == null ? "null" : data[i].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();

        customArrayList.add("Apple");
        customArrayList.add("Banana");
        customArrayList.add("Cherry");
        System.out.println("ArrayList: " + customArrayList);

        customArrayList.add(1, "Mango"); // Add at index
        System.out.println("After adding Mango at index 1: " + customArrayList);

        System.out.println("Size of the ArrayList: " + customArrayList.size());

        customArrayList.remove(1); // Remove the element at index 1
        System.out.println("After removing index 1: " + customArrayList);

        System.out.println("Contains 'Cherry': " + customArrayList.contains("Cherry"));
        System.out.println("Index of 'Banana': " + customArrayList.indexOf("Banana"));
    }
}
