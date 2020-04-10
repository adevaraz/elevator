/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class SignalModule implements Runnable {
    private final LinkedBlockingQueue<Callable<Void>> signals;

    public SignalModule() {
        this.signals = new LinkedBlockingQueue<Callable<Void>>();
    }

    /**
     * @return the signals
     */
    protected LinkedBlockingQueue<Callable<Void>> getSignals() {
        return signals;
    }

    @Override
    public void run() {
        try {
            while (true) {
                signals.take().call();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}