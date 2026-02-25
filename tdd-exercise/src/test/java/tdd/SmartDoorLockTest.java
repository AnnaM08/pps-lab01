package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLockImpl smartDoor;
    private final int DEFAULT_PIN = 0000;

    @BeforeEach
    void setUp(){
        smartDoor = new SmartDoorLockImpl();
    }

    @Test
    public void testDoorInitiallyOpen() {
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testUnlockingDoor() {
        smartDoor.unlock(DEFAULT_PIN);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testChangePin() {
        int newPin = 1111;
        smartDoor.setPin(newPin);
        smartDoor.unlock(DEFAULT_PIN);
        assertTrue(smartDoor.isLocked());
        smartDoor.unlock(newPin);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testLockingDoor(){
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> smartDoor.lock());
        assertEquals("Cannot lock the door: PIN is not set.", exception.getMessage());
        smartDoor.setPin(DEFAULT_PIN);
        smartDoor.lock();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testBlockingAndResetingDoor(){
        smartDoor.setPin(DEFAULT_PIN);
        int badPin = 1111;
        for(int i = 0; i <= smartDoor.getMaxAttempts(); i++){
            smartDoor.unlock(badPin);
        }
        assertTrue(smartDoor.getFailedAttempts() > smartDoor.getMaxAttempts());
        assertTrue(smartDoor.isBlocked());
        smartDoor.reset();
        assertEquals(smartDoor.getFailedAttempts(), 0);
        assertFalse(smartDoor.isLocked());
    }

}
