package org.example;

import javax.swing.*;
import java.awt.*;

class Applications extends JFrame{
    public Applications() {
        init();
    }

    private void init() {
        setTitle("MY swing app");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(200,12,13));
        setResizable(false);
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(()-> new Applications().setVisible(true));

    }
}