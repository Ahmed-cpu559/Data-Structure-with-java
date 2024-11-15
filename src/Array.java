import java.util.Scanner;

public class Array {
    private static final Scanner input = new Scanner(System.in);
    private int size;
    private int length;
    private int[] arr;

    // Constructor
    public Array(int size) {
        this.size = size;
        this.length = 0;
        this.arr = new int[size];
    }

    // Utility methods
    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    // Fill and print methods
    public void fill() {
        System.out.println("How many items do you want to fill in the array?");
        int numberToFill = input.nextInt();

        if (numberToFill > size - length) { // Adjust to prevent overflow
            System.out.println("You can't exceed the array size!");
            return;
        }

        for (int i = length; i < length + numberToFill; i++) { // Start filling from the current length
            System.out.println("Enter a value at index " + i);
            arr[i] = input.nextInt();
        }
        length += numberToFill; // Update length after filling
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println("Item at index " + i + " = " + arr[i]);
        }
    }

    // Array manipulation methods
    public void append(int newValue) {
        if (length >= size) {
            System.out.println("The array is full");
            return;
        }

        arr[length] = newValue;
        length++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Invalid index");
            return;
        }

        for (int i = length; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        length++;
    }

    public void delete(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
            return;
        }

        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        length--;
    }

    public void setAllElements(int value) {
        for (int i = 0; i < size; i++) {
            arr[i] = value;
        }
        System.out.println("All items in the array have been set to " + value);
    }

    public int search(int value) {
        for (int i = 0; i < length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1; // Not found
    }

    public void enlarge(int newSize) {
        int[] newArr = new int[size + newSize];
        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
        size += newSize;

        System.out.println("Do you want to fill the new size? Enter 1 for yes, 0 for no: ");
        short x = input.nextShort();

        if (x == 1) {
            fill();
        }
    }
}
