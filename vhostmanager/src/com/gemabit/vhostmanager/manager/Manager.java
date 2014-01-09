package com.gemabit.vhostmanager.manager;

import java.util.ArrayList;

public class Manager {
    
    private ArrayList<Profile> profiles;
    
    public Manager() {
        loadProfiles();
        
    }
    
    public ArrayList<Profile> getProfiles() {
        return profiles;
    }
    
    private void loadProfiles() {
        
    }
    
}
