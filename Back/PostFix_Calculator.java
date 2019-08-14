package Back;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class PostFix_Calculator {
    private Stack<Double> stack = new Stack();
    private StringTokenizer tokenizer;
    private DecimalFormat format = new DecimalFormat("#.00");
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
        return Double.parseDouble(format.format(stack.pop()));
    }
    public String showProcess(String eq){
        StringBuilder process = new StringBuilder();
        tokenizer = new StringTokenizer(eq);
        while(tokenizer.hasMoreTokens()){
            String val = tokenizer.nextToken();
            if("+-/*^".contains(val)){
                double num1 = stack.pop();
                double num2 = stack.pop();
                stack.push(evaluate(num1,num2,val));
                process.append(format.format(num2)+" "+val+" "+format.format(num1)+" = "+format.format(stack.peek())+"|");
            }
            else{
                stack.push(Double.parseDouble(val));
            }
        }
        process.append("Result: \n"+format.format(stack.pop()));
        return process.toString();
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
