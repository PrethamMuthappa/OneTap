package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

 class ApplicationInit extends JFrame {

     static void runs(){
         JFrame frame = new JFrame("My Application");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel(new MigLayout());
         frame.add(panel);
         frame.setResizable(false);
         JFileChooser fileChooser = new JFileChooser();
         JButton button = new JButton("Click Me!");
         panel.add(button,fileChooser);

         frame.pack();
         frame.setSize(600,800);
         frame.setVisible(true);

     }


}
