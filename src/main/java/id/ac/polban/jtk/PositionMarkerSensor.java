package id.ac.polban.jtk;

/**
 *
 * @author IchaCahyaWulan
 */
public class PositionMarkerSensor implements Runnable {
    private final int cabID;

    private final ElevatorEngine elevatorEngine;
    
    private final ElevatorController elevatorController;
    
    private final double floorHeight = 2.5;

    public PositionMarkerSensor (int cabID, ElevatorEngine elevatorEngine, ElevatorController elevatorController) {
        this.cabID = cabID;

        this.elevatorEngine = elevatorEngine;

        this.elevatorController = elevatorController;

        Thread thread = new Thread(this);
        
        thread.setDaemon(true);

        thread.start();
    }

    /**
     * contributor: Icha Cahya W
     */
    @Override
    public void run() {
        double oldval = 0.0;
        while (true) {
            double height = elevatorEngine.getHeight();
            
            // System.out.println(height);;

            if (oldval == height ||
                (height % floorHeight) != 0) {
                continue;
            }

            this.elevatorController
                .getCabController()
                .getCabNavigator(this.cabID)
                .markerDetected();
        }
    }
}