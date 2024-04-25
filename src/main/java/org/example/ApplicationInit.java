package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.io.File;
import java.util.Locale;

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
         JLabel LabelNotify=new JLabel();
         JLabel spacer = new JLabel();
         JLabel spacer2 = new JLabel();

         String os=System.getProperty("os.name").toLowerCase();
         System.out.println(os);

         tempclear.addActionListener(e->{
Tempcleaner.cleartemp();
         });

         binclear.addActionListener(e -> {

             if(os.contains("windows")){
                 String current=System.getProperty("user.home");
                 System.out.println(current);
                 String relative=".\\$Recycle.Bin";
                 File file=new File(current+File.separator+relative);
                 System.out.println(file);
                 RecycleBinCleaner.recycle(file);
                 LabelNotify.setText("Recycle bin emptyed");
             }

             String currentdir=System.getProperty("user.home");
             System.out.println(currentdir);
             String relative=".local/share/Trash/files";
             File file=new File(currentdir + File.separator + relative);
             System.out.println(file);
             RecycleBinCleaner.recycle(file);
             LabelNotify.setText("Trash bin emptyed");
         });


         frame.add(panel);
         frame.setResizable(false);
         panel.add(title,"center,wrap");
         panel.add(separator,"center,growx,wrap");
         panel.add(description,"center,wrap");
         panel.add(LabelNotify,"center,wrap");
         panel.add(spacer, "h 30, wrap");
         panel.add(tempclear,"w 98,h 40, center,wrap");
         panel.add(spacer2, "h 30, wrap");
         panel.add(binclear,"w 50,h 40, center,wrap");
         panel.add(LabelNotify,"center,wrap");
         frame.pack();
         frame.setSize(500,500);
         frame.setVisible(true);

     }

}
