package id.ac.polban.jtk;

/**
 *
 * @author Zara Veda
 */
public interface OpenDoorButton {
    /**
     * contributor: Alvira PD
     */
    public static void pressed(int cabID) {
        ElevatorController
            .getInstance()
            .getCabController()
            .getDoorOperator(cabID)
            .openDoorButtonPressed(cabID);
    }

    /**
     * contributor: Zara Veda
     */
    public static void released(int cabID) {
        ElevatorController
            .getInstance()
            .released(cabID);
    }
}
