/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Programme;

import Controllers.Common.DB_Connection;
import Models.Faculty;
import Models.Programme;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thilanga Attanayake
 */
public class ProgrammeController {

    public ArrayList<Programme> getProgramme() {

        ArrayList<Programme> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM programme WHERE status=1");
            while (rs.next()) {
                arrayList.add(new Programme(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;

    }

    public Programme serachProgramme(int programme_id) {
        Programme programme = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM programme WHERE status=1 AND programme_id=" + programme_id);
            while (rs.next()) {
                programme = new Programme(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return programme;

    }

    public int insertProgramme(Programme programme) {

        int tempResult = 0;

        try {
            tempResult = DB_Connection.iud("INSERT INTO programme (programme_name,status) VALUES ('" + programme.getProgramme_name() + "'," + programme.getStatus() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempResult;

    }

    public int updateProgramme(Programme programme) {

        int tempResult = 0;

        try {

            String query = "UPDATE programme SET "
                    + "programme_name = '" + programme.getProgramme_name() + "' "
                    + "WHERE programme_id = " + programme.getProgramme_id() + "";

            System.out.println(query);

            tempResult = DB_Connection.iud(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempResult;

    }

    public int deleteProgramme(Programme programme) {

        int tempResult = 0;

        try {

            String query = "UPDATE programme SET "
                    + "status = '" + programme.getStatus() + "' "
                    + "WHERE programme_id = " + programme.getProgramme_id() + "";

            System.out.println(query);

            tempResult = DB_Connection.iud(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempResult;

    }

}
