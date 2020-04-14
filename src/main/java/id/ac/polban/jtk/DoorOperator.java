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

enum DoorStatus {
    OPEN, CLOSE;
}

public class DoorOperator {
<<<<<<< HEAD
    OpenDoorButtonImpl openDoorButton = new OpenDoorButtonImpl(this);
    DoorStatus doorStatus;
    
    void setDoorStatus(DoorStatus status) {
        this.doorStatus = status;
    }
    
    DoorStatus getDoorStatus() {
        return doorStatus;
    }
=======
    OpenDoorButton openDoorButton = new OpenDoorButton(this);
    DoorOperator operator = new DoorOperator();
    DoorOpeningDevice doorOpeningDevice = new DoorOpeningDevice(this);
    SummonRequestButton summonButton = new SummonRequestButton();
    DoorTimer timer = new DoorTimer();
    
    enum Status {
        OPENED, CLOSED;
    }
    
    private Status status;
>>>>>>> membuat method di class DoorOpeningDevice dan DoorOperator
    
    void startOperation() {
        operator.doorOpened();
        operator.doorClosed();
        
    }
    
    void doorOpened() {
        this.status = Status.OPENED;
        doorOpeningDevice.openDoors();
    }
    
    void doorClosed() {
        this.status = Status.OPENED;
        doorOpeningDevice.closeDoors();
    }
    
    void suspend() {
        timer.StopTimer();
    }
    
    void resume() {
        timer.StartTimer();
    }
    
    void suspendFromLoad() {
        doorOpeningDevice.openDoors();
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
