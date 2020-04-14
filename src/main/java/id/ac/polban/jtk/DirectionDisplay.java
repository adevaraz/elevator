/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk;

/**
 *
 * @author Zara Veda
 */

enum Direction {
    UP, DOWN;
}

public class DirectionDisplay {
    Direction dir;
    
    void setStatus(Direction currentDir) {
        dir = currentDir;
    }
}
