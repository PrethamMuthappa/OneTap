package org.example;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;
public class MainFrame {
    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        UIManager.put("Button.background",new Color(173,216,230));
        UIManager.put("Button.foreground",new Color(1,1,1));
        ApplicationInit.runs();
    }
}
