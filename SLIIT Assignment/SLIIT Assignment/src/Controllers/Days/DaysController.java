/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Days;

import Controllers.Common.DB_Connection;
import Models.DayModel;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DaysController {

    public ArrayList<DayModel> getDays() {
        ArrayList<DayModel> result = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM days");
            while (rs.next()) {
                System.out.println(rs.getString(2));
                result.add(new DayModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
