import java.util.Stack;

public class CalculatorADT implements CalcStack<Integer> {
    private Stack<Integer> stack;
    private static CalculatorADT instancia;
    private CalculatorADT() {
        stack = new Stack<>();
        instancia = null;
    }

    public static CalculadoraADT getInstancia(){
        if(instancia == null){
            instancia = new CalculatorADT();
        }
        return instancia;
    }
    @Override
    public void push(Integer value) {
        stack.push(value);
    }


    @Override
    public Integer pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return stack.pop();
    }

    //method to operate the "value1-operator-value2"
    @Override
    public Integer operation(char operator, Integer value1, Integer value2) {
        switch (operator) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                if (value2 == 0)
                    throw new ArithmeticException("División por cero");
                return value1 / value2;
            default:
                throw new IllegalArgumentException("Operador no soportado: " + operator);
        }
    }
    
    //Evaluates the value of the postfix expression (A whole String line)
    public int evaluatePostfix(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                push(Integer.parseInt(token));
            } else if (isOperator(token)) { 
                int value2 = pop();
                int value1 = pop();
                int result = operation(token.charAt(0), value1, value2);
                push(result);
            } else {
                throw new IllegalArgumentException("Expresión no válida: " + token);
            }
        }
        return pop(); 
    }

        private boolean isNumeric(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private boolean isOperator(String str){
            if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")){
                return true;
            }
            else{
                return false;
            }
        }


}
