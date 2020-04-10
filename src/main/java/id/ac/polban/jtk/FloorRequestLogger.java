
/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

public class FloorRequestLogger extends FloorRequestLoggerBase {
    public FloorRequestLogger(ElevatorController elevatorController) {
        super(elevatorController);
    }

    public void pressed(int cabID, int floorNumber) {
        this.getSignals().add(() -> {
            super.pressed(cabID, floorNumber);

            return null;
        });
    }
}