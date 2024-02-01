package Controller;

public class Counter implements AutoCloseable {

    static int sum;
    {
        sum = 0;
    }

    public void add() {
        sum++;
    }

    @Override
    public void close() {
        System.out.println("Counter closed");
    }

    @Override
    public String toString() {
        return String.format("Counter = %d", sum);
    }
}