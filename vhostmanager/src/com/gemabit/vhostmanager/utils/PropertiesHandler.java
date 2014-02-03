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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesHandler 
{
    public static ArrayList<String> getFilenamesFromFolder(String folderPath) 
    {
        ArrayList<String> tmpFileNames = new ArrayList<>();
        File[] files = new File(PropertiesHandler.class.getResource(folderPath).getPath()).listFiles();           

        for (File file : files) {
            if (file.isFile()) {
                tmpFileNames.add(file.getName());
            }
        }

        return tmpFileNames;
    }
    
    public static Properties loadProperties(String folderPath, String file)
    { 
        Properties properties = new Properties();
        
        try {          
            properties.load(new FileInputStream(PropertiesHandler.class.getResource(folderPath).getPath() + file));
        } catch (IOException e) {
            System.err.println("Error loading the properties file " + folderPath + ", " + e.getMessage());
        }      
        return properties;
    }
    
    public static boolean savePropertiesFiles(HashMap<String,String> propertiesMap, String folderPath, String file)
    {
        Properties properties = new Properties();
        
        for (Map.Entry<String,String> entry : propertiesMap.entrySet() ) {
            properties.setProperty(entry.getKey(), entry.getValue());
        }
        
        try {
            properties.store(new FileOutputStream(PropertiesHandler.class.getResource(folderPath).getPath() + file),null);            
        } catch (Exception e) {
            System.err.println("Error saving properties file at " + folderPath + ", " + e.getMessage());
            return false;
        }        
        return true;       
    }
}