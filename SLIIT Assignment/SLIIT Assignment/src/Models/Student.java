/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Thilanga Attanayake
 */
public class Student {
    
    private int student_id;
    private String academic_year;
    private String group_no;
    private String sub_group_no;
    private String group_id;
    private String sub_group_id;
    private Models.Faculty faculty;
    private Models.Semester semester;
    private Models.Programme programme;
    private int status_id;

    public Student(int student_id) {
        this.student_id = student_id;
    }
    
    public Student(int student_id, String academic_year, String group_no, String sub_group_no, String group_id, String sub_group_id, Faculty faculty, Semester semester, Programme programme, int status_id) {
        this.student_id = student_id;
        this.academic_year = academic_year;
        this.group_no = group_no;
        this.sub_group_no = sub_group_no;
        this.group_id = group_id;
        this.sub_group_id = sub_group_id;
        this.faculty = faculty;
        this.semester = semester;
        this.programme = programme;
        this.status_id = status_id;
    }

    public Student(int student_id, int status_id) {
        this.student_id = student_id;
        this.status_id = status_id;
    }
    

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getGroup_no() {
        return group_no;
    }

    public void setGroup_no(String group_no) {
        this.group_no = group_no;
    }

    public String getSub_group_no() {
        return sub_group_no;
    }

    public void setSub_group_no(String sub_group_no) {
        this.sub_group_no = sub_group_no;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getSub_group_id() {
        return sub_group_id;
    }

    public void setSub_group_id(String sub_group_id) {
        this.sub_group_id = sub_group_id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

  

    
    
    
    
}
