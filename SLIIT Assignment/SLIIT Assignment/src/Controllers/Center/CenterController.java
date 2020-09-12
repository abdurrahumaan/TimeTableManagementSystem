/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Center;

import Controllers.Common.DB_Connection;
import Models.Center;
import Models.Faculty;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thilanga Attanayake
 */
public class CenterController {

    public ArrayList<Center> getFaculties() {

        ArrayList<Center> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM center");
            while (rs.next()) {
                arrayList.add(new Center(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;

    }

    public Center searchFaculty(int center_id) {
        Center center = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM center WHERE center_id=" + center_id);
            while (rs.next()) {
                center = new Center(rs.getInt(1), rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return center;

    }

}
