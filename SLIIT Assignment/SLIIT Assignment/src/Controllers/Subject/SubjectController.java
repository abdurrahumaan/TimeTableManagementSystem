/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Subject;

import Controllers.Common.DB_Connection;
import Models.SemesterModel;
import Models.SubjectModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pasindu
 */
public class SubjectController {

    public ArrayList<SubjectModel> getAll() {
        ArrayList<SubjectModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM subject WHERE status=1");
            while (rs.next()) {
                ResultSet rs1 = DB_Connection.search("SELECT * FROM semester WHERE semester_id=" + rs.getInt(9));
                if (rs1.first()) {
                    arrayList.add(new SubjectModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), new SemesterModel(rs.getInt(9), rs1.getString(2)), rs.getInt(10)));
                }
            }
        } catch (Exception e) {
        }

        return arrayList;
    }

    public int store(SubjectModel subjectModel) {
        int x = 0;
        try {
            x = DB_Connection.iud("INSERT INTO subject (subject_name,subject_code,no_of_lec_hours,no_of_tu_hours,no_of_lab_hours,no_of_eva_hours,status,semester_id,year) VALUES ('" + subjectModel.getSubject_name() + "','" + subjectModel.getSubject_code() + "','" + subjectModel.getNo_of_lec_hours() + "','" + subjectModel.getNo_of_tu_hours() + "','" + subjectModel.getNo_of_lab_hours() + "','" + subjectModel.getNo_of_eva_hours() + "'," + subjectModel.getStatus() + "," + subjectModel.getSemesterModel().getSemester_id() + "," + subjectModel.getYear() + ")");
        } catch (Exception e) {
        }

        return x;
    }

    public int update(SubjectModel subjectModel) {
        int x = 0;
        try {
            x = DB_Connection.iud("UPDATE subject SET subject_name='" + subjectModel.getSubject_name() + "',subject_code='" + subjectModel.getSubject_code() + "',no_of_lec_hours='" + subjectModel.getNo_of_lec_hours() + "',no_of_tu_hours='" + subjectModel.getNo_of_tu_hours() + "',no_of_lab_hours='" + subjectModel.getNo_of_lab_hours() + "',no_of_eva_hours='" + subjectModel.getNo_of_eva_hours() + "',status=" + subjectModel.getStatus() + ",semester_id=" + subjectModel.getSemesterModel().getSemester_id() + ",year=" + subjectModel.getYear() + " WHERE subject_id=" + subjectModel.getSubject_id());
        } catch (Exception e) {
        }

        return x;
    }

    public ArrayList<SemesterModel> getSemesters() {
        ArrayList<SemesterModel> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM semester");
            while (rs.next()) {
                arrayList.add(new SemesterModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public int delete(int id) {
        int x = 0;
        try {
            x = DB_Connection.iud("DELETE FROM subject WHERE subject_id=" + id);
        } catch (Exception e) {
        }

        return x;
    }

    public SubjectModel getSubject(int id) {
        SubjectModel model = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM subject WHERE subject_id=" + id);
            if (rs.first()) {
                ResultSet rs1 = DB_Connection.search("SELECT * FROM semester WHERE semester_id=" + rs.getInt(9));
                if (rs1.first()) {
                    model=new SubjectModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), new SemesterModel(rs.getInt(9), rs1.getString(2)), rs.getInt(10));
                }
            }
        } catch (Exception e) {
        }
        return model;
    }

}
