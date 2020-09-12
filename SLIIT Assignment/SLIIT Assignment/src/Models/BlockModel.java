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
public class BlockModel {
    private int bb_id;
    private String building_block_name;
    private LocationModel locationModel;
    private int status;

    public BlockModel(int bb_id) {
        this.bb_id = bb_id;
    }

    public BlockModel(int bb_id, String building_block_name, LocationModel locationModel, int status) {
        this.bb_id = bb_id;
        this.building_block_name = building_block_name;
        this.locationModel = locationModel;
        this.status = status;
    }
    
    public BlockModel(int bb_id, String building_block_name) {
        this.bb_id = bb_id;
        this.building_block_name = building_block_name;
    }

    public BlockModel(String building_block_name, LocationModel locationModel, int status) {
        this.building_block_name = building_block_name;
        this.locationModel = locationModel;
        this.status = status;
    }

    public BlockModel(String building_block_name, int status) {
        this.building_block_name = building_block_name;
        this.status = status;
    }

    public BlockModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public int getBb_id() {
        return bb_id;
    }

    public String getBuilding_block_name() {
        return building_block_name;
    }

    public LocationModel getLocationModel() {
        return locationModel;
    }

    public int getStatus() {
        return status;
    }

    public void setBb_id(int bb_id) {
        this.bb_id = bb_id;
    }

    public void setBuilding_block_name(String building_block_name) {
        this.building_block_name = building_block_name;
    }

    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
