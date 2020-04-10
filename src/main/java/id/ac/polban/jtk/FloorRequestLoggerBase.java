/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorController.Request;

public class FloorRequestLoggerBase extends SignalModule {
    /**
     *
     */
    private final ElevatorController elevatorController;

    /**
     * 
     */
    public FloorRequestLoggerBase(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    /**
     * 
     * @param cabID
     * @param floorNumber
     */
    protected void pressed(int cabID, int floorNumber) {
        // Add request to queue
        elevatorController
            .getRequestQueue()
            .add(new FloorRequest(cabID, floorNumber));

        // Turn the button light on
        elevatorController
            .getCabController()
            .getCab(cabID)
            .getFloorRequestButton(floorNumber)
            .turnLightOn();
    }

    public class FloorRequest extends Request {
        /**
         * 
         */
        int cabID;

        /**
         * 
         */
        int floorNumber;

        public FloorRequest(int cabID, int floorNumber) {

        }

        @Override
        public Void call() throws Exception {
            // Process the request
            elevatorController
                .getCabController()
                .processRequest(this.cabID, this.floorNumber);

            return null;
        }
    }
}