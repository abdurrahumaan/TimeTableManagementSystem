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
public class TagModel {
    private int tag_id;
    private String tag_name;
    private int status;

    public TagModel(int tag_id) {
        this.tag_id = tag_id;
    }
    
    public TagModel(String tag_name, int status) {
        this.tag_name = tag_name;
        this.status = status;
    }

    public TagModel(int tag_id, String tag_name, int status) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.status = status;
    }

    public int getTag_id() {
        return tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public int getStatus() {
        return status;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
