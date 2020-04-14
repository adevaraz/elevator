package id.ac.polban.jtk;

import java.lang.reflect.Proxy;

class Cab {
    /**
     * 
     */
    private final FloorRequestButton[] floorRequestButtons;

    /**
     * 
     */
    private final CabNavigator cabNavigator;

    public Cab (int floorCount) {
        this.floorRequestButtons = new FloorRequestButton[floorCount];

        for (int i = 0; i < floorCount; ++i) {
            this.floorRequestButtons[i] = (FloorRequestButton)Proxy.newProxyInstance(FloorRequestButton.class.getClassLoader(), 
                                                                                     new Class[] {FloorRequestButton.class}, 
                                                                                     new SignalModule(new FloorRequestButtonImpl()));
        }
        this.cabNavigator = new CabNavigator(this);
    }

    /**
     * @return the floorRequestButton
     */
    public FloorRequestButton getFloorRequestButton(int floorNumber) {
        return floorRequestButtons[floorNumber];
    }

    /**
     * @return the cabNavigator
     */
    public CabNavigator getCabNavigator() {
        return cabNavigator;
    }

    boolean isAvailable () {
        return true;
    }
}