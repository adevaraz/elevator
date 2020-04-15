package id.ac.polban.jtk;

import java.util.concurrent.LinkedBlockingQueue;

public class ElevatorController {
    private static final ElevatorController instance = new ElevatorController();

    private final LinkedBlockingQueue<Request> requestQueue;

    private final RequestDispatcher requestDispatcher;

    private final FloorRequestLogger floorRequestLogger;

    // private final SummonRequestLogger summonRequestLogger;

    private final CabController cabController;

    /**
     * contributor: Raefaldhi Amartya J
     */
    private ElevatorController() {
        final int CAB_COUNT   = 2;

        final int FLOOR_COUNT = 6;
        
        DirectionDisplay[] directionDisplays = new DirectionDisplay[CAB_COUNT];

        DoorOpeningDevice[] doorOpeningDevices = new DoorOpeningDevice[CAB_COUNT];
 
        ElevatorEngine[] elevatorEngines = new ElevatorEngine[CAB_COUNT];

        FloorNumberDisplay[] floorNumberDisplays = new FloorNumberDisplay[CAB_COUNT];
        
        FloorRequestButton[][] floorRequestButtons = new FloorRequestButton[CAB_COUNT][FLOOR_COUNT];
        
        OpenDoorButton[] openDoorButtons = new OpenDoorButton[CAB_COUNT];

        PositionMarkerSensor[] positionMarkerSensors = new PositionMarkerSensor[CAB_COUNT];

        for (int i = 0; i < CAB_COUNT; ++i) {      
            directionDisplays[i] = DirectionDisplayImpl.createInstance();
            
            doorOpeningDevices[i] = DoorOpeningDeviceImpl.createInstance(i);
            
            elevatorEngines[i] = new ElevatorEngine();

            floorNumberDisplays[i] = FloorNumberDisplayImpl.createInstance();

            openDoorButtons[i] = OpenDoorButtonImpl.createInstance();

            positionMarkerSensors[i] = new PositionMarkerSensor(i, elevatorEngines[i], this);

            for (int j = 0; j < FLOOR_COUNT; ++j) {
                floorRequestButtons[i][j] = FloorRequestButtonImpl.createInstance(i, j);
            }
        }

        this.requestQueue = new LinkedBlockingQueue<Request>();
        
        this.requestDispatcher = new RequestDispatcher(this);

        this.floorRequestLogger = FloorRequestLoggerImpl.createInstance(this);

        // this.summonRequestLogger= new SummonRequestLogger(this);

        this.cabController = new CabController(floorRequestButtons,
                                               elevatorEngines, 
                                               directionDisplays, 
                                               floorNumberDisplays, 
                                               doorOpeningDevices, 
                                               openDoorButtons);
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public static ElevatorController getInstance() {
        return instance;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public LinkedBlockingQueue<Request> getRequestQueue() {
        return requestQueue;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public RequestDispatcher getRequestDispatcher() {
        return requestDispatcher;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public FloorRequestLogger getFloorRequestLogger() {
        return floorRequestLogger;
    }

    /**
     * contributor: Raefaldhi Amartya J
     */
    public CabController getCabController() {
        return cabController;
    }

    /**
     * contributor: Icha Ca
     */
    public void run() throws InterruptedException {
        this.requestDispatcher.listen();
    }

    public void terminate() {
        this.requestDispatcher.terminate();
    }

    public static abstract class Request {
        public abstract int getCabID();

        public abstract int getFloorNumber();

        public abstract void onDelete();
    }
}