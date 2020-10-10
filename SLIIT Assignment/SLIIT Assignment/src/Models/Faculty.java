/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Faculty {
    
    private int faculty_id;
    private String faculty_name;

    public Faculty() {
    }

    public Faculty(int faculty_id) {
        this.faculty_id = faculty_id;
    }
    
    

    public Faculty(int faculty_id, String faculty_name) {
        this.faculty_id = faculty_id;
        this.faculty_name = faculty_name;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }
    
    
}
