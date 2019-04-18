import java.util.ArrayList;

public class MathBox{

    private ArrayList<Number> data;

    public MathBox(Number[] data) throws NotUniqueItemException{
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

    public String toString(){
        StringBuffer result = new StringBuffer("{");
        data.forEach((Number number) -> result.append(number).append(", "));

        result.delete(result.length() - 2, result.length());
        result.append("}");

        return result.toString();
    }
}

class NotUniqueItemException extends Exception{
    NotUniqueItemException(String message){
        super(message);
    }
}