package com.gemabit.vhostmanager.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.io.InputStream;
import java.io.OutputStream;

public class SSHConnection {

    private String host;
    private String user;
    private String password;
    private Session session;
    private int port;
    private int lastExitStatus;

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public int getLastExitStatus() {
        return lastExitStatus;
    }

    public SSHConnection(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = 22;
    }

    public SSHConnection(String host, String user, String password, int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public boolean connect() {
        JSch jsch = new JSch();
        //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        try {
            session = jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            return true;
        } catch (Exception e) {
            System.err.println("Erro:" + e.getMessage());
            return false;
        }
    }

    public String exec(String command) {
        String response = new String();
        try {
            Channel channel = session.openChannel("exec");

            // man sudo
            //   -S  The -S (stdin) option causes sudo to read the password from the
            //       standard input instead of the terminal device.
            //   -p  The -p (prompt) option allows you to override the default
            //       password prompt and use a custom one.
            ((ChannelExec) channel).setCommand("sudo -S -p '' " + command);


            InputStream in = channel.getInputStream();
            OutputStream out = channel.getOutputStream();
            ((ChannelExec) channel).setErrStream(System.err);

            channel.connect();

            out.write((password + "\n").getBytes());
            out.flush();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    response = response.concat(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    this.lastExitStatus = channel.getExitStatus();
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }

        return response;
    }

    public void close() {
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }
}
