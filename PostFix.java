package Calculator;

public class PostFix {
    Stack<String> values = new Stack<>();
    public String convertEquation(String eq){
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<eq.length();i++){
            String c = Character.toString(eq.charAt(i));
            if("+-*/".contains(c)){
                if("*/".contains(c)) {
                    values.push(c);
                }
                else {
                    if(values.size > 0 && "*/".contains(values.peek())){
                        result.append(values.pop());
                    }
                    values.push(c);
                }
            }
            else if("()".contains(c)){
                if(c.equals("(")){
                    values.push(c);
                }
                else{
                    String letter = "";
                    while(!letter.equals("(")){
                        result.append(letter);
                        letter = values.pop();
                    }
                }
            }
            else{
                result.append(c);
            }
        }
        while(values.size > 0){
            result.append(values.pop());
        }
        return result.toString();
    }
}
