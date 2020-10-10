/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Levels;

import Controllers.Common.DB_Connection;
import Models.Faculty;
import Models.Levels;
import java.sql.ResultSet;
import java.util.ArrayList;


public class LevelsController {

    public ArrayList<Levels> getFaculties() {

        ArrayList<Levels> arrayList = new ArrayList<>();

        try {

            ResultSet rs = DB_Connection.search("SELECT * FROM levels");
            while (rs.next()) {
                arrayList.add(new Levels(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public Levels searchLevels(int levels_id) {
        Levels levels = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM levels WHERE levels_id=" + levels_id);
            while (rs.next()) {
                levels = new Levels(rs.getInt(1), rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return levels;

    }

}
