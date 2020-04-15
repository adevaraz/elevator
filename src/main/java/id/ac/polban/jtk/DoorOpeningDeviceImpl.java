package id.ac.polban.jtk;

import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NAD
 */

public class DoorOpeningDeviceImpl implements DoorOpeningDevice {
    int cabID;
    
    /**
     * contributor: Zara Veda
     */
    public DoorOpeningDeviceImpl(int cabID) {
        this.cabID = cabID;
    }

    /**
     * contributor: Zara Veda
     */
    public static DoorOpeningDevice createInstance(int cabID) {
        return (DoorOpeningDevice)Proxy.newProxyInstance(DoorOpeningDevice.class.getClassLoader(),
                                                          new Class[] {DoorOpeningDevice.class}, 
                                                          new SignalModule(new DoorOpeningDeviceImpl(cabID)));
    }
    
    /**
     * contributor: Nadhilah Nurfajrina
     */
    @Override
    public void openDoors() {
        try {        
            Thread.sleep(1);

            System.out.println("--opening doors..");
            
            ElevatorController
                .getInstance()
                .getCabController()
                .getDoorOperator(cabID)
                .doorOpened();
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(DoorOpeningDeviceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * contributor: Nadhilah Nurfajrina
     */
    @Override
    public void closeDoors() {
        try {
            Thread.sleep(1);
            
            System.out.println("--closing doors..");
            
            ElevatorController
                .getInstance()
                .getCabController()
                .getDoorOperator(cabID)
                .doorClosed();
        }
        catch (InterruptedException ex) {
            Logger.getLogger(DoorOpeningDeviceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
