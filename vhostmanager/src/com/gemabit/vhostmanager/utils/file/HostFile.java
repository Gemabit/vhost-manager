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
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostFile extends BaseFile {

    protected ArrayList<String> originalLines;

    protected HashMap<String, String> hosts = new HashMap<>();

    public HostFile(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    public HostFile(File file) throws FileNotFoundException {
        super(file);
    }

    @Override
    public Attributes parseToAtributes(ArrayList<String> lines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load() {
        try {
            this.originalLines = this.read();
            
            for (String line : originalLines) {
                line = line.trim();
                if (!line.startsWith("#") && !line.isEmpty()) {
                    Pattern pattern = Pattern.compile("([0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+)\\s+([A-Za-z0-9_.-]+)");
                    Matcher matcher = pattern.matcher(line);

                    if (matcher.find()) {
                        String hostname = matcher.group(2);
                        String ip = matcher.group(1);
                        
                        this.hosts.put(hostname, ip);
                    }
                }
            }

            return true;
        } catch (IOException ex) {
            Logger.getLogger(HostFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean save() {
        ArrayList<String> lines = new ArrayList<>();
        for (Entry<String, String> entry : this.hosts.entrySet()) {
            String hostname = entry.getKey();
            String ip = entry.getValue();

            lines.add(ip.concat(" ").concat(hostname));
        }

        return this.write(lines);
    }

    public HashMap<String, String> getHosts() {
        return this.hosts;
    }

    public void addHost(String hostname, String ip) {
        this.hosts.put(hostname, ip);
    }

    public void removeHost(String hostname) {
        this.hosts.remove(hostname);
    }
}
