/**
 * This program plays through a whole game of Yahtzee through a GUI
 * CPSC 224-02, Spring 2022
 * HW4 Yahtzee GUI
 * Source: Most of the Die.java, DiceImages.java, DieView.java, Hand.java, HandView.java, Window.java
 * files written by Dr. Crandall
 *
 * @author Sean Burke
 * @version v1.4 4/8/22
 */
package edu.gonzaga;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import java.util.ArrayList;

public class DiceImages {
    ArrayList<ImageIcon> images;

    void loadImages(String imagesPath) {
        BufferedImage currPicture;
        images.add(null);
        for( int i = 1; i < 7; i++) {
            try {
                String filename = imagesPath + "/D6-0" + i + ".png";
                // System.out.println(filename);
                currPicture = ImageIO.read(new File(filename));
                Image dimg = currPicture.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(dimg);
                images.add(scaledImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public DiceImages(String imagesPath) {
        images = new ArrayList<>(12);
        loadImages(imagesPath);
    }

    public ImageIcon getDieImage(int dieValue) {
        return images.get(dieValue);
    }
}