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

import com.gemabit.vhostmanager.utils.PropertiesHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Profile {
    
    public static String PROFILEPATH = "/Resources/profiles/";
    
    private String name;
    private String host;
    private String user;
    private String password;
    private String apachePath;
    private String hostPath;
    private String vHostPath;
    
    /**
     * Defualt constructor.
     * 
     * @param name name of the profile   
     */
    public Profile(String name) {
        this.name = name;
        loadProfile();
    }
    
    /**
     * Constructor
     * 
     * @param name      name of the profile
     * @param host      host address 
     * @param user      name of the user that will be used to login
     * @param password  user's password
     */
    public Profile(String name, String host, String user, String password) {
        this.name       = name;
        this.host       = host;
        this.user       = user;
        this.password   = password;
        this.apachePath = "";
        this.hostPath   = "";
        this.vHostPath  = "";
        
        saveProvile();
    }
    /**
     * Initialize the profile attributes by loading them from a properties file.
     * 
     * @return boolean true, if the profile was successfully loaded, otherwise false 
     */
    private boolean loadProfile()
    {
        Properties properties = PropertiesHandler.loadProperties(PROFILEPATH, name);
        
        try {
            host        = properties.getProperty("host");
            user        = properties.getProperty("user");
            password    = properties.getProperty("password");
            apachePath  = properties.getProperty("apachePath");
            hostPath    = properties.getProperty("hostPath");
            vHostPath   = properties.getProperty("vHostPath");
        } catch (Exception e) {
            System.err.println("Error loading the profile " + name + ", " + e.getMessage());
            return false;
        }     
        return true;
    }
    
    /**
     * Saves the profile to a properties file.
     * 
     * @return boolean true, if the profile was successfully stored, otherwise false 
     */
    public boolean saveProvile()
    {
        HashMap<String,String> propertiesMap = new HashMap<>();
        propertiesMap.put("name", name);
        propertiesMap.put("host", host);
        propertiesMap.put("user", user);
        propertiesMap.put("password", password);
        propertiesMap.put("apachePath", apachePath);
        propertiesMap.put("hostPath", hostPath);
        propertiesMap.put("vHostPath", vHostPath);
        
        return PropertiesHandler.savePropertiesFiles(propertiesMap, PROFILEPATH, name);
    }
    
    /**
     * Gets the profile filenames.
     * 
     * @return ArrayList with the name of the profiles.
     */
    public static ArrayList<String> getProfiles()
    {   
        return PropertiesHandler.getFilenamesFromFolder(PROFILEPATH);
    }
    
    /**
     * Creates a default localhost file.
     * 
     * @return boolean true, if the localhost file was successfully created, otherwise false  
     */
    public static boolean createDefualtLocalhostProfile()
    {
        HashMap<String,String> propertiesMap = new HashMap<>();
        propertiesMap.put("name", "localhost");
        propertiesMap.put("host", "127.0.0.1");
        propertiesMap.put("user", "");
        propertiesMap.put("password", "");
        propertiesMap.put("apachePath", "");
        propertiesMap.put("hostPath", "");
        propertiesMap.put("vHostPath", "");
        
        return PropertiesHandler.savePropertiesFiles(propertiesMap, PROFILEPATH, "localhost");
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getApachePath() {
        return apachePath;
    }

    public String getHostPath() {
        return hostPath;
    }

    public String getvHostPath() {
        return vHostPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setApachePath(String apachePath) {
        this.apachePath = apachePath;
    }

    public void setHostPath(String hostPath) {
        this.hostPath = hostPath;
    }

    public void setvHostPath(String vHostPath) {
        this.vHostPath = vHostPath;
    }
    
    
}
