package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorEngine.Direction;

/**
 * 
 */
public class CabNavigator {
    /**
     * 
     */
    private final ElevatorEngine engine;

    /**
     * 
     */
    private ElevatorEngine.Direction direction = Direction.UP;

    /**
     * 
     */
    private double speed = 0.0;

    /**
     * 
     */
    private int floorNumber = 0;

    /**
     * 
     */
    public CabNavigator (ElevatorEngine engine) {
        this.engine = engine;
        
        engine.move(speed, direction);
    }

    public void moveTo (int floorNumber) {
        if (this.floorNumber > floorNumber) {
            direction = Direction.DOWN;
        } 
        else {
            direction = Direction.UP;
        }
        
        while (this.getFloorNumber() != floorNumber) {
            // DirectionDisplay.Show(direction)

            engine.move(speed, direction);

            int oldFloornumber = this.getFloorNumber();
            
            // Wait for the floorNumber to change
            while (true) {
                if (oldFloornumber != this.getFloorNumber()) {
                    break;
                }
            }

            // FloorNumberDisplay.Show( floorNumber )
        }
    }

    /**
     * 
     */
    public synchronized void markerDetected() {
        this.floorNumber += direction.getValue();
    }

    /**
     * @return the floorNumber
     */
    public synchronized int getFloorNumber() {
        return floorNumber;
    }
}