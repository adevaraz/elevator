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
public class DoorOpeningDevice {
    DoorOperator door;
    
    public DoorOpeningDevice(DoorOperator door) {
        this.door = door;
    }
    
    /**
     * penanggung jawab: Nadhilah 
     */
    void closeDoors() {
        //tambahin sleep beberapa detik (misal: 5 detik)
        //udahnya, ganti state door dengan manggil doorsClosed di DoorOperator
    }
}
