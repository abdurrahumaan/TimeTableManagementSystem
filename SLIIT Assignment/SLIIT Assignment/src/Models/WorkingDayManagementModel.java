/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Pasindu
 */
public class WorkingDayManagementModel {

    private int wdm_id;
    private String working_time_per_day, starting_time, ending_time;
    private int status, working_days;
    private ArrayList<DayModel> workingDayList;

    public WorkingDayManagementModel(int wdm_id) {
        this.wdm_id = wdm_id;
    }

    public WorkingDayManagementModel(int wdm_id, String working_time_per_day, String starting_time, String ending_time, int status, int working_days) {
        this.wdm_id = wdm_id;
        this.working_time_per_day = working_time_per_day;
        this.starting_time = starting_time;
        this.ending_time = ending_time;
        this.status = status;
        this.working_days = working_days;
    }

    public WorkingDayManagementModel(int wdm_id, String working_time_per_day, String starting_time, String ending_time, int status, int working_days, ArrayList<DayModel> workingDayList) {
        this.wdm_id = wdm_id;
        this.working_time_per_day = working_time_per_day;
        this.starting_time = starting_time;
        this.ending_time = ending_time;
        this.status = status;
        this.working_days = working_days;
        this.workingDayList = workingDayList;
    }

    public WorkingDayManagementModel(String working_time_per_day, String starting_time, String ending_time, int status, int working_days) {
        this.working_time_per_day = working_time_per_day;
        this.starting_time = starting_time;
        this.ending_time = ending_time;
        this.status = status;
        this.working_days = working_days;
    }

    public int getWdm_id() {
        return wdm_id;
    }

    public String getWorking_time_per_day() {
        return working_time_per_day;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public String getEnding_time() {
        return ending_time;
    }

    public int getStatus() {
        return status;
    }

    public void setWdm_id(int wdm_id) {
        this.wdm_id = wdm_id;
    }

    public void setWorking_time_per_day(String working_time_per_day) {
        this.working_time_per_day = working_time_per_day;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }

    public void setEnding_time(String ending_time) {
        this.ending_time = ending_time;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWorking_days() {
        return working_days;
    }

    public void setWorking_days(int working_days) {
        this.working_days = working_days;
    }

    public ArrayList<DayModel> getWorkingDayList() {
        return workingDayList;
    }

    public void setWorkingDayList(ArrayList<DayModel> workingDayList) {
        this.workingDayList = workingDayList;
    }
    
    

}
