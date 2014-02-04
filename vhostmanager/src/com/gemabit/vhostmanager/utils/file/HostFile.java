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
package com.gemabit.vhostmanager.utils.file;

import com.gemabit.vhostmanager.utils.Attributes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostFile extends BaseFile {

    /**
     * File lines holder
     */
    protected ArrayList<String> lines;

    /**
     * HostFile from filepath
     * @param filepath
     * @throws FileNotFoundException 
     */
    public HostFile(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    /**
     * HostFile from File
     * @param filepath
     * @throws FileNotFoundException 
     */
    public HostFile(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public Attributes parseToAtributes(ArrayList<String> lines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Loads the file data
     * @return boolean
     */
    @Override
    public boolean load() {
        try {
            this.lines = this.read();

            return true;
        } catch (IOException ex) {
            Logger.getLogger(HostFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Saves the file to the disk
     * @return boolean
     */
    @Override
    public boolean save() {
        return this.write(this.lines);
    }

    /**
     * Adds a hostname to the list
     * @param hostname
     * @param ip 
     */
    public void addHost(String hostname, String ip) {
        this.lines.add(ip.concat(" ").concat(hostname));
    }

    /**
     * Removes a hostname
     * @param hostname 
     */
    public void removeHost(String hostname) {
        for (String line : lines) {
            if (line.contains(hostname)) {
                lines.remove(line);
            }
        }
    }

    /**
     * Parses the file lines to a HashMap
     * @return HashMap<String, String>
     */
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> hosts = new HashMap<>();

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("#") || line.isEmpty()) {
                continue;
            }

            Pattern pattern = Pattern.compile("([0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+)\\s+([A-Za-z0-9_.-]+)");
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String hostname = matcher.group(2);
                String ip = matcher.group(1);

                hosts.put(hostname, ip);
            }
        }

        return hosts;
    }
}
