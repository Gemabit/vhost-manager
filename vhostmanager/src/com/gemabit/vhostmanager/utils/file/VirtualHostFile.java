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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualHostFile extends BaseFile {

    private String serverAdmin = "";
    private String ip = "";
    private String port = "";
    private String serverName = "";
    private String location = "";
    private boolean indexes = false;
    private boolean includes = false;
    private boolean followSymLinks = false;
    private boolean symLinksIfOwnerMatch = false;
    private boolean execCGI = false;
    private String allowOverride = "";
    private String order = "";
    private String allow = "";

    public VirtualHostFile(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    public VirtualHostFile(File file) throws FileNotFoundException {
        super(file);
    }

    public void setServerAdmin(String serverAdmin) {
        this.serverAdmin = serverAdmin;
    }

    public String getServerAdmin() {
        return serverAdmin;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setIndexes(boolean indexes) {
        this.indexes = indexes;
    }

    public boolean getIndexes() {
        return this.indexes;
    }

    public void setIncludes(boolean includes) {
        this.includes = includes;
    }

    public boolean getIncludes() {
        return this.includes;
    }

    public void setFollowSymLinks(boolean followSymLinks) {
        this.followSymLinks = followSymLinks;
    }

    public boolean getFollowSymlinks() {
        return this.symLinksIfOwnerMatch;
    }

    public void setExecCGI(boolean execCGI) {
        this.execCGI = execCGI;
    }

    public boolean getExecCGI() {
        return this.execCGI;
    }

    public void setAllowOverride(String allowOverride) {
        this.allowOverride = allowOverride;
    }

    public String getAllowOverride() {
        return allowOverride;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getAllow() {
        return allow;
    }

    @Override
    public Attributes parseToAtributes(ArrayList<String> lines) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean load() {
        Pattern pattern;
        Matcher matcher;
        try {
            ArrayList<String> lines = this.read();

            for (String line : lines) {
                line = line.trim();

                //Removing comments
                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }

                //Getting IP and Port
                pattern = Pattern.compile("<VirtualHost\\s+(.*?):([0-9]+)>");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.ip = matcher.group(1);
                    this.port = matcher.group(2);
                    continue;
                }

                //Getting Server Admin email
                pattern = Pattern.compile("ServerAdmin\\s+(.*)");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.serverAdmin = matcher.group(1);
                    continue;
                }

                //Getting Server Name
                pattern = Pattern.compile("ServerName\\s+(.*)");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.serverName = matcher.group(1);
                    continue;
                }

                //Getting Document Root aka location
                pattern = Pattern.compile("DocumentRoot\\s+\"(.*?)\"");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.location = matcher.group(1);
                    continue;
                }

                //Getting Directory Options
                pattern = Pattern.compile("Options\\s+(.*)");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    String matches = matcher.group(1);
                    if (matches.contains("All")) {
                        this.indexes = true;
                        this.includes = true;
                        this.followSymLinks = true;
                        this.symLinksIfOwnerMatch = true;
                        this.execCGI = true;
                    } else {
                        if (matches.contains("Indexes")) {
                            this.indexes = true;
                        }
                        if (matches.contains("Includes")) {
                            this.includes = true;
                        }
                        if (matches.contains("FollowSymLinks")) {
                            this.followSymLinks = true;
                        }
                        if (matches.contains("SymLinksIfOwnerMatch")) {
                            this.symLinksIfOwnerMatch = true;
                        }
                        if (matches.contains("ExecCGI")) {
                            this.execCGI = true;
                        }
                    }

                    //this.location = matcher.group(1);
                    continue;
                }

                //Getting Directory AllowOverride
                pattern = Pattern.compile("AllowOverride\\s+(.*)");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.allowOverride = matcher.group(1);
                    continue;
                }

                //Getting Directory Order
                pattern = Pattern.compile("Order\\s+(.*)");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.order = matcher.group(1);
                    continue;
                }

                //Getting Directory Allow
                pattern = Pattern.compile("Allow\\s+(.*)");
                matcher = pattern.matcher(line);

                if (matcher.find()) {
                    this.allow = matcher.group(1);
                }
            }

            return true;
        } catch (IOException ex) {
            Logger.getLogger(VirtualHostFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean save() {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("<VirtualHost ".concat(this.ip).concat(":").concat(this.port).concat(">"));
        lines.add("\tServerAdmin ".concat(this.serverAdmin));
        lines.add("\tServerName ".concat(this.serverName));
        lines.add("");
        lines.add("\tDocumentRoot \"".concat(this.location).concat("\""));
        lines.add("\t<Directory \"".concat(this.location).concat("\""));

        String options = "Options ";
        if (this.indexes && this.includes && this.followSymLinks && this.symLinksIfOwnerMatch && this.execCGI) {
            options = options.concat("+All");
        } else {
            options = this.indexes ? options.concat("+Indexes ") : options.concat("-Indexes ");
            options = this.includes ? options.concat("+Includes ") : options.concat("-Includes ");
            options = this.followSymLinks ? options.concat("+FollowSymLinks ") : options.concat("-FollowSymLinks ");
            options = this.symLinksIfOwnerMatch ? options.concat("+SymLinksIfOwnerMatch ") : options.concat("-SymLinksIfOwnerMatch ");
            options = this.execCGI ? options.concat("+ExecCGI ") : options.concat("-ExecCGI ");
        }
        lines.add("\t\t".concat(options));
        lines.add("\t\tAllowOverride ".concat(this.allowOverride));
        lines.add("\t\tOrder ".concat(this.order));
        lines.add("\t\tAllow ".concat(this.allow));

        lines.add("\t</Directory>");
        lines.add("</VirtualHost>");

        return this.write(lines);
    }

}
