/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Pasindu
 */
public class SubjectModel {
    private int subject_id;
    private String subject_name,subject_code,no_of_lec_hours,no_of_tu_hours,no_of_lab_hours,no_of_eva_hours;
    private int status;
    private SemesterModel semesterModel;
    private int year;

    public SubjectModel(int subject_id) {
        this.subject_id = subject_id;
    }

    public SubjectModel(String subject_name, String subject_code, String no_of_lec_hours, String no_of_tu_hours, String no_of_lab_hours, String no_of_eva_hours, int status, SemesterModel semesterModel,int year) {
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.no_of_lec_hours = no_of_lec_hours;
        this.no_of_tu_hours = no_of_tu_hours;
        this.no_of_lab_hours = no_of_lab_hours;
        this.no_of_eva_hours = no_of_eva_hours;
        this.status = status;
        this.semesterModel=semesterModel;
        this.year=year;
    }

    public SubjectModel(int subject_id, String subject_name, String subject_code, String no_of_lec_hours, String no_of_tu_hours, String no_of_lab_hours, String no_of_eva_hours, int status, SemesterModel semesterModel,int year) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.no_of_lec_hours = no_of_lec_hours;
        this.no_of_tu_hours = no_of_tu_hours;
        this.no_of_lab_hours = no_of_lab_hours;
        this.no_of_eva_hours = no_of_eva_hours;
        this.status = status;
        this.semesterModel=semesterModel;
        this.year=year;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public String getNo_of_lec_hours() {
        return no_of_lec_hours;
    }

    public String getNo_of_tu_hours() {
        return no_of_tu_hours;
    }

    public String getNo_of_lab_hours() {
        return no_of_lab_hours;
    }

    public String getNo_of_eva_hours() {
        return no_of_eva_hours;
    }

    public int getStatus() {
        return status;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public void setNo_of_lec_hours(String no_of_lec_hours) {
        this.no_of_lec_hours = no_of_lec_hours;
    }

    public void setNo_of_tu_hours(String no_of_tu_hours) {
        this.no_of_tu_hours = no_of_tu_hours;
    }

    public void setNo_of_lab_hours(String no_of_lab_hours) {
        this.no_of_lab_hours = no_of_lab_hours;
    }

    public void setNo_of_eva_hours(String no_of_eva_hours) {
        this.no_of_eva_hours = no_of_eva_hours;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public SemesterModel getSemesterModel() {
        return semesterModel;
    }

    public void setSemesterModel(SemesterModel semesterModel) {
        this.semesterModel = semesterModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    
}
