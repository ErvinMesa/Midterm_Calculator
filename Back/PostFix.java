package Back;

public class PostFix {
    Stack<String> values = new Stack<>();
    public String convertEquation(String eq){
        StringBuilder result = new StringBuilder(), temp = new StringBuilder();
        boolean prevIsOperator = false;
        for(int i = 0;i<eq.length();i++){
            String c = Character.toString(eq.charAt(i));
            try {
                if ("+-*/^".contains(c)) {
                    if(c.equals("-") && prevIsOperator || i == 0){
                        temp.append("-");
                        prevIsOperator = false;
                        continue;
                    }
                    if (temp.length() > 0) {
                        result.append(temp + " ");
                        temp.delete(0, temp.length());
                    }
                    if (!values.stackEmpty()) {
                        if ("^".contains(values.peek())) {
                            result.append(values.pop() + " ");
                        }
                        if (!values.stackEmpty() && "*/".contains(values.peek()) && !"^".contains(c)) {
                            result.append(values.pop() + " ");
                        }
                        if (!values.stackEmpty() && "+-".contains(values.peek()) && "+-".contains(c)) {
                            result.append(values.pop() + " ");
                        }
                    }
                    values.push(c);
                    prevIsOperator = true;
                } else if ("()".contains(c)) {
                    if (c.equals("(")) {
                        values.push(c);
                    } else {
                        if (temp.length() > 0) {
                            result.append(temp + " ");
                            temp.delete(0, temp.length());
                        }
                        String letter = "";
                        while (!letter.equals("(")) {
                            if (!letter.isEmpty())
                                result.append(letter + " ");
                            letter = values.pop();
                        }
                    }
                    prevIsOperator = false;
                } else if (c.equals(" ")) {
                } else {
                    temp.append(c);
                    prevIsOperator = false;
                }
            }
            catch (NullPointerException e){
            }
        }
        result.append(temp+" ");
        while(values.hasNext()){
            result.append(values.pop()+" ");
        }
        return result.toString();
    }
}
