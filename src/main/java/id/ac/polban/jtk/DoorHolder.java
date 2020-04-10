package id.ac.polban.jtk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara Veda
 */

import java.util.TimerTask;

public class DoorHolder extends TimerTask {
    public static int i = 0;
    
    public void run() {
        System.out.println("Timer: " + ++i);
    }
}
