import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MathBox{

    private ArrayList<Number> data;

    public MathBox(@NotNull Number[] data) throws NotUniqueItemException{
        this.data = new ArrayList<>();

        for(Number n : data){
            if(!this.data.contains(n)){
                this.data.add(n);
            }
            else{
                throw new NotUniqueItemException("Number " + n.toString() + "is not unique");
            }
        }
    }

    public Number summator(){
        if(data.size() == 0){
            return 0;
        }

        double result = 0;
        for(Number n : data){
            result += n.doubleValue();
        }

        if((int) result - result == 0){
            return (int) result;
        }
        return result;
    }

    public void splitter(@NotNull Number factor) throws ArithmeticException{
        if(factor.doubleValue() == 0.0){
            throw new ArithmeticException("Cannot divide by zero.");
        }
        ListIterator<Number> iterator = data.listIterator();
        while(iterator.hasNext()){
            double currElement = iterator.next().doubleValue();
            double result = currElement/factor.doubleValue();
            if((int) result - result == 0){
                iterator.set((int) result);
            }
            else{
                iterator.set(result);
            }
        }
    }

    public String toString(){
        StringBuffer result = new StringBuffer("{");
        data.forEach((Number number) -> result.append(number).append(", "));

        result.delete(result.length() - 2, result.length());
        result.append("}");

        return result.toString();
    }

    @Override
    public int hashCode(){
        int result = 13;

        for(Number n : data){
            result = result*37 + n.hashCode();
        }

        return result;
    }

    Iterator<Number> listIterator(){
        return data.listIterator();
    }

    public int size(){
        return data.size();
    }
}

class NotUniqueItemException extends Exception{
    NotUniqueItemException(String message){
        super(message);
    }
}