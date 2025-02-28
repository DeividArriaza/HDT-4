
/**
 * Implementation of a stack using an ArrayList.
 * @param <T> type of elements stored in the stack.
 */
public class ArrayList<T> implements IStack<T> {

    private ArrayList<T> stack; // ArrayList to store the elements of the stack.

    /**
     * Constructor of the stack.
     */
    public ArrayListStack() {
        this.stack = new ArrayList<>();
    }

    /**
     * Adds an element to the top of the stack.
     * @param value element to be added.
     */
    @Override
    public void push(T value) {
        stack.add(value);
    }

    /**
     * Removes the top element of the stack.
     * @return the removed element or null if the stack is empty.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null; // If the stack is empty, return null.
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Evaluates a postfix expression.
     * @param value the postfix expression to be processed.
     * @return the result of the evaluation.
     */
    @Override
    public T postfixExpression(T value) {
        
        return value;
    }
}

