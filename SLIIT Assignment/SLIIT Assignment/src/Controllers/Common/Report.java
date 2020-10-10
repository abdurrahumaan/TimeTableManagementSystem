/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Common;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Report {
    
    File file1;
    File file2;
    Desktop desktop;
    
    public Report() {
        file1 = new File("C:\\SLITT");
        file2 = new File("C:\\SLITT\\report.html");
        
        initialize();
    }
    
    private void initialize() {
        try {
            
            desktop = Desktop.getDesktop();
            
            if (!file1.exists()) {
                file1.mkdir();
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void genarateAndOpen(String content) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        bufferedWriter.write("<html>"
                + "<head>"
                + "<style>"
                + ".fontStyle {"
                + "font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;"
                + "}"
                + "#customers {"
                + "font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;"
                + "border-collapse: collapse;"
                + "width: 100%;"
                + "}"
                + "#customers td,"
                + "#customers th {"
                + "border: 1px solid #ddd;"
                + "padding: 8px;"
                + "text-align: center;"
                + "}"
                + "#customers tr:nth-child(even) {"
                + "background-color: #f2f2f2;"
                + "}"
                + "#customers tr:hover {"
                + "background-color: #ddd;"
                + "}"
                + "#customers th {"
                + "padding-top: 12px;"
                + "padding-bottom: 12px;"
                + "text-align: left;"
                + "background-color: lightgray;"
                + "color: black;"
                + "}"
                + "</style>"
                + "</head>"
                + "<body>"
                +content
                + "</body>");
        bufferedWriter.flush();
        bufferedWriter.close();
        desktop.open(file2);
    }
    
}
