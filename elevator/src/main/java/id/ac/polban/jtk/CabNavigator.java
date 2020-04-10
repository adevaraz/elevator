package id.ac.polban.jtk;

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

    }
}