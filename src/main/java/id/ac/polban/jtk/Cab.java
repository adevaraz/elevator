package id.ac.polban.jtk;

class Cab {
    /**
     * 
     */
    private final FloorRequestButton[] floorRequestButtons;

    /**
     * 
     */
    private final CabNavigator cabNavigator;

    public Cab () {
        this.floorRequestButtons = new FloorRequestButton[6];

        this.floorRequestButtons[0] = new FloorRequestButton();
        this.floorRequestButtons[1] = new FloorRequestButton();
        this.floorRequestButtons[2] = new FloorRequestButton();
        this.floorRequestButtons[3] = new FloorRequestButton();
        this.floorRequestButtons[4] = new FloorRequestButton();
        this.floorRequestButtons[5] = new FloorRequestButton();

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