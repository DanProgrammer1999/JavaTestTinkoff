public class Exceptions{
    static class NotUniqueItemException extends Exception{
        NotUniqueItemException(String message){
            super(message);
        }
    }
}
