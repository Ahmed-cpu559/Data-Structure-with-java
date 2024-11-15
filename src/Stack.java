public class Stack {
    public Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int item) {
        Node newNode = new Node();
        newNode.data = item;
        if (isEmpty()) {
            newNode.next = null;
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        int popValue = top.data;
        top = top.next;

        return popValue;
    }

    public void display() {
        Node temp;
        temp = top;
        if (!isEmpty()) {
            while (temp != null) {
                System.out.println("data " + temp.data);
                temp = temp.next;
            }
        } else {
            System.out.println("the stack is empty ");
        }
    }

    public int peek() {
        return top.data;
    }

    public int counter() {
        int count = 0;
        Node temp;
        temp = top;
        if (!isEmpty()) {
            while (temp != null) {
                count++;
                temp = temp.next;
            }
        } else {
            System.out.println("the stack is alReady empty ");
        }
        return count;
    }
    public boolean isFound (int item){
        boolean found = false;
        Node temp = top ;
        while (temp != null){
            if(item==temp.data){
                found=true;
                break;
            }
            temp=temp.next;
        }
        return found;
    }

}
