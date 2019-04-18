import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.ListIterator;

public class MathBox{

    private ArrayList<Number> data;

    /**
     * Constructor for class <code>MathBox</code>
     *
     * @param data Array of objects of class <code>Number</code>
     * @throws NotUniqueItemException Throws exception if a number appears more than once in the array
     */
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

    /**
     * Sum up all elements in the object and return the result.
     *
     * @return The sum of all values in the object
     */
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

    /**
     * Divide each number by factor in-place
     *
     * @param factor The divisor on which to divide by
     * @throws ArithmeticException Throws <code>ArithmeticException</code> if the factor is 0
     */
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

    /**
     * Remove the specified number from the object.
     *
     * @param value The value of the number to remove from the object
     * @return <code>true</code>, if the number was found and removed;
     * <code>false</code>, otherwise
     */
    public boolean remove(@NotNull Number value){
        ListIterator<Number> iterator = this.listIterator();

        while(iterator.hasNext()){
            if(iterator.next().doubleValue() == value.doubleValue()){
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    /**
     * String representation of the object.
     *
     * @return String representation, which contains each element, separated by ',' and encased in '{}'
     */
    public String toString(){
        StringBuffer result = new StringBuffer("{");
        data.forEach((Number number) -> result.append(number).append(", "));

        result.delete(result.length() - 2, result.length());
        result.append("}");

        return result.toString();
    }

    /**
     * Get hash code of this object
     *
     * @return Calculated hash code of the object
     */
    @Override
    public int hashCode(){
        int result = 13;

        for(Number n : data){
            result = result*37 + n.hashCode();
        }

        return result;
    }

    /**
     * Compare this object to another one (it is done element-wise)
     *
     * @param box Another object <code>MathBox</code> to compare with
     * @return    <code>true</code>, if the two objects have the same length and if they are equal element-wise
     *            <code>false</code>, otherwise
     */
    public boolean equals(MathBox box){
        if(box == null || this.size() != box.size()){
            return false;
        }

        ListIterator<Number> iter1 = this.listIterator();
        ListIterator<Number> iter2 = box.listIterator();

        while(iter1.hasNext() && iter2.hasNext()){
            if(iter1.next().doubleValue() != iter2.next().doubleValue()){
                return false;
            }
        }

        return true;
    }

    /**
     * Get iterator for this object
     * @return iterator for this object
     */
    public ListIterator<Number> listIterator(){
        return data.listIterator();
    }

    /**
     * Number of elements contained in this object
     *
     * @return Number of elements in this object
     */
    public int size(){
        return data.size();
    }
}

class NotUniqueItemException extends Exception{
    NotUniqueItemException(String message){
        super(message);
    }
}