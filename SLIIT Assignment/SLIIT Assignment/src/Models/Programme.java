/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class Programme {
    
    private int programme_id;
    private String programme_name;
    private int status;

    public Programme(int programme_id, String programme_name, int status) {
        this.programme_id = programme_id;
        this.programme_name = programme_name;
        this.status = status;
    }

    public int getProgramme_id() {
        return programme_id;
    }

    public void setProgramme_id(int programme_id) {
        this.programme_id = programme_id;
    }

    public String getProgramme_name() {
        return programme_name;
    }

    public void setProgramme_name(String programme_name) {
        this.programme_name = programme_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
