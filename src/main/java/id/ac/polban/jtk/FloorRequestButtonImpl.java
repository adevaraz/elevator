
/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

public class FloorRequestButtonImpl implements FloorRequestButton {
    private int cabID;

    private int floorNumber;

    private enum Status {OFF, ON}

    private Status status = Status.OFF;

    private FloorRequestButtonImpl(int cabID, int floorNumber) {
        this.cabID = cabID;

        this.floorNumber = floorNumber;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public void turnLightOn() {
        System.out.println("TurnLightOn(" + this.cabID + ")-- floorNumber: " + this.floorNumber);
        this.status = Status.ON;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public void turnLightOff() {
        System.out.println("TurnLightOff(" + this.cabID + ")-- floorNumber: " + this.floorNumber);
        this.status = Status.OFF;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public static FloorRequestButton createInstance(int cabID, int floorNumber) {
        return (FloorRequestButton)Proxy.newProxyInstance(FloorRequestButton.class.getClassLoader(),
                                                          new Class[] {FloorRequestButton.class}, 
                                                          new SignalModule(new FloorRequestButtonImpl(cabID, floorNumber)));
    }
}