package id.ac.polban.jtk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara Veda
 */

public class DoorOperator {
    
    public enum DoorStatus {
        OPENED, CLOSED;
    }
    
    OpenDoorButtonImpl openDoorButton;
    SummonRequestButton summonButton ;
    DoorOpeningDeviceImpl doorDevice;
    DoorStatus doorStatus;
    DoorTimer timer = new DoorTimer();
    
    public DoorOperator(DoorOperator operator) {
        doorDevice = new DoorOpeningDeviceImpl(operator);
        openDoorButton = new OpenDoorButtonImpl(operator);
        summonButton = new SummonRequestButton();
        doorStatus = DoorStatus.CLOSED;
    }
    
    void setDoorStatus(DoorStatus status) {
        this.doorStatus = status;
    }
    
    DoorStatus getDoorStatus() {
        return doorStatus;
    }
    
    void startOperation() {
        doorDevice.openDoors();
        timer.StartTimer();
        doorDevice.closeDoors();
    }
    
    void doorOpened() {
        setDoorStatus(DoorStatus.OPENED);
    }
    
    void doorClosed() {
        setDoorStatus(DoorStatus.CLOSED);
    }
    
    void suspend() {
        timer.StopTimer();
    }
    
    void resume() {
        timer.StartTimer();
    }
    
    void suspendFromLoad() {
        this.doorOpened();
        timer.StopTimer();
    }
    
    void resumeFromLoad() {
        timer.StartTimer();
    }
    
    void openDoorButtonPressed(int cabID) {
    	ElevatorController
                        .getInstance()
                        .getCabController()
                        .getDoorOperator(cabID)
                        .openDoorButton.pressed();
    }
    
    void summonButtonPressed(int floorNumber, boolean direction) {
        timer.StartTimer();
    }
}
