package id.ac.polban.jtk;

public interface FloorRequestButton {
    public void turnLightOn();

    public void turnLightOff();

    public static void pressed(int cabID, int floorNumber) {
        ElevatorController
            .getInstance()
            .getFloorRequestLogger()
            .pressed(cabID, floorNumber);
    }
}