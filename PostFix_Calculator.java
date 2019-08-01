package Calculator;

import java.util.StringTokenizer;

public class PostFix_Calculator {
    private Stack<Double> stack = new Stack();
    private StringTokenizer tokenizer;
    public PostFix_Calculator(){}
    public double solve(String eq){
        tokenizer = new StringTokenizer(eq);
        while(tokenizer.hasMoreTokens()){
            String val = tokenizer.nextToken();
            if("+-/*^".contains(val)){
                stack.push(evaluate(stack.pop(),stack.pop(),val));
            }
            else{
                stack.push(Double.parseDouble(val));
            }
        }
        return stack.pop();
    }
    public double evaluate(double a, double b,String operator){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return b-a;
            case "*":
                return a*b;
            case "/":
                return b/a;
            case "^":
                return Math.pow(b,a);
        }
        return 0;
    }
}
