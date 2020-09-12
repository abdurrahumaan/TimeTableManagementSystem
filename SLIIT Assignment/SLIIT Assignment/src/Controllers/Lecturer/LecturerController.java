/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Lecturer;

import Controllers.Center.CenterController;
import Controllers.Common.DB_Connection;
import Controllers.Faculty.FacultyController;
import Controllers.Levels.LevelsController;
import Models.Lecturer;
import Models.LocationModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pasindu
 */
public class LecturerController {

    FacultyController facultyController;
    CenterController centerController;
    LevelsController levelsController;

    public LecturerController() {

        facultyController = new FacultyController();
        centerController = new CenterController();
        levelsController = new LevelsController();

    }

    public int saveLecture(Lecturer lecturer) {

        int x = 0;
        try {
            x = DB_Connection.iud("INSERT INTO lecturer (employee_id,name,department,building,faculty_id,center_id,levels_id,status) VALUES ("
                    + "'" + lecturer.getEmployee_id() + "',"
                    + "'" + lecturer.getName() + "',"
                    + "'" + lecturer.getDepartmemnt() + "',"
                    + "" + lecturer.getBuilding().getLocation_id() + ","
                    + "" + lecturer.getFaculty().getFaculty_id() + ","
                    + "" + lecturer.getCenter().getCenter_id() + "," + lecturer.getLevels().getCenter_id() + ","
                    + "" + lecturer.getStatus() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return x;

    }

    public int updateLecture(Lecturer lecturer) {

        int x = 0;
        try {
            x = DB_Connection.iud("UPDATE lecturer SET name='" + lecturer.getName() + "',"
                    + "department='" + lecturer.getDepartmemnt() + "',"
                    + "building=" + lecturer.getBuilding().getLocation_id() + ","
                    + "faculty_id=" + lecturer.getFaculty().getFaculty_id() + ","
                    + "center_id=" + lecturer.getCenter().getCenter_id() + ","
                    + "levels_id=" + lecturer.getLevels().getCenter_id() + ","
                    + "status=" + lecturer.getStatus() + " WHERE employee_id='" + lecturer.getEmployee_id() + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return x;

    }

    public ArrayList<Lecturer> getAll() {
        ArrayList<Lecturer> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM lecturer WHERE status=1");
            while (rs.next()) {
                ResultSet rs1 = DB_Connection.search("SELECT * FROM location WHERE location_id=" + rs.getInt(7));
                if (rs1.first()) {
                    arrayList.add(new Lecturer(rs.getString(1), rs.getString(2), rs.getString(3), new LocationModel(rs1.getInt(1), rs1.getString(2)), facultyController.searchFaculty(rs.getInt(4)), centerController.searchFaculty(rs.getInt(5)), levelsController.searchLevels(rs.getInt(6)), rs.getInt(8)));
                }
            }
        } catch (Exception e) {
        }

        return arrayList;
    }

    public void deleteRecord(String empId) {
        try {
            DB_Connection.iud("DELETE FROM lecturer WHERE employee_id='" + empId + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Lecturer getLecturer(String id) {
        Lecturer tag = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM lecturer WHERE employee_id='" + id + "'");
            if (rs.first()) {
                ResultSet rs1 = DB_Connection.search("SELECT * FROM location WHERE location_id=" + rs.getInt(7));
                if (rs1.first()) {
                    tag = new Lecturer(rs.getString(1), rs.getString(2), rs.getString(3), new LocationModel(rs1.getInt(1), rs1.getString(2)), facultyController.searchFaculty(rs.getInt(4)), centerController.searchFaculty(rs.getInt(5)), levelsController.searchLevels(rs.getInt(6)), rs.getInt(8));
                }
            }
        } catch (Exception e) {
        }
        return tag;
    }

}
