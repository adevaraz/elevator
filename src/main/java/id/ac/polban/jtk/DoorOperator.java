package id.ac.polban.jtk;

/**
 *
 * @author Zara Veda
 */
public class DoorOperator {
    
    public enum DoorStatus {
        OPENED, CLOSED;
    }
    
    OpenDoorButton openDoorButton;
    SummonRequestButton summonButton ;
    DoorOpeningDevice doorDevice;
    DoorStatus doorStatus;
    DoorTimer timer = new DoorTimer();
    
    public DoorOperator(final DoorOpeningDevice doorOpeningDevice, final OpenDoorButton openDoorButton) {
        this.doorDevice = doorOpeningDevice;

        this.openDoorButton = openDoorButton;

        // summonButton = new SummonRequestButton();
        doorStatus = DoorStatus.CLOSED;
    }
    
    /**
     * contributor: Zara Veda
     */
    void setDoorStatus(DoorStatus status) {
        this.doorStatus = status;
    }
    
    /**
     * contributor: Roma Ulina P
     */
    DoorStatus getDoorStatus() {
        return doorStatus;
    }
    
    /**
     * contributor: Nadhilah Nurfajrina
     */
    void startOperation() {
        doorDevice.openDoors();
        timer.StartTimer();
        doorDevice.closeDoors();
    }
    
    /**
     * contributor: Alvira PD
     */
    void doorOpened() {
        setDoorStatus(DoorStatus.OPENED);
    }
    
    /**
     * contributor: Zara Veda
     */
    void doorClosed() {
        setDoorStatus(DoorStatus.CLOSED);
    }
    
    /**
     * contributor: 
     */
    void suspend() {
        timer.StopTimer();
    }
    
    /**
     * contributor: 
     */
    void resume() {
        timer.StartTimer();
    }
    
    /**
     * contributor: 
     */
    void suspendFromLoad() {
        this.doorOpened();
        timer.StopTimer();
    }
    
    /**
     * contributor: 
     */
    void resumeFromLoad() {
        timer.StartTimer();
    }
    
    /**
     * contributor: Alvira PD
     */
    void openDoorButtonPressed() {
        this.startOperation();
    }
    
    /**
     * contributor: M. Andhika Z
     */
    void summonButtonPressed(int floorNumber, boolean direction) {
        timer.StartTimer();
    }
}