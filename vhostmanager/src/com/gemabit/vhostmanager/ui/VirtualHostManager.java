/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemabit.vhostmanager.ui;

import com.gemabit.vhostmanager.utils.DBConnection;
import com.gemabit.vhostmanager.utils.HostFile;
import com.gemabit.vhostmanager.utils.OperatingSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lsoares
 */
public class VirtualHostManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        Main window = new Main();
        window.setResizable(false);
        window.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) window.getjTable1().getModel();

        model.addRow(new Object[]{"asdsad", "asdsad", "asdsad"});

        /*
         HostFile x =  new HostFile("/Users/andre/Java/vhost-manager/vhostmanager/src/Resources/my_text_file.txt");
         x.removeHost("127.0.0.1", "anotherhost.local");
         ArrayList<HashMap> hosts = x.getHosts();
         System.out.print("end");*/
        ResultSet results;
        DBConnection con = new DBConnection();
        con.connect();
        try {
            con.execute("insert into profiles (name) values ('pataniscas')");
            results = con.executeQuery("select * from profiles");
            while (results.next()) {
                String restName = results.getString(2);
                String cityName = results.getString(3);
                System.out.println("\t\t" + restName + "\t\t" + cityName);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VirtualHostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.close();
    }
}
