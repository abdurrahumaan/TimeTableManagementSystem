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
public class Semester {
    
    private int semester_id;
    private String semester;
    private int status;

    public Semester(int semester_id, String semester, int status) {
        this.semester_id = semester_id;
        this.semester = semester;
        this.status = status;
    }

    public Semester(String semester, int status) {
        this.semester = semester;
        this.status = status;
    }

    public Semester(int semester_id, int status) {
        this.semester_id = semester_id;
        this.status = status;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
