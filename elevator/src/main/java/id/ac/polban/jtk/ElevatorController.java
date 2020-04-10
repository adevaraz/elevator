package id.ac.polban.jtk;

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

        this.floorRequestLogger = new FloorRequestLogger(this);

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
    public static abstract class Request implements Runnable {
        public Request() {

        }

        @Override
        public void run() {

        }
    }

    @Override
    public void run() {
        try {
            Thread requestDispatcherThread = new Thread(this.requestDispatcher);
            Thread floorRequestLoggerThread = new Thread(this.floorRequestLogger);

            requestDispatcherThread.start();
            requestDispatcherThread.join();

            floorRequestLoggerThread.start();
            floorRequestLoggerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}