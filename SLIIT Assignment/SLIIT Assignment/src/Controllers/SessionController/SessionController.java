/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.SessionController;

import Controllers.Common.DB_Connection;
import Controllers.Lecturer.LecturerController;
import Controllers.Location.LocationController;
import Controllers.Student.StudentController;
import Controllers.Subject.SubjectController;
import Controllers.Tag.TagController;
import Controllers.WorkingDayManagement.WorkingDayManagementController;
import Models.BlockModel;
import Models.Lecturer;
import Models.SessionModel;
import Models.Student;
import Models.SubjectModel;
import Models.TagModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pasindu
 */
public class SessionController {

    SubjectController subjectController;
    TagController tagController;
    StudentController studentController;
    LocationController locationController;
    LecturerController lecturerController;
    WorkingDayManagementController workingDayManagementController;

    public SessionController() {
        subjectController = new SubjectController();
        tagController = new TagController();
        studentController = new StudentController();
        locationController = new LocationController();
        lecturerController = new LecturerController();
        workingDayManagementController = new WorkingDayManagementController();
    }

    public int saveSession(SessionModel sessionModel) {
        int tempReturn = 0;
        try {
            Connection conn = DB_Connection.iudPS();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO session (no_of_students,working_day_management_has_days_id,subject_id,tag_id,student_id,status,building_block_bb_id) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1, sessionModel.getNo_of_students());
            ps1.setInt(2, sessionModel.getDuration().getId());
            ps1.setInt(3, sessionModel.getSubject_id().getSubject_id());
            ps1.setInt(4, sessionModel.getTag_id().getTag_id());
            ps1.setInt(5, sessionModel.getStudent_id().getStudent_id());
            ps1.setInt(6, sessionModel.getStatus());
            ps1.setInt(7, sessionModel.getBuilding_block_bb_id().getBb_id());
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                tempReturn = 1;
                int sessionSavedId = rs.getInt(1);
                DB_Connection.iud("INSERT INTO lecturer_has_session(employee_id,session_id,status_id) VALUES ('" + sessionModel.getLecturer().getEmployee_id() + "'," + sessionSavedId + ",1)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public ArrayList<SessionModel> getSessions() {
        ArrayList<SessionModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM session WHERE status=1");
            while (rs.next()) {

                SubjectModel subjectModel = subjectController.getSubject(rs.getInt(4));
                TagModel tagModel = tagController.getTag(rs.getInt(5));
                Student student = studentController.getStudent(rs.getInt(6));
                BlockModel blockModel = locationController.getBlock(rs.getInt(8));

                arrayList.add(new SessionModel(rs.getInt(1), rs.getInt(2), workingDayManagementController.getRecord(rs.getInt(3)), subjectModel, tagModel, student, rs.getInt(7), blockModel, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public void deleteSession(int id) {
        try {
            DB_Connection.iud("UPDATE session SET status=2 WHERE session_id=" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveLectureToSession(String empId, int sessId) {
        try {
            DB_Connection.iud("INSERT INTO lecturer_has_session(employee_id,session_id,status_id) VALUES ('" + empId + "'," + sessId + ",1)");
        } catch (Exception e) {
        }
    }

    public ArrayList<Lecturer> loadLectures(int sessionId) {
        ArrayList<Lecturer> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM lecturer_has_session WHERE session_id=" + sessionId);
            while (rs.next()) {
                arrayList.add(lecturerController.getLecturer(rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public boolean isLectureForThisSession(int sessionId, String empId) {
        boolean check = false;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM lecturer_has_session WHERE employee_id='" + empId + "' AND session_id=" + sessionId);
            if (rs.first()) {
                check = true;
            }
        } catch (Exception e) {
        }
        return check;
    }

    public boolean validate1(String empNo, int studentId, int wid) {
        boolean check = true;
        try {
            ResultSet rsLecs = DB_Connection.search("SELECT * FROM lecturer_has_session WHERE employee_id='" + empNo + "'");
            while (rsLecs.next()) {
                System.out.println("SELECT * FROM session WHERE session_id=" + rsLecs.getInt(3) + " AND student_id=" + studentId + " AND working_day_management_has_days_id=" + wid);
                ResultSet rs = DB_Connection.search("SELECT * FROM session WHERE session_id=" + rsLecs.getInt(3) + " AND student_id=" + studentId + " AND working_day_management_has_days_id=" + wid);
                if (rs.first()) {
                    check = false;
                } else {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean validate2(int blockId, int wid) {
        boolean result = true;

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM session WHERE working_day_management_has_days_id=" + wid + " AND building_block_bb_id=" + blockId);
            if (rs.first()) {
                result = false;
            } else {
                result = true;
            }
        } catch (Exception e) {
        }

        return result;
    }

    public boolean validate3(String lecId, int wid) {
        boolean result = true;

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM lecturer_has_session WHERE employee_id='" + lecId + "'");
            while (rs.next()) {
                ResultSet rs1 = DB_Connection.search("SELECT * FROM session WHERE working_day_management_has_days_id=" + wid);
                if (rs1.first()) {
                    result = false;
                }
            }
        } catch (Exception e) {
        }

        return result;
    }
}
