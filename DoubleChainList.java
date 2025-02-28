/**
 * Implementation of a double chain list.
 * @param <T> data type of the list.
 */
public class DoubleChainList<T> implements IList<T> {

    /**
     * Class that represents a node of the list.
     * @param <T> data type of the node.
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructor of the node.
         * @param data value of the node.
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;  // First node of the list.
    private Node<T> tail;  // Last node of the list.

    /**
     * Constructor of the list.
     */
    public DoubleChainList() {
        this.head = null;
        this.tail = null;
    }

   
    @Override
    public String getTypeList(String data) {
        return "Double chain list of " + data;
    }

  
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) { // If the list is empty.
            head = tail = newNode;
        } else { 
            tail.next = newNode; // Connect the new node with the previous.
            newNode.prev = tail; // Connect the previous node with the new one.
            tail = newNode; // Move the tail to the new node.
        }
    }

  
    @Override
    public T remove() {
        if (head == null) {
            return null; // If the list is empty, return null.
        }
        T data = head.data;
        head = head.next; // Move the head to the next node.
        if (head != null) {
            head.prev = null; // Desconect the previous node.
        } else { 
            tail = null; // If the list is empty, the tail is null.
        }
        return data;
    }

    
    @Override
    public boolean isEmpty() {
        return head == null; // If the head is null, the list is empty.
    }
}


