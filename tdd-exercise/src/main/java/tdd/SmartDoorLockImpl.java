package tdd;

import java.util.Optional;

public class SmartDoorLockImpl implements SmartDoorLock{

    public enum DoorState{
        LOCKED, UNLOCKED, BLOCKED
    }

    private DoorState actualState = DoorState.LOCKED;
    private Optional<Integer> pin = Optional.empty();
    private final int MAX_ATTEMPTS = 100;
    private int failedAttempts = 0;

    @Override
    public void setPin(int pin) {
        this.pin = Optional.of(pin);
    }

    @Override
    public void unlock(int pin) {
        if (this.pin.isEmpty() || this.pin.get() == pin){
            this.actualState = DoorState.UNLOCKED;
        } else {
            this.failedAttempts += 1;
            if (this.failedAttempts > MAX_ATTEMPTS){
                this.actualState = DoorState.BLOCKED;
            }
        }
    }

    @Override
    public void lock() {
        if(this.pin.isPresent()){
            this.actualState = DoorState.LOCKED;
        } else {
            throw new IllegalStateException("Cannot lock the door: PIN is not set.");
        }
    }

    @Override
    public boolean isLocked() {
        return this.actualState == DoorState.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return this.actualState == DoorState.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return this.MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.pin = Optional.empty();
        failedAttempts = 0;
        this.actualState = DoorState.UNLOCKED;
    }
}
