package tdd;

public class CircularQueueImpl implements CircularQueue{

    public static final int MAX_DIMENSION = 3;
    private int[] circularqueue = new int[MAX_DIMENSION];
    private int head = 0;
    private int size = 0;

    @Override
    public void push(int elem) {
            circularqueue[head] = elem;
            head = (head + 1) % MAX_DIMENSION;
            if(size < MAX_DIMENSION){
                size++;
            }
    }

    @Override
    public int peek() {
        if(size == 0){
            throw new IllegalStateException("The queue is empty");
        }
        return circularqueue[head];
    }

    @Override
    public int pop() {
        if(size == 0){
            throw new IllegalStateException("The queue is empty");
        }
        int oldestValue = circularqueue[head];
        head = (head + 1) % MAX_DIMENSION;
        size--;
        return oldestValue;
    }

    @Override
    public int getSize() {
        return size;
    }
}
