/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.app;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;

/**
 *
 * @author rayki
 */
public class App {
public static boolean access = true;
public static String time;
    public static void main(String[] args) {
        runThreads();
    }
    public static void start() {
        System.out.println("Project Initializing");
        try {
            LoginUI.main(null);
            System.out.println("Project Launched");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Launch RainScape.");

            System.out.println("Project Not Launched");
            System.exit(0);
        }

        
        }
    
     public static void runThreads() {
       

        Callable callable2 = () -> {
            DateTime.autoUpdate();
            return null;
        };
        
        Callable callable3 = () -> {
            start();
            return null;
        };
        
        ArrayList taskList = new ArrayList();
        
        taskList.add(callable2);
        taskList.add(callable3);
        
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            executor.invokeAll(taskList);
        } catch (InterruptedException ie) {
            System.out.println("Interrupted Exception: " + ie);
        }
    }
    }

