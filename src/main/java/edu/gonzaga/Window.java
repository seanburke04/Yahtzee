package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window {
    //Icon
    private String workingDirectory = System.getProperty("user.dir");
    private String iconPath = workingDirectory + "/src/media/Logos/dicecup.jpg";
    private ImageIcon yahtzeeIcon = new ImageIcon(iconPath);

    //Frame
    private JFrame frame = new JFrame("Yahtzee!");

    //Menu
    JMenuBar menuBarWidget = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenu menuHelp = new JMenu("Help");
    JMenuItem menuFileOpen = new JMenuItem("Open");
    JMenuItem menuFileSaveAs = new JMenuItem("Save as");

    public void makeWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 600, 400);

        //Probably don't need menu bar
        menuBarWidget.add(menuFile);
        menuBarWidget.add(menuHelp);

        menuFile.add(menuFileOpen);
        menuFile.add(menuFileSaveAs);

        frame.getContentPane().add(BorderLayout.NORTH, menuBarWidget);

        frame.setIconImage(yahtzeeIcon.getImage());
    }

    public void makeVisible(Boolean visible){
        frame.setVisible(visible);
    }
}
