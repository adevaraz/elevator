package id.ac.polban.jtk;

public interface FloorRequestButton {
    public void turnLightOn();

    public void turnLightOff();

    /**
     * contributor: Raefaldhi Amartya J
     */
    public static void pressed(final int cabID, final int floorNumber) {
        ElevatorController
            .getInstance()
            .getFloorRequestLogger()
            .pressed(cabID, floorNumber);
    }
}