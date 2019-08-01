package Calculator;

public class PostFix {
    Stack<String> values = new Stack<>();
    public String convertEquation(String eq){
        StringBuilder result = new StringBuilder(), temp = new StringBuilder();
        for(int i = 0;i<eq.length();i++){
            String c = Character.toString(eq.charAt(i));
            if("+-*/^".contains(c)){
                result.append(temp+" ");
                temp.delete(0,temp.length());
                if(!values.stackEmpty()) {
                    if("^".contains(values.peek())){
                        result.append(values.pop() + " ");
                    }
                    else if ("*/".contains(values.peek()) && !"^".contains(c)){
                        result.append(values.pop() + " ");
                    }
                }
                values.push(c);
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
                temp.append(c);
            }
        }
        result.append(temp+" ");
        while(values.hasNext()){
            result.append(values.pop()+" ");
        }
        return result.toString();
    }
}
