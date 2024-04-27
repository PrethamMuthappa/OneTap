package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;


class ApplicationInit extends JFrame {

    static void runs() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new MigLayout());
        JLabel title = new JLabel("ONE TAP");
        JLabel description = new JLabel("  A simple tool for clearing your systems cache/temporary files or trash files");
        JSeparator separator = new JSeparator();
        JSeparator separator2 = new JSeparator();
        JButton tempclear = new JButton("Temp");
        JButton binclear = new JButton("Recycle bin");
        JLabel LabelNotify = new JLabel();
        JLabel info=new JLabel("@PrethamMuthappa");
        JLabel spacer = new JLabel();
        JLabel spacer2 = new JLabel();
        JLabel spacer3 = new JLabel();
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setBorderPainted(true);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("About");
        menuBar.add(menu);

        String currentdirs=System.getProperty("user.home");
        String relatives=".local/share/Trash/";
        File files=new File(currentdirs+File.separator+relatives);
        JFileChooser jFileChooser=new JFileChooser(files);
        jFileChooser.ensureFileIsVisible(files);
        jFileChooser.setDragEnabled(true);
        jFileChooser.setFileHidingEnabled(false);

        // Button to redirect to my github account / repo for this project
        JButton linkButton = new JButton("Github");
        linkButton.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(URI.create("https://github.com/PrethamMuthappa/SwingMigLayoutApp"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("clicked");
        });

        JMenuItem jMenuItem = new JMenuItem("GITHUB");
        jMenuItem.addActionListener(linkButton.getActionListeners()[0]);
        menu.add(jMenuItem);

        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(os);


        //Temp cleaner currently only for windows
        tempclear.addActionListener(e -> {
            Tempcleaner.cleartemp();
        });


        //Bin cleaner for both window and Linux
        binclear.addActionListener(e -> {

            if (os.contains("windows")) {
                String current = System.getProperty("user.home");
                System.out.println(current);
                String relative = ".\\$Recycle.Bin";
                File winfile = new File(current + File.separator + relative);
                System.out.println(winfile);
                RecycleBinCleaner.recycle(winfile);
                for (int i = 0; i <= 100; i++) {
                    progressBar.setValue(i + 10);
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                LabelNotify.setText("Recycle bin emptyed");

            }

            String currentdir = System.getProperty("user.home");
            System.out.println(currentdir);
            String relative = ".local/share/Trash/files";
            File file = new File(currentdir + File.separator + relative);
            System.out.println(file);
            RecycleBinCleaner.recycle(file);

            for (int i = 0; i <= 100; i++) {
                progressBar.setValue(i + 10);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            LabelNotify.setText("Trash bin emptyed");

        });


        frame.add(panel);
        frame.setResizable(false);
        panel.add(menuBar, "left,wrap");
        panel.add(title, "center,wrap");
        panel.add(separator, "center,growx,wrap");
        panel.add(description, "center,wrap");
        panel.add(LabelNotify, "center,wrap");
        panel.add(spacer, "h 30, wrap");
        panel.add(progressBar, "h 8, w 50 ,center,growx,wrap");
        panel.add(spacer3, "h 30 ,wrap");
        panel.add(tempclear, "w 98,h 40, center,wrap");
        panel.add(spacer2, "h 30, wrap");
        panel.add(binclear, "w 50,h 40, center,wrap");
        panel.add(LabelNotify, "center,wrap");
        panel.add(jFileChooser,"center,growx,wrap");
        panel.add(separator2,"center,growx,wrap");
        panel.add(info,"center,wrap");

        frame.pack();
        frame.setSize(550, 600);
        frame.setVisible(true);

    }


}

