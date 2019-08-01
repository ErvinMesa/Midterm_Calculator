package Calculator;

public class Stack_Data <T>{
    T data;
    Stack_Data next;
    public Stack_Data(T data, Stack_Data next){
        this.data = data;
        this.next = next;
    }
    public Stack_Data(T data){
        this(data,null);
    }
    public Stack_Data(){
        this(null);
    }
    public Stack_Data getNext(){
        return next;
    }
    public T getData(){
        return data;
    }
}
