package homework2;

public class MyArrayDataException extends RuntimeException{
    private int x;
    private int y;


    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, int x, int y, Throwable cause) {
        super(message, cause);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
