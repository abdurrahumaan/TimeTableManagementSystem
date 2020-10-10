/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Student;

import Controllers.Common.DB_Connection;
import Controllers.Faculty.FacultyController;
import Controllers.Programme.ProgrammeController;
import Controllers.Semester.SemesterController;
import Models.Semester;
import Models.Student;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thilanga Attanayake
 */
public class StudentController {

    FacultyController facultyController;
    SemesterController semesterController;
    ProgrammeController programmeController;

    public StudentController() {
        facultyController = new FacultyController();
        semesterController = new SemesterController();
        programmeController = new ProgrammeController();
    }

    public int saveStudent(Models.Student student) {
        int tempReturn = 0;
        try {

            tempReturn = DB_Connection.iud("INSERT INTO student (academic_year,group_no,sub_group_no,group_id,sub_group_id,faculty_id,semester_id,programme_id,status) VALUES ("
                    + "'" + student.getAcademic_year() + "',"
                    + "'" + student.getGroup_no() + "',"
                    + "'" + student.getSub_group_no() + "',"
                    + "'" + student.getGroup_id() + "',"
                    + "'" + student.getSub_group_id() + "',"
                    + "'" + student.getFaculty().getFaculty_id() + "',"
                    + "'" + student.getSemester().getSemester_id() + "',"
                    + "'" + student.getProgramme().getProgramme_id() + "',"
                    + "'" + student.getStatus_id() + "')"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempReturn;
    }

    public ArrayList<Student> getStudents() {

        ArrayList<Student> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM student WHERE status=1");
            while (rs.next()) {
                arrayList.add(new Student(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), facultyController.searchFaculty(rs.getInt(7)), semesterController.serachSemester(rs.getInt(8)), programmeController.serachProgramme(rs.getInt(9)), rs.getInt(10)));
//                arrayList.add(new Student(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), facultyController.searchFaculty(rs.getInt(7)), null, null, rs.getInt(10)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;

    }

}
