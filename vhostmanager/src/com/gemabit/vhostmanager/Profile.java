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

import com.gemabit.vhostmanager.utils.PropertiesLoader;
import java.util.ArrayList;

public class Profile {
    
    public static String PROFILEPATH = "/Users/luis/Desktop/Code/Java/vhost-manager/vhostmanager/src/Resources/profiles";
    private String name;
    private String host;
    private String user;
    private String password;

    public Profile(String name) {
        this.name = name;
        loadProfile();
    }
    
    private boolean loadProfile()
    {
        return true;
    }
    
    public boolean saveProvile()
    {
        return true;
    }
    
    public static ArrayList<String> getProfiles()
    {       
        return new PropertiesLoader(PROFILEPATH).getFileNames();
    }
    
    private static boolean createDefualtLocalhostProfile()
    {
        return true;
    }
}
