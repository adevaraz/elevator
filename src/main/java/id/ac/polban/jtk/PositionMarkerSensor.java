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
    
    /**
     * tinggi satu lantai dalam meter
     */
    private final double floorHeight = 2.5;
    
    public PositionMarkerSensor (ElevatorEngine elevatorEngine, CabNavigator cabNavigator) {
        this.elevatorEngine = elevatorEngine;
        this.cabNavigator = cabNavigator;
    }

    @Override
    public void run() {
        while (true) {
            if(elevatorEngine.getHeight() % floorHeight == 0){
                cabNavigator.markerDetected();
            }
        }
    }
}