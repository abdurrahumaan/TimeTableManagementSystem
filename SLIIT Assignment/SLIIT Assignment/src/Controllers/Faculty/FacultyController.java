/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Faculty;

import Controllers.Common.DB_Connection;
import Models.Faculty;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FacultyController {

    public ArrayList<Models.Faculty> getFaculties() {

        ArrayList<Models.Faculty> arrayList = new ArrayList<>();

        try {

            ResultSet rs = DB_Connection.search("SELECT * FROM faculty");
            while (rs.next()) {
                arrayList.add(new Faculty(rs.getInt(1), rs.getString(2)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;

    }

    public Faculty searchFaculty(int faculty_id) {
        Faculty faculty = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM faculty WHERE faculty_id=" + faculty_id);
            while (rs.next()) {
                faculty = new Faculty(rs.getInt(1), rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return faculty;

    }

}
