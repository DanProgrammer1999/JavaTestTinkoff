import java.util.ArrayList;
import java.util.ListIterator;

public class ObjectBox{
    protected ArrayList<Object> data;

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

    /**
     * Element-wise comparison of this object and other
     *
     * @param other object to compare to
     * @return <code>true</code> if the objects have the same size and they are equal element-wise
     * <code>false</code>, otherwise
     */
    public boolean equals(ObjectBox other){
        if(other == null || this.size() != other.size()){
            return false;
        }

        ListIterator<Object> iter1 = this.listIterator();
        ListIterator<Object> iter2 = other.listIterator();

        while(iter1.hasNext() && iter2.hasNext()){
            if(iter1.next().equals(iter2.next())){
                return false;
            }
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode(){
        int result = 13;

        for(Object o : data){
            result = result*37 + o.hashCode();
        }

        return result;
    }
}
