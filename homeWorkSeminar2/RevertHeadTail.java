package homeWorkSeminar2;

public class RevertHeadTail {
    Node head;
    Node tail;

    public void revert(){
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

    public class Node {
    
        int value;
        Node next;
        Node previous;
    }
}
