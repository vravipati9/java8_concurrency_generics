package generics;

public class TypeErasure {
    public static void main(String[] args) {
        MyNode myNode = new MyNode(5);
        Node node = myNode;     // a raw type - compiler throws an unchecked warning
        node.setData("test data");  //causes ClassCastException to be thrown
    }
}

class Node<T> {
    public T data;
    public Node(T data) {
        this.data = data;
    }
    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
    class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
    }
    public void setData(Integer data) {
        super.setData(data);
    }
}

/*
After type erasure, Node and MyNode classes become
public class Node {

    public Object data;

    public Node(Object data) { this.data = data; }

    public void setData(Object data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}

public class MyNode extends Node {

    public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
 */
