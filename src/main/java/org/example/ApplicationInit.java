package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.io.File;

class ApplicationInit extends JFrame {

     static void runs(){
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel(new MigLayout());
         JLabel title = new JLabel("ONE TAP");
         JLabel description=new JLabel("  A simple tool for clearing your systems cache/temporary files or trash files");
         JSeparator separator=new JSeparator();
         JButton tempclear=new JButton("Temp");
         JButton binclear=new JButton("Recycle bin");

         tempclear.addActionListener(e->{
Tempcleaner.cleartemp();
         });

         binclear.addActionListener(e -> {
             String currentdir=System.getProperty("user.dir");
             System.out.println(currentdir);
             String relative="../local/share/Trash/files";
             File file=new File(currentdir + File.separator + relative);
             RecycleBinCleaner.recycle(file);
         });

         frame.add(panel);
         frame.setResizable(false);
         panel.add(title,"center,wrap");
         panel.add(separator,"center,growx,wrap");
         panel.add(description,"center,wrap");
         panel.add(tempclear,"center,wrap");
         panel.add(binclear,"center,wrap");
         frame.pack();
         frame.setSize(500,500);
         frame.setVisible(true);

     }

}
