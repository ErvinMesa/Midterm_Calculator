package Calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack <T>{
    ArrayList<T> data = new ArrayList();
    int size = 0;
    public Stack(T[] data){
        for(T item: data){
            this.data.add(item);
        }
        size = data.length;
    }
    public Stack(){

    }
    public void push(T item){
        data.add(item);
        size++;
    }
    public T pop(){
        T item = data.get(size-1);
        data.remove(size-1);
        size--;
        return item;
    }
    public T peek(){
        if (data.size() > 0)
            return data.get(size-1);
        else
            return null;
    }
    public int size(){
        return size;
    }
    public String toString(){
        return Arrays.asList(data).toString();
    }
}
