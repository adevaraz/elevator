package id.ac.polban.jtk;

class Cab {
    /**
     * 
     */
    private final FloorRequestButton[] floorRequestButton;

    /**
     * 
     */
    private final CabNavigator cabNavigator;

    public Cab () {
        this.floorRequestButton = new FloorRequestButton[6];

        this.floorRequestButton[0] = new FloorRequestButton();
        this.floorRequestButton[1] = new FloorRequestButton();
        this.floorRequestButton[2] = new FloorRequestButton();
        this.floorRequestButton[3] = new FloorRequestButton();
        this.floorRequestButton[4] = new FloorRequestButton();
        this.floorRequestButton[5] = new FloorRequestButton();

        this.cabNavigator = new CabNavigator(this);
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