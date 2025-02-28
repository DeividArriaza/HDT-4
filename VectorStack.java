import java.util.Vector;

/*
 * Implementation of a stack using a Vector.
 * @param <T> type of elements stored in the stack.
 */
public class VectorStack<T> implements IStack<T> {
    private VectorStack<T> stack = new VectorStack<>(); // Vector to store the elements of the stack.

    @Override
    public void push(T value) {
        stack.add(value);
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1); 
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.lastElement();
        }
        return null;
    }

    /*
     * Evaluates a postfix expression.
     * @param value the postfix expression to be processed.
     * @return the result of the evaluation.
     */
    private int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    /*
     * Converts an infix expression to a postfix expression.
     * @param infix the infix expression to be converted.
     * @return the postfix expression.
     */
    @Override
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        VectorStack<Character> stack = new VectorStack<>();
        stack.push('#'); 

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) { 
                postfix.append(ch);
            } else if (ch == '(') { 
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        /*
         * Pop all the remaining operators from the stack.
         */
        while (!stack.isEmpty() && stack.peek() != '#') { 
            postfix.append(stack.pop()); 
        }

        return postfix.toString();
    }
}
