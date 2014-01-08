package com.gemabit.vhostmanager.utils;

/**
 * Operating System detection class
 * @author André Filipe <andre.r.flip@gmail.com>
 */
public class OperatingSystem {

    public static final String MAC = "mac";
    public static final String LINUX = "nix";
    public static final String WINDOWS = "win";
    public static final String SOLARIS = "sunos";
    public static final String UNKNOWN = "unknown";
    
    private static String os = System.getProperty("os.name").toLowerCase();
    
    /**
     * Detects the Operating system
     * @return string
     */
    public static String detect() {
        if (os.indexOf(MAC) >= 0) {
            return MAC;
        }
        if (os.indexOf(LINUX) >= 0) {
            return LINUX;
        }
        if (os.indexOf(WINDOWS) >= 0) {
            return WINDOWS;
        }
        if (os.indexOf(SOLARIS) >= 0) {
            return SOLARIS;
        }
        
        return UNKNOWN;
    }
    
    /**
     * Is your OS Mac?
     * @return boolean
     */
    public static boolean isMac() {
        return detect().equals(MAC);
    }
    
    /**
     * Is your OS Linux?
     * @return boolean
     */
    public static boolean isLinux() {
        return detect().equals(LINUX);
    }
    
    /**
     * Is your OS Windows?
     * @return boolean
     */
    public static boolean isWindows() {
        return detect().equals(WINDOWS);
    }
    
    /**
     * Is your OS Solaris?
     * @return boolean
     */
    public static boolean isSolaris() {
        return detect().equals(SOLARIS);
    }
}
