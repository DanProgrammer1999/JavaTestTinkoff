import org.jetbrains.annotations.NotNull;

import java.util.ListIterator;

public class MathBox extends ObjectBox{

    /**
     * Constructor for class <code>MathBox</code>
     *
     * @param data Array of objects of class <code>Number</code>
     * @throws Exceptions.NotUniqueItemException Throws exception if a number appears more than once in the array
     */
    public MathBox(@NotNull Number[] data) throws Exceptions.NotUniqueItemException{
        super();

        for(Number n : data){
            if(!this.data.contains(n)){
                this.data.add(n);
            }
            else{
                throw new Exceptions.NotUniqueItemException("Number " + n.toString() + "is not unique");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Object o) throws Exceptions.NotUniqueItemException{
        if(!(o instanceof Number)){
            throw new IllegalArgumentException("Object " + o.toString() + " is not instance of Number!");
        }

        super.add(o);
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
        for(Object o : data){
            result += ((Number) o).doubleValue();
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
        ListIterator<Object> iterator = data.listIterator();
        while(iterator.hasNext()){
            double currElement = ((Number) iterator.next()).doubleValue();
            double result = currElement/factor.doubleValue();
            if((int) result - result == 0){
                iterator.set((int) result);
            }
            else{
                iterator.set(result);
            }
        }
    }
}