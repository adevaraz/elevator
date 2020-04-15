package id.ac.polban.jtk;

import java.util.concurrent.LinkedBlockingQueue;

public class ElevatorController implements Runnable {
    private static final ElevatorController 
        instance = new ElevatorController(
                       new FloorRequestButton[][] {
                           {
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance()
                           },
                           {
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance(),
                               FloorRequestButtonImpl.createInstance()
                           }
                       },
                       new ElevatorEngine(),
                       DirectionDisplayImpl.createInstance(),
                       FloorNumberDisplayImpl.createInstance());

    private final LinkedBlockingQueue<Request> requestQueue;

    private final RequestDispatcher requestDispatcher;

    private final FloorRequestLogger floorRequestLogger;

    // private final SummonRequestLogger summonRequestLogger;

    private final CabController cabController;

    private ElevatorController(final FloorRequestButton[][] floorRequestButtons, 
                               final ElevatorEngine elevatorEngine, 
                               final DirectionDisplay directionDisplay, 
                               final FloorNumberDisplay floorNumberDisplay) {
        this.requestQueue = new LinkedBlockingQueue<Request>();

        this.requestDispatcher = new RequestDispatcher(this);

        this.floorRequestLogger = FloorRequestLoggerImpl.createInstance(this);
        
        // this.summonRequestLogger= new SummonRequestLogger(this);

        this.cabController = new CabController(floorRequestButtons, elevatorEngine, directionDisplay, floorNumberDisplay);
    }

    public static ElevatorController getInstance() {
        return instance;
    }

    public LinkedBlockingQueue<Request> getRequestQueue() {
        return requestQueue;
    }

    public RequestDispatcher getRequestDispatcher() {
        return requestDispatcher;
    }

    public FloorRequestLogger getFloorRequestLogger() {
        return floorRequestLogger;
    }

    public CabController getCabController() {
        return cabController;
    }

    @Override
    public void run() {
        try {
            this.requestDispatcher.listen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void terminate() {
        this.requestDispatcher.terminate();
    }

    public static abstract class Request {
        public abstract int getCabID();

        public abstract int getFloorNumber();
    }
}