package org.example;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;
public class MainFrame {
    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        FlatRobotoFont.install();
        UIManager.put("Button.background",new Color(173,216,230));
        UIManager.put("Button.foreground",new Color(1,1,1));
        UIManager.put("default",new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        ApplicationInit.runs();
    }
}
