import java.util.ArrayList;

public class ObjectBox{
    private ArrayList<Object> data;

    public ObjectBox(){
        data = new ArrayList<>();
    }

    public void add(Object o) throws Exceptions.NotUniqueItemException{
        if(data.contains(o)){
            throw new Exceptions.NotUniqueItemException("Object " + o.toString() + " is a duplicate");
        }

        data.add(o);
    }
}
