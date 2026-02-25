package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private MinMaxStackImpl stack;
    @BeforeEach
    public void setUp(){
        stack = new  MinMaxStackImpl();
    }
    @Test
    public void testInsertionsInStack(){
        int fistInsertedValue = 10;
        assertThrows(IllegalStateException.class, () -> stack.pop());
        assertThrows(IllegalStateException.class, () -> stack.peek());
        stack.push(fistInsertedValue);
        assertEquals(fistInsertedValue, stack.peek());
        assertEquals(fistInsertedValue, stack.pop());
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void testMaxMinValues(){
        int fistInsertedValue = 10;
        int secondInsertedValue = 20;
        int thirdInsertedValue = 30;
        int numberElementsInStack = 0;
        stack.push(fistInsertedValue);
        numberElementsInStack++;
        stack.push(secondInsertedValue);
        numberElementsInStack++;
        stack.push(thirdInsertedValue);
        numberElementsInStack++;
        assertEquals(numberElementsInStack, stack.size());
        assertEquals(thirdInsertedValue, stack.getMax());
        assertEquals(fistInsertedValue, stack.getMin());
        stack.pop();
        assertEquals(secondInsertedValue, stack.getMax());

    }
}