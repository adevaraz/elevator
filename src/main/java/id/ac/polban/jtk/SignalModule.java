/**
 * Contributor:
 * - Raefaldhi Amartya Junior (181524026)
 */
package id.ac.polban.jtk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Used for simulate concurency
 */
public class SignalModule implements InvocationHandler, Runnable {
    private Object target;

    private final LinkedBlockingQueue<Callable<Object>> signals;

    public SignalModule(Object target) {
        this.target = target;

        this.signals = new LinkedBlockingQueue<Callable<Object>>();

        Thread thread = new Thread(this);
        
        thread.setDaemon(true);

        thread.start();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.signals.put(() -> {
            return method.invoke(target, args);
        });

        return null;
    }

    @Override
    public void run() {
        try {
            while (true) {
                signals
                    .take()
                    .call();
            }
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}