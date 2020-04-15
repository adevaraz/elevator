package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

public class DirectionDisplayImpl implements DirectionDisplay {
    private Direction direction = Direction.UP;

    @Override
    public void show(Direction direction) {
        this.direction = direction;

        System.out.println("DirectionDisplay.show(" + (this.direction == Direction.UP ? "UP" : "DOWN") + ")");
    }

    public static DirectionDisplay createInstance() {
        return (DirectionDisplay)Proxy.newProxyInstance(DirectionDisplay.class.getClassLoader(), 
                                                        new Class[] {DirectionDisplay.class}, 
                                                        new SignalModule(new DirectionDisplayImpl()));
    }
}