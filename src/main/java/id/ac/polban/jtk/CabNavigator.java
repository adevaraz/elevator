package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorEngine.Direction;

/**
 * 
 */
public class CabNavigator {
    /**
     * 
     */
    private final Cab cab;

    /**
     * 
     */
    private final ElevatorEngine engine;

    /**
     * 
     */
    private ElevatorEngine.Direction direction;

    /**
     * 
     */
    private double speed;

    /**
     * 
     */
    private int floorNumber;

    /**
     * 
     */
    public CabNavigator (Cab cab) {
        this.cab = cab;
        
        this.engine = new ElevatorEngine();

        engine.move(speed, direction);
    }

    public void moveTo (int floorNumber) {
        while (true) {
            if (this.floorNumber > floorNumber) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.UP;
            }
     
            // DirectionDisplay.Show(direction)

            engine.move(speed, direction);

            // PositionMarkerSensor.MarkerDetected( cabID )

            // FloorNumberDisplay.Show( floorNumber )

            if (this.floorNumber == floorNumber) {
                break;
            }
        }
    }
}