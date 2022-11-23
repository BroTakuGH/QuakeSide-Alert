package com.mycompany.app;

import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class DashboardUI extends javax.swing.JFrame {
    
    public int i;
    public boolean open;
    public String whatRegion;
    public String[] region1 = {"Batac City","Laoag City","Candon City","Vigan City","San Fernando City","Alaminos City","Dagupan City","San Carlos City","Urdaneta City"};
    public String[] region2 = {"Tuguegarao City","Cauayan City","Ilagan City","Santiago City",};
    public String[] region3 = {"Balanga City","Malolos City","Meycauayan City","San Jose del Monte City","Cabanatuan City","Gapan City","Muñoz City","Palayan City","Angeles City","Mabalacat City","San Fernando City","Tarlac City","Olongapo City","San Jose City"};
    public String[] region4 = {"Batangas City","Lipa City","Tanauan City","Bacoor City","Cavite City","Dasmariñas City","Imus City","Tagaytay City","Trece Martires City","Biñan City","Cabuyao City","San Pablo City","Santa Rosa City","Lucena City","Lucena City","Antipolo City","Calamba City"};
    public String[] region5 = {"Legazpi City","Ligao City","Tabaco City","Iriga City","Naga City","Masbate City","Sorsogon City","Calapan City"};
    public String[] region6 = {"Roxas City","Iloilo City","Passi City","Bacolod City","Bago City","Cadiz City","Escalante City","Himamaylan City","Kabankalan City","La Carlota City","Sagay City","San Carlos City","Silay City","Sipalay City","Talisay City","Victorias City"};
    public String[] region7 = {"Tagbilaran City","Bogo City","Carcar City","Cebu City","Danao City","Lapu-Lapu City","Mandaue City","Naga City","Talisay City","Bais City","Bayawan City","Canlaon City","Dumaguete City","Guihulngan City","Tanjay City","Toledo City"};
    public String[] region8 = {"Borongan City","Baybay City","Ormoc City","Tacloban City","Calbayog City","Catbalogan City","Maasin City"};
    public String[] region9 = {"Dipolog City","Dapitan City","Isabela City","Pagadian City","Zamboanga City"};
    public String[] region10 = {"Cagayan de Oro","El Salvador","Gingoog","Malaybalay","Valencia","Oroquieta","Ozamiz","Tangub","Iligan"};
    public String[] region11 = {"Panabo City","Samal City","Tagum City","Davao City","Digos City","Mati City"};
    public String[] region12 = {"GENERAL SANTOS","COTABATO","KORONADAL","TACURONG","KIDAPAWAN"};
    public String[] region13 = {"Bayugan","Butuan","Cabadbaran","Surigao","Tandag","Bislig"};
    public String[] NCR = {"Caloocan","Malabon","Navotas","Valenzuela","Quezon City","Marikina","Pasig","Taguig","Makati","Manila","Mandaluyong","San Juan","Pasay","Parañaque","Las Piñas","Muntinlupa"};
    public String[] CAR = {"Baguio","Tabuk"};
    public String[] BARMM = {"Cotabato"};
    
    public double[] magnitude1 = {4.6,4.1,4.1,2.0,5.1,4.1,5.1,2.0,2.3};
    public double[] magnitude2 = {4.1,4.1,4.1,5.1};
    public double[] magnitude3 = {5.1,5.1,5.1,5.1,5.1,1.8,2.2,2.2,1.7,2.5,1.7,5.1,2.9,2.2};
    public double[] magnitude4 = {1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7,1.7};
    public double[] magnitude5 = {1.8,1.8,1.8,1.8,1.8,1.8,1.8,1.8};
    public double[] magnitude6 = {2.1,2.1,2.1,2.1,2.1,1.8,1.8,2.1,2.1,2.1,1.8,2.0,1.8,2.8,2.4,1.8};
    public double[] magnitude7 = {2.4,2.4,1.8,2.4,2.4,2.4,2.4,2.4,2.4,2.1,2.5,2.5,2.5,2.5,4.2,2.5};
    public double[] magnitude8 = {2.4,2.4,2.4,2.4,1.8,2.4,2.4};
    public double[] magnitude9 = {5.8,7.1,4.8,6.3,8.1};
    public double[] magnitude10 = {7.0,5.0,3.0,4.0,4.0,5.6,5.9,4.0,3.0};
    public double[] magnitude11 = {5.0,3.0,2.0,5.6,6.0,4.7};
    public double[] magnitude12 = {6.7,6.0,5.0,3.0,7.0};
    public double[] magnitude13 = {4.5,3.4,4.3,3.2,2.3,1.8};
    public double[] magnitude14 = {8.0,7.0,7.4,5.0,4.6,6.7,6.3,7.1,3.2,4.5,7.8,6.7,5.4,5.3,4.3,3.2};
    public double[] magnitude15 = {5.0,3.8};
    public double[] magnitude16 = {5.3};
    public String test = region1[i];

    //DATE
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    //END OF DATE
    DefaultTableModel model;
    
    Image appICON = new ImageIcon("src\\main\\java\\MyIcons\\ICON.png").getImage();
    
    public void setIconImage() {
        super.setIconImage(appICON); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
    }
    ImageIcon imageQuakeSlide = new ImageIcon("src\\main\\java\\MyIcons\\QuakeSlide.png");
    public void images(){
        jLabel4.setIcon(imageQuakeSlide);
    }
     public void barChart(){
         
        
   
     }
     
    public DashboardUI() {


        initComponents();
        TIME.setVisible(false);
        images();
        setIconImage();
        this.setSize(988, 657);
        scaleImage();
        scaleImage1();
        scaleImage2();
        scaleImage3();
        scaleImage4();
        scaleImage5();
        model = (DefaultTableModel) jTable1.getModel();
        DATE.setText(dateFormat.format(date));


    panelChart.removeAll();
    panelChart.add(jPanel9);
    panelChart.repaint();
    panelChart.revalidate();  
    
        try {
            String User_Name = USERNAME.username;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quakedb", "root", "");
            String sql = "select*from tb_users1 where USERNAME= '"+ User_Name + "'";
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()){
            
                String Username = rs.getString(1);
                String Password = rs.getString(2);
                String Address = rs.getString(3);
                String Email_Address = rs.getString(4);
                        
             jTextField1.setText(Username);
             jPasswordField1.setText(Password);
             jTextField3.setText(Address);
             jTextField4.setText(Email_Address);
           
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void scaleImage1(){
        ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Landslide1.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel15.getWidth(),jLabel15.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel15.setIcon(scaledIcon);
        
    }
    public void scaleImage2(){
        ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Landslide2.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel20.getWidth(),jLabel20.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel20.setIcon(scaledIcon);
        
    }
    public void scaleImage3(){
        ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Landslide3.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel30.getWidth(),jLabel30.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel30.setIcon(scaledIcon);
        
    }
    public void scaleImage4(){
        ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\ICON.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel49.getWidth(),jLabel49.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel49.setIcon(scaledIcon);
        
    }
    public void scaleImage5(){
        ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\ICON.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel50.getWidth(),jLabel50.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel50.setIcon(scaledIcon);
        
    }
    public void scaleImage(){
        ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Allen.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        
    }
    int page = 0;
    public void image1(){
        
        if (page == 0){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Rays.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page++;
        } else if (page == 1){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Geoff.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page++;
        } else if (page == 2){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Miko.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page++;
        }
        else if (page == 3){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Jm.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page++;
        }
        else if (page == 4){
            page = 0;
        scaleImage();
        }
    }
    public void image2(){
        
        if (page == 2){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Rays.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page--;
        } else if (page == 3){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Geoff.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page--;
        } else if (page == 4){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Miko.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page--;
        }
        else if (page == 0){
            ImageIcon icon = new ImageIcon("src\\main\\java\\MyIcons\\Jm.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel10.getWidth(),jLabel10.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel10.setIcon(scaledIcon);
        page = 4;
        }
        else if (page == 1){
            page = 4;
        scaleImage();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWrapper = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Region1 = new javax.swing.JButton();
        Region2 = new javax.swing.JButton();
        Region3 = new javax.swing.JButton();
        Region4 = new javax.swing.JButton();
        Region5 = new javax.swing.JButton();
        Region6 = new javax.swing.JButton();
        Region7 = new javax.swing.JButton();
        Region8 = new javax.swing.JButton();
        Region9 = new javax.swing.JButton();
        Region10 = new javax.swing.JButton();
        Region11 = new javax.swing.JButton();
        Region12 = new javax.swing.JButton();
        Region13 = new javax.swing.JButton();
        Region14 = new javax.swing.JButton();
        Region15 = new javax.swing.JButton();
        Region16 = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelChart = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        REPORT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(20, 29, 38));

        mainWrapper.setBackground(new java.awt.Color(20, 29, 38));

        rightPanel.setBackground(new java.awt.Color(20, 29, 38));
        rightPanel.setPreferredSize(new java.awt.Dimension(200, 300));

        jPanel3.setBackground(new java.awt.Color(11, 17, 23));

        jPanel5.setBackground(new java.awt.Color(36, 52, 71));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("the Philippines");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Northern Mindanao Region of");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("October 2022");

        jLabel15.setText("jLabel15");

        jLabel16.setBackground(new java.awt.Color(153, 102, 255));
        jLabel16.setForeground(new java.awt.Color(153, 102, 255));
        jLabel16.setText("CLICK HERE FOR THE LINK");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel14)))
                .addGap(263, 263, 263))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(36, 52, 71));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Cagayan, Philippines");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Thu, 18 Aug 2022");

        jLabel20.setText("jLabel15");

        jLabel21.setBackground(new java.awt.Color(153, 102, 255));
        jLabel21.setForeground(new java.awt.Color(153, 102, 255));
        jLabel21.setText("CLICK HERE FOR THE LINK");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel21))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel19)))
                .addGap(280, 280, 280))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(36, 52, 71));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Davao del Sur, Philippines");

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Wed, 16 Nov 2022");

        jLabel30.setText("jLabel15");

        jLabel31.setBackground(new java.awt.Color(153, 102, 255));
        jLabel31.setForeground(new java.awt.Color(153, 102, 255));
        jLabel31.setText("CLICK HERE FOR THE LINK");
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel29))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(280, 280, 280))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("LANDSLIDE NEWS ARTICLES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        leftPanel.setBackground(new java.awt.Color(20, 29, 38));
        leftPanel.setPreferredSize(new java.awt.Dimension(200, 300));

        jPanel2.setBackground(new java.awt.Color(11, 17, 23));

        Region1.setBackground(new java.awt.Color(255, 204, 0));
        Region1.setText("Region I");
        Region1.setActionCommand("Region1");
        Region1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region1ActionPerformed(evt);
            }
        });

        Region2.setBackground(new java.awt.Color(255, 204, 0));
        Region2.setText("Region II");
        Region2.setActionCommand("Region I");
        Region2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region2ActionPerformed(evt);
            }
        });

        Region3.setBackground(new java.awt.Color(255, 204, 0));
        Region3.setText("Region III");
        Region3.setActionCommand("Region I");
        Region3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region3ActionPerformed(evt);
            }
        });

        Region4.setBackground(new java.awt.Color(255, 204, 0));
        Region4.setText("Region IV");
        Region4.setActionCommand("Region I");
        Region4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region4ActionPerformed(evt);
            }
        });

        Region5.setBackground(new java.awt.Color(255, 204, 0));
        Region5.setText("Region V");
        Region5.setActionCommand("Region I");
        Region5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region5ActionPerformed(evt);
            }
        });

        Region6.setBackground(new java.awt.Color(255, 204, 0));
        Region6.setText("Region VI");
        Region6.setActionCommand("Region I");
        Region6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region6ActionPerformed(evt);
            }
        });

        Region7.setBackground(new java.awt.Color(255, 204, 0));
        Region7.setText("Region VII");
        Region7.setActionCommand("Region I");
        Region7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region7ActionPerformed(evt);
            }
        });

        Region8.setBackground(new java.awt.Color(255, 204, 0));
        Region8.setText("Region VIII");
        Region8.setActionCommand("Region I");
        Region8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region8ActionPerformed(evt);
            }
        });

        Region9.setBackground(new java.awt.Color(255, 204, 0));
        Region9.setText("Region IX");
        Region9.setActionCommand("Region I");
        Region9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region9ActionPerformed(evt);
            }
        });

        Region10.setBackground(new java.awt.Color(255, 204, 0));
        Region10.setText("Region X");
        Region10.setActionCommand("Region I");
        Region10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region10ActionPerformed(evt);
            }
        });

        Region11.setBackground(new java.awt.Color(255, 204, 0));
        Region11.setText("Region XI");
        Region11.setActionCommand("Region I");
        Region11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region11ActionPerformed(evt);
            }
        });

        Region12.setBackground(new java.awt.Color(255, 204, 0));
        Region12.setText("Region XII");
        Region12.setActionCommand("Region I");
        Region12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region12ActionPerformed(evt);
            }
        });

        Region13.setBackground(new java.awt.Color(255, 204, 0));
        Region13.setText("Region XIII");
        Region13.setActionCommand("Region I");
        Region13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region13ActionPerformed(evt);
            }
        });

        Region14.setBackground(new java.awt.Color(255, 204, 0));
        Region14.setText("NCR");
        Region14.setActionCommand("Region I");
        Region14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region14ActionPerformed(evt);
            }
        });

        Region15.setBackground(new java.awt.Color(255, 204, 0));
        Region15.setText("CAR");
        Region15.setActionCommand("Region I");
        Region15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region15ActionPerformed(evt);
            }
        });

        Region16.setBackground(new java.awt.Color(255, 204, 0));
        Region16.setText("BARMM");
        Region16.setActionCommand("Region I");
        Region16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Region16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Region16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Region8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Region16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Region6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Region7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Region3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Region4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Region5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(Region2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Region1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Region9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Region10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Region15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Region13)
                            .addComponent(Region14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Region12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Region11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region1)
                    .addComponent(Region9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region2)
                    .addComponent(Region10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region3)
                    .addComponent(Region11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region4)
                    .addComponent(Region12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region5)
                    .addComponent(Region13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region6)
                    .addComponent(Region14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region7)
                    .addComponent(Region15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Region8)
                    .addComponent(Region16))
                .addGap(261, 261, 261))
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 264, Short.MAX_VALUE))
        );

        centerPanel.setBackground(new java.awt.Color(36, 52, 71));
        centerPanel.setPreferredSize(new java.awt.Dimension(1, 100));
        centerPanel.setRequestFocusEnabled(false);

        navbar.setBackground(new java.awt.Color(20, 29, 38));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  HOME");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  PROFILE");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("    DATA");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("  REPORT");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        panelChart.setBackground(new java.awt.Color(36, 52, 71));
        panelChart.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(36, 52, 71));

        jLabel6.setText("USERNAME");

        jLabel7.setText("PASSWORD");

        jLabel8.setText("EMAIL");

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setText("Change Password?");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("CITY");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(20, 29, 38));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(20, 29, 38));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(20, 29, 38));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPasswordField1.setEditable(false);
        jPasswordField1.setBackground(new java.awt.Color(20, 29, 38));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText(">");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 204, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("<");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Profile Picture");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        panelChart.add(jPanel1, "card2");

        jPanel4.setBackground(new java.awt.Color(20, 29, 38));

        REPORT.setBackground(new java.awt.Color(36, 52, 71));
        REPORT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setBackground(new java.awt.Color(36, 52, 71));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date & Time", "City", "Username", "Report"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(255, 204, 0));
        jButton5.setText("Enter");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(REPORT, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(17, 17, 17))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(REPORT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelChart.add(jPanel4, "card3");

        jPanel10.setBackground(new java.awt.Color(20, 29, 38));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("how to prepare and prevent dying from earthquake and landslide");

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Doing the duck cover and hold is an effective way to stay out of danger when experiencing an ");

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("earthquake. Being prepared and having emergency safety kits at an accessible and close ");

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("location is also ideal. Researching the area that you are in or the area that you are planning to ");

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("travel through will prove to be helpful and this is where our application will be of use by giving ");

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("them the information about areas prone to earthquakes and landslides and help them avoid it.");

        jButton6.setBackground(new java.awt.Color(255, 204, 0));
        jButton6.setForeground(new java.awt.Color(20, 29, 38));
        jButton6.setText("BACK");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel43))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel44)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48)
                            .addComponent(jLabel45))))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(234, 234, 234))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        panelChart.add(jPanel10, "card5");

        jPanel9.setBackground(new java.awt.Color(20, 29, 38));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("What is our app about and how will it help?");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Our application “Quakeslide Alert” was made with the purpose of helping its users avoid ");

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("potential danger particularly earthquakes and landslides by giving them information on how ");

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("frequently earthquakes and landslides occur in all of the regions. The application has the feature ");

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("of being able to display recent earthquakes and landslides and their intensity. ");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("What is Earthquake and Landslide?");

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("An earthquake is a phenomena that happens suddenly and causes the ground and ");

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("everything on it to shake violently. It happens when accumulated stress from shifting crustal ");

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("or lithospheric plates is released. The sliding down of a slope of a mass of rock, debris, or earth");

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("is known as a landslide. Landslides are a type of \"mass wasting,\" which refers to any downward");

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("movement of soil or rock caused by gravity alone.");

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setForeground(new java.awt.Color(20, 29, 38));
        jButton1.setText("how to prepare at prevent dying from earthquake and landslide");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(190, 190, 190))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel33))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel38)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(104, 104, 104))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        panelChart.add(jPanel9, "card4");

        DATE.setForeground(new java.awt.Color(255, 255, 255));
        DATE.setText("DATE");

        TIME.setForeground(new java.awt.Color(255, 255, 255));
        TIME.setText("TIME");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("DATE:");

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(centerPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TIME)
                    .addComponent(DATE))
                .addGap(45, 45, 45))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DATE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TIME)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(panelChart, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout mainWrapperLayout = new javax.swing.GroupLayout(mainWrapper);
        mainWrapper.setLayout(mainWrapperLayout);
        mainWrapperLayout.setHorizontalGroup(
            mainWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainWrapperLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainWrapperLayout.setVerticalGroup(
            mainWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Region1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region1ActionPerformed

                DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region1.length; i++){
        barChartData.setValue(magnitude1[i], region1[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION I"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();
            
        
    }//GEN-LAST:event_Region1ActionPerformed
    public void defaultPanel(){
        
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
        for (i = 0 ; i < region1.length; i++){
        barChartData.setValue(magnitude1[i], region1[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION I"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();
    }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        defaultPanel();
         if (open == false){
         open = true;
         System.out.println(open);
         Thread th = new Thread(){
             @Override
             public void run(){
                 try {
                     for (int h = 0;h <= 657; h++){
                         Thread.sleep(1);
                         jPanel2.setSize(200,h);
                         jPanel3.setSize(200,h);
                         //576, 338
                     }
                     
                 } catch (Exception e){
                     JOptionPane.showMessageDialog(null, e);
                 }
             }

         };th.start();
         

     } else if (open == true){
         jPanel2.show();
         open = false;
         System.out.println(open);
         Thread th = new Thread(){
             @Override
             public void run(){
                 try {
                     for (int h = 657; h >= 0; h--){
                         Thread.sleep(1);
                         jPanel2.setSize(200,h);
                         jPanel3.setSize(200,h);
                     }
                 } catch (Exception e){
                     JOptionPane.showMessageDialog(null, e);
                 }
             }

         };th.start();
     }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    setVisible(false);
    new ForgotPassword().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    
    if (open == true){
         open = false;
         System.out.println(open);
         Thread th = new Thread(){
             @Override
             public void run(){
                 try {
                     for (int h = 657; h >= 0; h--){
                         Thread.sleep(1);
                         jPanel2.setSize(200,h);
                         jPanel3.setSize(200,h);
                     }
                 } catch (Exception e){
                     JOptionPane.showMessageDialog(null, e);
                 }
             }

         };th.start();
     }
        
    panelChart.removeAll();
    panelChart.add(jPanel1);
    panelChart.repaint();
    panelChart.revalidate();
  
     
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
    jLabel3.setBackground(Color.red);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println(page);
        image1();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    image2();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(1);
        columnModel.getColumn(2).setPreferredWidth(20);
        columnModel.getColumn(3).setPreferredWidth(200);
        if (open == true){
         open = false;
         System.out.println(open);
         Thread th = new Thread(){
             @Override
             public void run(){
                 try {
                     for (int h = 657; h >= 0; h--){
                         Thread.sleep(1);
                         jPanel2.setSize(200,h);
                         jPanel3.setSize(200,h);
                     }
                 } catch (Exception e){
                     JOptionPane.showMessageDialog(null, e);
                 }
             }

         };th.start();
     }
        
    panelChart.removeAll();
    panelChart.add(jPanel4);
    panelChart.repaint();
    panelChart.revalidate();
    }//GEN-LAST:event_jLabel5MouseClicked

    void time() {

                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss:a");
                TIME.setText(s.format(d));

    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try {
            time();
            String User_Name = USERNAME.username;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quakedb", "root", "");
            String sql = "select*from tb_users1 where USERNAME= '"+ User_Name + "'";
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()){
            
                String Username = rs.getString(1);
                String Address = rs.getString(3);
                
                        
             model.insertRow(model.getRowCount(), new Object[]{DATE.getText() + " " + TIME.getText(),Address,Username,REPORT.getText()}); 
           
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Region2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region2ActionPerformed

        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region2.length; i++){
        barChartData.setValue(magnitude2[i], region2[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION II"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();  
        // TODO add your handling code here:
    }//GEN-LAST:event_Region2ActionPerformed

    private void Region3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region3ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region3.length; i++){
        barChartData.setValue(magnitude3[i], region3[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION III"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region3ActionPerformed

    private void Region4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region4ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region4.length; i++){
        barChartData.setValue(magnitude4[i], region4[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION IV"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region4ActionPerformed

    private void Region5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region5ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region5.length; i++){
        barChartData.setValue(magnitude5[i], region5[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION V"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region5ActionPerformed

    private void Region6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region6ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region6.length; i++){
        barChartData.setValue(magnitude6[i], region6[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION VI"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region6ActionPerformed

    private void Region7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region7ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region7.length; i++){
        barChartData.setValue(magnitude7[i], region7[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION VII"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region7ActionPerformed

    private void Region8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region8ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region8.length; i++){
        barChartData.setValue(magnitude8[i], region8[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION VIII"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region8ActionPerformed

    private void Region9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region9ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region9.length; i++){
        barChartData.setValue(magnitude9[i], region9[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION IX"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region9ActionPerformed

    private void Region10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region10ActionPerformed
    DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region10.length; i++){
        barChartData.setValue(magnitude10[i], region10[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION X"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region10ActionPerformed

    private void Region11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region11ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region11.length; i++){
        barChartData.setValue(magnitude11[i], region11[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION XI"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region11ActionPerformed

    private void Region12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region12ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region12.length; i++){
        barChartData.setValue(magnitude12[i], region12[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION XII"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region12ActionPerformed

    private void Region13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region13ActionPerformed
DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < region13.length; i++){
        barChartData.setValue(magnitude13[i], region13[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("REGION XIII"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region13ActionPerformed

    private void Region14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region14ActionPerformed
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < NCR.length; i++){
        barChartData.setValue(magnitude14[i], NCR[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("NCR"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region14ActionPerformed

    private void Region15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region15ActionPerformed
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < CAR.length; i++){
        barChartData.setValue(magnitude15[i], CAR[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("CAR"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region15ActionPerformed

    private void Region16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Region16ActionPerformed
        DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
        
            for (i = 0 ; i < BARMM.length; i++){
        barChartData.setValue(magnitude16[i], BARMM[i], "");
            }
        
        
        
        JFreeChart barChart = ChartFactory.createBarChart("BARMM"," ", "HIGHEST MAGNITUDE IN 2022", barChartData, PlotOrientation.VERTICAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.WHITE);
        barchrt.setBackgroundPaint(new Color(36, 52, 71));
        ChartPanel barPanel = new ChartPanel (barChart);
        panelChart.removeAll();
        panelChart.add(barPanel,BorderLayout.CENTER);
        panelChart.validate();        // TODO add your handling code here:
    }//GEN-LAST:event_Region16ActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Desktop browser = Desktop.getDesktop();
        try{
            try {
                browser.browse(new URI("https://floodlist.com/asia/philippines-northern-mindanao-october-2022"));
            } catch (URISyntaxException ex) {
                Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (IOException err){
            
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
      Desktop browser = Desktop.getDesktop();
        try{
            try {
                browser.browse(new URI("https://reliefweb.int/report/philippines/philippines-flooding-and-landslide-region-ii-18-aug-2022"));
            } catch (URISyntaxException ex) {
                Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (IOException err){
            
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        Desktop browser = Desktop.getDesktop();
        try{
            try {
                browser.browse(new URI("https://reliefweb.int/report/philippines/philippines-flooding-and-landslides-davao-occidental-and-davao-del-sur-region-xi-16-nov-2022"));
            } catch (URISyntaxException ex) {
                Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (IOException err){
            
        }
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if (open == true){
         open = false;
         System.out.println(open);
         Thread th = new Thread(){
             @Override
             public void run(){
                 try {
                     for (int h = 657; h >= 0; h--){
                         Thread.sleep(1);
                         jPanel2.setSize(200,h);
                         jPanel3.setSize(200,h);
                     }
                 } catch (Exception e){
                     JOptionPane.showMessageDialog(null, e);
                 }
             }

         };th.start();
     }
        
    panelChart.removeAll();
    panelChart.add(jPanel10);
    panelChart.repaint();
    panelChart.revalidate();         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    panelChart.removeAll();
    panelChart.add(jPanel9);
    panelChart.repaint();
    panelChart.revalidate();          // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      
    if (open == true){
         open = false;
         System.out.println(open);
         Thread th = new Thread(){
             @Override
             public void run(){
                 try {
                     for (int h = 657; h >= 0; h--){
                         Thread.sleep(1);
                         jPanel2.setSize(200,h);
                         jPanel3.setSize(200,h);
                     }
                 } catch (Exception e){
                     JOptionPane.showMessageDialog(null, e);
                 }
             }

         };th.start();
     }
        
    panelChart.removeAll();
    panelChart.add(jPanel9);
    panelChart.repaint();
    panelChart.revalidate();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUI().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DATE;
    private javax.swing.JTextField REPORT;
    private javax.swing.JButton Region1;
    private javax.swing.JButton Region10;
    private javax.swing.JButton Region11;
    private javax.swing.JButton Region12;
    private javax.swing.JButton Region13;
    private javax.swing.JButton Region14;
    private javax.swing.JButton Region15;
    private javax.swing.JButton Region16;
    private javax.swing.JButton Region2;
    private javax.swing.JButton Region3;
    private javax.swing.JButton Region4;
    private javax.swing.JButton Region5;
    private javax.swing.JButton Region6;
    private javax.swing.JButton Region7;
    private javax.swing.JButton Region8;
    private javax.swing.JButton Region9;
    private javax.swing.JLabel TIME;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainWrapper;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables

    private Thread newThread() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
