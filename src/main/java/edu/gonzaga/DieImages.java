//Written by Dr. Crandall, modified by me

package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DieImages {
    private ArrayList<ImageIcon> images;
    private String workingDirectory = System.getProperty("user.dir");
    private String diceFolderPath = "/src/media/Dice";

    public DieImages(){
        images = new ArrayList<>(12);
        loadImages();
    }

    private void loadImages(){
        BufferedImage currentImage;
        String filename = workingDirectory + diceFolderPath;
        images.add(null);
        for (int i = 1; i < 13; i++){
            try{
                if (i < 10){
                    filename = filename + "/D6-0" + i + ".png";
                }
                else{
                    filename = filename + "/D6-" + i + ".png";
                }
                currentImage = ImageIO.read(new File(filename));
                Image dieImage = currentImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(dieImage);
                images.add(scaledImage);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public ImageIcon getDieImage(int dieValue){
        return images.get(dieValue);
    }
}
