package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

/**
 *
 * @author Andhika
 * @author RomaUlina
 */
public class SummonRequestButtonImpl implements SummonRequestButton {
    private enum LightStatus {OFF, ON}
    
    private LightStatus status = LightStatus.OFF;

    private SummonRequestButtonImpl() {

    }

    public void turnLightOn() {
        this.status = LightStatus.ON;
    }

    public void turnLightOff() {
        this.status = LightStatus.OFF;
    }

    public static SummonRequestButton createInstance() {
        return (SummonRequestButton)Proxy.newProxyInstance(SummonRequestButton.class.getClassLoader(),
                                                          new Class[] {SummonRequestButton.class}, 
                                                          new SignalModule(new SummonRequestButtonImpl()));
    }
}
