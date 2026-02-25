package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularQueue queue;

    @BeforeEach
    public void setUp(){
        queue = new CircularQueueImpl();
    }
    @Test
    public void testQueueDoesNotExceedMaxCapacity() {
        for(int i = 0; i < 10; i++){
            queue.push(i);
        }
        assertEquals(CircularQueueImpl.MAX_DIMENSION, queue.getSize());
    }

    @Test
    public void testPopLogic(){
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;
        int overwritingValue = 4;
        queue.push(firstValue);
        queue.push(secondValue);
        queue.push(thirdValue);
        assertEquals(firstValue, queue.peek());
        queue.push(overwritingValue);
        assertEquals(secondValue, queue.peek());
        assertEquals(secondValue, queue.pop());
        queue.pop();
        queue.pop();
        assertEquals(0, queue.getSize());
    }
}
