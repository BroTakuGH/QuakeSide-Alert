/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rayki
 */
public class DateTime {
   
    
    public static void autoUpdate() {
        System.out.println("DateTime AutoUpdate Initialized");
        
        while (true) {
            boolean access = App.access;
            
            try {
                Thread.sleep(100); // While loop time buffer, Default 100 milliseconds
            } catch (InterruptedException ie) {
                System.out.println("Interrupted Exception: " + ie);
            }

            while (access) {
                try {
                    Thread.sleep(1); // While loop time buffer, Default 1 millisecond
                } catch (InterruptedException ie) {
                    System.out.println("Interrupted Exception: " + ie);
                }
                
                DateTime.setValues();

                // System.out.println("DateTime Updated");
            }
        }
    }
    
    public static String localTime() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
        Date date = new Date();
        
        String time = dateFormat.format(date);
        
        time = time.replace('a', 'A');
        time = time.replace('p', 'P');
        time = time.replace('m', 'M');
        
        if (time.charAt(0) != '0') {
            return time;
        } else {
            return time.substring(1);
        }
    }
    
    public static String localDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        return dateFormat.format(date);
    }
    
    public static void setValues() {
        if (!localTime().equals(DashboardUI.TIME)){
            DashboardUI.TIME.setText(localTime());
        }
        
        if (!localDate().equals(DashboardUI.DATE)) {
            DashboardUI.DATE.setText(localDate());
        }
}
}
