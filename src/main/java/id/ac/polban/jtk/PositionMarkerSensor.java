package id.ac.polban.jtk;

/**
 *
 * @author IchaCahyaWulan
 */
public class PositionMarkerSensor implements Runnable {
    /**
     * Membuat sensor untuk ElevatorEngine dan Navigator tertentu
     */
    private final ElevatorEngine elevatorEngine;
    private final CabNavigator cabNavigator;
    
    public PositionMarkerSensor (ElevatorEngine elevatorEngine, CabNavigator cabNavigator) {
        this.elevatorEngine = elevatorEngine;
        this.cabNavigator = cabNavigator;
    }

    @Override
    public void run() {
        while (true) {
            
        }
    }
}