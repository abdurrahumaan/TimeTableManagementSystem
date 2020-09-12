/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Location;

import Controllers.Common.DB_Connection;
import Models.BlockModel;
import Models.LocationModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pasindu
 */
public class LocationController {

    public int storeLocation(LocationModel locationModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("INSERT INTO location (building_name) VALUES ('" + locationModel.getBuilding_name() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public int updateLocation(LocationModel locationModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("UPDATE location SET building_name='" + locationModel.getBuilding_name() + "' WHERE location_id=" + locationModel.getLocation_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public int storeBlockRoom(BlockModel blockModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("INSERT INTO building_block (building_block_name,location_id,status) VALUES ('" + blockModel.getBuilding_block_name() + "'," + blockModel.getLocationModel().getLocation_id() + "," + blockModel.getStatus() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public int updateBlockRoom(BlockModel blockModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("UPDATE building_block SET building_block_name='" + blockModel.getBuilding_block_name() + "' WHERE bb_id=" + blockModel.getBb_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public int storeLocationWithBlockRoom(LocationModel locationModel, BlockModel blockModel) {

        int tempReturn = storeLocation(locationModel);
        try {
            if (tempReturn == 1) {
                tempReturn = DB_Connection.iud("INSERT INTO building_block (building_block_name,location_id,status) VALUES ('" + locationModel.getBuilding_name() + "'," + locationModel.getLocation_id() + "," + blockModel.getStatus() + ")");
            } else {
                tempReturn = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public ArrayList<LocationModel> getLocations() {
        ArrayList<LocationModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM location");
            while (rs.next()) {
                arrayList.add(new LocationModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }

        return arrayList;
    }

    public ArrayList<BlockModel> getLocationBlocks(LocationModel locationModel) {
        ArrayList<BlockModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM building_block WHERE location_id=" + locationModel.getLocation_id());
            while (rs.next()) {
                arrayList.add(new BlockModel(rs.getInt(1), rs.getString(2), new LocationModel(rs.getInt(3)), rs.getInt(4)));
            }
        } catch (Exception e) {
        }

        return arrayList;
    }

    public void deleteLocation(LocationModel locationModel) {
        try {
            DB_Connection.iud("DELETE FROM location WHERE location_id=" + locationModel.getLocation_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBlock(BlockModel blockModel) {
        try {
            DB_Connection.iud("DELETE FROM building_block WHERE bb_id=" + blockModel.getBb_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BlockModel> getBlocksWithLocations() {
        ArrayList<BlockModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM building_block");
            while (rs.next()) {
                ResultSet rsLocation = DB_Connection.search("SELECT * FROM location WHERE location_id=" + rs.getInt(3));
                if (rsLocation.first()) {
                    arrayList.add(new BlockModel(rs.getInt(1), rs.getString(2), new LocationModel(rsLocation.getInt(1), rsLocation.getString(2)), rs.getInt(4)));
                }
            }
        } catch (Exception e) {
        }

        return arrayList;
    }

    public BlockModel getBlock(int id) {
        BlockModel tag = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM building_block WHERE bb_id=" + id);
            if (rs.first()) {
                ResultSet rsLocation = DB_Connection.search("SELECT * FROM location WHERE location_id=" + rs.getInt(3));
                if (rsLocation.first()) {
                    tag = new BlockModel(rs.getInt(1), rs.getString(2), new LocationModel(rsLocation.getInt(1), rsLocation.getString(2)), rs.getInt(4));
                }
            }
        } catch (Exception e) {
        }
        return tag;
    }
}
