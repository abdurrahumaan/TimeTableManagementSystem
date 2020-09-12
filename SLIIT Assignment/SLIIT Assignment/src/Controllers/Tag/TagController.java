/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Tag;

import Controllers.Common.DB_Connection;
import Models.TagModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Pasindu
 */
public class TagController {

    public int storeTag(TagModel tagModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("INSERT INTO tag (tag_name,status) VALUES ('" + tagModel.getTag_name() + "'," + tagModel.getStatus() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public int updateTag(TagModel tagModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("UPDATE tag SET tag_name='" + tagModel.getTag_name() + "' WHERE tag_id=" + tagModel.getTag_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public ArrayList<TagModel> getAllActivated() {
        ArrayList<TagModel> tagModelListTemp = new ArrayList();
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM tag WHERE status=1");
            while (rs.next()) {
                tagModelListTemp.add(new TagModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return tagModelListTemp;
    }

    public ArrayList<TagModel> getAll() {
        ArrayList<TagModel> tagModelListTemp = new ArrayList();
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM tag");
            while (rs.next()) {
                tagModelListTemp.add(new TagModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return tagModelListTemp;
    }

    public int deleteTag(TagModel tagModel) {
        int tempReturn = 0;
        try {
            tempReturn = DB_Connection.iud("DELETE FROM tag WHERE tag_id=" + tagModel.getTag_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempReturn;
    }

    public TagModel getTag(int id) {
        TagModel tag = null;
        try {
            ResultSet rs = DB_Connection.search("SELECT * FROM tag WHERE tag_id=" + id);
            if (rs.first()) {
                tag = new TagModel(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return tag;
    }
}
