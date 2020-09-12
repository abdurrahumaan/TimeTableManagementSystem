/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Pasindu
 */
public class LocationModel {
    private int location_id;
    private String building_name;

    public LocationModel(int location_id) {
        this.location_id = location_id;
    }

    public LocationModel(String building_name) {
        this.building_name = building_name;
    }

    public LocationModel(int location_id, String building_name) {
        this.location_id = location_id;
        this.building_name = building_name;
    }

    public int getLocation_id() {
        return location_id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }
    
    
}
