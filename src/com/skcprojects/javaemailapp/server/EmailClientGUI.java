package com.skcprojects.javaemailapp.server;

import javax.swing.*;
import java.awt.BorderLayout.*;

public class EmailClientGUI extends JFrame{
    public EmailClientGUI(){
        setTitle("Java Email Client");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        setVisible(true);
    }

    private void initUI(){

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmailClientGUI());
    }
}
