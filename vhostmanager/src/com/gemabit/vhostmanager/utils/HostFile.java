package com.gemabit.vhostmanager.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author andre
 */
public class HostFile {

    private File me;

    public HostFile(String filepath) {
        me = new File(filepath);
    }
    
    public boolean isFile(){
        return me.isFile();
    }
    
    public ArrayList<HashMap> getHosts() throws IOException {
        ArrayList<HashMap> hosts = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(me));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("#")) {
                continue;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] x = line.split(" ");

            HashMap<String, String> host = new HashMap<>();
            host.put("ip", x[0]);
            host.put("domain", x[x.length - 1]);
            hosts.add(host);
        }
        br.close();

        return hosts;
    }

    public void addHost(String ip, String domain) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(me, true));
        bw.append("\n".concat(ip).concat(" ").concat(domain));
        bw.close();
    }

    public boolean removeHost(String ip, String domain) throws FileNotFoundException, IOException {
        File tempFile = new File(me.getAbsolutePath() + ".tmp");
        
        BufferedReader br = new BufferedReader(new FileReader(me));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line;
        while ((line = br.readLine()) != null) {

          if (!line.trim().equals(ip.concat(" ").concat(domain))) {
            pw.println(line);
            pw.flush();
          }
        }
        pw.close();
        br.close();

        //Delete the original file
        if (me.delete()) {
            return tempFile.renameTo(me);
        }
        
        return false;
    }
}
