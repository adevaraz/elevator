/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

import id.ac.polban.jtk.ElevatorController.Request;

public class FloorRequestLoggerImpl implements FloorRequestLogger {
    private final ElevatorController elevatorController;

    private FloorRequestLoggerImpl(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void pressed(int cabID, int floorNumber) {
        if (false) {
            return;
        }

        // Add request to queue
        this.elevatorController
            .getRequestQueue()
            .add(new FloorRequest(cabID, floorNumber));

        // Turn the button light on
        // elevatorController
        //     .getCabController()
        //     .getFloorRequestButton(cabID, floorNumber)
        //     .turnLightOn();
    }

    public static FloorRequestLogger createInstance(ElevatorController elevatorController) {
        return (FloorRequestLogger) Proxy.newProxyInstance(FloorRequestLogger.class.getClassLoader(),
                                                           new Class[] {FloorRequestLogger.class},
                                                           new SignalModule(new FloorRequestLoggerImpl(elevatorController)));
    }

    public static class FloorRequest extends Request {
        private int cabID;

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