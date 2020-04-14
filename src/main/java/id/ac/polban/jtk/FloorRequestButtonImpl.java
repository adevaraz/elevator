/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

public class FloorRequestButtonImpl implements FloorRequestButton {
    public enum Status {ON, OFF}

    private Status status;

    private FloorRequestButtonImpl() {
        this.status = Status.OFF;
    }

    public void turnLightOn() {
        this.status = Status.ON;
    }

    public void turnLightOff() {
        this.status = Status.OFF;
    }

    public static FloorRequestButton createInstance() {
        return (FloorRequestButton)Proxy.newProxyInstance(FloorRequestButton.class.getClassLoader(),
                                                          new Class[] {FloorRequestButton.class}, 
                                                          new SignalModule(new FloorRequestButtonImpl()));
    }
}