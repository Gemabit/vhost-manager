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
package com.gemabit.vhostmanager.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesLoader {
    
    private final String folderPath;
    private final ArrayList<String> fileNames;
    private Properties properties;
    
    public PropertiesLoader(String folderPath) 
    {
        this.folderPath = folderPath;
        this.fileNames = getFilenamesFromFolder(folderPath);
    }

    public ArrayList<String> getFileNames() {
        return fileNames;
    }
    
    private ArrayList<String> getFilenamesFromFolder(String folderPath)
    {
        ArrayList<String> tmpFileNames = new ArrayList<>();
        File[] files = new File(getClass().getResource(folderPath).getPath()).listFiles();
        
        for(File file : files) {
            if (file.isFile()) {
                tmpFileNames.add(file.getName());
            }   
        }
        
        return tmpFileNames;
    }
    
}
