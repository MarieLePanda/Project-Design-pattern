/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panda.prod.application;

/**
 *
 * @author mickx
 */
public class SystemSettings {
        
    public static final String SEPARATOR = System.getProperty("os.name").startsWith("Windows") ? "\\" : "/";
    public static final String PATH_HOME = System.getProperty("os.name").startsWith("Windows") ? "C:/" : "/home/";
    
}
