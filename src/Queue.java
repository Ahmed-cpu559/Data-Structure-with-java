public class Queue {
    private Node front;
    private Node rear ;

    Queue(){
        front=null;
        rear=null;
    }

    public boolean isEmpty (){
        return (front==null);
    }
    public void enqueue(int value){

        Node newNode = new Node();
        newNode.data = value;

        if(isEmpty()) {
            newNode.next=null;
            front=newNode;
            rear=newNode;
        }
        else {
            rear.next=newNode;
            rear=newNode;
    }

    }
    public void display(){
        Node temp = new Node();
        temp=front;
        int i = 1;
        if(!isEmpty()) {
            while (temp != null) {
                System.out.println(i + "the data equal " + temp.data);
                temp = temp.next;
                i++;
            }
        }
        else {
            System.out.println("the Queue is empty !!");
        }
    }
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("the Queue is empty !!");
            return 0;
        } else if (front == rear) {
            int value = front.data;
            front = null;
            rear = null;
            return value;
        } else {
            int value = front.data;
            front = front.next;
            return value;
        }
    }

    public void delete() {
        if (isEmpty()) {
            System.out.println("the Queue is empty !!");
        } else if (front == rear) {
            front = null;
            rear = null;
        } else {
            Node temp = new Node();
            temp.next = front.next;
            front = temp.next;
        }
    }

    public int getFront (){
        return front.data;
    }
    public int getRear(){
        return rear.data;
    }
    public int counter(){
        Node temp = new Node();
        temp=front;
        int i = 0;
        if(!isEmpty()) {
            while (temp != null) {
                i++;
                temp = temp.next;
            }
        }
        else {
            System.out.println("the Queue is empty !!");
        }
        return i;
    }
    public boolean isFound (int Kye){
        boolean found = false;
        Node temp = new Node();
        temp=front;

        if(!isEmpty()) {
            while (temp != null) {
                if(Kye==temp.data){
                    found=true;
                    break;
                }
                temp = temp.next;
            }
        }
        else {
            System.out.println("the Queue is empty !!");
        }
        return found;
    }
    public void clear() {
        front = null;
        rear = null;
    }

}
