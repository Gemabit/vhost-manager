/**
 * vHost - Virtual Host Manager.
 *
 * @copyright © Gemabit <www.gemabit.com> 2014
 * @license Apache License, Version 2.0
 *
 * Copyright 2014 Gemabit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.gemabit.vhostmanager;

import com.gemabit.vhostmanager.ui.Main;
import com.gemabit.vhostmanager.utils.file.HostFile;
import com.gemabit.vhostmanager.utils.file.VirtualHostFile;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VHostManager {

    public static void main(String args[]) {

            //start main window
        //Main mainWindow = new Main();
            /*
         try {
         //HostFile hostFile = new HostFile("c:\\Windows\\System32\\drivers\\etc\\hosts");
         HostFile hostFile = new HostFile("/Users/andre/Java/vhost-manager/vhostmanager/src/Resources/my_text_file.txt");
         hostFile.load();
            
         hostFile.addHost("maria.local", "127.0.0.1");
            
         hostFile.save();
         } catch (FileNotFoundException ex) {
         Logger.getLogger(VHostManager.class.getName()).log(Level.SEVERE, null, ex);
         }
         //*/
        
        try {
            VirtualHostFile file = new VirtualHostFile("/Users/andre/Java/vhost-manager/vhostmanager/src/Resources/host_test.txt");
            
            file.load();
            file.setServerName("croco.loko");
            file.setLocation("/var/www/totodile");
            file.setIndexes(false);
            file.save();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VHostManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
