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
}

class NotUniqueItemException extends Exception{
    NotUniqueItemException(String message){
        super(message);
    }
}