package id.ac.polban.jtk;

import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;

public class ElevatorController implements Runnable {
    /**
     *
     */
    private static final ElevatorController instance = new ElevatorController();

    /**
     *
     */
    private final LinkedBlockingQueue<Request> requestQueue;

    /**
     *
     */
    private final RequestDispatcher requestDispatcher;

    /**
     *
     */
    private final FloorRequestLogger floorRequestLogger;

    /**
     *
     */
    private final CabController cabController;

    public ElevatorController() {
        this.requestQueue = new LinkedBlockingQueue<Request>();

        this.requestDispatcher = new RequestDispatcher(this);

        this.floorRequestLogger = (FloorRequestLogger) Proxy.newProxyInstance(FloorRequestLogger.class.getClassLoader(), new Class[] { FloorRequestLogger.class }, new SignalModule(new FloorRequestLoggerImpl(this)));

        this.cabController = new CabController(this);
    }

    /**
     * @return the instance
     */
    public static ElevatorController getInstance() {
        return instance;
    }

    /**
     * @return the requestQueue
     */
    public LinkedBlockingQueue<Request> getRequestQueue() {
        return requestQueue;
    }

    /**
     * @return the requestDispatcher
     */
    public RequestDispatcher getRequestDispatcher() {
        return requestDispatcher;
    }

    /**
     * @return the floorRequestLogger
     */
    public FloorRequestLogger getFloorRequestLogger() {
        return floorRequestLogger;
    }

    /**
     * @return the cabController
     */
    public CabController getCabController() {
        return cabController;
    }

    /**
     * 
     */
    public static abstract class Request {
        public abstract int getCabID();

        public abstract int getFloorNumber();
    }

    @Override
    public void run() {
        try {
            this.requestDispatcher.listen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

