/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Semester;

import Controllers.Common.DB_Connection;
import Models.Programme;
import Models.Semester;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thilanga Attanayake
 */
public class SemesterController {

    public ArrayList<Semester> getSemesters() {

        ArrayList<Semester> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM semester WHERE status='1'");
            while (rs.next()) {
                arrayList.add(new Semester(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;

    }

    public Semester serachSemester(int semester_id) {
        Semester semester = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM semester WHERE status='1' AND semester_id=" + semester_id);
            while (rs.next()) {
                semester = new Semester(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return semester;

    }

    public int insertSemester(Models.Semester semester) {

        int tempResult = 0;

        try {
            tempResult = DB_Connection.iud("INSERT INTO semester (semester,status) VALUES ('" + semester.getSemester() + "'," + semester.getStatus() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempResult;

    }

    public int deleteSemesterAndYear(Semester semester) {
        int tempResult = 0;

        try {

            String query = "UPDATE semester SET "
                    + "status = '" + semester.getStatus() + "' "
                    + "WHERE semester_id = " + semester.getSemester_id() + "";

            System.out.println(query);

            tempResult = DB_Connection.iud(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempResult;
    }

    public int updateSemester(Semester semester) {

        int tempResult = 0;
        try {

            String query = "UPDATE semester SET "
                    + "semester = '" + semester.getSemester()+ "' "
                    + "WHERE semester_id = " + semester.getSemester_id() + "";

            System.out.println(query);

            tempResult = DB_Connection.iud(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempResult;

    }

}
