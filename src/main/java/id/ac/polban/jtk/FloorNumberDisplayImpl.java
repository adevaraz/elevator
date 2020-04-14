package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

public class FloorNumberDisplayImpl implements FloorNumberDisplay {
    private int floorNumber = 0;

    @Override
    public void show(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public static FloorNumberDisplay createInstance() {
        return (FloorNumberDisplay)Proxy.newProxyInstance(FloorNumberDisplay.class.getClassLoader(),
                                                          new Class[] {FloorNumberDisplay.class},
                                                          new SignalModule(new FloorNumberDisplayImpl()));
    }
}