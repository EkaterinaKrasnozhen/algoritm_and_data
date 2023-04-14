package lection3;

public class List {
    Node head;
    Node tail;

    public void addInTail(int value) {//добавление в конец
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void addInMiddle(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null){
            next.previous = null;
            head = next;
        } else {
            if (next == null){
                previous.next = null;
                tail = previous;
            }
        }
    }

    public void revertDuo(){
        Node currNode = head;
        while(currNode != null){
            Node next = currNode.next;
            Node previous = currNode.previous;
            currNode.next = previous;
            currNode.previous = next;
            if (previous == null){
                tail = currNode;
            }
            if (next == null){
                head = currNode;
            }
            currNode = next;
        }
    }

    public void revertSingle(){
        if (head != null && head.next != null){
            Node temp = head;
            revetSingle(head.next, head);
            temp.next = null;
        }
    }

    public void revetSingle(Node currentNode, Node previousNode){
        if (currentNode.next == null){
            head = currentNode;
        } else {
            revetSingle(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public class Node {
    
        int value;
        Node next;
        Node previous;
    }
}
