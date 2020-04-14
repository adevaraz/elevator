package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorEngine.Direction;

/**
 * 
 */
public class CabNavigator {
    private final ElevatorEngine engine;

    private final DirectionDisplay directionDisplay;

    private final FloorNumberDisplay floorNumberDisplay;

    private ElevatorEngine.Direction direction = Direction.UP;

    private double speed = 0.0;

    private int floorNumber = 0;

    private boolean isSuspended = false;

    public CabNavigator (ElevatorEngine engine, DirectionDisplay directionDisplay, FloorNumberDisplay floorNumberDisplay) {
        this.engine = engine;

        this.directionDisplay = directionDisplay;

        this.floorNumberDisplay = floorNumberDisplay;
    }

    private DirectionDisplay getDirectionDisplay() {
        return directionDisplay;
    }

    private FloorNumberDisplay getFloorNumberDisplay() {
        return floorNumberDisplay;
    }

    private void setDirection(ElevatorEngine.Direction direction) {
        this.direction = direction;

        // Update the direction display
        this.getDirectionDisplay()
            .show(this.direction == Direction.UP ? DirectionDisplay.Direction.UP 
                                                 : DirectionDisplay.Direction.DOWN);
    }

    public int getFloorNumber() {
        synchronized (this) {
            return floorNumber;
        }
    }

    private void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;

        // Update the floor number display
        this.getFloorNumberDisplay()
            .show(this.floorNumber);
    }

    public boolean isSuspended() {
        synchronized (this) {
            return isSuspended;
        }
    }

    private void setSuspended(boolean isSuspended) {
        synchronized (this) {
            this.isSuspended = isSuspended;
        }
    }

    public void suspend() {
        this.setSuspended(true);
    }

    public void resume() {
        this.setSuspended(false);
    }

    public interface MoveToCallback {
        public void onFloorChanged(int floorNumber);
    }

    public void moveTo(int floorNumber, MoveToCallback moveToCallback) {
        setDirection(this.floorNumber > floorNumber ? Direction.DOWN
                                                    : Direction.UP);
        
        while (this.getFloorNumber() != floorNumber && !this.isSuspended()) {
            engine.move(speed, direction);

            int oldFloornumber = this.getFloorNumber();
            
            // Wait for the floorNumber to change
            while (true) {
                if (oldFloornumber != this.getFloorNumber()) {
                    moveToCallback.onFloorChanged(this.getFloorNumber());
                    break;
                }
            }
        }
        this.suspend();
    }

    public void markerDetected() {
        synchronized (this) {
            setFloorNumber(this.floorNumber + direction.getValue());
        }
    }
}