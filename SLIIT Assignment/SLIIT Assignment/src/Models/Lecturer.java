/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Lecturer {
    
    private String employee_id;
    private String name;
    private String departmemnt;
    private LocationModel building;
    private Faculty faculty;
    private Center center;
    private Levels levels;
    private int status;

    public Lecturer(String employee_id) {
        this.employee_id = employee_id;
    }

    public Lecturer(String employee_id, String name, String departmemnt, LocationModel building, Faculty faculty, Center center, Levels levels, int status) {
        this.employee_id = employee_id;
        this.name = name;
        this.departmemnt = departmemnt;
        this.building = building;
        this.faculty = faculty;
        this.center = center;
        this.levels = levels;
        this.status = status;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmemnt() {
        return departmemnt;
    }

    public void setDepartmemnt(String departmemnt) {
        this.departmemnt = departmemnt;
    }

    public LocationModel getBuilding() {
        return building;
    }

    public void setBuilding(LocationModel building) {
        this.building = building;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
