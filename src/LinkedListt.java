public class LinkedListt {
    private Node head;

    // Constructor to initialize the linked list
    public LinkedListt() {
        head = null;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert a new node at the beginning of the list
    public void insertFirst(int newValue) {
        Node newNode = new Node();
        newNode.data = newValue;

        newNode.next = head;
        head = newNode;
    }

    // Display all elements in the list
    public void display() {
        Node temp = head;

        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Count the number of nodes in the list
    public int counter() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Check if a value exists in the list
    public boolean isFound(int key) {
        Node temp = head;

        while (temp != null) {
            if (key == temp.data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Insert a new node before a specific value
    public void insertBefore(int item, int newValue) {
        Node newNode = new Node();
        newNode.data = newValue;

        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        // If the item is the first node
        if (head.data == item) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == item) {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found: " + item);
    }

    // Append a new node at the end of the list
    public void append(int newValue) {
        Node newNode = new Node();
        newNode.data = newValue;
        newNode.next = null;

        if (isEmpty()) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete a node with a specific value
    public void delete(int value) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        // If the value is in the head
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == value) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found: " + value);
    }

    // Make the linked list circular
    public void willBeCircle() {
        if (isEmpty()) {
            System.out.println("The list is empty. Cannot make it circular.");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
    }
}
