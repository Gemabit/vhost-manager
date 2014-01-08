/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemabit.vhostmanager.ui;

import com.gemabit.vhostmanager.utils.OperatingSystem;
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
        
        model.addRow(new Object[]{"asdsad","asdsad","asdsad"});
        
    }
}
