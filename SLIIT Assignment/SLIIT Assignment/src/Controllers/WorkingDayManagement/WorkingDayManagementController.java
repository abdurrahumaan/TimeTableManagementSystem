/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.WorkingDayManagement;

import Controllers.Common.DB_Connection;
import Models.DayModel;
import Models.WorkingDayManagemenHasDay;
import Models.WorkingDayManagemenHasDay2;
import Models.WorkingDayManagementModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pasindu
 */
public class WorkingDayManagementController {

    public ArrayList<DayModel> loadDays() {
        ArrayList<DayModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM days");
            while (rs.next()) {
                arrayList.add(new DayModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }

        return arrayList;
    }

    public ArrayList<WorkingDayManagementModel> loadWorkingDayManagement() {
        ArrayList<WorkingDayManagementModel> arrayList = new ArrayList<>();

        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM working_day_management WHERE working_day_management.status=1");
            while (rs.next()) {

                ResultSet rs1 = DB_Connection.search("SELECT * FROM working_day_management_has_days WHERE working_day_management_wdm_id=" + rs.getInt(1));
                ArrayList<DayModel> newArray = new ArrayList<>();
                while (rs1.next()) {
                    ResultSet dayResult = DB_Connection.search("SELECT * FROM days WHERE day_id=" + rs1.getInt(3));
                    if (dayResult.next()) {
                        newArray.add(new DayModel(dayResult.getInt(1), dayResult.getString(2)));
                    }

                }

                arrayList.add(new WorkingDayManagementModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), newArray));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public int store(WorkingDayManagementModel workingDayManagementModel, ArrayList<DayModel> daysList) {
        int tempReturn = 0;
        try {
            Connection conn = DB_Connection.iudPS();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO working_day_management (working_time_per_day,starting_time,ending_time,status,working_days) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, workingDayManagementModel.getWorking_time_per_day());
            ps1.setString(2, workingDayManagementModel.getStarting_time());
            ps1.setString(3, workingDayManagementModel.getEnding_time());
            ps1.setInt(4, workingDayManagementModel.getStatus());
            ps1.setInt(5, workingDayManagementModel.getWorking_days());
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();

            if (rs.next()) {
                tempReturn = 1;
                daysList.forEach((dataRecord) -> {
                    try {
                        DB_Connection.iud("INSERT INTO working_day_management_has_days(working_day_management_wdm_id,days_day_id) VALUES (" + rs.getInt(1) + "," + dataRecord.getDay_id() + ")");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public int update(WorkingDayManagementModel workingDayManagementModel, ArrayList<DayModel> daysList) {
        int tempReturn = 0;
        try {
            Connection conn = DB_Connection.iudPS();
            PreparedStatement ps1 = conn.prepareStatement("UPDATE working_day_management SET working_time_per_day=?,starting_time=?,ending_time=?,status=?,working_days=? WHERE wdm_id=?", Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, workingDayManagementModel.getWorking_time_per_day());
            ps1.setString(2, workingDayManagementModel.getStarting_time());
            ps1.setString(3, workingDayManagementModel.getEnding_time());
            ps1.setInt(4, workingDayManagementModel.getStatus());
            ps1.setInt(5, workingDayManagementModel.getWorking_days());
            ps1.setInt(6, workingDayManagementModel.getWdm_id());
            ps1.executeUpdate();

            tempReturn = 1;

            try {
                DB_Connection.iud("DELETE FROM working_day_management_has_days WHERE working_day_management_wdm_id=" + workingDayManagementModel.getWdm_id());
            } catch (Exception e) {
                e.printStackTrace();
            }

            daysList.forEach((dataRecord) -> {
                try {
                    DB_Connection.iud("INSERT INTO working_day_management_has_days(working_day_management_wdm_id,days_day_id) VALUES (" + workingDayManagementModel.getWdm_id() + "," + dataRecord.getDay_id() + ")");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public void deactiveRecord(WorkingDayManagementModel workingDayManagementModel) {
        try {
            DB_Connection.iud("UPDATE working_day_management SET status=2 WHERE wdm_id=" + workingDayManagementModel.getWdm_id());
        } catch (Exception e) {
        }
    }

    public WorkingDayManagemenHasDay2 getRecord(int id) {
        WorkingDayManagemenHasDay2 record = null;
        try {
            ResultSet rs1 = DB_Connection.search("SELECT * FROM working_day_management_has_days WHERE id=" + id);
            if (rs1.first()) {
                ResultSet rs3 = DB_Connection.search("SELECT * FROM days WHERE day_id=" + rs1.getInt(3));
                ResultSet rs = DB_Connection.search("SELECT * FROM working_day_management WHERE wdm_id=" + rs1.getInt(2));

                if (rs.first() && rs3.first()) {
                    record = new WorkingDayManagemenHasDay2(rs1.getInt(1), new WorkingDayManagementModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)), new DayModel(rs3.getInt(1), rs3.getString(2)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }

    public ArrayList<WorkingDayManagemenHasDay2> getRecords() {
        ArrayList<WorkingDayManagemenHasDay2> record = new ArrayList<>();
        try {
            ResultSet rs1 = DB_Connection.search("SELECT * FROM working_day_management_has_days");
            while (rs1.next()) {
                System.out.println(rs1.getInt(1));
                ResultSet rs3 = DB_Connection.search("SELECT * FROM days WHERE day_id=" + rs1.getInt(3));
                ResultSet rs = DB_Connection.search("SELECT * FROM working_day_management WHERE wdm_id=" + rs1.getInt(2));

                if (rs.first() && rs3.first()) {
                    record.add(new WorkingDayManagemenHasDay2(rs1.getInt(1), new WorkingDayManagementModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)), new DayModel(rs3.getInt(1), rs3.getString(2))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }

}
