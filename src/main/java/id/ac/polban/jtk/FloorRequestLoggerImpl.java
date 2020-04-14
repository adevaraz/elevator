/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import id.ac.polban.jtk.ElevatorController.Request;

public class FloorRequestLoggerImpl implements FloorRequestLogger {
    /**
     *
     */
    private final ElevatorController elevatorController;

    /**
     * 
     */
    public FloorRequestLoggerImpl(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    /**
     * 
     * @param cabID
     * @param floorNumber
     */
    public void pressed(int cabID, int floorNumber) {
        // TODO: If door closed and elevator stopped at floor x
        if (false) {
            // TODO: Open the door
            return;
        }
        // Add request to queue
        elevatorController
            .getRequestQueue()
            .add(new FloorRequest(cabID, floorNumber));

        // Turn the button light on
        elevatorController
            .getCabController()
            .getFloorRequestButton(cabID, floorNumber)
            .turnLightOn();
    }

    public static class FloorRequest extends Request {
        /**
         * 
         */
        private int cabID;

        /**
         * 
         */
        private int floorNumber;

        public FloorRequest(int cabID, int floorNumber) {
            super();

            this.cabID = cabID;
            this.floorNumber = floorNumber;
        }

        @Override
        public int getCabID() {
            return this.cabID;
        }

        @Override
        public int getFloorNumber() {
            return this.floorNumber;
        }
    }
}