package id.ac.polban.jtk;

/**
 *
 * @author Andhika
 * @author RomaUlina
 */
public interface SummonRequestButton {
    public void turnLightOn();

    public void turnLightOff();

    public static void pressed(final int floorNumber, final Direction direction) {
        ElevatorController
            .getInstance()
            .getFloorRequestLogger()
            .pressed(cabID, floorNumber);
    }

    public static void released(final int floorNumber, final Direction direction) {
        ElevatorController
            .getInstance()
            .getFloorRequestLogger()
            .pressed(cabID, floorNumber);
    }
}