/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gemabit.vhostmanager.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
 */
public class OperatingSystemTest {
    
    public OperatingSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of detect method, of class OperatingSystem.
     */
    @Test
    public void testDetect() {
        System.out.println("detect");
        String expResult = "mac";
        String result = OperatingSystem.detect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isMac method, of class OperatingSystem.
     */
    @Test
    public void testIsMac() {
        System.out.println("isMac");
        boolean expResult = true;
        boolean result = OperatingSystem.isMac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isLinux method, of class OperatingSystem.
     */
    @Test
    public void testIsLinux() {
        System.out.println("isLinux");
        boolean expResult = false;
        boolean result = OperatingSystem.isLinux();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isWindows method, of class OperatingSystem.
     */
    @Test
    public void testIsWindows() {
        System.out.println("isWindows");
        boolean expResult = false;
        boolean result = OperatingSystem.isWindows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isSolaris method, of class OperatingSystem.
     */
    @Test
    public void testIsSolaris() {
        System.out.println("isSolaris");
        boolean expResult = false;
        boolean result = OperatingSystem.isSolaris();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
