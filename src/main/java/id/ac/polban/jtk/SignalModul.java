/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
/**
 *
 * @author Andhika
 */
public class SignalModul implements InvocationHandler, Runnable {
      /**
     * 
     */
    private Object target;

    /**
     * 
     */
    private final LinkedBlockingQueue<Callable<Object>> signals;
    
    public SignalModul(Object target) {
        this.target = target;

        this.signals = new LinkedBlockingQueue<Callable<Object>>();

        Thread thread = new Thread(this);
        
        thread.setDaemon(true);

        thread.start();
    }
    
    @Override
    public Object invoke(Object o, Method method, Object[] os) throws Throwable {
        this.signals.put(() -> {Object[] args = null;
        return method.invoke(target, args);});

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
}
