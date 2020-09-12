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
import java.util.regex.Pattern;

/**
 *
 * @author Thilanga Attanayake
 */
public class StudentController {

    FacultyController facultyController;
    SemesterController semesterController;
    ProgrammeController programmeController;

    int totStudentCount;
    int firstYearStudentCount;
    int secondYearStudentCount;
    int thirdYearStudentCount;
    int fourthYearStudentCount;
    int firstProgrammeStudentCount;
    int seconProgrammeStudentCount;
    int thirdProgrammeStudentCount;

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
                arrayList.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), facultyController.searchFaculty(rs.getInt(7)), semesterController.serachSemester(rs.getInt(8)), programmeController.serachProgramme(rs.getInt(9)), rs.getInt(10)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;

    }

    public int updateStudent(Models.Student student) {

        int tempReturn = 0;

        try {

            String query = "UPDATE student SET "
                    + "academic_year = '" + student.getAcademic_year() + "',"
                    + "group_no = '" + student.getGroup_no() + "',"
                    + "sub_group_no = '" + student.getSub_group_no() + "',"
                    + "group_id = '" + student.getGroup_id() + "',"
                    + "sub_group_id = '" + student.getSub_group_id() + "',"
                    + "faculty_id = '" + student.getFaculty().getFaculty_id() + "',"
                    + "semester_id = '" + student.getSemester().getSemester_id() + "',"
                    + "programme_id = '" + student.getProgramme().getProgramme_id() + "' "
                    + "WHERE student_id = " + student.getStudent_id() + "";

            System.out.println(query);

            tempReturn = DB_Connection.iud(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;

    }

    public int deleteStudent(Models.Student student) {

        int tempReturn = 0;

        try {

            String query = "UPDATE student SET "
                    + "status = '" + student.getStatus_id() + "' "
                    + "WHERE student_id = " + student.getStudent_id() + "";

            System.out.println(query);

            tempReturn = DB_Connection.iud(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;

    }

    public String totStudentCount() {

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM student WHERE status=1");
            while (rs.next()) {

                totStudentCount++;

                if (rs.getString(5).split(Pattern.quote("."))[0].equals("Y1")) {
                    firstYearStudentCount += 1;
                } else if (rs.getString(5).split(Pattern.quote("."))[0].equals("Y2")) {
                    secondYearStudentCount += 1;
                } else if (rs.getString(5).split(Pattern.quote("."))[0].equals("Y3")) {
                    thirdYearStudentCount += 1;
                } else if (rs.getString(5).split(Pattern.quote("."))[0].equals("Y4")) {
                    fourthYearStudentCount += 1;
                }

                if (rs.getString(5).split(Pattern.quote("."))[2].equals("IT")) {
                    firstProgrammeStudentCount += 1;
                } else if (rs.getString(5).split(Pattern.quote("."))[2].equals("CSSE")) {
                    seconProgrammeStudentCount += 1;
                } else if (rs.getString(5).split(Pattern.quote("."))[2].equals("CSE")) {
                    thirdProgrammeStudentCount += 1;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        String tempReturn = firstYearStudentCount + "-" + secondYearStudentCount + "-" + thirdYearStudentCount + "-" + fourthYearStudentCount + "-" + firstProgrammeStudentCount + "-" + seconProgrammeStudentCount + "-" + thirdProgrammeStudentCount + "-" + totStudentCount;

        System.out.println(tempReturn);

        firstYearStudentCount = 0;
        secondYearStudentCount = 0;
        thirdYearStudentCount = 0;
        fourthYearStudentCount = 0;
        firstProgrammeStudentCount = 0;
        seconProgrammeStudentCount = 0;
        thirdProgrammeStudentCount = 0;

        return tempReturn;

    }

    public Student getStudent(int id) {
        Student tag = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM student WHERE student_id=" + id);
            if (rs.first()) {
                tag = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), facultyController.searchFaculty(rs.getInt(7)), semesterController.serachSemester(rs.getInt(8)), programmeController.serachProgramme(rs.getInt(9)), rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return tag;
    }

}
