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
        ListIterator<Object> iterator = this.listIterator();

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

    public int size(){
        return data.size();
    }

    public boolean equals(ObjectBox box){
        if(box == null || this.size() != box.size()){
            return false;
        }

        ListIterator<Object> iter1 = this.listIterator();
        ListIterator<Object> iter2 = box.listIterator();

        while(iter1.hasNext() && iter2.hasNext()){
            if(iter1.next().equals(iter2.next())){
                return false;
            }
        }

        return true;
    }
}
