import java.util.ArrayList;
import java.util.ListIterator;

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

    public boolean remove(Object o){
        ListIterator<Number> iterator = this.listIterator();

        while(iterator.hasNext()){
            if(iterator.next().equals(o)){
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public ListIterator<Object> listIterator(){
        return data.listIterator();
    }
}
