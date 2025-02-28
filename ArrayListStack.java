import java.util.ArrayList;
/*
 * Implementation of a stack using an ArrayList.
 */
public class ArrayListStack<T> implements IStack<T> {
    private ArrayList<T> stack = new ArrayList<>(); // ArrayList to store the elements of the stack.

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
            return stack.get(stack.size() - 1);
        }
        return null;
    }

    /*
     * Evaluates a postfix expression.
     * @param value the postfix expression to be processed.
     * @return the result of the evaluation.
     */
    @Override
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        ArrayListStack<Character> stack = new ArrayListStack<>();
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
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        /*
         * Pops all the remaining elements from the stack.
         */
        while (!stack.isEmpty() && stack.peek() != '#') {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    
    private int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1; //if the character is + or - return 1
            case '*': case '/': return 2; //if the character is * or / return 2
            case '^': return 3;  //if the character is ^ return 3
            default: return -1; //if the character is not any of the above return -1
        }
    }
}
