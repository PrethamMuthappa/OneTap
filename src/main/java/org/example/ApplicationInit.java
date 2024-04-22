package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

class ApplicationInit extends JFrame {

     static void runs(){
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel(new MigLayout());
         JLabel title = new JLabel("ONE TAP");
         JLabel description=new JLabel("  A simple tool for clearing your systems cache/temporary files or trash files");
         JSeparator separator=new JSeparator();
         frame.add(panel);
         frame.setResizable(false);
         panel.add(title,"center,wrap");
         panel.add(separator,"center,growx,wrap");
         panel.add(description,"center,wrap");
         frame.pack();
         frame.setSize(500,500);
         frame.setVisible(true);

     }

}
