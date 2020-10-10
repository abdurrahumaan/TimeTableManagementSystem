/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class DayModel {
    private int day_id;
    private String day_name;

    public DayModel(int day_id) {
        this.day_id = day_id;
    }

    public DayModel(String day_name) {
        this.day_name = day_name;
    }

    public DayModel(int day_id, String day_name) {
        this.day_id = day_id;
        this.day_name = day_name;
    }

    public int getDay_id() {
        return day_id;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }
    
    
}
