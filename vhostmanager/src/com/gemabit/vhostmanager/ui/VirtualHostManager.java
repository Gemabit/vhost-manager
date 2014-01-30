/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemabit.vhostmanager.ui;

import com.gemabit.vhostmanager.utils.file.HostFile;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static void main(String[] args) {
        // TODO code application logic here

        Main window = new Main();
        window.setResizable(false);
        window.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) window.getjTable1().getModel();

        model.addRow(new Object[]{"asdsad", "asdsad", "asdsad"});
        
        try {
            HostFile hostFile = new HostFile("c:\\Windows\\System32\\drivers\\etc\\hosts");
            hostFile.load();
            
            hostFile.addHost("maria.local", "127.0.0.1");
            
            hostFile.save();
            /*
            HostFile x =  new HostFile("/Users/andre/Java/vhost-manager/vhostmanager/src/Resources/my_text_file.txt");
            x.removeHost("127.0.0.1", "anotherhost.local");
            ArrayList<HashMap> hosts = x.getHosts();
            System.out.print("end");*/
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VirtualHostManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
