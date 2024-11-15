// Generic class
public class Templent <T> {
    private T data;

    public Templent(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

