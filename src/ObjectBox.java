import java.util.ArrayList;
import java.util.ListIterator;

public class ObjectBox{
    protected ArrayList<Object> data;

    /**
     * Constructor for this object
     */
    public ObjectBox(){
        data = new ArrayList<>();
    }

    /**
     * Add an object to the list
     *
     * @param o The object to be added
     * @throws Exceptions.NotUniqueItemException Throws exception if this object already exists.
     */
    public void add(Object o) throws Exceptions.NotUniqueItemException{
        if(data.contains(o)){
            throw new Exceptions.NotUniqueItemException("Object " + o.toString() + " is a duplicate");
        }

        data.add(o);
    }

    /**
     * Remove the specified object, if it exists.
     *
     * @param o The object to be removed
     * @return <code>true</code>, if the object was successfully removed
     * <code>false</code>, otherwise
     */
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

    /**
     * @return <code>ListIterator</code> through the items in this object
     */
    public ListIterator<Object> listIterator(){
        return data.listIterator();
    }

    /**
     * @return Number of elements in the object
     */
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
