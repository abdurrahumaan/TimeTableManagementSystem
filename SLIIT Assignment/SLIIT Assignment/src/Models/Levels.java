/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Levels {
    
    private int center_id;
    private String center_name;

    public Levels(int center_id) {
        this.center_id = center_id;
    }

    
    
    public Levels(int center_id, String center_name) {
        this.center_id = center_id;
        this.center_name = center_name;
    }

    public int getCenter_id() {
        return center_id;
    }

    public void setCenter_id(int center_id) {
        this.center_id = center_id;
    }

    public String getCenter_name() {
        return center_name;
    }

    public void setCenter_name(String center_name) {
        this.center_name = center_name;
    }
    
    
    
}
