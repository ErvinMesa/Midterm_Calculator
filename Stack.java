package Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Stack <T>{
    private ArrayList<T> data = new ArrayList();
    private Stack_Data<T> top = null;
    int size = 0;
    public Stack(T[] data){
        for(T item: data){
            top = new Stack_Data<T>(item,top);
        }
        size = data.length;
    }
    public Stack(T data){
        top = new Stack_Data<T>(data);
        size = 1;
    }
    public Stack(){}
    public void push(T item){
        top = new Stack_Data<T>(item,top);
        size++;
    }
    public T pop() {
        size--;
        T temp = top.getData();
        top = top.next;
        return temp;
    }
    public T peek(){
        return top.getData();
    }
    public boolean stackEmpty(){
        return (size == 0);
    }
    public boolean hasNext(){
        return top != null;
    }
    public int size(){
        return size;
    }
    public String toString(){
        return Arrays.asList(data).toString();
    }
}
